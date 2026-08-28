package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Dedicated databases list
 */
data class DedicatedDatabaseList(
    /**
     * Total number of databases that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of databases.
     */
    @SerializedName("databases")
    val databases: List<DedicatedDatabase>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "databases" to databases.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseList(
            total = (map["total"] as Number).toLong(),
            databases = (map["databases"] as List<Map<String, Any>>).map { DedicatedDatabase.from(map = it) },
        )
    }
}
