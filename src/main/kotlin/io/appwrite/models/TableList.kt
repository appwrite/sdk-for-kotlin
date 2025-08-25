package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Tables List
 */
data class TableList(
    /**
     * Total number of tables that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of tables.
     */
    @SerializedName("tables")
    val tables: List<Table>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "tables" to tables.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TableList(
            total = (map["total"] as Number).toLong(),
            tables = (map["tables"] as List<Map<String, Any>>).map { Table.from(map = it) },
        )
    }
}