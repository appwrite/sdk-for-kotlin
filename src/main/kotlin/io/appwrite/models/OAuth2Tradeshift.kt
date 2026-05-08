package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Tradeshift
 */
data class OAuth2Tradeshift(
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
     * Tradeshift OAuth2 client ID.
     */
    @SerializedName("oauth2ClientId")
    val oauth2ClientId: String,

    /**
     * Tradeshift OAuth2 client secret.
     */
    @SerializedName("oauth2ClientSecret")
    val oauth2ClientSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "oauth2ClientId" to oauth2ClientId as Any,
        "oauth2ClientSecret" to oauth2ClientSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Tradeshift(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            oauth2ClientId = map["oauth2ClientId"] as String,
            oauth2ClientSecret = map["oauth2ClientSecret"] as String,
        )
    }
}