package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Provider
 */
data class Provider(
    /**
     * Provider ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Provider creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Provider update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name for the provider instance.
     */
    @SerializedName("name")
    val name: String,

    /**
     * The name of the provider service.
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * Is provider enabled?
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Type of provider.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Provider credentials.
     */
    @SerializedName("credentials")
    val credentials: Any,

    /**
     * Provider options.
     */
    @SerializedName("options")
    var options: Any?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "provider" to provider as Any,
        "enabled" to enabled as Any,
        "type" to type as Any,
        "credentials" to credentials as Any,
        "options" to options as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Provider(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            provider = map["provider"] as String,
            enabled = map["enabled"] as Boolean,
            type = map["type"] as String,
            credentials = map["credentials"] as Any,
            options = map["options"] as? Any?,
        )
    }
}