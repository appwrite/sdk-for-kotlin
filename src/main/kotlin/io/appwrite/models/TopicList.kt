package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Topic list
 */
data class TopicList(
    /**
     * Total number of topics rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of topics.
     */
    @SerializedName("topics")
    val topics: List<Topic>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "topics" to topics.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TopicList(
            total = (map["total"] as Number).toLong(),
            topics = (map["topics"] as List<Map<String, Any>>).map { Topic.from(map = it) },
        )
    }
}