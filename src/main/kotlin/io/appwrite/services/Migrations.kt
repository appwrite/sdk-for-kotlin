package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 * The Migrations service allows you to migrate third-party data to your Appwrite project.
 */
class Migrations(client: Client) : Service(client) {
    /**
     * List all migrations in the current project. This endpoint returns a list of all migrations including their status, progress, and any errors that occurred during the migration process.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: status, stage, source, destination, resources, resourceId, resourceInternalId, resourceType, parentResourceId, parentResourceInternalId, parentResourceType, destinationResourceId, destinationResourceInternalId, destinationResourceType, statusCounters, resourceData, errors
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.MigrationList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.MigrationList {
        val apiPath = "/migrations"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MigrationList = {
            io.appwrite.models.MigrationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MigrationList::class.java,
            converter,
        )
    }

    /**
     * Migrate data from another Appwrite project to your current project. This endpoint allows you to migrate resources like databases, collections, documents, users, and files from an existing Appwrite project.
     *
     * @param resources List of resources to migrate
     * @param endpoint Source Appwrite endpoint
     * @param projectId Source Project ID
     * @param apiKey Source API Key
     * @param onDuplicate Behavior when a row with an existing $id is encountered. "fail" (default): abort on first conflict. "skip": silently ignore. "overwrite": replace existing row.
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createAppwriteMigration(
        resources: List<io.appwrite.enums.AppwriteMigrationResource>,
        endpoint: String,
        projectId: String,
        apiKey: String,
        onDuplicate: io.appwrite.enums.OnDuplicate? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/appwrite"
        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "projectId" to projectId,
            "apiKey" to apiKey,
            "onDuplicate" to onDuplicate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Export documents to a CSV file from your Appwrite database. This endpoint allows you to export documents to a CSV file stored in a secure internal bucket. You'll receive an email with a download link when the export is complete.
     *
     * @param databaseId Database ID containing the source collection.
     * @param collectionId Collection ID to export documents from.
     * @param filename The name of the file to be created for the export, excluding the .csv extension.
     * @param columns List of attributes to export. If empty, all attributes will be exported. You can use the `*` wildcard to export all attributes from the collection.
     * @param queries Array of query strings generated using the Query class provided by the SDK to filter documents to export. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param delimiter The character that separates each column value. Default is comma.
     * @param enclosure The character that encloses each column value. Default is double quotes.
     * @param escape The escape character for the enclosure character. Default is double quotes.
     * @param header Whether to include the header row with column names. Default is true.
     * @param notify Set to true to receive an email when the export is complete. Default is true.
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCSVExport(
        databaseId: String,
        collectionId: String,
        filename: String,
        columns: List<String>? = null,
        queries: List<String>? = null,
        delimiter: String? = null,
        enclosure: String? = null,
        escape: String? = null,
        header: Boolean? = null,
        notify: Boolean? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/csv/exports"
        val apiParams = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "collectionId" to collectionId,
            "filename" to filename,
            "columns" to columns,
            "queries" to queries,
            "delimiter" to delimiter,
            "enclosure" to enclosure,
            "escape" to escape,
            "header" to header,
            "notify" to notify,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Import documents from a CSV file into your Appwrite database. This endpoint allows you to import documents from a CSV file uploaded to Appwrite Storage bucket.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @param databaseId Database ID containing the target collection.
     * @param collectionId Collection ID to import documents into.
     * @param internalFile Is the file stored in an internal bucket?
     * @param onDuplicate Behavior when a row with an existing $id is encountered. "fail" (default): abort on first conflict. "skip": silently ignore. "overwrite": replace existing row.
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCSVImport(
        bucketId: String,
        fileId: String,
        databaseId: String,
        collectionId: String,
        internalFile: Boolean? = null,
        onDuplicate: io.appwrite.enums.OnDuplicate? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/csv/imports"
        val apiParams = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "fileId" to fileId,
            "databaseId" to databaseId,
            "collectionId" to collectionId,
            "internalFile" to internalFile,
            "onDuplicate" to onDuplicate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Migrate data from a Firebase project to your Appwrite project. This endpoint allows you to migrate resources like authentication and other supported services from a Firebase project.
     *
     * @param resources List of resources to migrate
     * @param serviceAccount JSON of the Firebase service account credentials
     * @return [io.appwrite.models.Migration]
     */
    @Throws(AppwriteException::class)
    suspend fun createFirebaseMigration(
        resources: List<io.appwrite.enums.FirebaseMigrationResource>,
        serviceAccount: String,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/firebase"
        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "serviceAccount" to serviceAccount,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Export documents to a JSON file from your Appwrite database. This endpoint allows you to export documents to a JSON file stored in a secure internal bucket. You'll receive an email with a download link when the export is complete.
     *
     *
     * @param databaseId Database ID containing the source collection.
     * @param collectionId Collection ID to export documents from.
     * @param filename The name of the file to be created for the export, excluding the .json extension.
     * @param columns List of attributes to export. If empty, all attributes will be exported. You can use the `*` wildcard to export all attributes from the collection.
     * @param queries Array of query strings generated using the Query class provided by the SDK to filter documents to export. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param notify Set to true to receive an email when the export is complete. Default is true.
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createJSONExport(
        databaseId: String,
        collectionId: String,
        filename: String,
        columns: List<String>? = null,
        queries: List<String>? = null,
        notify: Boolean? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/json/exports"
        val apiParams = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "collectionId" to collectionId,
            "filename" to filename,
            "columns" to columns,
            "queries" to queries,
            "notify" to notify,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Import documents from a JSON file into your Appwrite database. This endpoint allows you to import documents from a JSON file uploaded to Appwrite Storage bucket.
     *
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @param databaseId Database ID containing the target collection.
     * @param collectionId Collection ID to import documents into.
     * @param internalFile Is the file stored in an internal bucket?
     * @param onDuplicate Behavior when a row with an existing $id is encountered. "fail" (default): abort on first conflict. "skip": silently ignore. "overwrite": replace existing row.
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createJSONImport(
        bucketId: String,
        fileId: String,
        databaseId: String,
        collectionId: String,
        internalFile: Boolean? = null,
        onDuplicate: io.appwrite.enums.OnDuplicate? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/json/imports"
        val apiParams = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "fileId" to fileId,
            "databaseId" to databaseId,
            "collectionId" to collectionId,
            "internalFile" to internalFile,
            "onDuplicate" to onDuplicate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Migrate data from an NHost project to your Appwrite project. This endpoint allows you to migrate resources like authentication, databases, and other supported services from an NHost project.
     *
     * @param resources List of resources to migrate
     * @param subdomain Source's Subdomain
     * @param region Source's Region
     * @param adminSecret Source's Admin Secret
     * @param database Source's Database Name
     * @param username Source's Database Username
     * @param password Source's Database Password
     * @param port Source's Database Port
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createNHostMigration(
        resources: List<io.appwrite.enums.NHostMigrationResource>,
        subdomain: String,
        region: String,
        adminSecret: String,
        database: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/nhost"
        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "subdomain" to subdomain,
            "region" to region,
            "adminSecret" to adminSecret,
            "database" to database,
            "username" to username,
            "password" to password,
            "port" to port,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Migrate data from a Supabase project to your Appwrite project. This endpoint allows you to migrate resources like authentication, databases, and other supported services from a Supabase project.
     *
     * @param resources List of resources to migrate
     * @param endpoint Source's Supabase Endpoint
     * @param apiKey Source's API Key
     * @param databaseHost Source's Database Host
     * @param username Source's Database Username
     * @param password Source's Database Password
     * @param port Source's Database Port
     * @return [io.appwrite.models.Migration]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSupabaseMigration(
        resources: List<io.appwrite.enums.SupabaseMigrationResource>,
        endpoint: String,
        apiKey: String,
        databaseHost: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/supabase"
        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "apiKey" to apiKey,
            "databaseHost" to databaseHost,
            "username" to username,
            "password" to password,
            "port" to port,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Get a migration by its unique ID. This endpoint returns detailed information about a specific migration including its current status, progress, and any errors that occurred during the migration process.
     *
     * @param migrationId Migration unique ID.
     * @return [io.appwrite.models.Migration]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        migrationId: String,
    ): io.appwrite.models.Migration {
        if (migrationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"migrationId\"")
        }
        val apiPath = ("/migrations/{migrationId}"
            .replace("{migrationId}", Client.encodePath(migrationId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Retry a failed migration. This endpoint allows you to retry a migration that has previously failed.
     *
     * @param migrationId Migration unique ID.
     * @return [io.appwrite.models.Migration]
     */
    @Throws(AppwriteException::class)
    suspend fun retry(
        migrationId: String,
    ): io.appwrite.models.Migration {
        if (migrationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"migrationId\"")
        }
        val apiPath = ("/migrations/{migrationId}"
            .replace("{migrationId}", Client.encodePath(migrationId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Migration = {
            io.appwrite.models.Migration.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Migration::class.java,
            converter,
        )
    }

    /**
     * Delete a migration by its unique ID. This endpoint allows you to remove a migration from your project's migration history.
     *
     * @param migrationId Migration ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        migrationId: String,
    ): Any {
        if (migrationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"migrationId\"")
        }
        val apiPath = ("/migrations/{migrationId}"
            .replace("{migrationId}", Client.encodePath(migrationId))
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
}
