package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Topic list
 */
data class TopicList(
    /**
     * Total number of topics that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of topics.
     */
    @SerializedName("topics")
    val topics: List<Topic>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "topics" to topics.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TopicList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            topics = ((if (map.containsKey("topics")) map["topics"] else listOf<Any?>()) as List<Map<String, Any>>).map { Topic.from(map = it) },
        )
    }
}
