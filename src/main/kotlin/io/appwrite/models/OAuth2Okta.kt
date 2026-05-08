package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Okta
 */
data class OAuth2Okta(
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
     * Okta OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Okta OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Okta OAuth2 domain.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Okta OAuth2 authorization server ID.
     */
    @SerializedName("authorizationServerId")
    val authorizationServerId: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "domain" to domain as Any,
        "authorizationServerId" to authorizationServerId as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Okta(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            clientSecret = map["clientSecret"] as String,
            domain = map["domain"] as String,
            authorizationServerId = map["authorizationServerId"] as String,
        )
    }
}