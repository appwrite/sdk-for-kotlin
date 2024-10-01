package io.appwrite

import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.fromJson
import io.appwrite.extensions.toJson
import io.appwrite.extensions.fromMultiPart
import io.appwrite.models.Payload
import io.appwrite.models.UploadProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import okhttp3.Headers.Companion.toHeaders
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.RandomAccessFile
import java.io.IOException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume

class Client @JvmOverloads constructor(
    var endPoint: String = "https://cloud.appwrite.io/v1",
    private var selfSigned: Boolean = false
) : CoroutineScope {

    companion object {
        const val CHUNK_SIZE = 5*1024*1024; // 5MB
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()

    lateinit var http: OkHttpClient

    lateinit var httpForRedirect: OkHttpClient

    private val headers: MutableMap<String, String>

    val config: MutableMap<String, String>


    init {
        headers = mutableMapOf(
            "content-type" to "application/json",
            "user-agent" to "AppwriteKotlinSDK/7.0.0 ${System.getProperty("http.agent")}",
            "x-sdk-name" to "Kotlin",
            "x-sdk-platform" to "server",
            "x-sdk-language" to "kotlin",
            "x-sdk-version" to "7.0.0",
            "x-appwrite-response-format" to "1.6.0",
        )

        config = mutableMapOf()

        setSelfSigned(selfSigned)
    }

    /**
     * Set Project
     *
     * Your project ID
     *
     * @param {string} project
     *
     * @return this
     */
    fun setProject(value: String): Client {
        config["project"] = value
        addHeader("x-appwrite-project", value)
        return this
    }

    /**
     * Set Key
     *
     * Your secret API key
     *
     * @param {string} key
     *
     * @return this
     */
    fun setKey(value: String): Client {
        config["key"] = value
        addHeader("x-appwrite-key", value)
        return this
    }

    /**
     * Set JWT
     *
     * Your secret JSON Web Token
     *
     * @param {string} jwt
     *
     * @return this
     */
    fun setJWT(value: String): Client {
        config["jWT"] = value
        addHeader("x-appwrite-jwt", value)
        return this
    }

    /**
     * Set Locale
     *
     * @param {string} locale
     *
     * @return this
     */
    fun setLocale(value: String): Client {
        config["locale"] = value
        addHeader("x-appwrite-locale", value)
        return this
    }

    /**
     * Set Session
     *
     * The user session to authenticate with
     *
     * @param {string} session
     *
     * @return this
     */
    fun setSession(value: String): Client {
        config["session"] = value
        addHeader("x-appwrite-session", value)
        return this
    }

    /**
     * Set ForwardedUserAgent
     *
     * The user agent string of the client that made the request
     *
     * @param {string} forwardeduseragent
     *
     * @return this
     */
    fun setForwardedUserAgent(value: String): Client {
        config["forwardedUserAgent"] = value
        addHeader("x-forwarded-user-agent", value)
        return this
    }

    /**
     * Set self Signed
     *
     * @param status
     *
     * @return this
     */
    fun setSelfSigned(status: Boolean): Client {
        selfSigned = status

        val builder = OkHttpClient()
            .newBuilder()

        if (!selfSigned) {
            http = builder.build()
            httpForRedirect = builder.followRedirects(false).build()
            return this
        }

        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(
                @Suppress("CustomX509TrustManager")
                object : X509TrustManager {
                    @Suppress("TrustAllX509TrustManager")
                    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                    }
                    @Suppress("TrustAllX509TrustManager")
                    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                    }
                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )
            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })

            http = builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        return this
    }

    /**
    * Set endpoint.
    *
    * @param endpoint
    *
    * @return this
    */
    fun setEndpoint(endPoint: String): Client {
        this.endPoint = endPoint
        return this
    }

    /**
     * Add Header
     *
     * @param key
     * @param value
     *
     * @return this
     */
    fun addHeader(key: String, value: String): Client {
        headers[key] = value
        return this
    }

    /**
     * Prepare the HTTP request
     *
     * @param method
     * @param path
     * @param headers
     * @param params
     *
     * @return [Request]
     */
    @Throws(AppwriteException::class)
    suspend fun prepareRequest(
        method: String,
        path: String,
        headers:  Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
    ): Request {
        val filteredParams = params.filterValues { it != null }

        val requestHeaders = this.headers.toHeaders().newBuilder()
            .addAll(headers.toHeaders())
            .build()

        val httpBuilder = (endPoint + path).toHttpUrl().newBuilder()

        if ("GET" == method) {
            filteredParams.forEach {
                when (it.value) {
                    null -> {
                        return@forEach
                    }
                    is List<*> -> {
                        val list = it.value as List<*>
                        for (index in list.indices) {
                            httpBuilder.addQueryParameter(
                                "${it.key}[]",
                                list[index].toString()
                            )
                        }
                    }
                    else -> {
                        httpBuilder.addQueryParameter(it.key, it.value.toString())
                    }
                }
            }

            return Request.Builder()
                .url(httpBuilder.build())
                .headers(requestHeaders)
                .get()
                .build()
        }

        val body = if (MultipartBody.FORM.toString() == headers["content-type"]) {
            val builder = MultipartBody.Builder().setType(MultipartBody.FORM)

            filteredParams.forEach {
                when {
                    it.key == "file" -> {
                        builder.addPart(it.value as MultipartBody.Part)
                    }
                    it.value is List<*> -> {
                        val list = it.value as List<*>
                        for (index in list.indices) {
                            builder.addFormDataPart(
                                "${it.key}[]",
                                list[index].toString()
                            )
                        }
                    }
                    it.value is Payload -> {
                        val payload = it.value as Payload
                        if (payload.sourceType == "path") {
                            builder.addFormDataPart(it.key, payload.filename, File(payload.path).asRequestBody())
                        } else {
                            builder.addFormDataPart(it.key, payload.toString())
                        }
                    }
                    else -> {
                        builder.addFormDataPart(it.key, it.value.toString())
                    }
                }
            }
            builder.build()
        } else {
            filteredParams
                .toJson()
                .toRequestBody("application/json".toMediaType())
        }

        return Request.Builder()
            .url(httpBuilder.build())
            .headers(requestHeaders)
            .method(method, body)
            .build()
    }

    /**
     * Send the HTTP request
     *
     * @param method
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> call(
        method: String,
        path: String,
        headers:  Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
        responseType: Class<T>,
        converter: ((Any) -> T)? = null
    ): T {
        val request = prepareRequest(method, path, headers, params)
        return awaitResponse(request, responseType, converter)
    }

    /**
     * Send the HTTP request
     *
     * @param method
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    suspend fun redirect(
        method: String,
        path: String,
        headers:  Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
    ): String {
        val request = prepareRequest(method, path, headers, params)
        val response = awaitRedirect(request)
        return response.header("Location") ?: ""
    }

    /**
     * Upload a file in chunks
     *
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> chunkedUpload(
        path: String,
        headers:  MutableMap<String, String>,
        params: MutableMap<String, Any?>,
        responseType: Class<T>,
        converter: ((Any) -> T),
        paramName: String,
        idParamName: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null,
    ): T {
        var file: RandomAccessFile? = null
        val input = params[paramName] as Payload
        val size: Long = when(input.sourceType) {
            "path", "file" -> {
                file = RandomAccessFile(input.path, "r")
                file.length()
            }
            "bytes" -> {
                input.toBinary().size.toLong()
            }
            else -> throw UnsupportedOperationException()
        }

        if (size < CHUNK_SIZE) {
            val data = when(input.sourceType) {
                "file", "path" -> File(input.path).asRequestBody()
                "bytes" -> input.toBinary().toRequestBody(input.mimeType?.toMediaType())
                else -> throw UnsupportedOperationException()
            }
            params[paramName] = MultipartBody.Part.createFormData(
                paramName,
                input.filename,
                data
            )
            return call(
                method = "POST",
                path,
                headers,
                params,
                responseType,
                converter
            )
        }

        val buffer = ByteArray(CHUNK_SIZE)
        var offset = 0L
        var result: Map<*, *>? = null

        if (idParamName?.isNotEmpty() == true && params[idParamName] != "unique()") {
            // Make a request to check if a file already exists
            val current = call(
                method = "GET",
                path = "$path/${params[idParamName]}",
                headers = headers,
                params = emptyMap(),
                responseType = Map::class.java,
            )
            val chunksUploaded = current["chunksUploaded"] as Long
            offset = chunksUploaded * CHUNK_SIZE
        }

        while (offset < size) {
            when(input.sourceType) {
                "file", "path" -> {
                    file!!.seek(offset)
                    file!!.read(buffer)
                }
                "bytes" -> {
                    val end = if (offset + CHUNK_SIZE < size) {
                        offset + CHUNK_SIZE - 1
                    } else {
                        size - 1
                    }
                    input.toBinary().copyInto(
                        buffer,
                        startIndex = offset.toInt(),
                        endIndex = end.toInt()
                    )
                }
                else -> throw UnsupportedOperationException()
            }

            params[paramName] = MultipartBody.Part.createFormData(
                paramName,
                input.filename,
                buffer.toRequestBody()
            )

            headers["Content-Range"] =
                "bytes $offset-${((offset + CHUNK_SIZE) - 1).coerceAtMost(size - 1)}/$size"

            result = call(
                method = "POST",
                path,
                headers,
                params,
                responseType = Map::class.java
            )

            offset += CHUNK_SIZE
            headers["x-appwrite-id"] = result!!["\$id"].toString()
            onProgress?.invoke(
                UploadProgress(
                    id = result!!["\$id"].toString(),
                    progress = offset.coerceAtMost(size).toDouble() / size * 100,
                    sizeUploaded = offset.coerceAtMost(size),
                    chunksTotal = result!!["chunksTotal"].toString().toInt(),
                    chunksUploaded = result!!["chunksUploaded"].toString().toInt(),
                )
            )
        }

        return converter(result as Map<String, Any>)
    }

    /**
     * Await Redirect
     *
     * @param request
     * @param responseType

     * @return [Response]
     */
    @Throws(AppwriteException::class)
    private suspend fun awaitRedirect(
        request: Request
    ) = suspendCancellableCoroutine<Response> {
        httpForRedirect.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                if (it.isCancelled) {
                    return
                }
                it.cancel(e)
            }

            @Suppress("UNCHECKED_CAST")
            override fun onResponse(call: Call, response: Response) {
                if (response.code < 300 || response.code >= 400) {
                    val body = response.body!!
                        .charStream()
                        .buffered()
                        .use(BufferedReader::readText)

                    val error = if (response.headers["content-type"]?.contains("application/json") == true) {
                        val map = body.fromJson<Map<String, Any>>()

                        AppwriteException(
                            map["message"] as? String ?: "",
                            (map["code"] as Number).toInt(),
                            map["type"] as? String ?: "",
                            body
                        )
                    } else {
                        AppwriteException(body, response.code)
                    }
                    it.cancel(error)
                    return
                }
                it.resume(response)
            }
        })
    }

    /**
     * Await Response
     *
     * @param request
     * @param responseType
     * @param converter
     *
     * @return [T]
     */
    @Throws(AppwriteException::class)
    private suspend fun <T> awaitResponse(
        request: Request,
        responseType: Class<T>,
        converter: ((Any) -> T)? = null
    ) = suspendCancellableCoroutine<T> {
        http.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                if (it.isCancelled) {
                    return
                }
                it.cancel(e)
            }

            @Suppress("UNCHECKED_CAST")
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    val body = response.body!!
                        .charStream()
                        .buffered()
                        .use(BufferedReader::readText)

                    val error = if (response.headers["content-type"]?.contains("application/json") == true) {
                        val map = body.fromJson<Map<String, Any>>()

                        AppwriteException(
                            map["message"] as? String ?: "",
                            (map["code"] as Number).toInt(),
                            map["type"] as? String ?: "",
                            body
                        )
                    } else {
                        AppwriteException(body, response.code)
                    }
                    it.cancel(error)
                    return
                }

                val warnings = response.headers["x-appwrite-warning"]
                if (warnings != null) {
                    warnings.split(";").forEach { warning ->
                        println("Warning: $warning")
                    }
                }

                when {
                    responseType == Boolean::class.java -> {
                        it.resume(true as T)
                        return
                    }
                    responseType == ByteArray::class.java -> {
                        it.resume(response.body!!
                            .byteStream()
                            .buffered()
                            .use(BufferedInputStream::readBytes) as T
                        )
                        return
                    }
                    response.body == null -> {
                        it.resume(true as T)
                        return
                    }
                }
                if (response.headers["content-type"]?.contains("multipart/form-data") == true) {
                    val binaryBody = response.body!!.bytes()
                    val body = String(binaryBody)
                    val map = body.fromMultiPart(binaryBody)
                    it.resume(converter?.invoke(map) ?: map as T)
                    return
                }

                val body = response.body!!
                    .charStream()
                    .buffered()
                    .use(BufferedReader::readText)
                if (body.isEmpty()) {
                    it.resume(true as T)
                    return
                }

                val map = body.fromJson<Map<String, Any>>()
                it.resume(
                    converter?.invoke(map) ?: map as T
                )
            }
        })
    }
}
