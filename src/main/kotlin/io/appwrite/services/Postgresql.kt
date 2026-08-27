package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 ***/
class Postgresql(client: Client) : Service(client) {
    /**
     * List all dedicated databases. Results support pagination.
     *
     * @param queries Array of query strings.
     * @return [io.appwrite.models.DedicatedDatabaseList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
    ): io.appwrite.models.DedicatedDatabaseList {
        val apiPath = "/postgresql"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseList = {
            io.appwrite.models.DedicatedDatabaseList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseList::class.java,
            converter,
        )
    }

    /**
     * Create a new dedicated database with the chosen engine and configuration. Status will be 'provisioning' until the database is ready.
     *
     * @param databaseId Database ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Database display name. Max length: 128 chars.
     * @param version Database engine version. Defaults to latest for selected engine.
     * @param specification Specification identifier. Drives the allocated CPU, memory, storage, storage class, and connection ceiling.
     * @param replicas Number of high availability replicas (0-5). High availability is enabled when greater than 0.
     * @param syncMode Replication sync mode preference. Allowed values: async, sync, quorum.
     * @param networkIdleTimeoutSeconds Connection idle timeout in seconds.
     * @param networkIPAllowlist IP addresses/CIDR ranges allowed to connect.
     * @param idleTimeoutMinutes Minutes of inactivity before container scales to zero.
     * @param pitr Enable point-in-time recovery (PITR). Continuously archives changes so the database can be restored to any moment within the retention window.
     * @param pitrRetentionDays Number of days to retain PITR data.
     * @param storageAutoscaling Enable automatic storage expansion when usage exceeds threshold.
     * @param storageAutoscalingThresholdPercent Storage usage percentage (50-95) that triggers automatic expansion.
     * @param storageAutoscalingMaxGb Maximum storage size in GB for autoscaling. 0 means no limit.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        databaseId: String,
        name: String,
        version: String? = null,
        specification: String? = null,
        replicas: Long? = null,
        syncMode: String? = null,
        networkIdleTimeoutSeconds: Long? = null,
        networkIPAllowlist: List<String>? = null,
        idleTimeoutMinutes: Long? = null,
        pitr: Boolean? = null,
        pitrRetentionDays: Long? = null,
        storageAutoscaling: Boolean? = null,
        storageAutoscalingThresholdPercent: Long? = null,
        storageAutoscalingMaxGb: Long? = null,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = "/postgresql"
        val apiParams = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "name" to name,
            "version" to version,
            "specification" to specification,
            "replicas" to replicas,
            "syncMode" to syncMode,
            "networkIdleTimeoutSeconds" to networkIdleTimeoutSeconds,
            "networkIPAllowlist" to networkIPAllowlist,
            "idleTimeoutMinutes" to idleTimeoutMinutes,
            "pitr" to pitr,
            "pitrRetentionDays" to pitrRetentionDays,
            "storageAutoscaling" to storageAutoscaling,
            "storageAutoscalingThresholdPercent" to storageAutoscalingThresholdPercent,
            "storageAutoscalingMaxGb" to storageAutoscalingMaxGb,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * List the dedicated database specifications available on the current plan. Each specification reports its resource limits, pricing, and whether it is enabled for the organization.
     *
     * @return [io.appwrite.models.DedicatedDatabaseSpecificationList]
     */
    @Throws(AppwriteException::class)
    suspend fun listSpecifications(): io.appwrite.models.DedicatedDatabaseSpecificationList {
        val apiPath = "/postgresql/specifications"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseSpecificationList = {
            io.appwrite.models.DedicatedDatabaseSpecificationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseSpecificationList::class.java,
            converter,
        )
    }

