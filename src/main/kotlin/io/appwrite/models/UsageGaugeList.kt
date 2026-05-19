package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Usage gauges list
 */
data class UsageGaugeList(
    /**
     * Total number of gauges that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of gauges.
     */
    @SerializedName("gauges")
    val gauges: List<UsageGauge>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "gauges" to gauges.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageGaugeList(
            total = (map["total"] as Number).toLong(),
            gauges = (map["gauges"] as List<Map<String, Any>>).map { UsageGauge.from(map = it) },
        )
    }
}