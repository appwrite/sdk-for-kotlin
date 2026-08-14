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
     * Requested replication sync mode. Possible values: async (asynchronous, fastest), sync (synchronous, strong consistency), quorum (quorum-based, majority of replicas must confirm). This is what was asked for; compare it with effectiveSyncMode for what the primary is enforcing.
     */
    @SerializedName("syncMode")
    val syncMode: String,

    /**
     * Replication sync mode the primary is actually enforcing. Null when high availability is disabled or the state could not be read. A value below the requested syncMode means writes are being acknowledged with weaker durability than configured.
     */
    @SerializedName("effectiveSyncMode")
    var effectiveSyncMode: String?,

    /**
     * Whether the enforced replication is weaker than the requested syncMode.
     */
    @SerializedName("syncDegraded")
    val syncDegraded: Boolean,

    /**
     * Number of standby acknowledgements the primary waits for before a write is committed. Zero means writes are acknowledged locally.
     */
    @SerializedName("syncAcknowledgements")
    val syncAcknowledgements: Long,

    /**
     * Number of standbys registered with the primary for synchronous replication.
     */
    @SerializedName("syncStandbyCount")
    val syncStandbyCount: Long,

    /**
     * Whether the other sync fields are an engine reading rather than a recorded estimate. True when the primary answered what it is enforcing, including when that answer contradicted the record, in which case the contradicted values are replaced by the ones the engine reports. False when the reading could not be taken: the probe did not answer, there was no engine to ask, or the values describe a configuration change just applied rather than anything measured. Absent when no engine was asked at all, so an unprobed database is distinguishable from an unconfirmed one. False never means a standby was found lagging, because it is the absence of a reading rather than a negative one, so draw no conclusion about replication health from it or from a response that omits it.
     */
    @SerializedName("syncStateConfirmed")
    var syncStateConfirmed: Boolean?,

    /**
     * Per-pod statuses for the primary and every replica.
     */
    @SerializedName("members")
    val members: List<DedicatedDatabaseMember>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "replicas" to replicas as Any,
        "syncMode" to syncMode as Any,
        "effectiveSyncMode" to effectiveSyncMode as Any?,
        "syncDegraded" to syncDegraded as Any,
        "syncAcknowledgements" to syncAcknowledgements as Any,
        "syncStandbyCount" to syncStandbyCount as Any,
        "syncStateConfirmed" to syncStateConfirmed as Any?,
        "members" to members.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseReplicas(
            replicas = (map["replicas"] as Number).toLong(),
            syncMode = map["syncMode"] as String,
            effectiveSyncMode = map["effectiveSyncMode"] as? String,
            syncDegraded = map["syncDegraded"] as Boolean,
            syncAcknowledgements = (map["syncAcknowledgements"] as Number).toLong(),
            syncStandbyCount = (map["syncStandbyCount"] as Number).toLong(),
            syncStateConfirmed = map["syncStateConfirmed"] as? Boolean,
            members = (map["members"] as List<Map<String, Any>>).map { DedicatedDatabaseMember.from(map = it) },
        )
    }
}
