package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Embedding
 */
data class Embedding(
    /**
     * Embedding model used to generate embeddings.
     */
    @SerializedName("model")
    val model: String,

    /**
     * Number of dimensions for each embedding vector.
     */
    @SerializedName("dimension")
    val dimension: Long,

    /**
     * Embedding vector values. If an error occurs, this will be an empty array.
     */
    @SerializedName("embedding")
    val embedding: List<Double>,

    /**
     * Error message if embedding generation fails. Empty string if no error.
     */
    @SerializedName("error")
    val error: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "model" to model as Any,
        "dimension" to dimension as Any,
        "embedding" to embedding as Any,
        "error" to error as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Embedding(
            model = map["model"] as String,
            dimension = (map["dimension"] as Number).toLong(),
            embedding = map["embedding"] as List<Double>,
            error = map["error"] as String,
        )
    }
}