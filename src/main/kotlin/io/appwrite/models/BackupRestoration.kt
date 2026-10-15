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
     * The restoration start time. Null until the restoration starts.
     */
    @SerializedName("startedAt")
    var startedAt: String?,

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
     * Restoration options as a key-value object.
     */
    @SerializedName("options")
    val options: Map<String, Any?>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "archiveId" to archiveId as Any,
        "policyId" to policyId as Any,
        "status" to status as Any,
        "startedAt" to startedAt as Any?,
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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            archiveId = (if (map.containsKey("archiveId")) map["archiveId"] else "") as String,
            policyId = (if (map.containsKey("policyId")) map["policyId"] else "") as String,
            status = (if (map.containsKey("status")) map["status"] else "") as String,
            startedAt = map["startedAt"] as? String,
            migrationId = (if (map.containsKey("migrationId")) map["migrationId"] else "") as String,
            services = (if (map.containsKey("services")) map["services"] else listOf<Any?>()) as List<String>,
            resources = (if (map.containsKey("resources")) map["resources"] else listOf<Any?>()) as List<String>,
            options = (if (map.containsKey("options")) map["options"] else mapOf<String, Any?>()) as Map<String, Any?>,
        )
    }
}
