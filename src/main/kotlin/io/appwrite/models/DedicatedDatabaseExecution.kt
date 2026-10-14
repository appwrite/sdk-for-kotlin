package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Execution
 */
data class DedicatedDatabaseExecution(
    /**
     * Result rows as a list of column-name => value maps. Empty for non-returning statements.
     */
    @SerializedName("rows")
    val rows: List<Map<String, Any?>>,

    /**
     * Number of rows returned (for SELECT) or affected (for INSERT/UPDATE/DELETE).
     */
    @SerializedName("rowCount")
    val rowCount: Long,

    /**
     * Column metadata in result-set order.
     */
    @SerializedName("columns")
    val columns: List<DedicatedDatabaseExecutionColumn>,

    /**
     * Server-side execution time in milliseconds.
     */
    @SerializedName("durationMs")
    val durationMs: Long,

    /**
     * True when the configured row or byte cap was hit and the result was truncated.
     */
    @SerializedName("truncated")
    val truncated: Boolean,

    /**
     * Serialised payload size in bytes.
     */
    @SerializedName("bytes")
    val bytes: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "rows" to rows as Any,
        "rowCount" to rowCount as Any,
        "columns" to columns.map { it.toMap() } as Any,
        "durationMs" to durationMs as Any,
        "truncated" to truncated as Any,
        "bytes" to bytes as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseExecution(
            rows = (if (map.containsKey("rows")) map["rows"] else listOf<Any?>()) as List<Map<String, Any?>>,
            rowCount = ((if (map.containsKey("rowCount")) map["rowCount"] else 0) as Number).toLong(),
            columns = ((if (map.containsKey("columns")) map["columns"] else listOf<Any?>()) as List<Map<String, Any>>).map { DedicatedDatabaseExecutionColumn.from(map = it) },
            durationMs = ((if (map.containsKey("durationMs")) map["durationMs"] else 0) as Number).toLong(),
            truncated = (if (map.containsKey("truncated")) map["truncated"] else false) as Boolean,
            bytes = ((if (map.containsKey("bytes")) map["bytes"] else 0) as Number).toLong(),
        )
    }
}
