package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * dedicatedDatabaseLimits
 */
data class BillingPlanDedicatedDatabaseLimits(
    /**
     * Minimum CPU allocation in millicores.
     */
    @SerializedName("minCpu")
    var minCpu: Long?,

    /**
     * Maximum CPU allocation in millicores.
     */
    @SerializedName("maxCpu")
    var maxCpu: Long?,

    /**
     * Minimum memory allocation in megabytes.
     */
    @SerializedName("minMemoryMb")
    var minMemoryMb: Long?,

    /**
     * Maximum memory allocation in megabytes.
     */
    @SerializedName("maxMemoryMb")
    var maxMemoryMb: Long?,

    /**
     * Minimum storage allocation in gigabytes.
     */
    @SerializedName("minStorageGb")
    var minStorageGb: Long?,

    /**
     * Maximum storage allocation in gigabytes.
     */
    @SerializedName("maxStorageGb")
    var maxStorageGb: Long?,

    /**
     * Maximum number of high-availability replicas per dedicated database.
     */
    @SerializedName("maxReplicas")
    var maxReplicas: Long?,

    /**
     * Maximum number of client connections.
     */
    @SerializedName("maxConnections")
    var maxConnections: Long?,

    /**
     * Maximum number of entries allowed in the IP allowlist.
     */
    @SerializedName("maxIpAllowlistSize")
    var maxIpAllowlistSize: Long?,

    /**
     * Maximum number of database extensions that can be enabled.
     */
    @SerializedName("maxExtensions")
    var maxExtensions: Long?,

    /**
     * Maximum number of days a backup can be retained.
     */
    @SerializedName("maxBackupRetentionDays")
    var maxBackupRetentionDays: Long?,

    /**
     * Maximum number of days of point-in-time recovery data that can be retained.
     */
    @SerializedName("maxPitrRetentionDays")
    var maxPitrRetentionDays: Long?,

    /**
     * Maximum number of rows a single SQL API query can return.
     */
    @SerializedName("maxSqlApiMaxRows")
    var maxSqlApiMaxRows: Long?,

    /**
     * Maximum response size in bytes for a single SQL API query.
     */
    @SerializedName("maxSqlApiMaxBytes")
    var maxSqlApiMaxBytes: Long?,

    /**
     * Maximum execution time in seconds for a single SQL API query.
     */
    @SerializedName("maxSqlApiTimeoutSeconds")
    var maxSqlApiTimeoutSeconds: Long?,

    /**
     * Maximum number of SQL statement types that can be permitted through the SQL API.
     */
    @SerializedName("maxSqlApiAllowedStatements")
    var maxSqlApiAllowedStatements: Long?,

    /**
     * SQL statement types permitted through the SQL API.
     */
    @SerializedName("allowedSqlStatements")
    var allowedSqlStatements: List<String>?,

    /**
     * Storage classes available for dedicated databases.
     */
    @SerializedName("allowedStorageClasses")
    var allowedStorageClasses: List<String>?,

    /**
     * Replica synchronization modes available for dedicated databases.
     */
    @SerializedName("allowedSyncModes")
    var allowedSyncModes: List<String>?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "minCpu" to minCpu as Any,
        "maxCpu" to maxCpu as Any,
        "minMemoryMb" to minMemoryMb as Any,
        "maxMemoryMb" to maxMemoryMb as Any,
        "minStorageGb" to minStorageGb as Any,
        "maxStorageGb" to maxStorageGb as Any,
        "maxReplicas" to maxReplicas as Any,
        "maxConnections" to maxConnections as Any,
        "maxIpAllowlistSize" to maxIpAllowlistSize as Any,
        "maxExtensions" to maxExtensions as Any,
        "maxBackupRetentionDays" to maxBackupRetentionDays as Any,
        "maxPitrRetentionDays" to maxPitrRetentionDays as Any,
        "maxSqlApiMaxRows" to maxSqlApiMaxRows as Any,
        "maxSqlApiMaxBytes" to maxSqlApiMaxBytes as Any,
        "maxSqlApiTimeoutSeconds" to maxSqlApiTimeoutSeconds as Any,
        "maxSqlApiAllowedStatements" to maxSqlApiAllowedStatements as Any,
        "allowedSqlStatements" to allowedSqlStatements as Any,
        "allowedStorageClasses" to allowedStorageClasses as Any,
        "allowedSyncModes" to allowedSyncModes as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlanDedicatedDatabaseLimits(
            minCpu = (map["minCpu"] as? Number)?.toLong(),
            maxCpu = (map["maxCpu"] as? Number)?.toLong(),
            minMemoryMb = (map["minMemoryMb"] as? Number)?.toLong(),
            maxMemoryMb = (map["maxMemoryMb"] as? Number)?.toLong(),
            minStorageGb = (map["minStorageGb"] as? Number)?.toLong(),
            maxStorageGb = (map["maxStorageGb"] as? Number)?.toLong(),
            maxReplicas = (map["maxReplicas"] as? Number)?.toLong(),
            maxConnections = (map["maxConnections"] as? Number)?.toLong(),
            maxIpAllowlistSize = (map["maxIpAllowlistSize"] as? Number)?.toLong(),
            maxExtensions = (map["maxExtensions"] as? Number)?.toLong(),
            maxBackupRetentionDays = (map["maxBackupRetentionDays"] as? Number)?.toLong(),
            maxPitrRetentionDays = (map["maxPitrRetentionDays"] as? Number)?.toLong(),
            maxSqlApiMaxRows = (map["maxSqlApiMaxRows"] as? Number)?.toLong(),
            maxSqlApiMaxBytes = (map["maxSqlApiMaxBytes"] as? Number)?.toLong(),
            maxSqlApiTimeoutSeconds = (map["maxSqlApiTimeoutSeconds"] as? Number)?.toLong(),
            maxSqlApiAllowedStatements = (map["maxSqlApiAllowedStatements"] as? Number)?.toLong(),
            allowedSqlStatements = map["allowedSqlStatements"] as? List<String>,
            allowedStorageClasses = map["allowedStorageClasses"] as? List<String>,
            allowedSyncModes = map["allowedSyncModes"] as? List<String>,
        )
    }
}