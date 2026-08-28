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
            rows = map["rows"] as List<Map<String, Any?>>,
            rowCount = (map["rowCount"] as Number).toLong(),
            columns = (map["columns"] as List<Map<String, Any>>).map { DedicatedDatabaseExecutionColumn.from(map = it) },
            durationMs = (map["durationMs"] as Number).toLong(),
            truncated = map["truncated"] as Boolean,
            bytes = (map["bytes"] as Number).toLong(),
        )
    }
}
