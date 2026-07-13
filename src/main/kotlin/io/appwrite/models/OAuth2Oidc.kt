package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Oidc
 */
data class OAuth2Oidc(
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
     * OpenID Connect OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * OpenID Connect OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * OpenID Connect well-known configuration URL. When set, authorization, token, and user info endpoints can be discovered automatically.
     */
    @SerializedName("wellKnownURL")
    val wellKnownURL: String,

    /**
     * OpenID Connect authorization endpoint URL.
     */
    @SerializedName("authorizationURL")
    val authorizationURL: String,

    /**
     * OpenID Connect token endpoint URL.
     */
    @SerializedName("tokenURL")
    val tokenURL: String,

    /**
     * OpenID Connect user info endpoint URL.
     */
    @SerializedName("userInfoURL")
    val userInfoURL: String,

    /**
     * OpenID Connect prompt values controlling the authentication and consent screens.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2OidcPrompt>,

    /**
     * Maximum authentication age in seconds. When set, the user must have authenticated within this many seconds.
     */
    @SerializedName("maxAge")
    var maxAge: Long?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "wellKnownURL" to wellKnownURL as Any,
        "authorizationURL" to authorizationURL as Any,
        "tokenURL" to tokenURL as Any,
        "userInfoURL" to userInfoURL as Any,
        "prompt" to prompt as Any,
        "maxAge" to maxAge as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Oidc(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            clientSecret = map["clientSecret"] as String,
            wellKnownURL = map["wellKnownURL"] as String,
            authorizationURL = map["authorizationURL"] as String,
            tokenURL = map["tokenURL"] as String,
            userInfoURL = map["userInfoURL"] as String,
            prompt = map["prompt"] as List<io.appwrite.enums.OAuth2OidcPrompt>,
            maxAge = (map["maxAge"] as? Number)?.toLong(),
        )
    }
}