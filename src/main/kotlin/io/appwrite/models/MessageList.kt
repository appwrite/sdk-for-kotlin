package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Message list
 */
data class MessageList(
    /**
     * Total number of messages that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of messages.
     */
    @SerializedName("messages")
    val messages: List<Message>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "messages" to messages.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MessageList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            messages = ((if (map.containsKey("messages")) map["messages"] else listOf<Any?>()) as List<Map<String, Any>>).map { Message.from(map = it) },
        )
    }
}
