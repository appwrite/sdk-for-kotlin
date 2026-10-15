package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Collections List
 */
data class CollectionList(
    /**
     * Total number of collections that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of collections.
     */
    @SerializedName("collections")
    val collections: List<Collection>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "collections" to collections.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = CollectionList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            collections = ((if (map.containsKey("collections")) map["collections"] else listOf<Any?>()) as List<Map<String, Any>>).map { Collection.from(map = it) },
        )
    }
}
