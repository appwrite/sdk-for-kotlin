package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * DedicatedDatabase
 */
data class DedicatedDatabase(
    /**
     * Dedicated database ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Database creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Database update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Project ID that owns this database.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Database display name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Product API that owns this database: tablesdb, documentsdb, vectorsdb, mysql, postgresql, or mongodb.
     */
    @SerializedName("api")
    var api: String?,

    /**
     * Database engine: postgresql, mysql, or mongodb. Null until the backing reports one.
     */
    @SerializedName("engine")
    var engine: String?,

    /**
     * Database engine version.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Specification identifier.
     */
    @SerializedName("specification")
    val specification: String,

    /**
     * Database backend provider. Possible values: edge.
     */
    @SerializedName("backend")
    val backend: String,

    /**
     * Database hostname for connections.
     */
    @SerializedName("hostname")
    val hostname: String,

    /**
     * Database port for connections. Derived from the engine when the backing has not reported one yet.
     */
    @SerializedName("connectionPort")
    var connectionPort: Long?,

    /**
     * Database username for connections.
     */
    @SerializedName("connectionUser")
    val connectionUser: String,

    /**
     * Database password for connections.
     */
    @SerializedName("connectionPassword")
    val connectionPassword: String,

    /**
     * Committed generation of the primary connection credentials. Null until the rotation contract has been initialized.
     */
    @SerializedName("credentialGeneration")
    var credentialGeneration: Long?,

    /**
     * Full database connection string (URI format).
     */
    @SerializedName("connectionString")
    val connectionString: String,

    /**
     * Whether SSL/TLS is required for client connections.
     */
    @SerializedName("ssl")
    val ssl: Boolean,

    /**
     * Database status. Possible values: provisioning, ready, inactive, paused, failed, deleted, restoring, scaling.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Container status for lifecycle-managed database runtimes: active, inactive, or failed (a wake was declined because the backing namespace is gone).
     */
    @SerializedName("containerStatus")
    val containerStatus: String,

    /**
     * Last activity timestamp in ISO 8601 format.
     */
    @SerializedName("lastAccessedAt")
    var lastAccessedAt: String?,

    /**
     * Display-only timestamp when the database is expected to be considered idle (ISO 8601 format). Derived from last activity; lifecycle transitions are driven by lifecycleState.
     */
    @SerializedName("idleUntil")
    var idleUntil: String?,

    /**
     * Idle-lifecycle state of the database. Possible values: active, warm, cold, hibernated.
     */
    @SerializedName("lifecycleState")
    val lifecycleState: String,

    /**
     * Minutes of inactivity before container scales to zero.
     */
    @SerializedName("idleTimeoutMinutes")
    val idleTimeoutMinutes: Long,

    /**
     * CPU allocated in millicores.
     */
    @SerializedName("cpu")
    val cpu: Long,

    /**
     * Memory allocated in MB.
     */
    @SerializedName("memory")
    val memory: Long,

    /**
     * Storage allocated in GB.
     */
    @SerializedName("storage")
    val storage: Long,

    /**
     * Storage resize status. Possible values: idle (no resize in flight), resizing (the volume is growing towards storageTargetGb).
     */
    @SerializedName("storageStatus")
    val storageStatus: String,

    /**
     * Size in GB the volume is growing towards while storageStatus is resizing. 0 when no resize is in flight.
     */
    @SerializedName("storageTargetGb")
    val storageTargetGb: Long,

    /**
     * Time the in-flight storage resize started, in ISO 8601 format.
     */
    @SerializedName("storageResizeStartedAt")
    var storageResizeStartedAt: String?,

    /**
     * Storage class. Currently always 'ssd'; DigitalOcean exposes a single block-storage class.
     */
    @SerializedName("storageClass")
    val storageClass: String,

    /**
     * Maximum storage allowed in GB. 0 means use system default.
     */
    @SerializedName("storageMaxGb")
    val storageMaxGb: Long,

    /**
     * Kubernetes node pool where the database is scheduled.
     */
    @SerializedName("nodePool")
    val nodePool: String,

    /**
     * Number of high availability replicas. High availability is enabled when greater than 0.
     */
    @SerializedName("replicas")
    val replicas: Long,

    /**
     * Replication sync mode: async, sync, or quorum.
     */
    @SerializedName("syncMode")
    val syncMode: String,

    /**
     * Maximum concurrent client connections. This is the limit a client pool may reach; the engine's own max_connections reported by the status endpoint is a smaller backend limit the pooler multiplexes onto and does not constrain a client pool.
     */
    @SerializedName("networkMaxConnections")
    val networkMaxConnections: Long,

    /**
     * Connection idle timeout in seconds.
     */
    @SerializedName("networkIdleTimeoutSeconds")
    val networkIdleTimeoutSeconds: Long,

    /**
     * IP addresses/CIDR ranges allowed to connect.
     */
    @SerializedName("networkIPAllowlist")
    val networkIPAllowlist: List<String>,

    /**
     * Whether automatic backups are enabled.
     */
    @SerializedName("backupEnabled")
    val backupEnabled: Boolean,

    /**
     * Whether point-in-time recovery is enabled.
     */
    @SerializedName("pitr")
    val pitr: Boolean,

    /**
     * Number of days to retain PITR data.
     */
    @SerializedName("pitrRetentionDays")
    val pitrRetentionDays: Long,

    /**
     * Whether automatic storage expansion is enabled.
     */
    @SerializedName("storageAutoscaling")
    val storageAutoscaling: Boolean,

    /**
     * Storage usage percentage that triggers automatic expansion.
     */
    @SerializedName("storageAutoscalingThresholdPercent")
    val storageAutoscalingThresholdPercent: Long,

    /**
     * Maximum storage size in GB for autoscaling. Defaults to 3 times the specification's storage. 0 means no limit.
     */
    @SerializedName("storageAutoscalingMaxGb")
    val storageAutoscalingMaxGb: Long,

    /**
     * Day of the week for the maintenance window. Possible values: sun, mon, tue, wed, thu, fri, sat.
     */
    @SerializedName("maintenanceWindowDay")
    val maintenanceWindowDay: String,

    /**
     * Hour in UTC (0-23) when the maintenance window starts.
     */
    @SerializedName("maintenanceWindowHourUtc")
    val maintenanceWindowHourUtc: Long,

    /**
     * Whether metrics collection is enabled.
     */
    @SerializedName("metricsEnabled")
    val metricsEnabled: Boolean,

    /**
     * Whether the SQL API sidecar is enabled for this database.
     */
    @SerializedName("sqlApiEnabled")
    val sqlApiEnabled: Boolean,

    /**
     * Statement types accepted by the SQL API. Defaults to read/write DML only; DDL/DCL types (CREATE, ALTER, DROP, TRUNCATE, GRANT, REVOKE) are opt-in per database. Allowed values: SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, TRUNCATE, GRANT, REVOKE.
     */
    @SerializedName("sqlApiAllowedStatements")
    val sqlApiAllowedStatements: List<String>,

    /**
     * Maximum rows returned per SQL API execution. Results larger than this are truncated.
     */
    @SerializedName("sqlApiMaxRows")
    val sqlApiMaxRows: Long,

    /**
     * Maximum serialised SQL API result payload in bytes. Results larger than this are truncated.
     */
    @SerializedName("sqlApiMaxBytes")
    val sqlApiMaxBytes: Long,

    /**
     * Maximum server-side SQL API execution time in seconds before the query is cancelled.
     */
    @SerializedName("sqlApiTimeoutSeconds")
    val sqlApiTimeoutSeconds: Long,

    /**
     * Error message if status is failed.
     */
    @SerializedName("error")
    val error: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "projectId" to projectId as Any,
        "name" to name as Any,
        "api" to api as Any?,
        "engine" to engine as Any?,
        "version" to version as Any,
        "specification" to specification as Any,
        "backend" to backend as Any,
        "hostname" to hostname as Any,
        "connectionPort" to connectionPort as Any?,
        "connectionUser" to connectionUser as Any,
        "connectionPassword" to connectionPassword as Any,
        "credentialGeneration" to credentialGeneration as Any?,
        "connectionString" to connectionString as Any,
        "ssl" to ssl as Any,
        "status" to status as Any,
        "containerStatus" to containerStatus as Any,
        "lastAccessedAt" to lastAccessedAt as Any?,
        "idleUntil" to idleUntil as Any?,
        "lifecycleState" to lifecycleState as Any,
        "idleTimeoutMinutes" to idleTimeoutMinutes as Any,
        "cpu" to cpu as Any,
        "memory" to memory as Any,
        "storage" to storage as Any,
        "storageStatus" to storageStatus as Any,
        "storageTargetGb" to storageTargetGb as Any,
        "storageResizeStartedAt" to storageResizeStartedAt as Any?,
        "storageClass" to storageClass as Any,
        "storageMaxGb" to storageMaxGb as Any,
        "nodePool" to nodePool as Any,
        "replicas" to replicas as Any,
        "syncMode" to syncMode as Any,
        "networkMaxConnections" to networkMaxConnections as Any,
        "networkIdleTimeoutSeconds" to networkIdleTimeoutSeconds as Any,
        "networkIPAllowlist" to networkIPAllowlist as Any,
        "backupEnabled" to backupEnabled as Any,
        "pitr" to pitr as Any,
        "pitrRetentionDays" to pitrRetentionDays as Any,
        "storageAutoscaling" to storageAutoscaling as Any,
        "storageAutoscalingThresholdPercent" to storageAutoscalingThresholdPercent as Any,
        "storageAutoscalingMaxGb" to storageAutoscalingMaxGb as Any,
        "maintenanceWindowDay" to maintenanceWindowDay as Any,
        "maintenanceWindowHourUtc" to maintenanceWindowHourUtc as Any,
        "metricsEnabled" to metricsEnabled as Any,
        "sqlApiEnabled" to sqlApiEnabled as Any,
        "sqlApiAllowedStatements" to sqlApiAllowedStatements as Any,
        "sqlApiMaxRows" to sqlApiMaxRows as Any,
        "sqlApiMaxBytes" to sqlApiMaxBytes as Any,
        "sqlApiTimeoutSeconds" to sqlApiTimeoutSeconds as Any,
        "error" to error as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabase(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            api = map["api"] as? String,
            engine = map["engine"] as? String,
            version = (if (map.containsKey("version")) map["version"] else "") as String,
            specification = (if (map.containsKey("specification")) map["specification"] else "") as String,
            backend = (if (map.containsKey("backend")) map["backend"] else "") as String,
            hostname = (if (map.containsKey("hostname")) map["hostname"] else "") as String,
            connectionPort = (map["connectionPort"] as? Number)?.toLong(),
            connectionUser = (if (map.containsKey("connectionUser")) map["connectionUser"] else "") as String,
            connectionPassword = (if (map.containsKey("connectionPassword")) map["connectionPassword"] else "") as String,
            credentialGeneration = (map["credentialGeneration"] as? Number)?.toLong(),
            connectionString = (if (map.containsKey("connectionString")) map["connectionString"] else "") as String,
            ssl = (if (map.containsKey("ssl")) map["ssl"] else false) as Boolean,
            status = (if (map.containsKey("status")) map["status"] else "provisioning") as String,
            containerStatus = (if (map.containsKey("containerStatus")) map["containerStatus"] else "") as String,
            lastAccessedAt = map["lastAccessedAt"] as? String,
            idleUntil = map["idleUntil"] as? String,
            lifecycleState = (if (map.containsKey("lifecycleState")) map["lifecycleState"] else "") as String,
            idleTimeoutMinutes = ((if (map.containsKey("idleTimeoutMinutes")) map["idleTimeoutMinutes"] else 15) as Number).toLong(),
            cpu = ((if (map.containsKey("cpu")) map["cpu"] else 500) as Number).toLong(),
            memory = ((if (map.containsKey("memory")) map["memory"] else 512) as Number).toLong(),
            storage = ((if (map.containsKey("storage")) map["storage"] else 10) as Number).toLong(),
            storageStatus = (if (map.containsKey("storageStatus")) map["storageStatus"] else "idle") as String,
            storageTargetGb = ((if (map.containsKey("storageTargetGb")) map["storageTargetGb"] else 0) as Number).toLong(),
            storageResizeStartedAt = map["storageResizeStartedAt"] as? String,
            storageClass = (if (map.containsKey("storageClass")) map["storageClass"] else "ssd") as String,
            storageMaxGb = ((if (map.containsKey("storageMaxGb")) map["storageMaxGb"] else 0) as Number).toLong(),
            nodePool = (if (map.containsKey("nodePool")) map["nodePool"] else "") as String,
            replicas = ((if (map.containsKey("replicas")) map["replicas"] else 0) as Number).toLong(),
            syncMode = (if (map.containsKey("syncMode")) map["syncMode"] else "") as String,
            networkMaxConnections = ((if (map.containsKey("networkMaxConnections")) map["networkMaxConnections"] else 100) as Number).toLong(),
            networkIdleTimeoutSeconds = ((if (map.containsKey("networkIdleTimeoutSeconds")) map["networkIdleTimeoutSeconds"] else 900) as Number).toLong(),
            networkIPAllowlist = (if (map.containsKey("networkIPAllowlist")) map["networkIPAllowlist"] else listOf<Any?>()) as List<String>,
            backupEnabled = (if (map.containsKey("backupEnabled")) map["backupEnabled"] else true) as Boolean,
            pitr = (if (map.containsKey("pitr")) map["pitr"] else true) as Boolean,
            pitrRetentionDays = ((if (map.containsKey("pitrRetentionDays")) map["pitrRetentionDays"] else 7) as Number).toLong(),
            storageAutoscaling = (if (map.containsKey("storageAutoscaling")) map["storageAutoscaling"] else true) as Boolean,
            storageAutoscalingThresholdPercent = ((if (map.containsKey("storageAutoscalingThresholdPercent")) map["storageAutoscalingThresholdPercent"] else 85) as Number).toLong(),
            storageAutoscalingMaxGb = ((if (map.containsKey("storageAutoscalingMaxGb")) map["storageAutoscalingMaxGb"] else 0) as Number).toLong(),
            maintenanceWindowDay = (if (map.containsKey("maintenanceWindowDay")) map["maintenanceWindowDay"] else "sun") as String,
            maintenanceWindowHourUtc = ((if (map.containsKey("maintenanceWindowHourUtc")) map["maintenanceWindowHourUtc"] else 3) as Number).toLong(),
            metricsEnabled = (if (map.containsKey("metricsEnabled")) map["metricsEnabled"] else false) as Boolean,
            sqlApiEnabled = (if (map.containsKey("sqlApiEnabled")) map["sqlApiEnabled"] else true) as Boolean,
            sqlApiAllowedStatements = (if (map.containsKey("sqlApiAllowedStatements")) map["sqlApiAllowedStatements"] else listOf<Any?>("SELECT", "INSERT", "UPDATE", "DELETE")) as List<String>,
            sqlApiMaxRows = ((if (map.containsKey("sqlApiMaxRows")) map["sqlApiMaxRows"] else 10000) as Number).toLong(),
            sqlApiMaxBytes = ((if (map.containsKey("sqlApiMaxBytes")) map["sqlApiMaxBytes"] else 10485760) as Number).toLong(),
            sqlApiTimeoutSeconds = ((if (map.containsKey("sqlApiTimeoutSeconds")) map["sqlApiTimeoutSeconds"] else 30) as Number).toLong(),
            error = (if (map.containsKey("error")) map["error"] else "") as String,
        )
    }
}
