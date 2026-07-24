package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Status
 */
data class DatabaseStatus(
    /**
     * Overall health status: healthy, degraded, or unhealthy.
     */
    @SerializedName("health")
    val health: String,

    /**
     * Whether the database is ready to accept connections.
     */
    @SerializedName("ready")
    val ready: Boolean,

    /**
     * Database engine: postgresql, mysql, mariadb, or mongodb.
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
     * Connection statistics.
     */
    @SerializedName("connections")
    val connections: DatabaseStatusConnections,

    /**
     * List of database replicas and their status.
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
        "connections" to connections.toMap() as Any,
        "replicas" to replicas.map { it.toMap() } as Any,
        "volumes" to volumes.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseStatus(
            health = map["health"] as String,
            ready = map["ready"] as Boolean,
            engine = map["engine"] as String,
            version = map["version"] as String,
            uptime = (map["uptime"] as Number).toLong(),
            connections = DatabaseStatusConnections.from(map = map["connections"] as Map<String, Any>),
            replicas = (map["replicas"] as List<Map<String, Any>>).map { DatabaseStatusReplica.from(map = it) },
            volumes = (map["volumes"] as List<Map<String, Any>>).map { DatabaseStatusVolume.from(map = it) },
        )
    }
}
