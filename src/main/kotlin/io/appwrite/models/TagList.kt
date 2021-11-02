package io.appwrite.models

/// Tags List
data class TagList(
    val sum: Long,
    val tags: List<Tag>
) {
    companion object {
        fun from(map: Map<String, Any>) = TagList(
            sum = map["sum"] as Long,
            tags = (map["tags"] as List<Map<String, Any>>).map { Tag.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "tags" to tags.map { it.toMap() } as Any
    )
}