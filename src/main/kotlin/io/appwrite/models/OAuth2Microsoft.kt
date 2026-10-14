package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Microsoft
 */
data class OAuth2Microsoft(
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
     * Microsoft OAuth2 application ID.
     */
    @SerializedName("applicationId")
    val applicationId: String,

    /**
     * Microsoft OAuth2 application secret.
     */
    @SerializedName("applicationSecret")
    val applicationSecret: String,

    /**
     * Microsoft OAuth2 prompt values.
     */
    @SerializedName("prompt")
    val prompt: List<io.appwrite.enums.OAuth2MicrosoftPrompt>,

    /**
     * Microsoft Entra ID tenant identifier. Use 'common', 'organizations', 'consumers' or a specific tenant ID.
     */
    @SerializedName("tenant")
    val tenant: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "applicationId" to applicationId as Any,
        "applicationSecret" to applicationSecret as Any,
        "prompt" to prompt.map { it.value } as Any,
        "tenant" to tenant as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Microsoft(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            applicationId = (if (map.containsKey("applicationId")) map["applicationId"] else "") as String,
            applicationSecret = (if (map.containsKey("applicationSecret")) map["applicationSecret"] else "") as String,
            prompt = ((if (map.containsKey("prompt")) map["prompt"] else listOf<Any?>()) as List<*>).mapNotNull { value -> io.appwrite.enums.OAuth2MicrosoftPrompt.values().find { it.value == value } },
            tenant = (if (map.containsKey("tenant")) map["tenant"] else "") as String,
        )
    }
}
