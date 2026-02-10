package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Backups(client: Client) : Service(client) {

    /**
     * List all archives for a project.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.BackupArchiveList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listArchives(
        queries: List<String>? = null,
    ): io.appwrite.models.BackupArchiveList {
        val apiPath = "/backups/archives"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.BackupArchiveList = {
            io.appwrite.models.BackupArchiveList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupArchiveList::class.java,
            converter,
        )
    }

    /**
     * Create a new archive asynchronously for a project.
     *
     * @param services Array of services to backup
     * @param resourceId Resource ID. When set, only this single resource will be backed up.
     * @return [io.appwrite.models.BackupArchive]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createArchive(
        services: List<io.appwrite.enums.BackupServices>,
        resourceId: String? = null,
    ): io.appwrite.models.BackupArchive {
        val apiPath = "/backups/archives"

        val apiParams = mutableMapOf<String, Any?>(
            "services" to services,
            "resourceId" to resourceId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupArchive = {
            io.appwrite.models.BackupArchive.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupArchive::class.java,
            converter,
        )
    }

    /**
     * Get a backup archive using it's ID.
     *
     * @param archiveId Archive ID. Choose a custom ID`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [io.appwrite.models.BackupArchive]
     */
    @Throws(AppwriteException::class)
    suspend fun getArchive(
        archiveId: String,
    ): io.appwrite.models.BackupArchive {
        val apiPath = "/backups/archives/{archiveId}"
            .replace("{archiveId}", archiveId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.BackupArchive = {
            io.appwrite.models.BackupArchive.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupArchive::class.java,
            converter,
        )
    }

    /**
     * Delete an existing archive for a project.
     *
     * @param archiveId Policy ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteArchive(
        archiveId: String,
    ): Any {
        val apiPath = "/backups/archives/{archiveId}"
            .replace("{archiveId}", archiveId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * List all policies for a project.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.BackupPolicyList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listPolicies(
        queries: List<String>? = null,
    ): io.appwrite.models.BackupPolicyList {
        val apiPath = "/backups/policies"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * Create a new backup policy.
     *
     * @param policyId Policy ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param services Array of services to backup
     * @param retention Days to keep backups before deletion
     * @param schedule Schedule CRON syntax.
     * @param name Policy name. Max length: 128 chars.
     * @param resourceId Resource ID. When set, only this single resource will be backed up.
     * @param enabled Is policy enabled? When set to 'disabled', no backups will be taken
     * @return [io.appwrite.models.BackupPolicy]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createPolicy(
        policyId: String,
        services: List<io.appwrite.enums.BackupServices>,
        retention: Long,
        schedule: String,
        name: String? = null,
        resourceId: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = "/backups/policies"

        val apiParams = mutableMapOf<String, Any?>(
            "policyId" to policyId,
            "name" to name,
            "services" to services,
            "resourceId" to resourceId,
            "enabled" to enabled,
            "retention" to retention,
            "schedule" to schedule,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Get a backup policy using it's ID.
     *
     * @param policyId Policy ID. Choose a custom ID`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [io.appwrite.models.BackupPolicy]
     */
    @Throws(AppwriteException::class)
    suspend fun getPolicy(
        policyId: String,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = "/backups/policies/{policyId}"
            .replace("{policyId}", policyId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * Update an existing policy using it's ID.
     *
     * @param policyId Policy ID. Choose a custom ID`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Policy name. Max length: 128 chars.
     * @param retention Days to keep backups before deletion
     * @param schedule Cron expression
     * @param enabled Is Backup enabled? When set to 'disabled', No backup will be taken
     * @return [io.appwrite.models.BackupPolicy]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePolicy(
        policyId: String,
        name: String? = null,
        retention: Long? = null,
        schedule: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.BackupPolicy {
        val apiPath = "/backups/policies/{policyId}"
            .replace("{policyId}", policyId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "retention" to retention,
            "schedule" to schedule,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Delete a policy using it's ID.
     *
     * @param policyId Policy ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deletePolicy(
        policyId: String,
    ): Any {
        val apiPath = "/backups/policies/{policyId}"
            .replace("{policyId}", policyId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * Create and trigger a new restoration for a backup on a project.
     *
     * @param archiveId Backup archive ID to restore
     * @param services Array of services to restore
     * @param newResourceId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param newResourceName Database name. Max length: 128 chars.
     * @return [io.appwrite.models.BackupRestoration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRestoration(
        archiveId: String,
        services: List<io.appwrite.enums.BackupServices>,
        newResourceId: String? = null,
        newResourceName: String? = null,
    ): io.appwrite.models.BackupRestoration {
        val apiPath = "/backups/restoration"

        val apiParams = mutableMapOf<String, Any?>(
            "archiveId" to archiveId,
            "services" to services,
            "newResourceId" to newResourceId,
            "newResourceName" to newResourceName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BackupRestoration = {
            io.appwrite.models.BackupRestoration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupRestoration::class.java,
            converter,
        )
    }

    /**
     * List all backup restorations for a project.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.BackupRestorationList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRestorations(
        queries: List<String>? = null,
    ): io.appwrite.models.BackupRestorationList {
        val apiPath = "/backups/restorations"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.BackupRestorationList = {
            io.appwrite.models.BackupRestorationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupRestorationList::class.java,
            converter,
        )
    }

    /**
     * Get the current status of a backup restoration.
     *
     * @param restorationId Restoration ID. Choose a custom ID`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [io.appwrite.models.BackupRestoration]
     */
    @Throws(AppwriteException::class)
    suspend fun getRestoration(
        restorationId: String,
    ): io.appwrite.models.BackupRestoration {
        val apiPath = "/backups/restorations/{restorationId}"
            .replace("{restorationId}", restorationId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.BackupRestoration = {
            io.appwrite.models.BackupRestoration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.BackupRestoration::class.java,
            converter,
        )
    }

}