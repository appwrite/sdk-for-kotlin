package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Replicas
 */
data class DedicatedDatabaseReplicas(
    /**
     * Number of configured replicas. Zero means high availability is disabled.
     */
    @SerializedName("replicas")
    val replicas: Long,

    /**
     * Replication sync mode. Possible values: async (asynchronous, fastest), sync (synchronous, strong consistency), quorum (quorum-based, majority of replicas must confirm).
     */
    @SerializedName("syncMode")
    val syncMode: String,

    /**
     * Per-pod statuses for the primary and every replica.
     */
    @SerializedName("members")
    val members: List<DedicatedDatabaseMember>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "replicas" to replicas as Any,
        "syncMode" to syncMode as Any,
        "members" to members.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseReplicas(
            replicas = (map["replicas"] as Number).toLong(),
            syncMode = map["syncMode"] as String,
            members = (map["members"] as List<Map<String, Any>>).map { DedicatedDatabaseMember.from(map = it) },
        )
    }
}
