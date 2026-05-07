package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Facebook
 */
data class OAuth2Facebook(
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
     * Facebook OAuth2 app ID.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * Facebook OAuth2 app secret.
     */
    @SerializedName("appSecret")
    val appSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "appId" to appId as Any,
        "appSecret" to appSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Facebook(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            appId = map["appId"] as String,
            appSecret = map["appSecret"] as String,
        )
    }
}