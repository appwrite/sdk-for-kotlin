package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Video Profiles List
 */
data class VideoProfileList(
    /**
     * Total number of profiles that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of profiles.
     */
    @SerializedName("profiles")
    val profiles: List<VideoProfile>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "profiles" to profiles.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoProfileList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            profiles = ((if (map.containsKey("profiles")) map["profiles"] else listOf<Any?>()) as List<Map<String, Any>>).map { VideoProfile.from(map = it) },
        )
    }
}
