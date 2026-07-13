package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Linkedin
 */
data class OAuth2Linkedin(
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
     * LinkedIn OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * LinkedIn OAuth2 primary client secret.
     */
    @SerializedName("primaryClientSecret")
    val primaryClientSecret: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "primaryClientSecret" to primaryClientSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Linkedin(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            primaryClientSecret = map["primaryClientSecret"] as String,
        )
    }
}
