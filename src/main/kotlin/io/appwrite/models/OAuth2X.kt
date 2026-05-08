package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2X
 */
data class OAuth2X(
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
     * X OAuth2 customer key.
     */
    @SerializedName("customerKey")
    val customerKey: String,

    /**
     * X OAuth2 secret key.
     */
    @SerializedName("secretKey")
    val secretKey: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "customerKey" to customerKey as Any,
        "secretKey" to secretKey as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2X(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            customerKey = map["customerKey"] as String,
            secretKey = map["secretKey"] as String,
        )
    }
}