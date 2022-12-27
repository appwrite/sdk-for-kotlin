package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Health service allows you to both validate and monitor your Appwrite server&#039;s health.
**/
class Health : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Get HTTP
     *
     * Check the Appwrite HTTP server is up and responsive.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ): io.appwrite.models.HealthStatus {
        val path = "/health"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
                io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get Antivirus
     *
     * Check the Appwrite Antivirus server is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthAntivirus]
     */
    @Throws(AppwriteException::class)
    suspend fun getAntivirus(
    ): io.appwrite.models.HealthAntivirus {
        val path = "/health/anti-virus"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthAntivirus = {
                io.appwrite.models.HealthAntivirus.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthAntivirus::class.java,
            converter,
        )
    }

    /**
     * Get Cache
     *
     * Check the Appwrite in-memory cache server is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getCache(
    ): io.appwrite.models.HealthStatus {
        val path = "/health/cache"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
                io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get DB
     *
     * Check the Appwrite database server is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getDB(
    ): io.appwrite.models.HealthStatus {
        val path = "/health/db"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
                io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get Certificates Queue
     *
     * Get the number of certificates that are waiting to be issued against [Letsencrypt](https://letsencrypt.org/) in the Appwrite internal queue server.
     *
     * @return [io.appwrite.models.HealthQueue]
     */
    @Throws(AppwriteException::class)
    suspend fun getQueueCertificates(
    ): io.appwrite.models.HealthQueue {
        val path = "/health/queue/certificates"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
                io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get Functions Queue
     *
     * 
     *
     * @return [io.appwrite.models.HealthQueue]
     */
    @Throws(AppwriteException::class)
    suspend fun getQueueFunctions(
    ): io.appwrite.models.HealthQueue {
        val path = "/health/queue/functions"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
                io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get Logs Queue
     *
     * Get the number of logs that are waiting to be processed in the Appwrite internal queue server.
     *
     * @return [io.appwrite.models.HealthQueue]
     */
    @Throws(AppwriteException::class)
    suspend fun getQueueLogs(
    ): io.appwrite.models.HealthQueue {
        val path = "/health/queue/logs"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
                io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get Webhooks Queue
     *
     * Get the number of webhooks that are waiting to be processed in the Appwrite internal queue server.
     *
     * @return [io.appwrite.models.HealthQueue]
     */
    @Throws(AppwriteException::class)
    suspend fun getQueueWebhooks(
    ): io.appwrite.models.HealthQueue {
        val path = "/health/queue/webhooks"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
                io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get Local Storage
     *
     * Check the Appwrite local storage device is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getStorageLocal(
    ): io.appwrite.models.HealthStatus {
        val path = "/health/storage/local"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
                io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get Time
     *
     * Check the Appwrite server time is synced with Google remote NTP server. We use this technology to smoothly handle leap seconds with no disruptive events. The [Network Time Protocol](https://en.wikipedia.org/wiki/Network_Time_Protocol) (NTP) is used by hundreds of millions of computers and devices to synchronize their clocks over the Internet. If your computer sets its own clock, it likely uses NTP.
     *
     * @return [io.appwrite.models.HealthTime]
     */
    @Throws(AppwriteException::class)
    suspend fun getTime(
    ): io.appwrite.models.HealthTime {
        val path = "/health/time"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthTime = {
                io.appwrite.models.HealthTime.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.HealthTime::class.java,
            converter,
        )
    }

}