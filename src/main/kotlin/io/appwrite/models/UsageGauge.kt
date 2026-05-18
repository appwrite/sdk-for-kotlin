package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * usageGauge
 */
data class UsageGauge(
    /**
     * The metric key.
     */
    @SerializedName("metric")
    val metric: String,

    /**
     * The current snapshot value.
     */
    @SerializedName("value")
    val value: Long,

    /**
     * The snapshot timestamp.
     */
    @SerializedName("time")
    val time: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "metric" to metric as Any,
        "value" to value as Any,
        "time" to time as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageGauge(
            metric = map["metric"] as String,
            value = (map["value"] as Number).toLong(),
            time = map["time"] as String,
        )
    }
}