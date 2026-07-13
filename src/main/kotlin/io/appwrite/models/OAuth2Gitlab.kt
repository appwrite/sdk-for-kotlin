package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Gitlab
 */
data class OAuth2Gitlab(
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
     * GitLab OAuth2 application ID.
     */
    @SerializedName("applicationId")
    val applicationId: String,

    /**
     * GitLab OAuth2 secret.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * GitLab OAuth2 endpoint URL. Defaults to https://gitlab.com for self-hosted instances.
     */
    @SerializedName("endpoint")
    val endpoint: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "applicationId" to applicationId as Any,
        "secret" to secret as Any,
        "endpoint" to endpoint as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Gitlab(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            applicationId = map["applicationId"] as String,
            secret = map["secret"] as String,
            endpoint = map["endpoint"] as String,
        )
    }
}
