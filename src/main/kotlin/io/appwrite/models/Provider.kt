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
    val credentials: Map<String, Any?>,

    /**
     * Provider options.
     */
    @SerializedName("options")
    var options: Map<String, Any?>?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "provider" to provider as Any,
        "enabled" to enabled as Any,
        "type" to type as Any,
        "credentials" to credentials as Any,
        "options" to options as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Provider(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            provider = (if (map.containsKey("provider")) map["provider"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            credentials = (if (map.containsKey("credentials")) map["credentials"] else mapOf<String, Any?>()) as Map<String, Any?>,
            options = map["options"] as? Map<String, Any?>,
        )
    }
}
