package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Column Indexes List
 */
data class ColumnIndexList(
    /**
     * Total number of indexes that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of indexes.
     */
    @SerializedName("indexes")
    val indexes: List<ColumnIndex>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "indexes" to indexes.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnIndexList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            indexes = ((if (map.containsKey("indexes")) map["indexes"] else listOf<Any?>()) as List<Map<String, Any>>).map { ColumnIndex.from(map = it) },
        )
    }
}
