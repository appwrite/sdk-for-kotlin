package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Restoration
 */
data class DedicatedDatabaseRestoration(
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
     * Database ID being restored into.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Source database ID when restoring a backup into another database.
     */
    @SerializedName("sourceDatabaseId")
    var sourceDatabaseId: String?,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Backup ID used for restoration (null for PITR).
     */
    @SerializedName("backupId")
    var backupId: String?,

    /**
     * Restoration type. Possible values: backup (restore from a specific backup snapshot), pitr (point-in-time recovery to a specific timestamp).
     */
    @SerializedName("type")
    val type: String,

    /**
     * Restoration status. Possible values: pending (queued for processing), running (currently in progress), completed (successfully finished), failed (encountered an error).
     */
    @SerializedName("status")
    val status: String,

    /**
     * Target time for PITR restoration in ISO 8601 format.
     */
    @SerializedName("targetTime")
    var targetTime: String?,

    /**
     * Restoration start time in ISO 8601 format.
     */
    @SerializedName("startedAt")
    var startedAt: String?,

    /**
     * Restoration completion time in ISO 8601 format.
     */
    @SerializedName("completedAt")
    var completedAt: String?,

    /**
     * Error message if restoration failed.
     */
    @SerializedName("error")
    val error: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "databaseId" to databaseId as Any,
        "sourceDatabaseId" to sourceDatabaseId as Any?,
        "projectId" to projectId as Any,
        "backupId" to backupId as Any?,
        "type" to type as Any,
        "status" to status as Any,
        "targetTime" to targetTime as Any?,
        "startedAt" to startedAt as Any?,
        "completedAt" to completedAt as Any?,
        "error" to error as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseRestoration(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            databaseId = (if (map.containsKey("databaseId")) map["databaseId"] else "") as String,
            sourceDatabaseId = map["sourceDatabaseId"] as? String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            backupId = map["backupId"] as? String,
            type = (if (map.containsKey("type")) map["type"] else "backup") as String,
            status = (if (map.containsKey("status")) map["status"] else "pending") as String,
            targetTime = map["targetTime"] as? String,
            startedAt = map["startedAt"] as? String,
            completedAt = map["completedAt"] as? String,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
        )
    }
}
