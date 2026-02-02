package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Status List
 */
data class HealthStatusList(
    /**
     * Total number of statuses that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of statuses.
     */
    @SerializedName("statuses")
    val statuses: List<HealthStatus>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "statuses" to statuses.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = HealthStatusList(
            total = (map["total"] as Number).toLong(),
            statuses = (map["statuses"] as List<Map<String, Any>>).map { HealthStatus.from(map = it) },
        )
    }
}