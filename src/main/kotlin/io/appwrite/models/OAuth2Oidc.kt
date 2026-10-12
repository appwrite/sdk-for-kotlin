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
     * OpenID Connect prompt values controlling the authentication and consent screens.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2OidcPrompt>,

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
     * Maximum authentication age in seconds. When set, the user must have authenticated within this many seconds.
     */
    @SerializedName("maxAge")
    var maxAge: Long?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "prompt" to prompt as Any,
        "wellKnownURL" to wellKnownURL as Any,
        "authorizationURL" to authorizationURL as Any,
        "tokenURL" to tokenURL as Any,
        "userInfoURL" to userInfoURL as Any,
        "maxAge" to maxAge as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Oidc(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            clientId = (if (map.containsKey("clientId")) map["clientId"] else "") as String,
            clientSecret = (if (map.containsKey("clientSecret")) map["clientSecret"] else "") as String,
            prompt = (if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>()) as List<io.appwrite.enums.OAuth2OidcPrompt>,
            wellKnownURL = (if (map.containsKey("wellKnownURL")) map["wellKnownURL"] else "") as String,
            authorizationURL = (if (map.containsKey("authorizationURL")) map["authorizationURL"] else "") as String,
            tokenURL = (if (map.containsKey("tokenURL")) map["tokenURL"] else "") as String,
            userInfoURL = (if (map.containsKey("userInfoURL")) map["userInfoURL"] else "") as String,
            maxAge = (map["maxAge"] as? Number)?.toLong(),
        )
    }
}
