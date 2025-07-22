package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Buckets List
 */
data class BucketList(
    /**
     * Total number of buckets rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of buckets.
     */
    @SerializedName("buckets")
    val buckets: List<Bucket>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "buckets" to buckets.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BucketList(
            total = (map["total"] as Number).toLong(),
            buckets = (map["buckets"] as List<Map<String, Any>>).map { Bucket.from(map = it) },
        )
    }
}