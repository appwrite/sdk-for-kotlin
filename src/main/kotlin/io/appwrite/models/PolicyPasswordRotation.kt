package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password Rotation
 */
data class PolicyPasswordRotation(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether expired passwords require a reset before email/password sign-in.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Maximum password age in seconds.
     */
    @SerializedName("maxAge")
    val maxAge: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "maxAge" to maxAge as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasswordRotation(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            maxAge = ((if (map.containsKey("maxAge")) map["maxAge"] else 31536000) as Number).toLong(),
        )
    }
}
