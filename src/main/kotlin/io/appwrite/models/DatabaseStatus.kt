package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Status
 */
data class DatabaseStatus(
    /**
     * Overall health status: healthy, degraded, unhealthy, or unknown when nothing could be measured.
     */
    @SerializedName("health")
    val health: String,

    /**
     * Whether the database is ready to accept connections.
     */
    @SerializedName("ready")
    val ready: Boolean,

    /**
     * Database engine: postgresql, mysql, or mongodb.
     */
    @SerializedName("engine")
    val engine: String,

    /**
     * Database engine version.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Database uptime in seconds.
     */
    @SerializedName("uptime")
    val uptime: Long,

    /**
     * Connection statistics. Null when the database has not been probed.
     */
    @SerializedName("connections")
    var connections: DatabaseStatusConnections?,

    /**
     * Requested replication sync mode. Possible values: async, sync, quorum. Compare with effectiveSyncMode for what the primary is enforcing.
     */
    @SerializedName("syncMode")
    val syncMode: String,

    /**
     * Replication sync mode the primary is actually enforcing. Null when high availability is disabled or the state could not be read.
     */
    @SerializedName("effectiveSyncMode")
    var effectiveSyncMode: String?,

    /**
     * Whether the enforced replication is weaker than the requested syncMode.
     */
    @SerializedName("syncDegraded")
    val syncDegraded: Boolean,

    /**
     * Number of standby acknowledgements the primary waits for before a write is committed.
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
     * List of database replicas and their status. Every configured member appears, including one the backend has not brought up, which is reported as not healthy.
     */
    @SerializedName("replicas")
    val replicas: List<DatabaseStatusReplica>,

    /**
     * Storage volume information.
     */
    @SerializedName("volumes")
    val volumes: List<DatabaseStatusVolume>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "health" to health as Any,
        "ready" to ready as Any,
        "engine" to engine as Any,
        "version" to version as Any,
        "uptime" to uptime as Any,
        "connections" to connections?.toMap() as Any?,
        "syncMode" to syncMode as Any,
        "effectiveSyncMode" to effectiveSyncMode as Any?,
        "syncDegraded" to syncDegraded as Any,
        "syncAcknowledgements" to syncAcknowledgements as Any,
        "syncStandbyCount" to syncStandbyCount as Any,
        "syncStateConfirmed" to syncStateConfirmed as Any?,
        "replicas" to replicas.map { it.toMap() } as Any,
        "volumes" to volumes.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseStatus(
            health = (if (map.containsKey("health")) map["health"] else "unknown") as String,
            ready = (if (map.containsKey("ready")) map["ready"] else false) as Boolean,
            engine = (if (map.containsKey("engine")) map["engine"] else "postgresql") as String,
            version = (if (map.containsKey("version")) map["version"] else "") as String,
            uptime = ((if (map.containsKey("uptime")) map["uptime"] else 0) as Number).toLong(),
            connections = (map["connections"] as? Map<String, Any>)?.let { DatabaseStatusConnections.from(map = it) },
            syncMode = (if (map.containsKey("syncMode")) map["syncMode"] else "async") as String,
            effectiveSyncMode = map["effectiveSyncMode"] as? String,
            syncDegraded = (if (map.containsKey("syncDegraded")) map["syncDegraded"] else false) as Boolean,
            syncAcknowledgements = ((if (map.containsKey("syncAcknowledgements")) map["syncAcknowledgements"] else 0) as Number).toLong(),
            syncStandbyCount = ((if (map.containsKey("syncStandbyCount")) map["syncStandbyCount"] else 0) as Number).toLong(),
            syncStateConfirmed = map["syncStateConfirmed"] as? Boolean,
            replicas = (map["replicas"] as List<Map<String, Any>>).map { DatabaseStatusReplica.from(map = it) },
            volumes = (map["volumes"] as List<Map<String, Any>>).map { DatabaseStatusVolume.from(map = it) },
        )
    }
}
