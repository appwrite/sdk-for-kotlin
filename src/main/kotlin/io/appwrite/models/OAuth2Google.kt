package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Google
 */
data class OAuth2Google(
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
     * Google OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Google OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Google OAuth2 prompt values.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2GooglePrompt>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "prompt" to prompt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Google(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            clientId = map["clientId"] as String,
            clientSecret = map["clientSecret"] as String,
            prompt = map["prompt"] as List<io.appwrite.enums.OAuth2GooglePrompt>,
        )
    }
}
