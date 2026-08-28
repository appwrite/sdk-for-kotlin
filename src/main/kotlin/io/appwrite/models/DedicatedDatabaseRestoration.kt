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
    val sourceDatabaseId: String,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Backup ID used for restoration (null for PITR).
     */
    @SerializedName("backupId")
    val backupId: String,

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
    val targetTime: String,

    /**
     * Restoration start time in ISO 8601 format.
     */
    @SerializedName("startedAt")
    val startedAt: String,

    /**
     * Restoration completion time in ISO 8601 format.
     */
    @SerializedName("completedAt")
    val completedAt: String,

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
        "sourceDatabaseId" to sourceDatabaseId as Any,
        "projectId" to projectId as Any,
        "backupId" to backupId as Any,
        "type" to type as Any,
        "status" to status as Any,
        "targetTime" to targetTime as Any,
        "startedAt" to startedAt as Any,
        "completedAt" to completedAt as Any,
        "error" to error as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseRestoration(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            databaseId = map["databaseId"] as String,
            sourceDatabaseId = map["sourceDatabaseId"] as String,
            projectId = map["projectId"] as String,
            backupId = map["backupId"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            targetTime = map["targetTime"] as String,
            startedAt = map["startedAt"] as String,
            completedAt = map["completedAt"] as String,
            error = map["error"] as String,
        )
    }
}
