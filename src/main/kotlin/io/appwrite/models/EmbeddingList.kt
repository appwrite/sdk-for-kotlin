package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Embedding list
 */
data class EmbeddingList(
    /**
     * Total number of embeddings that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of embeddings.
     */
    @SerializedName("embeddings")
    val embeddings: List<Embedding>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "embeddings" to embeddings.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EmbeddingList(
            total = (map["total"] as Number).toLong(),
            embeddings = (map["embeddings"] as List<Map<String, Any>>).map { Embedding.from(map = it) },
        )
    }
}