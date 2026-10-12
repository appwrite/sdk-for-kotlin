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

    /**
     * Salesforce OAuth2 prompt values.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2SalesforcePrompt>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "customerKey" to customerKey as Any,
        "customerSecret" to customerSecret as Any,
        "prompt" to prompt as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Salesforce(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            customerKey = (if (map.containsKey("customerKey")) map["customerKey"] else "") as String,
            customerSecret = (if (map.containsKey("customerSecret")) map["customerSecret"] else "") as String,
            prompt = (if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>()) as List<io.appwrite.enums.OAuth2SalesforcePrompt>,
        )
    }
}
