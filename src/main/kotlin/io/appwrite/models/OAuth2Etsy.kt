package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Etsy
 */
data class OAuth2Etsy(
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
     * Etsy OAuth2 keystring.
     */
    @SerializedName("keyString")
    val keyString: String,

    /**
     * Etsy OAuth2 shared secret.
     */
    @SerializedName("sharedSecret")
    val sharedSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "keyString" to keyString as Any,
        "sharedSecret" to sharedSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Etsy(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            keyString = map["keyString"] as String,
            sharedSecret = map["sharedSecret"] as String,
        )
    }
}