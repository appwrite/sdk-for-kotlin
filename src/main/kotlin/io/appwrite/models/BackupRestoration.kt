package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Restoration
 */
data class BackupRestoration(
    /**
     * Restoration ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Restoration creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Restoration update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Backup archive ID.
     */
    @SerializedName("archiveId")
    val archiveId: String,

    /**
     * Backup policy ID.
     */
    @SerializedName("policyId")
    val policyId: String,

    /**
     * The status of the restoration. Possible values: pending, downloading, processing, completed, failed.
     */
    @SerializedName("status")
    val status: String,

    /**
     * The backup start time.
     */
    @SerializedName("startedAt")
    val startedAt: String,

    /**
     * Migration ID.
     */
    @SerializedName("migrationId")
    val migrationId: String,

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
     * Optional data in key-value object. 
     */
    @SerializedName("options")
    val options: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "archiveId" to archiveId as Any,
        "policyId" to policyId as Any,
        "status" to status as Any,
        "startedAt" to startedAt as Any,
        "migrationId" to migrationId as Any,
        "services" to services as Any,
        "resources" to resources as Any,
        "options" to options as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupRestoration(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            archiveId = map["archiveId"] as String,
            policyId = map["policyId"] as String,
            status = map["status"] as String,
            startedAt = map["startedAt"] as String,
            migrationId = map["migrationId"] as String,
            services = map["services"] as List<String>,
            resources = map["resources"] as List<String>,
            options = map["options"] as String,
        )
    }
}