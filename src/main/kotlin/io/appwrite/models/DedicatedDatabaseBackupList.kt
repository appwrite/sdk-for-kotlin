package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BackupList
 */
data class DedicatedDatabaseBackupList(
    /**
     * Total number of backups.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of backups.
     */
    @SerializedName("backups")
    val backups: List<DedicatedDatabaseBackup>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "backups" to backups.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseBackupList(
            total = (map["total"] as Number).toLong(),
            backups = (map["backups"] as List<Map<String, Any>>).map { DedicatedDatabaseBackup.from(map = it) },
        )
    }
}
