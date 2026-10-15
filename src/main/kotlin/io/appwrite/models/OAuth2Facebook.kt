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
    fun toMap(): Map<String, Any?> = mapOf(
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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            appId = (if (map.containsKey("appId")) map["appId"] else "") as String,
            appSecret = (if (map.containsKey("appSecret")) map["appSecret"] else "") as String,
        )
    }
}
