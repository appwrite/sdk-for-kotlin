package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Auth0
 */
data class OAuth2Auth0(
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
     * Auth0 OAuth2 client ID.
     */
    @SerializedName("clientId")
    val clientId: String,

    /**
     * Auth0 OAuth2 client secret.
     */
    @SerializedName("clientSecret")
    val clientSecret: String,

    /**
     * Auth0 OAuth2 prompt values.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2Auth0Prompt>,

    /**
     * Auth0 OAuth2 endpoint domain.
     */
    @SerializedName("endpoint")
    val endpoint: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "clientId" to clientId as Any,
        "clientSecret" to clientSecret as Any,
        "prompt" to prompt as Any,
        "endpoint" to endpoint as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Auth0(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            clientId = (if (map.containsKey("clientId")) map["clientId"] else "") as String,
            clientSecret = (if (map.containsKey("clientSecret")) map["clientSecret"] else "") as String,
            prompt = (if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>()) as List<io.appwrite.enums.OAuth2Auth0Prompt>,
            endpoint = (if (map.containsKey("endpoint")) map["endpoint"] else "") as String,
        )
    }
}
