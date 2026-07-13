package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Dropbox
 */
data class OAuth2Dropbox(
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
     * Dropbox OAuth2 app key.
     */
    @SerializedName("appKey")
    val appKey: String,

    /**
     * Dropbox OAuth2 app secret.
     */
    @SerializedName("appSecret")
    val appSecret: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "appKey" to appKey as Any,
        "appSecret" to appSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Dropbox(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            appKey = map["appKey"] as String,
            appSecret = map["appSecret"] as String,
        )
    }
}
