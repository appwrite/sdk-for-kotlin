package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Webhook
 */
data class Webhook(
    /**
     * Webhook ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Webhook creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Webhook update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Webhook name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Webhook URL endpoint.
     */
    @SerializedName("url")
    val url: String,

    /**
     * Webhook trigger events.
     */
    @SerializedName("events")
    val events: List<String>,

    /**
     * Indicated if SSL / TLS Certificate verification is enabled.
     */
    @SerializedName("security")
    val security: Boolean,

    /**
     * HTTP basic authentication username.
     */
    @SerializedName("httpUser")
    val httpUser: String,

    /**
     * HTTP basic authentication password.
     */
    @SerializedName("httpPass")
    val httpPass: String,

    /**
     * Signature key which can be used to validated incoming
     */
    @SerializedName("signatureKey")
    val signatureKey: String,

    /**
     * Indicates if this webhook is enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Webhook error logs from the most recent failure.
     */
    @SerializedName("logs")
    val logs: String,

    /**
     * Number of consecutive failed webhook attempts.
     */
    @SerializedName("attempts")
    val attempts: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "url" to url as Any,
        "events" to events as Any,
        "security" to security as Any,
        "httpUser" to httpUser as Any,
        "httpPass" to httpPass as Any,
        "signatureKey" to signatureKey as Any,
        "enabled" to enabled as Any,
        "logs" to logs as Any,
        "attempts" to attempts as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Webhook(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            url = map["url"] as String,
            events = map["events"] as List<String>,
            security = map["security"] as Boolean,
            httpUser = map["httpUser"] as String,
            httpPass = map["httpPass"] as String,
            signatureKey = map["signatureKey"] as String,
            enabled = map["enabled"] as Boolean,
            logs = map["logs"] as String,
            attempts = (map["attempts"] as Number).toLong(),
        )
    }
}