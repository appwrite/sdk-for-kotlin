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
class Embeddings(client: Client) : Service(client) {

    /**
     * Generate vector embeddings for an array of text using the selected embedding model. Use the returned vectors to power semantic search and similarity queries against your vector collections.
     * 
     *
     * @param texts Array of text to generate embeddings.
     * @param model The embedding model to use for generating vector embeddings.
     * @return [io.appwrite.models.EmbeddingList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTextEmbeddings(
        texts: List<String>,
        model: io.appwrite.enums.EmbeddingModel? = null,
    ): io.appwrite.models.EmbeddingList {
        val apiPath = ("/embeddings/text"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "texts" to texts,
            "model" to model,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.EmbeddingList = {
            io.appwrite.models.EmbeddingList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EmbeddingList::class.java,
            converter,
        )
    }

}
