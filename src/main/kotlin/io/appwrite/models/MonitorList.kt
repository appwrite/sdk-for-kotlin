package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Monitors List
 */
data class MonitorList(
    /**
     * Total number of monitors that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of monitors.
     */
    @SerializedName("monitors")
    val monitors: List<Monitor>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "monitors" to monitors.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MonitorList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            monitors = ((if (map.containsKey("monitors")) map["monitors"] else listOf<Any?>()) as List<Map<String, Any>>).map { Monitor.from(map = it) },
        )
    }
}
