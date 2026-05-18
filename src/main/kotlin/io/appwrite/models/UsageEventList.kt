package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Usage events list
 */
data class UsageEventList(
    /**
     * Total number of events that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of events.
     */
    @SerializedName("events")
    val events: List<UsageEvent>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "events" to events.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageEventList(
            total = (map["total"] as Number).toLong(),
            events = (map["events"] as List<Map<String, Any>>).map { UsageEvent.from(map = it) },
        )
    }
}