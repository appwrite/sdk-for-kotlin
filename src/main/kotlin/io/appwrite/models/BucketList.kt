package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Buckets List
 */
data class BucketList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of buckets.
     *
     */
    @SerializedName("buckets")
    val buckets: List<Bucket>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = BucketList(
            sum = (map["sum"] as Number).toLong(),
            buckets = (map["buckets"] as List<Map<String, Any>>).map { Bucket.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "buckets" to buckets.map { it.toMap() } as Any
    )
}