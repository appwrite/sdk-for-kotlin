package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Organization service allows you to manage organization-level projects.
**/
class Organization(client: Client) : Service(client) {

    /**
     * Get the current organization.
     *
     * @return [io.appwrite.models.Organization<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> get(
        nestedType: Class<T>,
    ): io.appwrite.models.Organization<T> {
        val apiPath = ("/organization"
        )

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Organization<T> = {
            io.appwrite.models.Organization.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get the current organization.
     *
     * @return [io.appwrite.models.Organization<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ): io.appwrite.models.Organization<Map<String, Any>> = get(
        nestedType = classOf(),
    )

    /**
     * Update the current organization's name.
     *
     * @param name New organization name. Max length: 128 chars.
     * @return [io.appwrite.models.Organization<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> update(
        name: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Organization<T> {
        val apiPath = ("/organization"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Organization<T> = {
            io.appwrite.models.Organization.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the current organization's name.
     *
     * @param name New organization name. Max length: 128 chars.
     * @return [io.appwrite.models.Organization<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun update(
        name: String,
    ): io.appwrite.models.Organization<Map<String, Any>> = update(
        name,
        nestedType = classOf(),
    )

    /**
     * Delete the current organization. All projects that belong to the organization are deleted as well.
     *
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
    ): Any {
        val apiPath = ("/organization"
        )

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
        val apiPath = ("/organization/keys"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
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
     * @param scopes Key scopes list. Maximum of 200 scopes are allowed.
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
        val apiPath = ("/organization/keys"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "keyId" to keyId,
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
        val apiPath = ("/organization/keys/{keyId}"
            .replace("{keyId}", keyId)
        )

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
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
     * @param scopes Key scopes list. Maximum of 200 scopes are allowed.
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
        val apiPath = ("/organization/keys/{keyId}"
            .replace("{keyId}", keyId)
        )

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
        val apiPath = ("/organization/keys/{keyId}"
            .replace("{keyId}", keyId)
        )

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
     * Get a list of all memberships from the current organization.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, teamId, invited, joined, confirm, roles
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.MembershipList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMemberships(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.MembershipList {
        val apiPath = ("/organization/memberships"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MembershipList = {
            io.appwrite.models.MembershipList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MembershipList::class.java,
            converter,
        )
    }

    /**
     * Invite a new member to join the current organization. An email with a link to join the organization will be sent to the new member's email address. If member doesn't exist in the project it will be automatically created.
     *
     * @param roles Array of strings. Use this param to set the user roles in the organization. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 81 characters long.
     * @param email Email of the new organization member.
     * @param userId ID of the user to be added to the organization.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param url URL to redirect the user back to your app from the invitation email. This parameter is not required when an API key is supplied.
     * @param name Name of the new organization member. Max length: 128 chars.
     * @return [io.appwrite.models.Membership]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMembership(
        roles: List<String>,
        email: String? = null,
        userId: String? = null,
        phone: String? = null,
        url: String? = null,
        name: String? = null,
    ): io.appwrite.models.Membership {
        val apiPath = ("/organization/memberships"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "userId" to userId,
            "phone" to phone,
            "roles" to roles,
            "url" to url,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }

    /**
     * Get a membership from the current organization by its unique ID.
     *
     * @param membershipId Membership ID.
     * @return [io.appwrite.models.Membership]
     */
    @Throws(AppwriteException::class)
    suspend fun getMembership(
        membershipId: String,
    ): io.appwrite.models.Membership {
        val apiPath = ("/organization/memberships/{membershipId}"
            .replace("{membershipId}", membershipId)
        )

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }

    /**
     * Modify the roles of a member in the current organization.
     *
     * @param membershipId Membership ID.
     * @param roles An array of strings. Use this param to set the user's roles in the organization. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 81 characters long.
     * @return [io.appwrite.models.Membership]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMembership(
        membershipId: String,
        roles: List<String>,
    ): io.appwrite.models.Membership {
        val apiPath = ("/organization/memberships/{membershipId}"
            .replace("{membershipId}", membershipId)
        )

        val apiParams = mutableMapOf<String, Any?>(
            "roles" to roles,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }

    /**
     * Remove a member from the current organization. The member is removed whether they accepted the invitation or not; a pending invitation is revoked.
     *
     * @param membershipId Membership ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteMembership(
        membershipId: String,
    ): Any {
        val apiPath = ("/organization/memberships/{membershipId}"
            .replace("{membershipId}", membershipId)
        )

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
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, teamId, labels, search, accessedAt
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
        val apiPath = ("/organization/projects"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
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
        val apiPath = ("/organization/projects"
        )

        val apiParams = mutableMapOf<String, Any?>(
            "projectId" to projectId,
            "name" to name,
            "region" to region,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
        val apiPath = ("/organization/projects/{projectId}"
            .replace("{projectId}", projectId)
        )

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
        val apiPath = ("/organization/projects/{projectId}"
            .replace("{projectId}", projectId)
        )

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
        val apiPath = ("/organization/projects/{projectId}"
            .replace("{projectId}", projectId)
        )

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
