package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Introspection
 */
data class Oauth2Introspection(
    /**
     * Whether the token is currently active. An inactive token carries no other claims (RFC 7662).
     */
    @SerializedName("active")
    val active: Boolean,

    /**
     * Kind of token that was introspected. Can be one of: `access_token` or `refresh_token`.
     */
    @SerializedName("token_use")
    var token_use: String?,

    /**
     * OAuth2 token type.
     */
    @SerializedName("token_type")
    var token_type: String?,

    /**
     * Space-separated scopes granted to the token.
     */
    @SerializedName("scope")
    var scope: String?,

    /**
     * OAuth2 client ID the token was issued to.
     */
    @SerializedName("client_id")
    var client_id: String?,

    /**
     * ID of the user who authorized the token.
     */
    @SerializedName("sub")
    var sub: String?,

    /**
     * Audiences the token is intended for. The first entry is the project API base URL; any further entries are the resource indicators requested at authorization time (RFC 8707).
     */
    @SerializedName("aud")
    var aud: List<String>?,

    /**
     * Issuer URL of the token.
     */
    @SerializedName("iss")
    var iss: String?,

    /**
     * Expiration time as a Unix timestamp in seconds.
     */
    @SerializedName("exp")
    var exp: Long?,

    /**
     * Issued-at time as a Unix timestamp in seconds.
     */
    @SerializedName("iat")
    var iat: Long?,

    /**
     * Unique identifier of the token.
     */
    @SerializedName("jti")
    var jti: String?,

    /**
     * Granted RFC 9396 authorization details, restricted to what the user can currently access.
     */
    @SerializedName("authorization_details")
    var authorization_details: List<Map<String, Any?>>?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "active" to active as Any,
        "token_use" to token_use as Any?,
        "token_type" to token_type as Any?,
        "scope" to scope as Any?,
        "client_id" to client_id as Any?,
        "sub" to sub as Any?,
        "aud" to aud as Any?,
        "iss" to iss as Any?,
        "exp" to exp as Any?,
        "iat" to iat as Any?,
        "jti" to jti as Any?,
        "authorization_details" to authorization_details as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Oauth2Introspection(
            active = (if (map.containsKey("active")) map["active"] else false) as Boolean,
            token_use = map["token_use"] as? String,
            token_type = map["token_type"] as? String,
            scope = map["scope"] as? String,
            client_id = map["client_id"] as? String,
            sub = map["sub"] as? String,
            aud = map["aud"] as? List<String>,
            iss = map["iss"] as? String,
            exp = (map["exp"] as? Number)?.toLong(),
            iat = (map["iat"] as? Number)?.toLong(),
            jti = map["jti"] as? String,
            authorization_details = map["authorization_details"] as? List<Map<String, Any?>>,
        )
    }
}
