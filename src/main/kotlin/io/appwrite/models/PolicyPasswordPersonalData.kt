package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password Personal Data
 */
data class PolicyPasswordPersonalData(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether password personal data policy is enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Custom terms blocked by case-insensitive substring matching when enabled.
     */
    @SerializedName("denyList")
    val denyList: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "denyList" to denyList as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasswordPersonalData(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            denyList = (if (map.containsKey("denyList")) map["denyList"] else listOf<Any?>()) as List<String>,
        )
    }
}
