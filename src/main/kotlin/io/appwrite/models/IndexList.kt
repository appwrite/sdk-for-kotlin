package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Indexes List
 */
data class IndexList(
    /**
     * Total number of indexes documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of indexes.
     *
     */
    @SerializedName("indexes")
    val indexes: List<Index>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = IndexList(
            total = (map["total"] as Number).toLong(),
            indexes = (map["indexes"] as List<Map<String, Any>>).map { Index.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "indexes" to indexes.map { it.toMap() } as Any
    )
}