package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Discord
 */
data class OAuth2Discord(
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
     * Discord OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Discord OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Discord OAuth2 prompt values.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2DiscordPrompt>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "prompt" to prompt.map { it.value } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Discord(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            clientId = (if (map.containsKey("clientId")) map["clientId"] else "") as String,
            clientSecret = (if (map.containsKey("clientSecret")) map["clientSecret"] else "") as String,
            prompt = ((if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>()) as List<*>).mapNotNull { value -> io.appwrite.enums.OAuth2DiscordPrompt.values().find { it.value == value } },
        )
    }
}
