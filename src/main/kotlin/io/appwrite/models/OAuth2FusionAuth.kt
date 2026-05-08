package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2FusionAuth
 */
data class OAuth2FusionAuth(
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
     * FusionAuth OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * FusionAuth OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * FusionAuth OAuth2 endpoint domain.
     */
    @SerializedName("endpoint")
    val endpoint: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "endpoint" to endpoint as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2FusionAuth(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            clientSecret = map["clientSecret"] as String,
            endpoint = map["endpoint"] as String,
        )
    }
}