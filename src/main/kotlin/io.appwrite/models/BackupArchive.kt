package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Archive
 */
data class BackupArchive(
    /**
     * Archive ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Archive creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Archive update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Archive policy ID.
     */
    @SerializedName("policyId")
    val policyId: String,

    /**
     * Archive size in bytes.
     */
    @SerializedName("size")
    val size: Long,

    /**
     * The status of the archive creation. Possible values: pending, processing, uploading, completed, failed.
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
     * The services that are backed up by this archive.
     */
    @SerializedName("services")
    val services: List<String>,

    /**
     * The resources that are backed up by this archive.
     */
    @SerializedName("resources")
    val resources: List<String>,

    /**
     * The resource ID to backup. Set only if this archive should backup a single resource.
     */
    @SerializedName("resourceId")
    var resourceId: String?,

    /**
     * The resource type to backup. Set only if this archive should backup a single resource.
     */
    @SerializedName("resourceType")
    var resourceType: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "policyId" to policyId as Any,
        "size" to size as Any,
        "status" to status as Any,
        "startedAt" to startedAt as Any,
        "migrationId" to migrationId as Any,
        "services" to services as Any,
        "resources" to resources as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupArchive(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            policyId = map["policyId"] as String,
            size = (map["size"] as Number).toLong(),
            status = map["status"] as String,
            startedAt = map["startedAt"] as String,
            migrationId = map["migrationId"] as String,
            services = map["services"] as List<String>,
            resources = map["resources"] as List<String>,
            resourceId = map["resourceId"] as? String,
            resourceType = map["resourceType"] as? String,
        )
    }
}