package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * PoolerConfig
 */
data class DedicatedDatabasePooler(
    /**
     * Whether connection pooling is enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Connection pool mode. Possible values: transaction (releases connections back to pool after each transaction), session (holds connections for the entire client session).
     */
    @SerializedName("mode")
    val mode: String,

    /**
     * Client-connection ceiling the pooler accepts. Enforced on MySQL and MariaDB; on PostgreSQL the pooler has no client cap, so this reports the database's advertised networkMaxConnections and cannot be set here.
     */
    @SerializedName("maxConnections")
    val maxConnections: Long,

    /**
     * Default pool size per user.
     */
    @SerializedName("defaultPoolSize")
    val defaultPoolSize: Long,

    /**
     * Pooler listening port.
     */
    @SerializedName("port")
    val port: Long,

    /**
     * Whether SELECTs are routed to HA replicas while writes and locked reads stay on the primary. Active only when HA is enabled.
     */
    @SerializedName("readWriteSplitting")
    val readWriteSplitting: Boolean,

    /**
     * Effective CPU request applied to the pooler sidecar container (Kubernetes quantity). Returns the proportional default (5% of DB CPU, floor 100m) unless overridden.
     */
    @SerializedName("poolerCpuRequest")
    val poolerCpuRequest: String,

    /**
     * Effective CPU limit applied to the pooler sidecar container (Kubernetes quantity). Returns the proportional default (10% of DB CPU, floor 200m) unless overridden.
     */
    @SerializedName("poolerCpuLimit")
    val poolerCpuLimit: String,

    /**
     * Effective memory request applied to the pooler sidecar container (Kubernetes quantity). Returns the proportional default (7.5% of DB memory, floor 64Mi) unless overridden.
     */
    @SerializedName("poolerMemoryRequest")
    val poolerMemoryRequest: String,

    /**
     * Effective memory limit applied to the pooler sidecar container (Kubernetes quantity). Returns the proportional default (15% of DB memory, floor 128Mi) unless overridden.
     */
    @SerializedName("poolerMemoryLimit")
    val poolerMemoryLimit: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "enabled" to enabled as Any,
        "mode" to mode as Any,
        "maxConnections" to maxConnections as Any,
        "defaultPoolSize" to defaultPoolSize as Any,
        "port" to port as Any,
        "readWriteSplitting" to readWriteSplitting as Any,
        "poolerCpuRequest" to poolerCpuRequest as Any,
        "poolerCpuLimit" to poolerCpuLimit as Any,
        "poolerMemoryRequest" to poolerMemoryRequest as Any,
        "poolerMemoryLimit" to poolerMemoryLimit as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabasePooler(
            enabled = map["enabled"] as Boolean,
            mode = map["mode"] as String,
            maxConnections = (map["maxConnections"] as Number).toLong(),
            defaultPoolSize = (map["defaultPoolSize"] as Number).toLong(),
            port = (map["port"] as Number).toLong(),
            readWriteSplitting = map["readWriteSplitting"] as Boolean,
            poolerCpuRequest = map["poolerCpuRequest"] as String,
            poolerCpuLimit = map["poolerCpuLimit"] as String,
            poolerMemoryRequest = map["poolerMemoryRequest"] as String,
            poolerMemoryLimit = map["poolerMemoryLimit"] as String,
        )
    }
}
