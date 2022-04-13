package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Account(client: Client) : Service(client) {

    /**
     * Get Account
     *
     * Get currently logged in user data as JSON object.
     *
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(): io.appwrite.models.User {
        val path = "/account"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            converter,
        )
    }
    
    /**
     * Delete Account
     *
     * Delete a currently logged in user account. Behind the scene, the user
     * record is not deleted but permanently blocked from any access. This is done
     * to avoid deleted accounts being overtaken by new users with the same email
     * address. Any user-related resources like documents or storage files should
     * be deleted separately.
     *
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(): Any {
        val path = "/account"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
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
     * Update Account Email
     *
     * Update currently logged in user account email address. After changing user
     * address, the user confirmation status will get reset. A new confirmation
     * email is not sent automatically however you can use the send confirmation
     * email endpoint again to send the confirmation email. For security measures,
     * user password is required to complete this request.
     * This endpoint can also be used to convert an anonymous account to a normal
     * one, by passing an email address and a new password.
     * 
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
		email: String,
		password: String
	): io.appwrite.models.User {
        val path = "/account/email"
        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            converter,
        )
    }
    
    /**
     * Get Account Logs
     *
     * Get currently logged in user list of latest security activity logs. Each
     * log returns user IP address, location and date and time of log.
     *
     * @param limit Maximum number of logs to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @return [io.appwrite.models.LogList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getLogs(
		limit: Long? = null,
		offset: Long? = null
	): io.appwrite.models.LogList {
        val path = "/account/logs"
        val params = mutableMapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }
    
    /**
     * Update Account Name
     *
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateName(
		name: String
	): io.appwrite.models.User {
        val path = "/account/name"
        val params = mutableMapOf<String, Any?>(
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            converter,
        )
    }
    
    /**
     * Update Account Password
     *
     * Update currently logged in user password. For validation, user is required
     * to pass in the new password, and the old password. For users created with
     * OAuth and Team Invites, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
		password: String,
		oldPassword: String? = null
	): io.appwrite.models.User {
        val path = "/account/password"
        val params = mutableMapOf<String, Any?>(
            "password" to password,
            "oldPassword" to oldPassword
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            converter,
        )
    }
    
    /**
     * Get Account Preferences
     *
     * Get currently logged in user preferences as a key-value object.
     *
     * @return [io.appwrite.models.Preferences]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getPrefs(): io.appwrite.models.Preferences {
        val path = "/account/prefs"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Preferences = {
            io.appwrite.models.Preferences.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Preferences::class.java,
            converter,
        )
    }
    
    /**
     * Update Account Preferences
     *
     * Update currently logged in user account preferences. The object you pass is
     * stored as is, and replaces any previous value. The maximum allowed prefs
     * size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.User]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
		prefs: Any
	): io.appwrite.models.User {
        val path = "/account/prefs"
        val params = mutableMapOf<String, Any?>(
            "prefs" to prefs
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.User = {
            io.appwrite.models.User.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.User::class.java,
            converter,
        )
    }
    
    /**
     * Create Password Recovery
     *
     * Sends the user an email with a temporary secret key for password reset.
     * When the user clicks the confirmation link he is redirected back to your
     * app password reset URL with the secret key and email address values
     * attached to the URL query string. Use the query string params to submit a
     * request to the [PUT
     * /account/recovery](/docs/client/account#accountUpdateRecovery) endpoint to
     * complete the process. The verification link sent to the user's email
     * address is valid for 1 hour.
     *
     * @param email User email.
     * @param url URL to redirect the user back to your app from the recovery email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecovery(
		email: String,
		url: String
	): io.appwrite.models.Token {
        val path = "/account/recovery"
        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "url" to url
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }
    
    /**
     * Create Password Recovery (confirmation)
     *
     * Use this endpoint to complete the user account password reset. Both the
     * **userId** and **secret** arguments will be passed as query parameters to
     * the redirect URL you have provided when sending your request to the [POST
     * /account/recovery](/docs/client/account#accountCreateRecovery) endpoint.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     *
     * @param userId User ID.
     * @param secret Valid reset token.
     * @param password New user password. Must be at least 8 chars.
     * @param passwordAgain Repeat new user password. Must be at least 8 chars.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecovery(
		userId: String,
		secret: String,
		password: String,
		passwordAgain: String
	): io.appwrite.models.Token {
        val path = "/account/recovery"
        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "password" to password,
            "passwordAgain" to passwordAgain
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }
    
    /**
     * Get Account Sessions
     *
     * Get currently logged in user list of active sessions across different
     * devices.
     *
     * @return [io.appwrite.models.SessionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getSessions(): io.appwrite.models.SessionList {
        val path = "/account/sessions"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.SessionList = {
            io.appwrite.models.SessionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.SessionList::class.java,
            converter,
        )
    }
    
    /**
     * Delete All Account Sessions
     *
     * Delete all sessions from the user account and remove any sessions cookies
     * from the end client.
     *
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSessions(): Any {
        val path = "/account/sessions"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
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
     * Get Session By ID
     *
     * Use this endpoint to get a logged in user's session using a Session ID.
     * Inputting 'current' will return the current session being used.
     *
     * @param sessionId Session ID. Use the string &#039;current&#039; to get the current device session.
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getSession(
		sessionId: String
	): io.appwrite.models.Session {
        val path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }
    
    /**
     * Update Session (Refresh Tokens)
     *
     * @param sessionId Session ID. Use the string &#039;current&#039; to update the current device session.
     * @return [io.appwrite.models.Session]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSession(
		sessionId: String
	): io.appwrite.models.Session {
        val path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }
    
    /**
     * Delete Account Session
     *
     * Use this endpoint to log out the currently logged in user from all their
     * account sessions across all of their different devices. When using the
     * Session ID argument, only the unique session ID provided is deleted.
     * 
     *
     * @param sessionId Session ID. Use the string &#039;current&#039; to delete the current device session.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteSession(
		sessionId: String
	): Any {
        val path = "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
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
     * Create Email Verification
     *
     * Use this endpoint to send a verification message to your user email address
     * to confirm they are the valid owners of that address. Both the **userId**
     * and **secret** arguments will be passed as query parameters to the URL you
     * have provided to be attached to the verification email. The provided URL
     * should redirect the user back to your app and allow you to complete the
     * verification process by verifying both the **userId** and **secret**
     * parameters. Learn more about how to [complete the verification
     * process](/docs/client/account#accountUpdateVerification). The verification
     * link sent to the user's email address is valid for 7 days.
     * 
     * Please note that in order to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md),
     * the only valid redirect URLs are the ones from domains you have set when
     * adding your platforms in the console interface.
     * 
     *
     * @param url URL to redirect the user back to your app from the verification email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVerification(
		url: String
	): io.appwrite.models.Token {
        val path = "/account/verification"
        val params = mutableMapOf<String, Any?>(
            "url" to url
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }
    
    /**
     * Create Email Verification (confirmation)
     *
     * Use this endpoint to complete the user email verification process. Use both
     * the **userId** and **secret** parameters that were attached to your app URL
     * to verify the user email ownership. If confirmed this route will return a
     * 200 status code.
     *
     * @param userId User ID.
     * @param secret Valid verification token.
     * @return [io.appwrite.models.Token]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVerification(
		userId: String,
		secret: String
	): io.appwrite.models.Token {
        val path = "/account/verification"
        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }
    
}