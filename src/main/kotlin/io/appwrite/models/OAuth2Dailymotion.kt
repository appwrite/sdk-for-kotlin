package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Dailymotion
 */
data class OAuth2Dailymotion(
    /**
     * OAuth2 provider ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * OAuth2 provider is active and can be used to create sessions.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Dailymotion OAuth2 API key.
     */
    @SerializedName("apiKey")
    val apiKey: String,

    /**
     * Dailymotion OAuth2 API secret.
     */
    @SerializedName("apiSecret")
    val apiSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "apiKey" to apiKey as Any,
        "apiSecret" to apiSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Dailymotion(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            apiKey = map["apiKey"] as String,
            apiSecret = map["apiSecret"] as String,
        )
    }
}