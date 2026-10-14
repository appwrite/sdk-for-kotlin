package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Keycloak
 */
data class OAuth2Keycloak(
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
     * Keycloak OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Keycloak OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Keycloak OAuth2 endpoint domain.
     */
    @SerializedName("endpoint")
    val endpoint: String,

    /**
     * Keycloak OAuth2 realm name.
     */
    @SerializedName("realmName")
    val realmName: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "endpoint" to endpoint as Any,
        "realmName" to realmName as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Keycloak(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            clientId = (if (map.containsKey("clientId")) map["clientId"] else "") as String,
            clientSecret = (if (map.containsKey("clientSecret")) map["clientSecret"] else "") as String,
            endpoint = (if (map.containsKey("endpoint")) map["endpoint"] else "") as String,
            realmName = (if (map.containsKey("realmName")) map["realmName"] else "") as String,
        )
    }
}
