package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Alerts List
 */
data class AlertList(
    /**
     * Total number of alerts that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of alerts.
     */
    @SerializedName("alerts")
    val alerts: List<Alert>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "alerts" to alerts.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlertList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            alerts = ((if (map.containsKey("alerts")) map["alerts"] else listOf<Any?>()) as List<Map<String, Any>>).map { Alert.from(map = it) },
        )
    }
}
