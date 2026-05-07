package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Notion
 */
data class OAuth2Notion(
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
     * Notion OAuth2 client ID.
     */
    @SerializedName("oauthClientId")
    val oauthClientId: String,

    /**
     * Notion OAuth2 client secret.
     */
    @SerializedName("oauthClientSecret")
    val oauthClientSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "oauthClientId" to oauthClientId as Any,
        "oauthClientSecret" to oauthClientSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Notion(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            oauthClientId = map["oauthClientId"] as String,
            oauthClientSecret = map["oauthClientSecret"] as String,
        )
    }
}