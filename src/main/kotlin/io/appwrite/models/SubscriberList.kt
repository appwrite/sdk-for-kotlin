package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Subscriber list
 */
data class SubscriberList(
    /**
     * Total number of subscribers that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of subscribers.
     */
    @SerializedName("subscribers")
    val subscribers: List<Subscriber>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "subscribers" to subscribers.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = SubscriberList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            subscribers = ((if (map.containsKey("subscribers")) map["subscribers"] else listOf<Any?>()) as List<Map<String, Any>>).map { Subscriber.from(map = it) },
        )
    }
}
