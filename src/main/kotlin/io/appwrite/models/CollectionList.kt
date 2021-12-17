package io.appwrite.models

/// Collections List
data class CollectionList(
    val sum: Long,
    val collections: List<Collection>
) {
    companion object {
        fun from(map: Map<String, Any>) = CollectionList(
            sum = map["sum"] as Long,
            collections = (map["collections"] as List<Map<String, Any>>).map { Collection.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "collections" to collections.map { it.toMap() } as Any
    )
}