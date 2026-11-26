package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.VideoCodecId
import io.appwrite.extensions.jsonCast

/**
 * Video profile
 */
data class VideoProfile(
    /**
     * Video profile ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Video profile creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Video profile update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Video profile name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Video encode codec: one of `h264`, `hevc`, or `vp9`.
     */
    @SerializedName("codec")
    val codec: VideoCodecId,

    /**
     * Target video bitrate in bits per second.
     */
    @SerializedName("videoBitRate")
    val videoBitRate: Long,

    /**
     * Target audio bitrate in bits per second.
     */
    @SerializedName("audioBitRate")
    val audioBitRate: Long,

    /**
     * Target video width in pixels.
     */
    @SerializedName("width")
    val width: Long,

    /**
     * Target video height in pixels.
     */
    @SerializedName("height")
    val height: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "codec" to codec.value as Any,
        "videoBitRate" to videoBitRate as Any,
        "audioBitRate" to audioBitRate as Any,
        "width" to width as Any,
        "height" to height as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = VideoProfile(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            codec = VideoCodecId.values().find { it.value == (if (map.containsKey("codec")) map["codec"] else "h264") as String }!!,
            videoBitRate = ((if (map.containsKey("videoBitRate")) map["videoBitRate"] else 0) as Number).toLong(),
            audioBitRate = ((if (map.containsKey("audioBitRate")) map["audioBitRate"] else 0) as Number).toLong(),
            width = ((if (map.containsKey("width")) map["width"] else 0) as Number).toLong(),
            height = ((if (map.containsKey("height")) map["height"] else 0) as Number).toLong(),
        )
    }
}
