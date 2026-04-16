package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Project service allows you to manage all the projects in your Appwrite server.
**/
class Project(client: Client) : Service(client) {

    /**
     * Get a list of all API keys from the current project.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: expire, accessedAt, name, scopes
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.KeyList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listKeys(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.KeyList {
        val apiPath = "/project/keys"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.KeyList = {
            io.appwrite.models.KeyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.KeyList::class.java,
            converter,
        )
    }

    /**
     * Create a new API key. It's recommended to have multiple API keys with strict scopes for separate functions within your project.
     *
     * @param keyId Key ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Key name. Max length: 128 chars.
     * @param scopes Key scopes list. Maximum of 100 scopes are allowed.
     * @param expire Expiration time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Use null for unlimited expiration.
     * @return [io.appwrite.models.Key]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createKey(
        keyId: String,
        name: String,
        scopes: List<io.appwrite.enums.Scopes>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/project/keys"

        val apiParams = mutableMapOf<String, Any?>(
            "keyId" to keyId,
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Key = {
            io.appwrite.models.Key.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Key::class.java,
            converter,
        )
    }

    /**
     * Get a key by its unique ID. 
     *
     * @param keyId Key ID.
     * @return [io.appwrite.models.Key]
     */
    @Throws(AppwriteException::class)
    suspend fun getKey(
        keyId: String,
    ): io.appwrite.models.Key {
        val apiPath = "/project/keys/{keyId}"
            .replace("{keyId}", keyId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Key = {
            io.appwrite.models.Key.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Key::class.java,
            converter,
        )
    }

    /**
     * Update a key by its unique ID. Use this endpoint to update the name, scopes, or expiration time of an API key.
     *
     * @param keyId Key ID.
     * @param name Key name. Max length: 128 chars.
     * @param scopes Key scopes list. Maximum of 100 scopes are allowed.
     * @param expire Expiration time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Use null for unlimited expiration.
     * @return [io.appwrite.models.Key]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateKey(
        keyId: String,
        name: String,
        scopes: List<io.appwrite.enums.Scopes>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/project/keys/{keyId}"
            .replace("{keyId}", keyId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Key = {
            io.appwrite.models.Key.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Key::class.java,
            converter,
        )
    }

    /**
     * Delete a key by its unique ID. Once deleted, the key can no longer be used to authenticate API calls.
     *
     * @param keyId Key ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteKey(
        keyId: String,
    ): Any {
        val apiPath = "/project/keys/{keyId}"
            .replace("{keyId}", keyId)

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
     * Update the project labels. Labels can be used to easily filter projects in an organization.
     *
     * @param labels Array of project labels. Replaces the previous labels. Maximum of 1000 labels are allowed, each up to 36 alphanumeric characters long.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateLabels(
        labels: List<String>,
    ): io.appwrite.models.Project {
        val apiPath = "/project/labels"

        val apiParams = mutableMapOf<String, Any?>(
            "labels" to labels,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Project = {
            io.appwrite.models.Project.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Project::class.java,
            converter,
        )
    }

    /**
     * Get a list of all platforms in the project. This endpoint returns an array of all platforms and their configurations.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: type, name, hostname, bundleIdentifier, applicationId, packageIdentifierName, packageName
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.PlatformList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listPlatforms(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.PlatformList {
        val apiPath = "/project/platforms"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.PlatformList = {
            io.appwrite.models.PlatformList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformList::class.java,
            converter,
        )
    }

    /**
     * Create a new Android platform for your project. Use this endpoint to register a new Android platform where your users will run your application which will interact with the Appwrite API.
     *
     * @param platformId Platform ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Platform name. Max length: 128 chars.
     * @param applicationId Android application ID. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformAndroid]
     */
    @Throws(AppwriteException::class)
    suspend fun createAndroidPlatform(
        platformId: String,
        name: String,
        applicationId: String,
    ): io.appwrite.models.PlatformAndroid {
        val apiPath = "/project/platforms/android"

        val apiParams = mutableMapOf<String, Any?>(
            "platformId" to platformId,
            "name" to name,
            "applicationId" to applicationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformAndroid = {
            io.appwrite.models.PlatformAndroid.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformAndroid::class.java,
            converter,
        )
    }

    /**
     * Update an Android platform by its unique ID. Use this endpoint to update the platform's name or application ID.
     *
     * @param platformId Platform ID.
     * @param name Platform name. Max length: 128 chars.
     * @param applicationId Android application ID. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformAndroid]
     */
    @Throws(AppwriteException::class)
    suspend fun updateAndroidPlatform(
        platformId: String,
        name: String,
        applicationId: String,
    ): io.appwrite.models.PlatformAndroid {
        val apiPath = "/project/platforms/android/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "applicationId" to applicationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformAndroid = {
            io.appwrite.models.PlatformAndroid.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformAndroid::class.java,
            converter,
        )
    }

    /**
     * Create a new Apple platform for your project. Use this endpoint to register a new Apple platform where your users will run your application which will interact with the Appwrite API.
     *
     * @param platformId Platform ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Platform name. Max length: 128 chars.
     * @param bundleIdentifier Apple bundle identifier. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformApple]
     */
    @Throws(AppwriteException::class)
    suspend fun createApplePlatform(
        platformId: String,
        name: String,
        bundleIdentifier: String,
    ): io.appwrite.models.PlatformApple {
        val apiPath = "/project/platforms/apple"

        val apiParams = mutableMapOf<String, Any?>(
            "platformId" to platformId,
            "name" to name,
            "bundleIdentifier" to bundleIdentifier,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformApple = {
            io.appwrite.models.PlatformApple.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformApple::class.java,
            converter,
        )
    }

    /**
     * Update an Apple platform by its unique ID. Use this endpoint to update the platform's name or bundle identifier.
     *
     * @param platformId Platform ID.
     * @param name Platform name. Max length: 128 chars.
     * @param bundleIdentifier Apple bundle identifier. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformApple]
     */
    @Throws(AppwriteException::class)
    suspend fun updateApplePlatform(
        platformId: String,
        name: String,
        bundleIdentifier: String,
    ): io.appwrite.models.PlatformApple {
        val apiPath = "/project/platforms/apple/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "bundleIdentifier" to bundleIdentifier,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformApple = {
            io.appwrite.models.PlatformApple.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformApple::class.java,
            converter,
        )
    }

    /**
     * Create a new Linux platform for your project. Use this endpoint to register a new Linux platform where your users will run your application which will interact with the Appwrite API.
     *
     * @param platformId Platform ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Platform name. Max length: 128 chars.
     * @param packageName Linux package name. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformLinux]
     */
    @Throws(AppwriteException::class)
    suspend fun createLinuxPlatform(
        platformId: String,
        name: String,
        packageName: String,
    ): io.appwrite.models.PlatformLinux {
        val apiPath = "/project/platforms/linux"

        val apiParams = mutableMapOf<String, Any?>(
            "platformId" to platformId,
            "name" to name,
            "packageName" to packageName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformLinux = {
            io.appwrite.models.PlatformLinux.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformLinux::class.java,
            converter,
        )
    }

    /**
     * Update a Linux platform by its unique ID. Use this endpoint to update the platform's name or package name.
     *
     * @param platformId Platform ID.
     * @param name Platform name. Max length: 128 chars.
     * @param packageName Linux package name. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformLinux]
     */
    @Throws(AppwriteException::class)
    suspend fun updateLinuxPlatform(
        platformId: String,
        name: String,
        packageName: String,
    ): io.appwrite.models.PlatformLinux {
        val apiPath = "/project/platforms/linux/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "packageName" to packageName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformLinux = {
            io.appwrite.models.PlatformLinux.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformLinux::class.java,
            converter,
        )
    }

    /**
     * Create a new web platform for your project. Use this endpoint to register a new platform where your users will run your application which will interact with the Appwrite API.
     *
     * @param platformId Platform ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Platform name. Max length: 128 chars.
     * @param hostname Platform web hostname. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformWeb]
     */
    @Throws(AppwriteException::class)
    suspend fun createWebPlatform(
        platformId: String,
        name: String,
        hostname: String,
    ): io.appwrite.models.PlatformWeb {
        val apiPath = "/project/platforms/web"

        val apiParams = mutableMapOf<String, Any?>(
            "platformId" to platformId,
            "name" to name,
            "hostname" to hostname,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformWeb = {
            io.appwrite.models.PlatformWeb.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformWeb::class.java,
            converter,
        )
    }

    /**
     * Update a web platform by its unique ID. Use this endpoint to update the platform's name or hostname.
     *
     * @param platformId Platform ID.
     * @param name Platform name. Max length: 128 chars.
     * @param hostname Platform web hostname. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformWeb]
     */
    @Throws(AppwriteException::class)
    suspend fun updateWebPlatform(
        platformId: String,
        name: String,
        hostname: String,
    ): io.appwrite.models.PlatformWeb {
        val apiPath = "/project/platforms/web/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "hostname" to hostname,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformWeb = {
            io.appwrite.models.PlatformWeb.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformWeb::class.java,
            converter,
        )
    }

    /**
     * Create a new Windows platform for your project. Use this endpoint to register a new Windows platform where your users will run your application which will interact with the Appwrite API.
     *
     * @param platformId Platform ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Platform name. Max length: 128 chars.
     * @param packageIdentifierName Windows package identifier name. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformWindows]
     */
    @Throws(AppwriteException::class)
    suspend fun createWindowsPlatform(
        platformId: String,
        name: String,
        packageIdentifierName: String,
    ): io.appwrite.models.PlatformWindows {
        val apiPath = "/project/platforms/windows"

        val apiParams = mutableMapOf<String, Any?>(
            "platformId" to platformId,
            "name" to name,
            "packageIdentifierName" to packageIdentifierName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformWindows = {
            io.appwrite.models.PlatformWindows.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformWindows::class.java,
            converter,
        )
    }

    /**
     * Update a Windows platform by its unique ID. Use this endpoint to update the platform's name or package identifier name.
     *
     * @param platformId Platform ID.
     * @param name Platform name. Max length: 128 chars.
     * @param packageIdentifierName Windows package identifier name. Max length: 256 chars.
     * @return [io.appwrite.models.PlatformWindows]
     */
    @Throws(AppwriteException::class)
    suspend fun updateWindowsPlatform(
        platformId: String,
        name: String,
        packageIdentifierName: String,
    ): io.appwrite.models.PlatformWindows {
        val apiPath = "/project/platforms/windows/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "packageIdentifierName" to packageIdentifierName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.PlatformWindows = {
            io.appwrite.models.PlatformWindows.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PlatformWindows::class.java,
            converter,
        )
    }

    /**
     * Get a platform by its unique ID. This endpoint returns the platform's details, including its name, type, and key configurations.
     *
     * @param platformId Platform ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun getPlatform(
        platformId: String,
    ): Any {
        val apiPath = "/project/platforms/{platformId}"
            .replace("{platformId}", platformId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> Any = {
            io.appwrite.models.PlatformWeb.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
            converter,
        )
    }

    /**
     * Delete a platform by its unique ID. This endpoint removes the platform and all its configurations from the project.
     *
     * @param platformId Platform ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deletePlatform(
        platformId: String,
    ): Any {
        val apiPath = "/project/platforms/{platformId}"
            .replace("{platformId}", platformId)

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
     * Update the status of a specific protocol. Use this endpoint to enable or disable a protocol in your project. 
     *
     * @param protocolId Protocol name. Can be one of: rest, graphql, websocket
     * @param enabled Protocol status.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateProtocolStatus(
        protocolId: io.appwrite.enums.ProtocolId,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/protocols/{protocolId}/status"
            .replace("{protocolId}", protocolId.value)

        val apiParams = mutableMapOf<String, Any?>(
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Project = {
            io.appwrite.models.Project.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Project::class.java,
            converter,
        )
    }

    /**
     * Update the status of a specific service. Use this endpoint to enable or disable a service in your project. 
     *
     * @param serviceId Service name. Can be one of: account, avatars, databases, tablesdb, locale, health, project, storage, teams, users, vcs, sites, functions, proxy, graphql, migrations, messaging
     * @param enabled Service status.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateServiceStatus(
        serviceId: io.appwrite.enums.ServiceId,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/services/{serviceId}/status"
            .replace("{serviceId}", serviceId.value)

        val apiParams = mutableMapOf<String, Any?>(
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Project = {
            io.appwrite.models.Project.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Project::class.java,
            converter,
        )
    }

    /**
     * Get a list of all project environment variables.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, resourceType, resourceId, secret
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.VariableList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listVariables(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.VariableList {
        val apiPath = "/project/variables"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.VariableList = {
            io.appwrite.models.VariableList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VariableList::class.java,
            converter,
        )
    }

    /**
     * Create a new project environment variable. These variables can be accessed by all functions and sites in the project.
     *
     * @param variableId Variable ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVariable(
        variableId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables"

        val apiParams = mutableMapOf<String, Any?>(
            "variableId" to variableId,
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Get a variable by its unique ID. 
     *
     * @param variableId Variable ID.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun getVariable(
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Update variable by its unique ID.
     *
     * @param variableId Variable ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
        variableId: String,
        key: String? = null,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Delete a variable by its unique ID. 
     *
     * @param variableId Variable ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
        variableId: String,
    ): Any {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

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

}
