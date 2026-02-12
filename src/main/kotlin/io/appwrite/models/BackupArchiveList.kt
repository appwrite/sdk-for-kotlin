package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Backup archive list
 */
data class BackupArchiveList(
    /**
     * Total number of archives that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of archives.
     */
    @SerializedName("archives")
    val archives: List<BackupArchive>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "archives" to archives.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupArchiveList(
            total = (map["total"] as Number).toLong(),
            archives = (map["archives"] as List<Map<String, Any>>).map { BackupArchive.from(map = it) },
        )
    }
}