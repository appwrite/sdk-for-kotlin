package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OperationList
 */
data class DedicatedDatabaseOperationList(
    /**
     * Total number of operations.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of operations.
     */
    @SerializedName("operations")
    val operations: List<DedicatedDatabaseOperation>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "operations" to operations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseOperationList(
            total = (map["total"] as Number).toLong(),
            operations = (map["operations"] as List<Map<String, Any>>).map { DedicatedDatabaseOperation.from(map = it) },
        )
    }
}