    /**
     * Get a dedicated database by its unique ID. Returns the database configuration and current status.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Update a dedicated database configuration. All changes are applied with zero downtime. Specification changes (cpu, memory, storage) are handled via rolling cutover. Storage expansion is done online. All other settings are applied in-place.
     *
     * @param databaseId Database ID.
     * @param name Database display name.
     * @param status Database status. Allowed values: ready, paused, inactive. Set to "paused" to pause, "ready" to resume (also recovers a failed database whose infrastructure is healthy), or "inactive" to spin down a shared-pool database.
     * @param specification Specification. Changes cpu, memory, storage, connection ceiling, and node pool based on specification config. Resource changes are applied via rolling cutover with zero downtime.
     * @param replicas Number of high availability replicas (0-5). High availability is enabled when greater than 0.
     * @param syncMode Replication sync mode preference. Allowed values: async, sync, quorum.
     * @param networkIdleTimeoutSeconds Connection idle timeout in seconds (60-86400).
     * @param networkIPAllowlist IP addresses/CIDR ranges allowed to connect.
     * @param idleTimeoutMinutes Minutes before container scales to zero.
     * @param pitr Enable or disable point-in-time recovery (PITR).
     * @param pitrRetentionDays Days to retain PITR data.
     * @param storageAutoscaling Enable automatic storage expansion when usage exceeds threshold.
     * @param storageAutoscalingThresholdPercent Storage usage percentage (50-95) that triggers automatic expansion.
     * @param storageAutoscalingMaxGb Maximum storage size in GB for autoscaling. 0 means no limit.
     * @param metricsTraceSampleRate Fraction of queries to trace (0.0–1.0). Forwarded to the sidecar.
     * @param metricsSlowQueryLogThresholdMs Threshold in ms above which queries are logged as slow. Forwarded to the sidecar.
     * @param sqlApiEnabled Enable the SQL API sidecar for this database.
     * @param sqlApiAllowedStatements Statement types the SQL API accepts. Allowed values: SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, TRUNCATE, GRANT, REVOKE.
     * @param sqlApiMaxRows Maximum rows returned per SQL API execution (1-1000000).
     * @param sqlApiMaxBytes Maximum serialised SQL API result payload in bytes (1024-104857600).
     * @param sqlApiTimeoutSeconds Per-call SQL API execution timeout in seconds (1-300).
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        databaseId: String,
        name: String? = null,
        status: String? = null,
        specification: String? = null,
        replicas: Long? = null,
        syncMode: String? = null,
        networkIdleTimeoutSeconds: Long? = null,
        networkIPAllowlist: List<String>? = null,
        idleTimeoutMinutes: Long? = null,
        pitr: Boolean? = null,
        pitrRetentionDays: Long? = null,
        storageAutoscaling: Boolean? = null,
        storageAutoscalingThresholdPercent: Long? = null,
        storageAutoscalingMaxGb: Long? = null,
        metricsTraceSampleRate: Double? = null,
        metricsSlowQueryLogThresholdMs: Long? = null,
        sqlApiEnabled: Boolean? = null,
        sqlApiAllowedStatements: List<String>? = null,
        sqlApiMaxRows: Long? = null,
        sqlApiMaxBytes: Long? = null,
        sqlApiTimeoutSeconds: Long? = null,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "status" to status,
            "specification" to specification,
            "replicas" to replicas,
            "syncMode" to syncMode,
            "networkIdleTimeoutSeconds" to networkIdleTimeoutSeconds,
            "networkIPAllowlist" to networkIPAllowlist,
            "idleTimeoutMinutes" to idleTimeoutMinutes,
            "pitr" to pitr,
            "pitrRetentionDays" to pitrRetentionDays,
            "storageAutoscaling" to storageAutoscaling,
            "storageAutoscalingThresholdPercent" to storageAutoscalingThresholdPercent,
            "storageAutoscalingMaxGb" to storageAutoscalingMaxGb,
            "metricsTraceSampleRate" to metricsTraceSampleRate,
            "metricsSlowQueryLogThresholdMs" to metricsSlowQueryLogThresholdMs,
            "sqlApiEnabled" to sqlApiEnabled,
            "sqlApiAllowedStatements" to sqlApiAllowedStatements,
            "sqlApiMaxRows" to sqlApiMaxRows,
            "sqlApiMaxBytes" to sqlApiMaxBytes,
            "sqlApiTimeoutSeconds" to sqlApiTimeoutSeconds,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Delete a dedicated database. This action is irreversible. The database status will be set to 'deleting' and all resources will be cleaned up. Deletion is allowed from any state, and repeating the call re-dispatches the cleanup.
     *
     * @param databaseId Database ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        databaseId: String,
    ): Any {
        val apiPath = ("/postgresql/{databaseId}"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * List all backups for a dedicated database. Results can be filtered by status and type.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: status, type, databaseId
     * @return [io.appwrite.models.DedicatedDatabaseBackupList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listBackups(
        databaseId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.DedicatedDatabaseBackupList {
        val apiPath = ("/postgresql/{databaseId}/backups"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseBackupList = {
            io.appwrite.models.DedicatedDatabaseBackupList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseBackupList::class.java,
            converter,
        )
    }

    /**
     * Create a manual backup of a dedicated database. The backup will be created asynchronously and its status can be checked via the get backup endpoint.
     *
     * @param databaseId Database ID.
     * @param type Backup type: full or incremental.
     * @return [io.appwrite.models.DedicatedDatabaseBackup]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBackup(
        databaseId: String,
        type: String? = null,
    ): io.appwrite.models.DedicatedDatabaseBackup {
        val apiPath = ("/postgresql/{databaseId}/backups"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseBackup = {
            io.appwrite.models.DedicatedDatabaseBackup.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseBackup::class.java,
            converter,
        )
    }

    /**
     * List scheduled backup policies for a dedicated database.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK.
     * @return [io.appwrite.models.BackupPolicyList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listBackupPolicies(
        databaseId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.BackupPolicyList {
        val apiPath = ("/postgresql/{databaseId}/backups/policies"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupPolicyList = {
            io.appwrite.models.BackupPolicyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupPolicyList::class.java,
            converter,
        )
    }

    /**
     * Create a scheduled backup policy for a dedicated database.
     *
     * @param databaseId Database ID.
     * @param policyId Policy ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Policy name. Max length: 128 chars.
     * @param schedule Schedule CRON syntax.
     * @param retention Days to keep backups before deletion.
     * @param type Backup type: full or incremental.
     * @param enabled Is policy enabled? When disabled, no backups will be taken.
     * @return [io.appwrite.models.BackupPolicy]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBackupPolicy(
        databaseId: String,
        policyId: String,
        name: String,
        schedule: String,
        retention: Long,
        type: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = ("/postgresql/{databaseId}/backups/policies"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "policyId" to policyId,
            "name" to name,
            "schedule" to schedule,
            "retention" to retention,
            "type" to type,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupPolicy = {
            io.appwrite.models.BackupPolicy.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupPolicy::class.java,
            converter,
        )
    }

    /**
     * Get a scheduled backup policy for a dedicated database.
     *
     * @param databaseId Database ID.
     * @param policyId Policy ID.
     * @return [io.appwrite.models.BackupPolicy]
     */
    @Throws(AppwriteException::class)
    suspend fun getBackupPolicy(
        databaseId: String,
        policyId: String,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = ("/postgresql/{databaseId}/backups/policies/{policyId}"
            .replace("{databaseId}", databaseId)
            .replace("{policyId}", policyId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupPolicy = {
            io.appwrite.models.BackupPolicy.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupPolicy::class.java,
            converter,
        )
    }

    /**
     * Update a scheduled backup policy for a dedicated database.
     *
     * @param databaseId Database ID.
     * @param policyId Policy ID.
     * @param name Policy name. Max length: 128 chars.
     * @param schedule Schedule CRON syntax.
     * @param retention Days to keep backups before deletion.
     * @param enabled Is policy enabled? When disabled, no backups will be taken.
     * @return [io.appwrite.models.BackupPolicy]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBackupPolicy(
        databaseId: String,
        policyId: String,
        name: String? = null,
        schedule: String? = null,
        retention: Long? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = ("/postgresql/{databaseId}/backups/policies/{policyId}"
            .replace("{databaseId}", databaseId)
            .replace("{policyId}", policyId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "schedule" to schedule,
            "retention" to retention,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupPolicy = {
            io.appwrite.models.BackupPolicy.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupPolicy::class.java,
            converter,
        )
    }

    /**
     * Delete a scheduled backup policy for a dedicated database. Backups already taken by the policy are kept until their retention expires.
     *
     * @param databaseId Database ID.
     * @param policyId Policy ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteBackupPolicy(
        databaseId: String,
        policyId: String,
    ): Any {
        val apiPath = ("/postgresql/{databaseId}/backups/policies/{policyId}"
            .replace("{databaseId}", databaseId)
            .replace("{policyId}", policyId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Configure off-cluster backup storage for a dedicated database. Supports S3, GCS, and Azure Blob Storage destinations. Backups will be stored to the configured destination in addition to on-cluster storage.
     *
     * @param databaseId Database ID.
     * @param provider Storage provider for off-cluster backups. Allowed values: s3 (Amazon S3 or S3-compatible), gcs (Google Cloud Storage), azure (Azure Blob Storage).
     * @param bucket Storage bucket or container name.
     * @param accessKey Access key or client ID for authentication.
     * @param secretKey Secret key or service account JSON for authentication.
     * @param region Storage region.
     * @param prefix Object key prefix for backups.
     * @param endpoint Custom endpoint for S3-compatible storage (e.g. MinIO).
     * @return [io.appwrite.models.DedicatedDatabaseBackupStorage]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBackupStorage(
        databaseId: String,
        provider: String,
        bucket: String,
        accessKey: String,
        secretKey: String,
        region: String? = null,
        prefix: String? = null,
        endpoint: String? = null,
    ): io.appwrite.models.DedicatedDatabaseBackupStorage {
        val apiPath = ("/postgresql/{databaseId}/backups/storage"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "provider" to provider,
            "bucket" to bucket,
            "region" to region,
            "prefix" to prefix,
            "endpoint" to endpoint,
            "accessKey" to accessKey,
            "secretKey" to secretKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseBackupStorage = {
            io.appwrite.models.DedicatedDatabaseBackupStorage.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseBackupStorage::class.java,
            converter,
        )
    }

    /**
     * Get details of a specific database backup including its status, size, and timestamps.
     *
     * @param databaseId Database ID.
     * @param backupId Backup ID.
     * @return [io.appwrite.models.DedicatedDatabaseBackup]
     */
    @Throws(AppwriteException::class)
    suspend fun getBackup(
        databaseId: String,
        backupId: String,
    ): io.appwrite.models.DedicatedDatabaseBackup {
        val apiPath = ("/postgresql/{databaseId}/backups/{backupId}"
            .replace("{databaseId}", databaseId)
            .replace("{backupId}", backupId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseBackup = {
            io.appwrite.models.DedicatedDatabaseBackup.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseBackup::class.java,
            converter,
        )
    }

    /**
     * Delete a database backup. This will permanently remove the backup from storage and cannot be undone.
     *
     * @param databaseId Database ID.
     * @param backupId Backup ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteBackup(
        databaseId: String,
        backupId: String,
    ): Any {
        val apiPath = ("/postgresql/{databaseId}/backups/{backupId}"
            .replace("{databaseId}", databaseId)
            .replace("{backupId}", backupId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * List all ephemeral branches for a dedicated database. Returns branch metadata including ID, name, namespace, and expiration time.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabaseBranchList]
     */
    @Throws(AppwriteException::class)
    suspend fun listBranches(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabaseBranchList {
        val apiPath = ("/postgresql/{databaseId}/branches"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseBranchList = {
            io.appwrite.models.DedicatedDatabaseBranchList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseBranchList::class.java,
            converter,
        )
    }

    /**
     * Create an ephemeral database branch from the primary via PVC snapshot. The branch is a full copy of the database at the current point in time, useful for testing schema migrations or running experiments without affecting production data. Branches expire after the configured TTL (default 24 hours). The branch is created asynchronously.
     *
     * @param databaseId Database ID.
     * @param branchId Branch ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param ttl Time-to-live in seconds before the branch expires. Min 300 (5 min), max 604800 (7 days). Default: 86400 (24h).
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBranch(
        databaseId: String,
        branchId: String? = null,
        ttl: Long? = null,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/branches"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "branchId" to branchId,
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Delete an ephemeral database branch. This removes the branch namespace, its PVC, and the associated VolumeSnapshot. The deletion runs asynchronously and is irreversible.
     *
     * @param databaseId Database ID.
     * @param branchId Branch ID.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteBranch(
        databaseId: String,
        branchId: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/branches/{branchId}"
            .replace("{databaseId}", databaseId)
            .replace("{branchId}", branchId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Rotate the primary connection credentials for a dedicated database. Generates a new password and updates the database atomically. Previous credentials stop working immediately. Returns the database with a refreshed connection string carrying the new password.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun updateCredentials(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/credentials"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Execute SQL through the console-facing Cloud endpoint. Cloud proxies through the edge platform to the per-database SQL API sidecar. Application traffic should bypass cloud entirely and POST directly to the per-database hostname: `https://db-{project}-{db}.{region}.appwrite.center/v1/sql/executions` with an `X-Appwrite-Key` header — that path scales to the whole DB fleet without a per-query cloud round-trip. The statement type must be on the database's configured allow-list. Use bound parameters for any user-supplied values — the API does not interpolate raw strings.
     *
     * @param databaseId Database ID.
     * @param sql SQL statement to execute. Exactly one statement per request.
     * @param bindings Optional bound parameters. Pass either a positional list or a name => value map matching the placeholder style used in the SQL.
     * @param timeoutSeconds Per-call execution timeout override. Must be less than or equal to the database's configured sqlApiTimeoutSeconds.
     * @return [io.appwrite.models.DedicatedDatabaseExecution]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createExecution(
        databaseId: String,
        sql: String,
        bindings: Map<String, Any?>? = null,
        timeoutSeconds: Long? = null,
    ): io.appwrite.models.DedicatedDatabaseExecution {
        val apiPath = ("/postgresql/{databaseId}/executions"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "sql" to sql,
            "bindings" to bindings,
            "timeoutSeconds" to timeoutSeconds,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseExecution = {
            io.appwrite.models.DedicatedDatabaseExecution.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseExecution::class.java,
            converter,
        )
    }

    /**
     * List installed and available extensions for a PostgreSQL database.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabaseExtensions]
     */
    @Throws(AppwriteException::class)
    suspend fun listExtensions(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabaseExtensions {
        val apiPath = ("/postgresql/{databaseId}/extensions"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseExtensions = {
            io.appwrite.models.DedicatedDatabaseExtensions.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseExtensions::class.java,
            converter,
        )
    }

    /**
     * Install a database extension. Only available for PostgreSQL databases. The install runs asynchronously; poll the extensions list endpoint for status.
     *
     * @param databaseId Database ID.
     * @param name Extension name (e.g., pgvector, postgis, uuid-ossp).
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun createExtension(
        databaseId: String,
        name: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/extensions"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Uninstall a database extension from a PostgreSQL database. The uninstall runs asynchronously; poll the extensions list endpoint for status.
     *
     * @param databaseId Database ID.
     * @param extensionName Extension name to uninstall.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteExtension(
        databaseId: String,
        extensionName: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/extensions/{extensionName}"
            .replace("{databaseId}", databaseId)
            .replace("{extensionName}", extensionName)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Trigger a manual failover for a dedicated database with high availability enabled. Promotes a replica to primary. The failover runs asynchronously; poll the database document for status updates. A database left mid-operation also accepts this call as a repair once nothing is driving the operation it is stuck in. Repairing a failover that did not finish, a `failed` database, a stranded upgrade or migrate, or a stranded compute resize additionally requires `targetReplicaId` to name the member to promote, because the default target may be the member that operation already promoted.
     *
     * @param databaseId Database ID.
     * @param targetReplicaId Target replica ID to promote. If not specified, the healthiest replica is selected.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFailover(
        databaseId: String,
        targetReplicaId: String? = null,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/failovers"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "targetReplicaId" to targetReplicaId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Update the maintenance window for a dedicated database. Maintenance operations like minor version upgrades will be performed during this window.
     *
     * @param databaseId Database ID.
     * @param day Day of the week for the maintenance window. Allowed values: sun, mon, tue, wed, thu, fri, sat.
     * @param hourUtc Hour in UTC (0-23) for maintenance window start.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMaintenance(
        databaseId: String,
        day: String,
        hourUtc: Long,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/maintenance"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "day" to day,
            "hourUtc" to hourUtc,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * Migrate a database between shared and dedicated types. Shared to dedicated provisions an always-on dedicated instance; dedicated to shared converts to a serverless instance that scales to zero when idle. Data is copied to the target with a brief read-only window during cutover.
     *
     * @param databaseId Database ID.
     * @param targetType Target database type to migrate to. Allowed values: shared (serverless, scales to zero when idle), dedicated (always-on with persistent resources).
     * @param specification Target specification to provision when migrating to dedicated. Ignored for shared. Defaults to the database's current specification.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMigration(
        databaseId: String,
        targetType: String,
        specification: String? = null,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/migrations"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "targetType" to targetType,
            "specification" to specification,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }

    /**
     * List the lifecycle operations recorded for a dedicated database, newest first. Every provision, update, restore, backup and replication action is recorded here with its outcome, including an attempt that was abandoned because another worker took over the database.
     *
     * @param databaseId Database ID.
     * @param status Filter by operation status.
     * @param limit Maximum number of operations to return.
     * @param offset Number of operations to skip.
     * @return [io.appwrite.models.DedicatedDatabaseOperationList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listOperations(
        databaseId: String,
        status: String? = null,
        limit: Long? = null,
        offset: Long? = null,
    ): io.appwrite.models.DedicatedDatabaseOperationList {
        val apiPath = ("/postgresql/{databaseId}/operations"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
            "limit" to limit,
            "offset" to offset,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseOperationList = {
            io.appwrite.models.DedicatedDatabaseOperationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseOperationList::class.java,
            converter,
        )
    }

    /**
     * Get available point-in-time recovery windows for a dedicated database. Returns the earliest and latest recovery points.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabasePITRWindows]
     */
    @Throws(AppwriteException::class)
    suspend fun getPitr(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabasePITRWindows {
        val apiPath = ("/postgresql/{databaseId}/pitr"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabasePITRWindows = {
            io.appwrite.models.DedicatedDatabasePITRWindows.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabasePITRWindows::class.java,
            converter,
        )
    }

    /**
     * Get the connection pooler configuration for a dedicated database. Returns pooler mode, max connections, and pool size settings.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabasePooler]
     */
    @Throws(AppwriteException::class)
    suspend fun getPooler(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabasePooler {
        val apiPath = ("/postgresql/{databaseId}/pooler"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabasePooler = {
            io.appwrite.models.DedicatedDatabasePooler.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabasePooler::class.java,
            converter,
        )
    }

    /**
     * Update the connection pooler configuration for a dedicated database. Configure pool mode, max connections, and pool sizes.
     *
     * @param databaseId Database ID.
     * @param mode Connection pool mode. Allowed values: transaction, session. Transaction mode returns connections to the pool after each transaction; session mode holds connections for the entire session lifetime.
     * @param maxConnections Client-connection ceiling the pooler accepts. Supported on MySQL and MariaDB only; the PostgreSQL pooler has no client cap, so set networkMaxConnections on the database instead.
     * @param defaultPoolSize Default pool size per user.
     * @param readWriteSplitting Route SELECTs to HA replicas, writes and locked reads to the primary. Defaults to true when HA is enabled.
     * @param poolerCpuRequest Pooler sidecar CPU request override (Kubernetes quantity, e.g. "250m" or "1"). Leave null for the proportional default (5% of DB CPU, floor 100m).
     * @param poolerCpuLimit Pooler sidecar CPU limit override (Kubernetes quantity, e.g. "500m" or "1"). Leave null for the proportional default (10% of DB CPU, floor 200m). Changing this field rolls the database pod.
     * @param poolerMemoryRequest Pooler sidecar memory request override (Kubernetes quantity, e.g. "128Mi" or "1Gi"). Leave null for the proportional default (7.5% of DB memory, floor 64Mi).
     * @param poolerMemoryLimit Pooler sidecar memory limit override (Kubernetes quantity, e.g. "256Mi" or "1Gi"). Leave null for the proportional default (15% of DB memory, floor 128Mi). Changing this field rolls the database pod.
     * @return [io.appwrite.models.DedicatedDatabasePooler]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePooler(
        databaseId: String,
        mode: String? = null,
        maxConnections: Long? = null,
        defaultPoolSize: Long? = null,
        readWriteSplitting: Boolean? = null,
        poolerCpuRequest: String? = null,
        poolerCpuLimit: String? = null,
        poolerMemoryRequest: String? = null,
        poolerMemoryLimit: String? = null,
    ): io.appwrite.models.DedicatedDatabasePooler {
        val apiPath = ("/postgresql/{databaseId}/pooler"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "mode" to mode,
            "maxConnections" to maxConnections,
            "defaultPoolSize" to defaultPoolSize,
            "readWriteSplitting" to readWriteSplitting,
            "poolerCpuRequest" to poolerCpuRequest,
            "poolerCpuLimit" to poolerCpuLimit,
            "poolerMemoryRequest" to poolerMemoryRequest,
            "poolerMemoryLimit" to poolerMemoryLimit,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabasePooler = {
            io.appwrite.models.DedicatedDatabasePooler.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabasePooler::class.java,
            converter,
        )
    }

    /**
     * Get high availability status for a dedicated database. Returns replica statuses, replication lag, and sync mode.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DedicatedDatabaseReplicas]
     */
    @Throws(AppwriteException::class)
    suspend fun getReplicas(
        databaseId: String,
    ): io.appwrite.models.DedicatedDatabaseReplicas {
        val apiPath = ("/postgresql/{databaseId}/replicas"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseReplicas = {
            io.appwrite.models.DedicatedDatabaseReplicas.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseReplicas::class.java,
            converter,
        )
    }

    /**
     * List all restorations for a dedicated database. Results can be filtered by status and type.
     *
     * @param databaseId Database ID.
     * @param status Filter by restoration status.
     * @param type Filter by restoration type.
     * @param limit Maximum number of restorations to return.
     * @param offset Number of restorations to skip.
     * @return [io.appwrite.models.DedicatedDatabaseRestorationList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRestorations(
        databaseId: String,
        status: String? = null,
        type: String? = null,
        limit: Long? = null,
        offset: Long? = null,
    ): io.appwrite.models.DedicatedDatabaseRestorationList {
        val apiPath = ("/postgresql/{databaseId}/restorations"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
            "type" to type,
            "limit" to limit,
            "offset" to offset,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseRestorationList = {
            io.appwrite.models.DedicatedDatabaseRestorationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseRestorationList::class.java,
            converter,
        )
    }

    /**
     * Restore a database from a backup or to a specific point in time (PITR). For backup restoration, provide a backupId. For PITR, provide a targetTime as an ISO 8601 datetime. PITR requires the database to have PITR enabled and is only available for enterprise databases.
     *
     * @param databaseId Database ID.
     * @param type Restoration type. Allowed values: backup, pitr. Use "backup" to restore from a specific backup, or "pitr" for point-in-time recovery.
     * @param backupId Backup ID to restore from (required for backup type).
     * @param targetDatabaseId Existing database ID to restore into. The target must be distinct, ready, and use the same engine and version.
     * @param targetTime Target time for PITR (required for pitr type) as an [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) datetime.
     * @return [io.appwrite.models.DedicatedDatabaseRestoration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRestoration(
        databaseId: String,
        type: String? = null,
        backupId: String? = null,
        targetDatabaseId: String? = null,
        targetTime: String? = null,
    ): io.appwrite.models.DedicatedDatabaseRestoration {
        val apiPath = ("/postgresql/{databaseId}/restorations"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
            "backupId" to backupId,
            "targetDatabaseId" to targetDatabaseId,
            "targetTime" to targetTime,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseRestoration = {
            io.appwrite.models.DedicatedDatabaseRestoration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseRestoration::class.java,
            converter,
        )
    }

    /**
     * Get details of a specific database restoration including its status, type, and timestamps.
     *
     * @param databaseId Database ID.
     * @param restorationId Restoration ID.
     * @return [io.appwrite.models.DedicatedDatabaseRestoration]
     */
    @Throws(AppwriteException::class)
    suspend fun getRestoration(
        databaseId: String,
        restorationId: String,
    ): io.appwrite.models.DedicatedDatabaseRestoration {
        val apiPath = ("/postgresql/{databaseId}/restorations/{restorationId}"
            .replace("{databaseId}", databaseId)
            .replace("{restorationId}", restorationId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabaseRestoration = {
            io.appwrite.models.DedicatedDatabaseRestoration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabaseRestoration::class.java,
            converter,
        )
    }

    /**
     * Get real-time health and status information for a dedicated database. Returns health status, readiness, uptime, connection info, replica status, and volume information.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.DatabaseStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getStatus(
        databaseId: String,
    ): io.appwrite.models.DatabaseStatus {
        val apiPath = ("/postgresql/{databaseId}/status"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DatabaseStatus = {
            io.appwrite.models.DatabaseStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DatabaseStatus::class.java,
            converter,
        )
    }

    /**
     * Upgrade a dedicated database to a new engine version. Uses blue-green deployment for zero-downtime cutover.
     *
     * @param databaseId Database ID.
     * @param targetVersion Target engine version to upgrade to.
     * @return [io.appwrite.models.DedicatedDatabase]
     */
    @Throws(AppwriteException::class)
    suspend fun createUpgrade(
        databaseId: String,
        targetVersion: String,
    ): io.appwrite.models.DedicatedDatabase {
        val apiPath = ("/postgresql/{databaseId}/upgrades"
            .replace("{databaseId}", databaseId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "targetVersion" to targetVersion,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DedicatedDatabase = {
            io.appwrite.models.DedicatedDatabase.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DedicatedDatabase::class.java,
            converter,
        )
    }
}
