package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Activity event list
 */
data class ActivityEventList(
    /**
     * Total number of events that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of events.
     */
    @SerializedName("events")
    val events: List<ActivityEvent>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "events" to events.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ActivityEventList(
            total = (map["total"] as Number).toLong(),
            events = (map["events"] as List<Map<String, Any>>).map { ActivityEvent.from(map = it) },
        )
    }
}