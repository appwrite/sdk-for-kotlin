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
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "collections" to collections.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = CollectionList(
            total = (map["total"] as Number).toLong(),
            collections = (map["collections"] as List<Map<String, Any>>).map { Collection.from(map = it) },
        )
    }
}