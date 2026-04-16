package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Platforms List
 */
data class PlatformList(
    /**
     * Total number of platforms in the given project.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of platforms.
     */
    @SerializedName("platforms")
    val platforms: List<Any>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "platforms" to platforms as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PlatformList(
            total = (map["total"] as Number).toLong(),
            platforms = map["platforms"] as List<Any>,
        )
    }
}