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
     * Microsoft Entra ID tenant identifier. Use 'common', 'organizations', 'consumers' or a specific tenant ID.
     */
    @SerializedName("tenant")
    val tenant: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "applicationId" to applicationId as Any,
        "applicationSecret" to applicationSecret as Any,
        "tenant" to tenant as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Microsoft(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            applicationId = map["applicationId"] as String,
            applicationSecret = map["applicationSecret"] as String,
            tenant = map["tenant"] as String,
        )
    }
}