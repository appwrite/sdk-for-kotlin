package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Session Invalidation
 */
data class PolicySessionInvalidation(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether session invalidation policy is enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicySessionInvalidation(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
        )
    }
}
