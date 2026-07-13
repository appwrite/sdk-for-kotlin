package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Disqus
 */
data class OAuth2Disqus(
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
     * Disqus OAuth2 public key.
     */
    @SerializedName("publicKey")
    val publicKey: String,

    /**
     * Disqus OAuth2 secret key.
     */
    @SerializedName("secretKey")
    val secretKey: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "publicKey" to publicKey as Any,
        "secretKey" to secretKey as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Disqus(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            publicKey = map["publicKey"] as String,
            secretKey = map["secretKey"] as String,
        )
    }
}
