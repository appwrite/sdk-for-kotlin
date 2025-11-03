package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Tokens(client: Client) : Service(client) {

    /**
     * List all the tokens created for a specific file or bucket. You can use the query params to filter your results.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: expire
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.ResourceTokenList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        bucketId: String,
        fileId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ResourceTokenList {
        val apiPath = "/tokens/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ResourceTokenList = {
            io.appwrite.models.ResourceTokenList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ResourceTokenList::class.java,
            converter,
        )
    }

    /**
     * Create a new token. A token is linked to a file. Token can be passed as a request URL search parameter.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param expire Token expiry date
     * @return [io.appwrite.models.ResourceToken]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFileToken(
        bucketId: String,
        fileId: String,
        expire: String? = null,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

        val apiParams = mutableMapOf<String, Any?>(
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ResourceToken = {
            io.appwrite.models.ResourceToken.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ResourceToken::class.java,
            converter,
        )
    }

    /**
     * Get a token by its unique ID.
     *
     * @param tokenId Token ID.
     * @return [io.appwrite.models.ResourceToken]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        tokenId: String,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ResourceToken = {
            io.appwrite.models.ResourceToken.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ResourceToken::class.java,
            converter,
        )
    }

    /**
     * Update a token by its unique ID. Use this endpoint to update a token's expiry date.
     *
     * @param tokenId Token unique ID.
     * @param expire File token expiry date
     * @return [io.appwrite.models.ResourceToken]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        tokenId: String,
        expire: String? = null,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)

        val apiParams = mutableMapOf<String, Any?>(
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ResourceToken = {
            io.appwrite.models.ResourceToken.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ResourceToken::class.java,
            converter,
        )
    }

    /**
     * Delete a token by its unique ID.
     *
     * @param tokenId Token ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        tokenId: String,
    ): Any {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

}