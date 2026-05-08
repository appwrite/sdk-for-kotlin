package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password Dictionary
 */
data class PolicyPasswordDictionary(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether password dictionary policy is enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasswordDictionary(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
        )
    }
}