package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Backup
 */
data class DedicatedDatabaseBackup(
    /**
     * Backup ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Backup creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Database ID this backup belongs to.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Backup policy ID when the backup was created by a schedule.
     */
    @SerializedName("policyId")
    val policyId: String,

    /**
     * Backup trigger. Possible values: manual, schedule.
     */
    @SerializedName("trigger")
    val trigger: String,

    /**
     * Backup type. Possible values: full (complete database snapshot), incremental (changes since last backup), wal (write-ahead log continuous archival).
     */
    @SerializedName("type")
    val type: String,

    /**
     * Backup type that was requested. Differs from `type` when the backend could not run the requested type and took a different one instead, in which case `fallbackReason` explains why. Empty for backups taken before the requested type was recorded.
     */
    @SerializedName("requestedType")
    val requestedType: String,

    /**
     * Why the backend ran a different backup type than the one requested. Empty when the backup ran as requested.
     */
    @SerializedName("fallbackReason")
    val fallbackReason: String,

    /**
     * Backup status. Possible values: pending (queued for processing), running (currently in progress), completed (successfully finished), failed (encountered an error), verified (integrity check passed).
     */
    @SerializedName("status")
    val status: String,

    /**
     * Backup size in bytes.
     */
    @SerializedName("sizeBytes")
    val sizeBytes: Long,

    /**
     * Backup start time in ISO 8601 format.
     */
    @SerializedName("startedAt")
    var startedAt: String?,

    /**
     * Backup completion time in ISO 8601 format.
     */
    @SerializedName("completedAt")
    var completedAt: String?,

    /**
     * Backup verification time in ISO 8601 format.
     */
    @SerializedName("verifiedAt")
    var verifiedAt: String?,

    /**
     * Backup expiration time in ISO 8601 format.
     */
    @SerializedName("expiresAt")
    var expiresAt: String?,

    /**
     * Transaction-log position the backup anchors at, in the engine's own notation: PostgreSQL `{walSegment}|{lsn}`, MySQL and MariaDB `{binlogFile}|{offset}`, MongoDB `{seconds}|{increment}`. Empty when the backup recorded no position, which is the case for backup types that carry none.
     */
    @SerializedName("logPosition")
    var logPosition: String?,

    /**
     * Error message if backup failed.
     */
    @SerializedName("error")
    val error: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "databaseId" to databaseId as Any,
        "projectId" to projectId as Any,
        "policyId" to policyId as Any,
        "trigger" to trigger as Any,
        "type" to type as Any,
        "requestedType" to requestedType as Any,
        "fallbackReason" to fallbackReason as Any,
        "status" to status as Any,
        "sizeBytes" to sizeBytes as Any,
        "startedAt" to startedAt as Any?,
        "completedAt" to completedAt as Any?,
        "verifiedAt" to verifiedAt as Any?,
        "expiresAt" to expiresAt as Any?,
        "logPosition" to logPosition as Any?,
        "error" to error as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseBackup(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            databaseId = (if (map.containsKey("databaseId")) map["databaseId"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            policyId = (if (map.containsKey("policyId")) map["policyId"] else "") as String,
            trigger = (if (map.containsKey("trigger")) map["trigger"] else "manual") as String,
            type = (if (map.containsKey("type")) map["type"] else "full") as String,
            requestedType = (if (map.containsKey("requestedType")) map["requestedType"] else "") as String,
            fallbackReason = (if (map.containsKey("fallbackReason")) map["fallbackReason"] else "") as String,
            status = (if (map.containsKey("status")) map["status"] else "pending") as String,
            sizeBytes = ((if (map.containsKey("sizeBytes")) map["sizeBytes"] else 0) as Number).toLong(),
            startedAt = map["startedAt"] as? String,
            completedAt = map["completedAt"] as? String,
            verifiedAt = map["verifiedAt"] as? String,
            expiresAt = map["expiresAt"] as? String,
            logPosition = map["logPosition"] as? String,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
        )
    }
}
