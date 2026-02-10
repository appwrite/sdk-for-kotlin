package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * backup
 */
data class BackupPolicy(
    /**
     * Backup policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Backup policy name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Policy creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Policy update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * The services that are backed up by this policy.
     */
    @SerializedName("services")
    val services: List<String>,

    /**
     * The resources that are backed up by this policy.
     */
    @SerializedName("resources")
    val resources: List<String>,

    /**
     * The resource ID to backup. Set only if this policy should backup a single resource.
     */
    @SerializedName("resourceId")
    var resourceId: String?,

    /**
     * The resource type to backup. Set only if this policy should backup a single resource.
     */
    @SerializedName("resourceType")
    var resourceType: String?,

    /**
     * How many days to keep the backup before it will be automatically deleted.
     */
    @SerializedName("retention")
    val retention: Long,

    /**
     * Policy backup schedule in CRON format.
     */
    @SerializedName("schedule")
    val schedule: String,

    /**
     * Is this policy enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "services" to services as Any,
        "resources" to resources as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "retention" to retention as Any,
        "schedule" to schedule as Any,
        "enabled" to enabled as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupPolicy(
            id = map["\$id"] as String,
            name = map["name"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            services = map["services"] as List<String>,
            resources = map["resources"] as List<String>,
            resourceId = map["resourceId"] as? String,
            resourceType = map["resourceType"] as? String,
            retention = (map["retention"] as Number).toLong(),
            schedule = map["schedule"] as String,
            enabled = map["enabled"] as Boolean,
        )
    }
}