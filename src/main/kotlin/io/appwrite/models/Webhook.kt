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
     * Optional description for the webhook.
     */
    @SerializedName("description")
    val description: String,

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
     * Indicates if SSL / TLS certificate verification is enabled.
     */
    @SerializedName("tls")
    val tls: Boolean,

    /**
     * HTTP basic authentication username.
     */
    @SerializedName("authUsername")
    val authUsername: String,

    /**
     * HTTP basic authentication password. Write-only: always returned empty.
     */
    @SerializedName("authPassword")
    val authPassword: String,

    /**
     * Signature key which can be used to validate incoming webhook payloads. Only returned on creation and secret rotation.
     */
    @SerializedName("secret")
    val secret: String,

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
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "description" to description as Any,
        "url" to url as Any,
        "events" to events as Any,
        "tls" to tls as Any,
        "authUsername" to authUsername as Any,
        "authPassword" to authPassword as Any,
        "secret" to secret as Any,
        "enabled" to enabled as Any,
        "logs" to logs as Any,
        "attempts" to attempts as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Webhook(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            url = (if (map.containsKey("url")) map["url"] else "") as String,
            events = (if (map.containsKey("events")) map["events"] else listOf<Any?>()) as List<String>,
            tls = (if (map.containsKey("tls")) map["tls"] else true) as Boolean,
            authUsername = (if (map.containsKey("authUsername")) map["authUsername"] else "") as String,
            authPassword = (if (map.containsKey("authPassword")) map["authPassword"] else "") as String,
            secret = (if (map.containsKey("secret")) map["secret"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            logs = (if (map.containsKey("logs")) map["logs"] else "") as String,
            attempts = ((if (map.containsKey("attempts")) map["attempts"] else 0) as Number).toLong(),
        )
    }
}
