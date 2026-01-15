package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Columns List
 */
data class ColumnList(
    /**
     * Total number of columns in the given table.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of columns.
     */
    @SerializedName("columns")
    val columns: List<Any>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "columns" to columns as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnList(
            total = (map["total"] as Number).toLong(),
            columns = map["columns"] as List<Any>,
        )
    }
}