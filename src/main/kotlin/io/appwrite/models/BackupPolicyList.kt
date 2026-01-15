package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Backup policy list
 */
data class BackupPolicyList(
    /**
     * Total number of policies that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of policies.
     */
    @SerializedName("policies")
    val policies: List<BackupPolicy>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "policies" to policies.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BackupPolicyList(
            total = (map["total"] as Number).toLong(),
            policies = (map["policies"] as List<Map<String, Any>>).map { BackupPolicy.from(map = it) },
        )
    }
}