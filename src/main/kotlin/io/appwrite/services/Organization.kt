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
class Organization(client: Client) : Service(client) {

    /**
     * Get a list of all API keys from the current organization.
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
        val apiPath = "/organization/keys"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * Create a new organization API key.
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
        scopes: List<io.appwrite.enums.OrganizationKeyScopes>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/organization/keys"

        val apiParams = mutableMapOf<String, Any?>(
            "keyId" to keyId,
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * Get a key by its unique ID. This endpoint returns details about a specific API key in your organization including its scopes.
     *
     * @param keyId Key unique ID.
     * @return [io.appwrite.models.Key]
     */
    @Throws(AppwriteException::class)
    suspend fun getKey(
        keyId: String,
    ): io.appwrite.models.Key {
        val apiPath = "/organization/keys/{keyId}"
            .replace("{keyId}", keyId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * @param keyId Key unique ID.
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
        scopes: List<io.appwrite.enums.OrganizationKeyScopes>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/organization/keys/{keyId}"
            .replace("{keyId}", keyId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * @param keyId Key unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteKey(
        keyId: String,
    ): Any {
        val apiPath = "/organization/keys/{keyId}"
            .replace("{keyId}", keyId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * Get a list of all projects. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, teamId, labels, search
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.ProjectList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listProjects(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ProjectList {
        val apiPath = "/organization/projects"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
        )
        val converter: (Any) -> io.appwrite.models.ProjectList = {
            io.appwrite.models.ProjectList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProjectList::class.java,
            converter,
        )
    }

    /**
     * Create a new project.
     *
     * @param projectId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, and hyphen. Can't start with a special char. Max length is 36 chars.
     * @param name Project name. Max length: 128 chars.
     * @param region Project Region.
     * @return [io.appwrite.models.Project]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createProject(
        projectId: String,
        name: String,
        region: io.appwrite.enums.Region? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/organization/projects"

        val apiParams = mutableMapOf<String, Any?>(
            "projectId" to projectId,
            "name" to name,
            "region" to region,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Project = {
            io.appwrite.models.Project.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Project::class.java,
            converter,
        )
    }

    /**
     * Get a project.
     *
     * @param projectId Project unique ID.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun getProject(
        projectId: String,
    ): io.appwrite.models.Project {
        val apiPath = "/organization/projects/{projectId}"
            .replace("{projectId}", projectId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
        )
        val converter: (Any) -> io.appwrite.models.Project = {
            io.appwrite.models.Project.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Project::class.java,
            converter,
        )
    }

    /**
     * Update a project by its unique ID.
     *
     * @param projectId Project unique ID.
     * @param name Project name. Max length: 128 chars.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateProject(
        projectId: String,
        name: String,
    ): io.appwrite.models.Project {
        val apiPath = "/organization/projects/{projectId}"
            .replace("{projectId}", projectId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
     * Delete a project by its unique ID.
     *
     * @param projectId Project unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteProject(
        projectId: String,
    ): Any {
        val apiPath = "/organization/projects/{projectId}"
            .replace("{projectId}", projectId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
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
