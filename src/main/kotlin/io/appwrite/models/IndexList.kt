package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Indexes List
 */
data class IndexList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

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
            sum = (map["sum"] as Number).toLong(),
            indexes = (map["indexes"] as List<Map<String, Any>>).map { Index.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "indexes" to indexes.map { it.toMap() } as Any
    )
}