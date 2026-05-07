package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Stripe
 */
data class OAuth2Stripe(
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
     * Stripe OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Stripe OAuth2 API secret key.
     */
    @SerializedName("apiSecretKey")
    val apiSecretKey: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "apiSecretKey" to apiSecretKey as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Stripe(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            apiSecretKey = map["apiSecretKey"] as String,
        )
    }
}