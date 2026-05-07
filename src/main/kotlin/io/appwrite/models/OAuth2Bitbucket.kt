package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Bitbucket
 */
data class OAuth2Bitbucket(
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
     * Bitbucket OAuth2 key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Bitbucket OAuth2 secret.
     */
    @SerializedName("secret")
    val secret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "key" to key as Any,
        "secret" to secret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Bitbucket(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            key = map["key"] as String,
            secret = map["secret"] as String,
        )
    }
}