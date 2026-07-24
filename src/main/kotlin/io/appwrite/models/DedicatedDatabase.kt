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
    val api: String,

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
     * Specification identifier.
     */
    @SerializedName("specification")
    val specification: String,

    /**
     * Database backend provider. Possible values: prisma, edge.
     */
    @SerializedName("backend")
    val backend: String,

    /**
     * Database hostname for connections.
     */
    @SerializedName("hostname")
    val hostname: String,

    /**
     * Database port for connections.
     */
    @SerializedName("connectionPort")
    val connectionPort: Long,

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
     * Container status for lifecycle-managed database runtimes: active or inactive.
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
     * Number of cross-region replicas. Cross-region availability is enabled when greater than 0.
     */
    @SerializedName("crossRegionReplicas")
    val crossRegionReplicas: Long,

    /**
     * Maximum concurrent connections.
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
     * Maximum storage size in GB for autoscaling. 0 means no limit.
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
        "api" to api as Any,
        "engine" to engine as Any,
        "version" to version as Any,
        "specification" to specification as Any,
        "backend" to backend as Any,
        "hostname" to hostname as Any,
        "connectionPort" to connectionPort as Any,
        "connectionUser" to connectionUser as Any,
        "connectionPassword" to connectionPassword as Any,
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
        "storageClass" to storageClass as Any,
        "storageMaxGb" to storageMaxGb as Any,
        "nodePool" to nodePool as Any,
        "replicas" to replicas as Any,
        "syncMode" to syncMode as Any,
        "crossRegionReplicas" to crossRegionReplicas as Any,
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
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            projectId = map["projectId"] as String,
            name = map["name"] as String,
            api = map["api"] as String,
            engine = map["engine"] as String,
            version = map["version"] as String,
            specification = map["specification"] as String,
            backend = map["backend"] as String,
            hostname = map["hostname"] as String,
            connectionPort = (map["connectionPort"] as Number).toLong(),
            connectionUser = map["connectionUser"] as String,
            connectionPassword = map["connectionPassword"] as String,
            connectionString = map["connectionString"] as String,
            ssl = map["ssl"] as Boolean,
            status = map["status"] as String,
            containerStatus = map["containerStatus"] as String,
            lastAccessedAt = map["lastAccessedAt"] as? String,
            idleUntil = map["idleUntil"] as? String,
            lifecycleState = map["lifecycleState"] as String,
            idleTimeoutMinutes = (map["idleTimeoutMinutes"] as Number).toLong(),
            cpu = (map["cpu"] as Number).toLong(),
            memory = (map["memory"] as Number).toLong(),
            storage = (map["storage"] as Number).toLong(),
            storageClass = map["storageClass"] as String,
            storageMaxGb = (map["storageMaxGb"] as Number).toLong(),
            nodePool = map["nodePool"] as String,
            replicas = (map["replicas"] as Number).toLong(),
            syncMode = map["syncMode"] as String,
            crossRegionReplicas = (map["crossRegionReplicas"] as Number).toLong(),
            networkMaxConnections = (map["networkMaxConnections"] as Number).toLong(),
            networkIdleTimeoutSeconds = (map["networkIdleTimeoutSeconds"] as Number).toLong(),
            networkIPAllowlist = map["networkIPAllowlist"] as List<String>,
            backupEnabled = map["backupEnabled"] as Boolean,
            pitr = map["pitr"] as Boolean,
            pitrRetentionDays = (map["pitrRetentionDays"] as Number).toLong(),
            storageAutoscaling = map["storageAutoscaling"] as Boolean,
            storageAutoscalingThresholdPercent = (map["storageAutoscalingThresholdPercent"] as Number).toLong(),
            storageAutoscalingMaxGb = (map["storageAutoscalingMaxGb"] as Number).toLong(),
            maintenanceWindowDay = map["maintenanceWindowDay"] as String,
            maintenanceWindowHourUtc = (map["maintenanceWindowHourUtc"] as Number).toLong(),
            metricsEnabled = map["metricsEnabled"] as Boolean,
            sqlApiEnabled = map["sqlApiEnabled"] as Boolean,
            sqlApiAllowedStatements = map["sqlApiAllowedStatements"] as List<String>,
            sqlApiMaxRows = (map["sqlApiMaxRows"] as Number).toLong(),
            sqlApiMaxBytes = (map["sqlApiMaxBytes"] as Number).toLong(),
            sqlApiTimeoutSeconds = (map["sqlApiTimeoutSeconds"] as Number).toLong(),
            error = map["error"] as String,
        )
    }
}
