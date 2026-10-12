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

    /**
     * Native Google sign-in is active and can be used to create sessions from an ID token. Independent of enabled, which only controls the browser-based flow.
     */
    @SerializedName("nativeEnabled")
    val nativeEnabled: Boolean,

    /**
     * Additional OAuth2 client IDs accepted as ID token audiences for native sign-in, next to the client ID.
     */
    @SerializedName("nativeClientIds")
    val nativeClientIds: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "prompt" to prompt as Any,
        "nativeEnabled" to nativeEnabled as Any,
        "nativeClientIds" to nativeClientIds as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Google(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            clientId = (if (map.containsKey("clientId")) map["clientId"] else "") as String,
            clientSecret = (if (map.containsKey("clientSecret")) map["clientSecret"] else "") as String,
            prompt = (if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>("consent")) as List<io.appwrite.enums.OAuth2GooglePrompt>,
            nativeEnabled = (if (map.containsKey("nativeEnabled")) map["nativeEnabled"] else false) as Boolean,
            nativeClientIds = (if (map.containsKey("nativeClientIds")) map["nativeClientIds"] else listOf<Any?>()) as List<String>,
        )
    }
}
