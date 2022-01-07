package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Users(client: Client) : Service(client) {

    /**
     * List Users
     *
     * Get a list of all the project's users. You can use the query params to
     * filter your results.
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of users to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the user used as the starting point for the query, excluding the user itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.UserList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.UserList {
        val path = "/users"
        val params = mapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.UserList = {
            io.appwrite.models.UserList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.UserList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create User
     *
     * Create a new user.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		userId: String,
		email: String,
		password: String,
		name: String? = null
	): io.appwrite.models.User {
        val path = "/users"
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Get User
     *
     * Get a user by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		userId: String
	): io.appwrite.models.User {
        val path = "/users/{userId}".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete User
     *
     * Delete a user by its unique ID.
     *
     * @param userId User ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		userId: String
	): Any {
        val path = "/users/{userId}".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Update Email
     *
     * Update the user email by its unique ID.
     *
     * @param userId User ID.
     * @param email User email.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
		userId: String,
		email: String
	): io.appwrite.models.User {
        val path = "/users/{userId}/email".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "email" to email
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Get User Logs
     *
     * Get the user activity logs list by its unique ID.
     *
     * @param userId User ID.
     * @param limit Maximum number of logs to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @return [io.appwrite.models.LogList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getLogs(
		userId: String,
		limit: Long? = null,
		offset: Long? = null
	): io.appwrite.models.LogList {
        val path = "/users/{userId}/logs".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LogList::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Name
     *
     * Update the user name by its unique ID.
     *
     * @param userId User ID.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateName(
		userId: String,
		name: String
	): io.appwrite.models.User {
        val path = "/users/{userId}/name".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Password
     *
     * Update the user password by its unique ID.
     *
     * @param userId User ID.
     * @param password New user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
		userId: String,
		password: String
	): io.appwrite.models.User {
        val path = "/users/{userId}/password".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "password" to password
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Get User Preferences
     *
     * Get the user preferences by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.Preferences]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getPrefs(
		userId: String
	): io.appwrite.models.Preferences {
        val path = "/users/{userId}/prefs".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Preferences = {
            io.appwrite.models.Preferences.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Preferences::class.java,
            convert = convert
        )
    }
    
    /**
     * Update User Preferences
     *
     * Update the user preferences by its unique ID. The object you pass is stored
     * as is, and replaces any previous value. The maximum allowed prefs size is
     * 64kB and throws error if exceeded.
     *
     * @param userId User ID.
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.Preferences]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
		userId: String,
		prefs: Any
	): io.appwrite.models.Preferences {
        val path = "/users/{userId}/prefs".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "prefs" to prefs
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Preferences = {
            io.appwrite.models.Preferences.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Preferences::class.java,
            convert = convert
        )
    }
    
    /**
     * Get User Sessions
     *
     * Get the user sessions list by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.SessionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getSessions(
		userId: String
	): io.appwrite.models.SessionList {
        val path = "/users/{userId}/sessions".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.SessionList = {
            io.appwrite.models.SessionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.SessionList::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete User Sessions
     *
     * Delete all user's sessions by using the user's unique ID.
     *
     * @param userId User ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSessions(
		userId: String
	): Any {
        val path = "/users/{userId}/sessions".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Delete User Session
     *
     * Delete a user sessions by its unique ID.
     *
     * @param userId User ID.
     * @param sessionId Session ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSession(
		userId: String,
		sessionId: String
	): Any {
        val path = "/users/{userId}/sessions/{sessionId}".replace("{userId}", userId).replace("{sessionId}", sessionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Update User Status
     *
     * Update the user status by its unique ID.
     *
     * @param userId User ID.
     * @param status User Status. To activate the user pass `true` and to block the user pass `false`.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateStatus(
		userId: String,
		status: Boolean
	): io.appwrite.models.User {
        val path = "/users/{userId}/status".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "status" to status
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Email Verification
     *
     * Update the user email verification status by its unique ID.
     *
     * @param userId User ID.
     * @param emailVerification User email verification status.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVerification(
		userId: String,
		emailVerification: Boolean
	): io.appwrite.models.User {
        val path = "/users/{userId}/verification".replace("{userId}", userId)
        val params = mapOf<String, Any?>(
            "emailVerification" to emailVerification
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            convert = convert
        )
    }
    
}