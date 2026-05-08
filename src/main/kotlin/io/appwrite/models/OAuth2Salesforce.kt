package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Salesforce
 */
data class OAuth2Salesforce(
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
     * Salesforce OAuth2 consumer key.
     */
    @SerializedName("customerKey")
    val customerKey: String,

    /**
     * Salesforce OAuth2 consumer secret.
     */
    @SerializedName("customerSecret")
    val customerSecret: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "customerKey" to customerKey as Any,
        "customerSecret" to customerSecret as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Salesforce(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            customerKey = map["customerKey"] as String,
            customerSecret = map["customerSecret"] as String,
        )
    }
}