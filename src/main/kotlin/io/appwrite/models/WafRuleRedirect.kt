package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.WafRuleAction
import io.appwrite.extensions.jsonCast

/**
 * WafRuleRedirect
 */
data class WafRuleRedirect(
    /**
     * Rule ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * WAF rule creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * WAF rule last update time in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Human friendly rule name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Optional description for the rule.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Resource type the rule is scoped to.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * Resource identifier. Empty for API-wide rules.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Action performed when the rule matches.
     */
    @SerializedName("action")
    val action: WafRuleAction,

    /**
     * Evaluation priority. Lower values execute earlier.
     */
    @SerializedName("priority")
    val priority: Long,

    /**
     * Whether the rule is active.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * List of conditions evaluated for this rule.
     */
    @SerializedName("conditions")
    val conditions: List<Map<String, Any?>>,

    /**
     * Action specific configuration.
     */
    @SerializedName("config")
    val config: Map<String, Any?>,

    /**
     * Target location for the redirect.
     */
    @SerializedName("location")
    val location: String,

    /**
     * HTTP status code used for the redirect.
     */
    @SerializedName("statusCode")
    val statusCode: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "description" to description as Any,
        "teamId" to teamId as Any,
        "projectId" to projectId as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "action" to action.value as Any,
        "priority" to priority as Any,
        "enabled" to enabled as Any,
        "conditions" to conditions as Any,
        "config" to config as Any,
        "location" to location as Any,
        "statusCode" to statusCode as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = WafRuleRedirect(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "api") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            action = WafRuleAction.values().find { it.value == map["action"] as String }!!,
            priority = ((if (map.containsKey("priority")) map["priority"] else 0) as Number).toLong(),
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            conditions = (if (map.containsKey("conditions")) map["conditions"] else listOf<Any?>()) as List<Map<String, Any?>>,
            config = (if (map.containsKey("config")) map["config"] else mapOf<String, Any?>()) as Map<String, Any?>,
            location = (if (map.containsKey("location")) map["location"] else "/") as String,
            statusCode = ((if (map.containsKey("statusCode")) map["statusCode"] else 302) as Number).toLong(),
        )
    }
}
