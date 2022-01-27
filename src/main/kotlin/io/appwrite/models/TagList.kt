package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Tags List
 */
data class TagList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of tags.
     *
     */
    @SerializedName("tags")
    val tags: List<Tag>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = TagList(
            sum = (map["sum"] as Number).toLong(),
            tags = (map["tags"] as List<Map<String, Any>>).map { Tag.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "tags" to tags.map { it.toMap() } as Any
    )
}