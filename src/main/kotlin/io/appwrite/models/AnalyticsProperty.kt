package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.AnalyticsPropertyType
import io.appwrite.extensions.jsonCast

/**
 * AnalyticsProperty
 */
data class AnalyticsProperty(
    /**
     * Analytics property ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Property creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Property update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Human-readable name of the tracked website or application.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Primary domain being tracked (e.g. example.com). May be empty for mobile and agent properties.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Whether tracking is currently active.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * List of origins allowed to send tracking events. Use ["*"] to allow all. Managed by Appwrite for a property linked to a site, following the site's production domains.
     */
    @SerializedName("allowedOrigins")
    val allowedOrigins: List<String>,

    /**
     * Kind of product this property tracks. Decides which dashboard panels apply.
     */
    @SerializedName("type")
    val type: AnalyticsPropertyType,

    /**
     * Whether events sent from a signed-in client session record that user's ID.
     */
    @SerializedName("identifyUsers")
    val identifyUsers: Boolean,

    /**
     * Most recent event date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

    /**
     * First event date in ISO 8601 format. Empty until the property receives its first event.
     */
    @SerializedName("firstAccessedAt")
    val firstAccessedAt: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "domain" to domain as Any,
        "enabled" to enabled as Any,
        "allowedOrigins" to allowedOrigins as Any,
        "type" to type.value as Any,
        "identifyUsers" to identifyUsers as Any,
        "accessedAt" to accessedAt as Any,
        "firstAccessedAt" to firstAccessedAt as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsProperty(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            domain = (if (map.containsKey("domain")) map["domain"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            allowedOrigins = (if (map.containsKey("allowedOrigins")) map["allowedOrigins"] else listOf<Any?>("*")) as List<String>,
            type = AnalyticsPropertyType.values().find { it.value == (if (map.containsKey("type")) map["type"] else "web") as String }!!,
            identifyUsers = (if (map.containsKey("identifyUsers")) map["identifyUsers"] else false) as Boolean,
            accessedAt = (if (map.containsKey("accessedAt")) map["accessedAt"] else "") as String,
            firstAccessedAt = (if (map.containsKey("firstAccessedAt")) map["firstAccessedAt"] else "") as String,
        )
    }
}
