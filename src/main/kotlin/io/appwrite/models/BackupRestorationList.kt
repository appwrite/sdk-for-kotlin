package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Backup restoration list
 */
data class BackupRestorationList(
    /**
     * Total number of restorations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of restorations.
     */
    @SerializedName("restorations")
    val restorations: List<BackupRestoration>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "restorations" to restorations.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupRestorationList(
            total = (map["total"] as Number).toLong(),
            restorations = (map["restorations"] as List<Map<String, Any>>).map { BackupRestoration.from(map = it) },
        )
    }
}