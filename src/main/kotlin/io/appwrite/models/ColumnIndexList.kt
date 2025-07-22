package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Column Indexes List
 */
data class ColumnIndexList(
    /**
     * Total number of indexes rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of indexes.
     */
    @SerializedName("indexes")
    val indexes: List<ColumnIndex>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "indexes" to indexes.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnIndexList(
            total = (map["total"] as Number).toLong(),
            indexes = (map["indexes"] as List<Map<String, Any>>).map { ColumnIndex.from(map = it) },
        )
    }
}