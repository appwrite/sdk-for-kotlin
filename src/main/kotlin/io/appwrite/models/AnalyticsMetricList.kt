package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AnalyticsMetricList
 */
data class AnalyticsMetricList(
    /**
     * Total number of metric rows returned.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * Metric rows: one per time bucket, one per dimension value, or a single row for the flat aggregate.
     */
    @SerializedName("metrics")
    val metrics: List<AnalyticsMetric>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "metrics" to metrics.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsMetricList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            metrics = ((if (map.containsKey("metrics")) map["metrics"] else listOf<Any?>()) as List<Map<String, Any>>).map { AnalyticsMetric.from(map = it) },
        )
    }
}
