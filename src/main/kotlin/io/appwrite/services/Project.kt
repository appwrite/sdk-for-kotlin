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
     * Get a project.
     *
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ): io.appwrite.models.Project {
        val apiPath = "/project"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * Delete a project.
     *
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
    ): Any {
        val apiPath = "/project"

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
     * Update properties of a specific auth method. Use this endpoint to enable or disable a method in your project. 
     *
     * @param methodId Auth Method ID. Possible values: email-password,magic-url,email-otp,anonymous,invites,jwt,phone
     * @param enabled Auth method status.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateAuthMethod(
        methodId: io.appwrite.enums.ProjectAuthMethodId,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/auth-methods/{methodId}"
            .replace("{methodId}", methodId.value)

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
     * You can also create an ephemeral API key if you need a short-lived key instead.
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
        scopes: List<io.appwrite.enums.ProjectKeyScopes>,
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
     * Create a new ephemeral API key. It's recommended to have multiple API keys with strict scopes for separate functions within your project.
     * 
     * You can also create a standard API key if you need a longer-lived key instead.
     *
     * @param scopes Key scopes list. Maximum of 100 scopes are allowed.
     * @param duration Time in seconds before ephemeral key expires. Maximum duration is 3600 seconds.
     * @return [io.appwrite.models.EphemeralKey]
     */
    @Throws(AppwriteException::class)
    suspend fun createEphemeralKey(
        scopes: List<io.appwrite.enums.ProjectKeyScopes>,
        duration: Long,
    ): io.appwrite.models.EphemeralKey {
        val apiPath = "/project/keys/ephemeral"

        val apiParams = mutableMapOf<String, Any?>(
            "scopes" to scopes,
            "duration" to duration,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.EphemeralKey = {
            io.appwrite.models.EphemeralKey.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EphemeralKey::class.java,
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
        scopes: List<io.appwrite.enums.ProjectKeyScopes>,
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
     * Get a list of all mock phones in the project. This endpoint returns an array of all mock phones and their OTPs.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.MockNumberList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMockPhones(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.MockNumberList {
        val apiPath = "/project/mock-phones"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MockNumberList = {
            io.appwrite.models.MockNumberList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MockNumberList::class.java,
            converter,
        )
    }

    /**
     * Create a new mock phone for your project. Use this endpoint to register a mock phone number and its sign-in OTP for your testers.
     *
     * @param number Phone number to associate with the mock phone. Must be a valid E.164 formatted phone number.
     * @param otp One-time password (OTP) to associate with the mock phone. Must be a 6-digit numeric code.
     * @return [io.appwrite.models.MockNumber]
     */
    @Throws(AppwriteException::class)
    suspend fun createMockPhone(
        number: String,
        otp: String,
    ): io.appwrite.models.MockNumber {
        val apiPath = "/project/mock-phones"

        val apiParams = mutableMapOf<String, Any?>(
            "number" to number,
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MockNumber = {
            io.appwrite.models.MockNumber.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MockNumber::class.java,
            converter,
        )
    }

    /**
     * Get a mock phone by its unique number. This endpoint returns the mock phone's OTP.
     *
     * @param number Phone number associated with the mock phone. Must be a valid E.164 formatted phone number.
     * @return [io.appwrite.models.MockNumber]
     */
    @Throws(AppwriteException::class)
    suspend fun getMockPhone(
        number: String,
    ): io.appwrite.models.MockNumber {
        val apiPath = "/project/mock-phones/{number}"
            .replace("{number}", number)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MockNumber = {
            io.appwrite.models.MockNumber.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MockNumber::class.java,
            converter,
        )
    }

    /**
     * Update a mock phone by its unique number. Use this endpoint to update the mock phone's OTP.
     *
     * @param number Phone number associated with the mock phone. Must be a valid E.164 formatted phone number.
     * @param otp One-time password (OTP) to associate with the mock phone. Must be a 6-digit numeric code.
     * @return [io.appwrite.models.MockNumber]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMockPhone(
        number: String,
        otp: String,
    ): io.appwrite.models.MockNumber {
        val apiPath = "/project/mock-phones/{number}"
            .replace("{number}", number)

        val apiParams = mutableMapOf<String, Any?>(
            "otp" to otp,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MockNumber = {
            io.appwrite.models.MockNumber.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MockNumber::class.java,
            converter,
        )
    }

    /**
     * Delete a mock phone by its unique number. This endpoint removes the mock phone and its OTP configuration from the project.
     *
     * @param number Phone number associated with the mock phone. Must be a valid E.164 formatted phone number.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteMockPhone(
        number: String,
    ): Any {
        val apiPath = "/project/mock-phones/{number}"
            .replace("{number}", number)

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
     * Get a list of all OAuth2 providers supported by the server, along with the project's configuration for each. Credential fields are write-only and always returned empty.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.OAuth2ProviderList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listOAuth2Providers(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.OAuth2ProviderList {
        val apiPath = "/project/oauth2"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.OAuth2ProviderList = {
            io.appwrite.models.OAuth2ProviderList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2ProviderList::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Amazon configuration.
     *
     * @param clientId 'Client ID' of Amazon OAuth2 app. For example: amzn1.application-oa2-client.87400c00000000000000000000063d5b2
     * @param clientSecret 'Client Secret' of Amazon OAuth2 app. For example: 79ffe4000000000000000000000000000000000000000000000000000002de55
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Amazon]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Amazon(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Amazon {
        val apiPath = "/project/oauth2/amazon"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Amazon = {
            io.appwrite.models.OAuth2Amazon.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Amazon::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Apple configuration.
     *
     * @param serviceId 'Service ID' of Apple OAuth2 app. For example: ip.appwrite.app.web
     * @param keyId 'Key ID' of Apple OAuth2 app. For example: P4000000N8
     * @param teamId 'Team ID' of Apple OAuth2 app. For example: D4000000R6
     * @param p8File Contents of the Apple OAuth2 app .p8 private key file. The secret key wrapped by the PEM markers is 200 characters long. For example: -----BEGIN PRIVATE KEY-----MIGTAg...jy2Xbna-----END PRIVATE KEY-----
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Apple]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Apple(
        serviceId: String? = null,
        keyId: String? = null,
        teamId: String? = null,
        p8File: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Apple {
        val apiPath = "/project/oauth2/apple"

        val apiParams = mutableMapOf<String, Any?>(
            "serviceId" to serviceId,
            "keyId" to keyId,
            "teamId" to teamId,
            "p8File" to p8File,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Apple = {
            io.appwrite.models.OAuth2Apple.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Apple::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Auth0 configuration.
     *
     * @param clientId 'Client ID' of Auth0 OAuth2 app. For example: OaOkIA000000000000000000005KLSYq
     * @param clientSecret 'Client Secret' of Auth0 OAuth2 app. For example: zXz0000-00000000000000000000000000000-00000000000000000000PJafnF
     * @param endpoint Domain of Auth0 instance. For example: example.us.auth0.com
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Auth0]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Auth0(
        clientId: String? = null,
        clientSecret: String? = null,
        endpoint: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Auth0 {
        val apiPath = "/project/oauth2/auth0"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "endpoint" to endpoint,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Auth0 = {
            io.appwrite.models.OAuth2Auth0.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Auth0::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Authentik configuration.
     *
     * @param clientId 'Client ID' of Authentik OAuth2 app. For example: dTKOPa0000000000000000000000000000e7G8hv
     * @param clientSecret 'Client Secret' of Authentik OAuth2 app. For example: ntQadq000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000Hp5WK
     * @param endpoint Domain of Authentik instance. For example: example.authentik.com
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Authentik]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Authentik(
        clientId: String? = null,
        clientSecret: String? = null,
        endpoint: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Authentik {
        val apiPath = "/project/oauth2/authentik"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "endpoint" to endpoint,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Authentik = {
            io.appwrite.models.OAuth2Authentik.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Authentik::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Autodesk configuration.
     *
     * @param clientId 'Client ID' of Autodesk OAuth2 app. For example: 5zw90v00000000000000000000kVYXN7
     * @param clientSecret 'Client Secret' of Autodesk OAuth2 app. For example: 7I000000000000MW
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Autodesk]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Autodesk(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Autodesk {
        val apiPath = "/project/oauth2/autodesk"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Autodesk = {
            io.appwrite.models.OAuth2Autodesk.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Autodesk::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Bitbucket configuration.
     *
     * @param key 'Key' of Bitbucket OAuth2 app. For example: Knt70000000000ByRc
     * @param secret 'Secret' of Bitbucket OAuth2 app. For example: NMfLZJ00000000000000000000TLQdDx
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Bitbucket]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Bitbucket(
        key: String? = null,
        secret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Bitbucket {
        val apiPath = "/project/oauth2/bitbucket"

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "secret" to secret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Bitbucket = {
            io.appwrite.models.OAuth2Bitbucket.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Bitbucket::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Bitly configuration.
     *
     * @param clientId 'Client ID' of Bitly OAuth2 app. For example: d95151000000000000000000000000000067af9b
     * @param clientSecret 'Client Secret' of Bitly OAuth2 app. For example: a13e250000000000000000000000000000d73095
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Bitly]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Bitly(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Bitly {
        val apiPath = "/project/oauth2/bitly"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Bitly = {
            io.appwrite.models.OAuth2Bitly.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Bitly::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Box configuration.
     *
     * @param clientId 'Client ID' of Box OAuth2 app. For example: deglcs00000000000000000000x2og6y
     * @param clientSecret 'Client Secret' of Box OAuth2 app. For example: OKM1f100000000000000000000eshEif
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Box]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Box(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Box {
        val apiPath = "/project/oauth2/box"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Box = {
            io.appwrite.models.OAuth2Box.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Box::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Dailymotion configuration.
     *
     * @param apiKey 'API Key' of Dailymotion OAuth2 app. For example: 07a9000000000000067f
     * @param apiSecret 'API Secret' of Dailymotion OAuth2 app. For example: a399a90000000000000000000000000000d90639
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Dailymotion]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Dailymotion(
        apiKey: String? = null,
        apiSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Dailymotion {
        val apiPath = "/project/oauth2/dailymotion"

        val apiParams = mutableMapOf<String, Any?>(
            "apiKey" to apiKey,
            "apiSecret" to apiSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Dailymotion = {
            io.appwrite.models.OAuth2Dailymotion.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Dailymotion::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Discord configuration.
     *
     * @param clientId 'Client ID' of Discord OAuth2 app. For example: 950722000000343754
     * @param clientSecret 'Client Secret' of Discord OAuth2 app. For example: YmPXnM000000000000000000002zFg5D
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Discord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Discord(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Discord {
        val apiPath = "/project/oauth2/discord"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Discord = {
            io.appwrite.models.OAuth2Discord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Discord::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Disqus configuration.
     *
     * @param publicKey 'Public Key, also known as API Key' of Disqus OAuth2 app. For example: cgegH70000000000000000000000000000000000000000000000000000Hr1nYX
     * @param secretKey 'Secret Key, also known as API Secret' of Disqus OAuth2 app. For example: W7Bykj00000000000000000000000000000000000000000000000000003o43w9
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Disqus]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Disqus(
        publicKey: String? = null,
        secretKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Disqus {
        val apiPath = "/project/oauth2/disqus"

        val apiParams = mutableMapOf<String, Any?>(
            "publicKey" to publicKey,
            "secretKey" to secretKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Disqus = {
            io.appwrite.models.OAuth2Disqus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Disqus::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Dropbox configuration.
     *
     * @param appKey 'App Key' of Dropbox OAuth2 app. For example: jl000000000009t
     * @param appSecret 'App Secret' of Dropbox OAuth2 app. For example: g200000000000vw
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Dropbox]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Dropbox(
        appKey: String? = null,
        appSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Dropbox {
        val apiPath = "/project/oauth2/dropbox"

        val apiParams = mutableMapOf<String, Any?>(
            "appKey" to appKey,
            "appSecret" to appSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Dropbox = {
            io.appwrite.models.OAuth2Dropbox.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Dropbox::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Etsy configuration.
     *
     * @param keyString 'Keystring' of Etsy OAuth2 app. For example: nsgzxh0000000000008j85a2
     * @param sharedSecret 'Shared Secret' of Etsy OAuth2 app. For example: tp000000ru
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Etsy]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Etsy(
        keyString: String? = null,
        sharedSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Etsy {
        val apiPath = "/project/oauth2/etsy"

        val apiParams = mutableMapOf<String, Any?>(
            "keyString" to keyString,
            "sharedSecret" to sharedSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Etsy = {
            io.appwrite.models.OAuth2Etsy.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Etsy::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Facebook configuration.
     *
     * @param appId 'App ID' of Facebook OAuth2 app. For example: 260600000007694
     * @param appSecret 'App Secret' of Facebook OAuth2 app. For example: 2d0b2800000000000000000000d38af4
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Facebook]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Facebook(
        appId: String? = null,
        appSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Facebook {
        val apiPath = "/project/oauth2/facebook"

        val apiParams = mutableMapOf<String, Any?>(
            "appId" to appId,
            "appSecret" to appSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Facebook = {
            io.appwrite.models.OAuth2Facebook.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Facebook::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Figma configuration.
     *
     * @param clientId 'Client ID' of Figma OAuth2 app. For example: byay5H0000000000VtiI40
     * @param clientSecret 'Client Secret' of Figma OAuth2 app. For example: yEpOYn0000000000000000004iIsU5
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Figma]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Figma(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Figma {
        val apiPath = "/project/oauth2/figma"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Figma = {
            io.appwrite.models.OAuth2Figma.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Figma::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 FusionAuth configuration.
     *
     * @param clientId 'Client ID' of FusionAuth OAuth2 app. For example: b2222c00-0000-0000-0000-000000862097
     * @param clientSecret 'Client Secret' of FusionAuth OAuth2 app. For example: Jx4s0C0000000000000000000000000000000wGqLsc
     * @param endpoint Domain of FusionAuth instance. For example: example.fusionauth.io
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2FusionAuth]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2FusionAuth(
        clientId: String? = null,
        clientSecret: String? = null,
        endpoint: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2FusionAuth {
        val apiPath = "/project/oauth2/fusionauth"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "endpoint" to endpoint,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2FusionAuth = {
            io.appwrite.models.OAuth2FusionAuth.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2FusionAuth::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 GitHub configuration.
     *
     * @param clientId 'OAuth2 app Client ID, or App ID' of GitHub OAuth2 app. For example: e4d87900000000540733. Example of wrong value: 370006
     * @param clientSecret 'Client Secret' of GitHub OAuth2 app. For example: 5e07c00000000000000000000000000000198bcc
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Github]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2GitHub(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Github {
        val apiPath = "/project/oauth2/github"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Github = {
            io.appwrite.models.OAuth2Github.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Github::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Gitlab configuration.
     *
     * @param applicationId 'Application ID' of Gitlab OAuth2 app. For example: d41ffe0000000000000000000000000000000000000000000000000000d5e252
     * @param secret 'Secret' of Gitlab OAuth2 app. For example: gloas-838cfa0000000000000000000000000000000000000000000000000000ecbb38
     * @param endpoint Endpoint URL of self-hosted GitLab instance. For example: https://gitlab.com
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Gitlab]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Gitlab(
        applicationId: String? = null,
        secret: String? = null,
        endpoint: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Gitlab {
        val apiPath = "/project/oauth2/gitlab"

        val apiParams = mutableMapOf<String, Any?>(
            "applicationId" to applicationId,
            "secret" to secret,
            "endpoint" to endpoint,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Gitlab = {
            io.appwrite.models.OAuth2Gitlab.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Gitlab::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Google configuration.
     *
     * @param clientId 'Client ID' of Google OAuth2 app. For example: 120000000095-92ifjb00000000000000000000g7ijfb.apps.googleusercontent.com
     * @param clientSecret 'Client Secret' of Google OAuth2 app. For example: example-google-client-secret
     * @param prompt Array of Google OAuth2 prompt values. If "none" is included, it must be the only element. "none" means: don't display any authentication or consent screens. Must not be specified with other values. "consent" means: prompt the user for consent. "select_account" means: prompt the user to select an account.
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Google]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Google(
        clientId: String? = null,
        clientSecret: String? = null,
        prompt: List<io.appwrite.enums.ProjectOAuth2GooglePrompt>? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Google {
        val apiPath = "/project/oauth2/google"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "prompt" to prompt,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Google = {
            io.appwrite.models.OAuth2Google.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Google::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Keycloak configuration.
     *
     * @param clientId 'Client ID' of Keycloak OAuth2 app. For example: appwrite-o0000000st-app
     * @param clientSecret 'Client Secret' of Keycloak OAuth2 app. For example: jdjrJd00000000000000000000HUsaZO
     * @param endpoint Domain of Keycloak instance. For example: keycloak.example.com
     * @param realmName Keycloak realm name. For example: appwrite-realm
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Keycloak]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Keycloak(
        clientId: String? = null,
        clientSecret: String? = null,
        endpoint: String? = null,
        realmName: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Keycloak {
        val apiPath = "/project/oauth2/keycloak"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "endpoint" to endpoint,
            "realmName" to realmName,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Keycloak = {
            io.appwrite.models.OAuth2Keycloak.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Keycloak::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Kick configuration.
     *
     * @param clientId 'Client ID' of Kick OAuth2 app. For example: 01KQ7C00000000000001MFHS32
     * @param clientSecret 'Client Secret' of Kick OAuth2 app. For example: 34ac5600000000000000000000000000000000000000000000000000e830c8b
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Kick]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Kick(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Kick {
        val apiPath = "/project/oauth2/kick"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Kick = {
            io.appwrite.models.OAuth2Kick.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Kick::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Linkedin configuration.
     *
     * @param clientId 'Client ID' of Linkedin OAuth2 app. For example: 770000000000dv
     * @param primaryClientSecret 'Primary Client Secret or Secondary Client Secret' of Linkedin OAuth2 app. For example: example-linkedin-client-secret
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Linkedin]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Linkedin(
        clientId: String? = null,
        primaryClientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Linkedin {
        val apiPath = "/project/oauth2/linkedin"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "primaryClientSecret" to primaryClientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Linkedin = {
            io.appwrite.models.OAuth2Linkedin.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Linkedin::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Microsoft configuration.
     *
     * @param applicationId 'Entra ID Application ID, also known as Client ID' of Microsoft OAuth2 app. For example: 00001111-aaaa-2222-bbbb-3333cccc4444
     * @param applicationSecret 'Entra ID Application Secret, also known as Client Secret' of Microsoft OAuth2 app. For example: A1bC2dE3fH4iJ5kL6mN7oP8qR9sT0u
     * @param tenant Microsoft Entra ID tenant identifier. Use 'common', 'organizations', 'consumers' or a specific tenant ID. For example: common
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Microsoft]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Microsoft(
        applicationId: String? = null,
        applicationSecret: String? = null,
        tenant: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Microsoft {
        val apiPath = "/project/oauth2/microsoft"

        val apiParams = mutableMapOf<String, Any?>(
            "applicationId" to applicationId,
            "applicationSecret" to applicationSecret,
            "tenant" to tenant,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Microsoft = {
            io.appwrite.models.OAuth2Microsoft.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Microsoft::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Notion configuration.
     *
     * @param oauthClientId 'OAuth Client ID' of Notion OAuth2 app. For example: 341d8700-0000-0000-0000-000000446ee3
     * @param oauthClientSecret 'OAuth Client Secret' of Notion OAuth2 app. For example: secret_dLUr4b000000000000000000000000000000lFHAa9
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Notion]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Notion(
        oauthClientId: String? = null,
        oauthClientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Notion {
        val apiPath = "/project/oauth2/notion"

        val apiParams = mutableMapOf<String, Any?>(
            "oauthClientId" to oauthClientId,
            "oauthClientSecret" to oauthClientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Notion = {
            io.appwrite.models.OAuth2Notion.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Notion::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Oidc configuration.
     *
     * @param clientId 'Client ID' of Oidc OAuth2 app. For example: qibI2x0000000000000000000000000006L2YFoG
     * @param clientSecret 'Client Secret' of Oidc OAuth2 app. For example: Ah68ed000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003qpcHV
     * @param wellKnownURL OpenID Connect well-known configuration URL. When provided, authorization, token, and user info endpoints can be discovered automatically. For example: https://myoauth.com/.well-known/openid-configuration
     * @param authorizationURL OpenID Connect authorization endpoint URL. Required when wellKnownURL is not provided. For example: https://myoauth.com/oauth2/authorize
     * @param tokenURL OpenID Connect token endpoint URL. Required when wellKnownURL is not provided. For example: https://myoauth.com/oauth2/token
     * @param userInfoURL OpenID Connect user info endpoint URL. Required when wellKnownURL is not provided. For example: https://myoauth.com/oauth2/userinfo
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Oidc]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Oidc(
        clientId: String? = null,
        clientSecret: String? = null,
        wellKnownURL: String? = null,
        authorizationURL: String? = null,
        tokenURL: String? = null,
        userInfoURL: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Oidc {
        val apiPath = "/project/oauth2/oidc"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "wellKnownURL" to wellKnownURL,
            "authorizationURL" to authorizationURL,
            "tokenURL" to tokenURL,
            "userInfoURL" to userInfoURL,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Oidc = {
            io.appwrite.models.OAuth2Oidc.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Oidc::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Okta configuration.
     *
     * @param clientId 'Client ID' of Okta OAuth2 app. For example: 0oa00000000000000698
     * @param clientSecret 'Client Secret' of Okta OAuth2 app. For example: Kiq0000000000000000000000000000000000000-00000000000H2L5-3SJ-vRV
     * @param domain Okta company domain. Required when enabling the provider. For example: trial-6400025.okta.com. Example of wrong value: trial-6400025-admin.okta.com, or https://trial-6400025.okta.com/
     * @param authorizationServerId Custom Authorization Servers. Optional, can be left empty or unconfigured. For example: aus000000000000000h7z
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Okta]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Okta(
        clientId: String? = null,
        clientSecret: String? = null,
        domain: String? = null,
        authorizationServerId: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Okta {
        val apiPath = "/project/oauth2/okta"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "domain" to domain,
            "authorizationServerId" to authorizationServerId,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Okta = {
            io.appwrite.models.OAuth2Okta.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Okta::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Paypal configuration.
     *
     * @param clientId 'Client ID' of Paypal OAuth2 app. For example: AdhIEG7-000000000000-0000000000000000000000000000000-0000000000000000000000-2pyB
     * @param secretKey 'Secret Key 1 or Secret Key 2' of Paypal OAuth2 app. For example: EH8KCXtew--000000000000000000000000000000000000000_C-1_5UP_000000000000000CB7KDp
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Paypal]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Paypal(
        clientId: String? = null,
        secretKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Paypal {
        val apiPath = "/project/oauth2/paypal"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "secretKey" to secretKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Paypal = {
            io.appwrite.models.OAuth2Paypal.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Paypal::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 PaypalSandbox configuration.
     *
     * @param clientId 'Client ID' of PaypalSandbox OAuth2 app. For example: AdhIEG7-000000000000-0000000000000000000000000000000-0000000000000000000000-2pyB
     * @param secretKey 'Secret Key 1 or Secret Key 2' of PaypalSandbox OAuth2 app. For example: EH8KCXtew--000000000000000000000000000000000000000_C-1_5UP_000000000000000CB7KDp
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Paypal]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2PaypalSandbox(
        clientId: String? = null,
        secretKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Paypal {
        val apiPath = "/project/oauth2/paypalSandbox"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "secretKey" to secretKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Paypal = {
            io.appwrite.models.OAuth2Paypal.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Paypal::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Podio configuration.
     *
     * @param clientId 'Client ID' of Podio OAuth2 app. For example: appwrite-o0000000st-app
     * @param clientSecret 'Client Secret' of Podio OAuth2 app. For example: Rn247T0000000000000000000000000000000000000000000000000000W2zWTN
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Podio]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Podio(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Podio {
        val apiPath = "/project/oauth2/podio"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Podio = {
            io.appwrite.models.OAuth2Podio.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Podio::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Salesforce configuration.
     *
     * @param customerKey 'Consumer Key' of Salesforce OAuth2 app. For example: 3MVG9I0000000000000000000000000000000000000000000000000000000000000000000000000C5Aejq
     * @param customerSecret 'Consumer Secret' of Salesforce OAuth2 app. For example: 3w000000000000e2
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Salesforce]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Salesforce(
        customerKey: String? = null,
        customerSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Salesforce {
        val apiPath = "/project/oauth2/salesforce"

        val apiParams = mutableMapOf<String, Any?>(
            "customerKey" to customerKey,
            "customerSecret" to customerSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Salesforce = {
            io.appwrite.models.OAuth2Salesforce.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Salesforce::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Slack configuration.
     *
     * @param clientId 'Client ID' of Slack OAuth2 app. For example: 23000000089.15000000000023
     * @param clientSecret 'Client Secret' of Slack OAuth2 app. For example: 81656000000000000000000000f3d2fd
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Slack]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Slack(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Slack {
        val apiPath = "/project/oauth2/slack"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Slack = {
            io.appwrite.models.OAuth2Slack.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Slack::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Spotify configuration.
     *
     * @param clientId 'Client ID' of Spotify OAuth2 app. For example: 6ec271000000000000000000009beace
     * @param clientSecret 'Client Secret' of Spotify OAuth2 app. For example: db068a000000000000000000008b5b9f
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Spotify]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Spotify(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Spotify {
        val apiPath = "/project/oauth2/spotify"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Spotify = {
            io.appwrite.models.OAuth2Spotify.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Spotify::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Stripe configuration.
     *
     * @param clientId 'Client ID' of Stripe OAuth2 app. For example: ca_UKibXX0000000000000000000006byvR
     * @param apiSecretKey 'API Secret Key' of Stripe OAuth2 app. For example: sk_51SfOd000000000000000000000000000000000000000000000000000000000000000000000000000000000000000QGWYfp
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Stripe]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Stripe(
        clientId: String? = null,
        apiSecretKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Stripe {
        val apiPath = "/project/oauth2/stripe"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "apiSecretKey" to apiSecretKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Stripe = {
            io.appwrite.models.OAuth2Stripe.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Stripe::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Tradeshift configuration.
     *
     * @param oauth2ClientId 'OAuth2 Client ID' of Tradeshift OAuth2 app. For example: appwrite-tes00000.0000000000est-app
     * @param oauth2ClientSecret 'OAuth2 Client Secret' of Tradeshift OAuth2 app. For example: 7cb52700-0000-0000-0000-000000ca5b83
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Tradeshift]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Tradeshift(
        oauth2ClientId: String? = null,
        oauth2ClientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Tradeshift {
        val apiPath = "/project/oauth2/tradeshift"

        val apiParams = mutableMapOf<String, Any?>(
            "oauth2ClientId" to oauth2ClientId,
            "oauth2ClientSecret" to oauth2ClientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Tradeshift = {
            io.appwrite.models.OAuth2Tradeshift.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Tradeshift::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Tradeshift Sandbox configuration.
     *
     * @param oauth2ClientId 'OAuth2 Client ID' of Tradeshift Sandbox OAuth2 app. For example: appwrite-tes00000.0000000000est-app
     * @param oauth2ClientSecret 'OAuth2 Client Secret' of Tradeshift Sandbox OAuth2 app. For example: 7cb52700-0000-0000-0000-000000ca5b83
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Tradeshift]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2TradeshiftSandbox(
        oauth2ClientId: String? = null,
        oauth2ClientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Tradeshift {
        val apiPath = "/project/oauth2/tradeshiftBox"

        val apiParams = mutableMapOf<String, Any?>(
            "oauth2ClientId" to oauth2ClientId,
            "oauth2ClientSecret" to oauth2ClientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Tradeshift = {
            io.appwrite.models.OAuth2Tradeshift.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Tradeshift::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Twitch configuration.
     *
     * @param clientId 'Client ID' of Twitch OAuth2 app. For example: vvi0in000000000000000000ikmt9p
     * @param clientSecret 'Client Secret' of Twitch OAuth2 app. For example: pmapue000000000000000000zylw3v
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Twitch]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Twitch(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Twitch {
        val apiPath = "/project/oauth2/twitch"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Twitch = {
            io.appwrite.models.OAuth2Twitch.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Twitch::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 WordPress configuration.
     *
     * @param clientId 'Client ID' of WordPress OAuth2 app. For example: 130005
     * @param clientSecret 'Client Secret' of WordPress OAuth2 app. For example: PlBfJS0000000000000000000000000000000000000000000000000000EdUZJk
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2WordPress]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2WordPress(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2WordPress {
        val apiPath = "/project/oauth2/wordpress"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2WordPress = {
            io.appwrite.models.OAuth2WordPress.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2WordPress::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 X configuration.
     *
     * @param customerKey 'Customer Key' of X OAuth2 app. For example: slzZV0000000000000NFLaWT
     * @param secretKey 'Secret Key' of X OAuth2 app. For example: tkEPkp00000000000000000000000000000000000000FTxbI9
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2X]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2X(
        customerKey: String? = null,
        secretKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2X {
        val apiPath = "/project/oauth2/x"

        val apiParams = mutableMapOf<String, Any?>(
            "customerKey" to customerKey,
            "secretKey" to secretKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2X = {
            io.appwrite.models.OAuth2X.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2X::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Yahoo configuration.
     *
     * @param clientId 'Client ID, also known as Customer Key' of Yahoo OAuth2 app. For example: dj0yJm000000000000000000000000000000000000000000000000000000000000000000000000000000000000Z4PWRm
     * @param clientSecret 'Client Secret, also known as Customer Secret' of Yahoo OAuth2 app. For example: cf978f0000000000000000000000000000c5e2e9
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Yahoo]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Yahoo(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Yahoo {
        val apiPath = "/project/oauth2/yahoo"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Yahoo = {
            io.appwrite.models.OAuth2Yahoo.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Yahoo::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Yandex configuration.
     *
     * @param clientId 'Client ID' of Yandex OAuth2 app. For example: 6a8a6a0000000000000000000091483c
     * @param clientSecret 'Client Secret' of Yandex OAuth2 app. For example: bbf98500000000000000000000c75a63
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Yandex]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Yandex(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Yandex {
        val apiPath = "/project/oauth2/yandex"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Yandex = {
            io.appwrite.models.OAuth2Yandex.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Yandex::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Zoho configuration.
     *
     * @param clientId 'Client ID' of Zoho OAuth2 app. For example: 1000.83C178000000000000000000RPNX0B
     * @param clientSecret 'Client Secret' of Zoho OAuth2 app. For example: fb5cac000000000000000000000000000000a68f6e
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Zoho]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Zoho(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Zoho {
        val apiPath = "/project/oauth2/zoho"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Zoho = {
            io.appwrite.models.OAuth2Zoho.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Zoho::class.java,
            converter,
        )
    }

    /**
     * Update the project OAuth2 Zoom configuration.
     *
     * @param clientId 'Client ID' of Zoom OAuth2 app. For example: QMAC00000000000000w0AQ
     * @param clientSecret 'Client Secret' of Zoom OAuth2 app. For example: GAWsG4000000000000000000007U01ON
     * @param enabled OAuth2 sign-in method status. Set to true to enable new session creation. Setting to true will trigger end-to-end credentials validation, and will throw if the credentials are invalid.
     * @return [io.appwrite.models.OAuth2Zoom]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateOAuth2Zoom(
        clientId: String? = null,
        clientSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.OAuth2Zoom {
        val apiPath = "/project/oauth2/zoom"

        val apiParams = mutableMapOf<String, Any?>(
            "clientId" to clientId,
            "clientSecret" to clientSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.OAuth2Zoom = {
            io.appwrite.models.OAuth2Zoom.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.OAuth2Zoom::class.java,
            converter,
        )
    }

    /**
     * Get a single OAuth2 provider configuration. Credential fields (client secret, p8 file, key/team IDs) are write-only and always returned empty.
     *
     * @param providerId OAuth2 provider key. For example: github, google, apple.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun getOAuth2Provider(
        providerId: io.appwrite.enums.ProjectOAuthProviderId,
    ): Any {
        val apiPath = "/project/oauth2/{providerId}"
            .replace("{providerId}", providerId.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> Any = {
            val responseMap = it as? Map<String, Any>
                ?: throw Exception("Unable to match response to any expected response model")
            when {
                responseMap["\$id"]?.toString() == "github" -> io.appwrite.models.OAuth2Github.from(map = responseMap)
                responseMap["\$id"]?.toString() == "discord" -> io.appwrite.models.OAuth2Discord.from(map = responseMap)
                responseMap["\$id"]?.toString() == "figma" -> io.appwrite.models.OAuth2Figma.from(map = responseMap)
                responseMap["\$id"]?.toString() == "dropbox" -> io.appwrite.models.OAuth2Dropbox.from(map = responseMap)
                responseMap["\$id"]?.toString() == "dailymotion" -> io.appwrite.models.OAuth2Dailymotion.from(map = responseMap)
                responseMap["\$id"]?.toString() == "bitbucket" -> io.appwrite.models.OAuth2Bitbucket.from(map = responseMap)
                responseMap["\$id"]?.toString() == "bitly" -> io.appwrite.models.OAuth2Bitly.from(map = responseMap)
                responseMap["\$id"]?.toString() == "box" -> io.appwrite.models.OAuth2Box.from(map = responseMap)
                responseMap["\$id"]?.toString() == "autodesk" -> io.appwrite.models.OAuth2Autodesk.from(map = responseMap)
                responseMap["\$id"]?.toString() == "google" -> io.appwrite.models.OAuth2Google.from(map = responseMap)
                responseMap["\$id"]?.toString() == "zoom" -> io.appwrite.models.OAuth2Zoom.from(map = responseMap)
                responseMap["\$id"]?.toString() == "zoho" -> io.appwrite.models.OAuth2Zoho.from(map = responseMap)
                responseMap["\$id"]?.toString() == "yandex" -> io.appwrite.models.OAuth2Yandex.from(map = responseMap)
                responseMap["\$id"]?.toString() == "x" -> io.appwrite.models.OAuth2X.from(map = responseMap)
                responseMap["\$id"]?.toString() == "wordpress" -> io.appwrite.models.OAuth2WordPress.from(map = responseMap)
                responseMap["\$id"]?.toString() == "twitch" -> io.appwrite.models.OAuth2Twitch.from(map = responseMap)
                responseMap["\$id"]?.toString() == "stripe" -> io.appwrite.models.OAuth2Stripe.from(map = responseMap)
                responseMap["\$id"]?.toString() == "spotify" -> io.appwrite.models.OAuth2Spotify.from(map = responseMap)
                responseMap["\$id"]?.toString() == "slack" -> io.appwrite.models.OAuth2Slack.from(map = responseMap)
                responseMap["\$id"]?.toString() == "podio" -> io.appwrite.models.OAuth2Podio.from(map = responseMap)
                responseMap["\$id"]?.toString() == "notion" -> io.appwrite.models.OAuth2Notion.from(map = responseMap)
                responseMap["\$id"]?.toString() == "salesforce" -> io.appwrite.models.OAuth2Salesforce.from(map = responseMap)
                responseMap["\$id"]?.toString() == "yahoo" -> io.appwrite.models.OAuth2Yahoo.from(map = responseMap)
                responseMap["\$id"]?.toString() == "linkedin" -> io.appwrite.models.OAuth2Linkedin.from(map = responseMap)
                responseMap["\$id"]?.toString() == "disqus" -> io.appwrite.models.OAuth2Disqus.from(map = responseMap)
                responseMap["\$id"]?.toString() == "amazon" -> io.appwrite.models.OAuth2Amazon.from(map = responseMap)
                responseMap["\$id"]?.toString() == "etsy" -> io.appwrite.models.OAuth2Etsy.from(map = responseMap)
                responseMap["\$id"]?.toString() == "facebook" -> io.appwrite.models.OAuth2Facebook.from(map = responseMap)
                responseMap["\$id"]?.toString() == "tradeshiftBox" -> io.appwrite.models.OAuth2Tradeshift.from(map = responseMap)
                responseMap["\$id"]?.toString() == "paypalSandbox" -> io.appwrite.models.OAuth2Paypal.from(map = responseMap)
                responseMap["\$id"]?.toString() == "gitlab" -> io.appwrite.models.OAuth2Gitlab.from(map = responseMap)
                responseMap["\$id"]?.toString() == "authentik" -> io.appwrite.models.OAuth2Authentik.from(map = responseMap)
                responseMap["\$id"]?.toString() == "auth0" -> io.appwrite.models.OAuth2Auth0.from(map = responseMap)
                responseMap["\$id"]?.toString() == "fusionauth" -> io.appwrite.models.OAuth2FusionAuth.from(map = responseMap)
                responseMap["\$id"]?.toString() == "keycloak" -> io.appwrite.models.OAuth2Keycloak.from(map = responseMap)
                responseMap["\$id"]?.toString() == "oidc" -> io.appwrite.models.OAuth2Oidc.from(map = responseMap)
                responseMap["\$id"]?.toString() == "apple" -> io.appwrite.models.OAuth2Apple.from(map = responseMap)
                responseMap["\$id"]?.toString() == "okta" -> io.appwrite.models.OAuth2Okta.from(map = responseMap)
                responseMap["\$id"]?.toString() == "kick" -> io.appwrite.models.OAuth2Kick.from(map = responseMap)
                responseMap["\$id"]?.toString() == "microsoft" -> io.appwrite.models.OAuth2Microsoft.from(map = responseMap)
                else -> throw Exception("Unable to match response to any expected response model")
            }
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
            val responseMap = it as? Map<String, Any>
                ?: throw Exception("Unable to match response to any expected response model")
            when {
                responseMap["type"]?.toString() == "web" -> io.appwrite.models.PlatformWeb.from(map = responseMap)
                responseMap["type"]?.toString() == "apple" -> io.appwrite.models.PlatformApple.from(map = responseMap)
                responseMap["type"]?.toString() == "android" -> io.appwrite.models.PlatformAndroid.from(map = responseMap)
                responseMap["type"]?.toString() == "windows" -> io.appwrite.models.PlatformWindows.from(map = responseMap)
                responseMap["type"]?.toString() == "linux" -> io.appwrite.models.PlatformLinux.from(map = responseMap)
                else -> throw Exception("Unable to match response to any expected response model")
            }
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
     * Get a list of all project policies and their current configuration.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.PolicyList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listPolicies(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.PolicyList {
        val apiPath = "/project/policies"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.PolicyList = {
            io.appwrite.models.PolicyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.PolicyList::class.java,
            converter,
        )
    }

    /**
     * Configures if aliased emails such as subaddresses and emails with suffixes are denied during new users sign-ups and email updates.
     *
     * @param enabled Set whether or not to block aliased emails during signup and email updates.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDenyAliasedEmailPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/deny-aliased-email"

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
     * Configures if disposable emails from known temporary domains are denied during new users sign-ups and email updates.
     *
     * @param enabled Set whether or not to block disposable email addresses during signup and email updates.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDenyDisposableEmailPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/deny-disposable-email"

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
     * Configures if emails from free providers such as Gmail or Yahoo are denied during new users sign-ups and email updates.
     *
     * @param enabled Set whether or not to block free email addresses during signup and email updates.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDenyFreeEmailPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/deny-free-email"

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
     * Updating this policy allows you to control if team members can see other members information. When enabled, all team members can see ID, name, email, phone number, and MFA status of other members..
     *
     * @param userId Set to true if you want make user ID visible to all team members, or false to hide it.
     * @param userEmail Set to true if you want make user email visible to all team members, or false to hide it.
     * @param userPhone Set to true if you want make user phone number visible to all team members, or false to hide it.
     * @param userName Set to true if you want make user name visible to all team members, or false to hide it.
     * @param userMFA Set to true if you want make user MFA status visible to all team members, or false to hide it.
     * @return [io.appwrite.models.Project]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMembershipPrivacyPolicy(
        userId: Boolean? = null,
        userEmail: Boolean? = null,
        userPhone: Boolean? = null,
        userName: Boolean? = null,
        userMFA: Boolean? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/membership-privacy"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "userEmail" to userEmail,
            "userPhone" to userPhone,
            "userName" to userName,
            "userMFA" to userMFA,
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
     * Updating this policy allows you to control if new passwords are checked against most common passwords dictionary. When enabled, and user changes their password, password must not be contained in the dictionary.
     *
     * @param enabled Toggle password dictionary policy. Set to true if you want password change to block passwords in the dictionary, or false to allow them. When changing this policy, existing passwords remain valid.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePasswordDictionaryPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/password-dictionary"

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
     * Updates one of password strength policies. Based on total length configured, previous password hashes are stored, and users cannot choose a new password that is already stored in the passwird history list, when updating an user password, or setting new one through password recovery.
     * 
     * Keep in mind, while password history policy is disabled, the history is not being stored. Enabling the policy will not have any history on existing users, and it will only start to collect and enforce the policy on password changes since the policy is enabled.
     *
     * @param total Set the password history length per user. Value can be between 1 and 5000, or null to disable the limit.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePasswordHistoryPolicy(
        total: Long? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/password-history"

        val apiParams = mutableMapOf<String, Any?>(
            "total" to total,
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
     * Updating this policy allows you to control if password strength is checked against personal data. When enabled, and user sets or changes their password, the password must not contain user ID, name, email or phone number.
     *
     * @param enabled Toggle password personal data policy. Set to true if you want to block passwords including user's personal data, or false to allow it. When changing this policy, existing passwords remain valid.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePasswordPersonalDataPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/password-personal-data"

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
     * Updating this policy allows you to control if email alert is sent upon session creation. When enabled, and user signs into their account, they will be sent an email notification. There is an exception, the first session after a new sign up does not trigger an alert, even if the policy is enabled.
     *
     * @param enabled Toggle session alert policy. Set to true if you want users to receive email notifications when a sessions are created for their users, or false to not send email alerts.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateSessionAlertPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/session-alert"

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
     * Update maximum duration how long sessions created within a project should stay active for.
     *
     * @param duration Maximum session length in seconds. Minium allowed value is 5 second, and maximum is 1 year, which is 31536000 seconds.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateSessionDurationPolicy(
        duration: Long,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/session-duration"

        val apiParams = mutableMapOf<String, Any?>(
            "duration" to duration,
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
     * Updating this policy allows you to control if existing sessions should be invalidated when a password of a user is changed. When enabled, and user changes their password, they will be logged out of all their devices.
     *
     * @param enabled Toggle session invalidation policy. Set to true if you want password change to invalidate all sessions of an user, or false to keep sessions active.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateSessionInvalidationPolicy(
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/session-invalidation"

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
     * Update the maximum number of sessions allowed per user. When the limit is hit, the oldest session will be deleted to make room for new one.
     *
     * @param total Set the maximum number of sessions allowed per user. Value can be between 1 and 5000, or null to disable the limit.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateSessionLimitPolicy(
        total: Long? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/session-limit"

        val apiParams = mutableMapOf<String, Any?>(
            "total" to total,
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
     * Update the maximum number of users in the project. When the limit is hit or amount of existing users already exceeded the limit, all users remain active, but new user sign up will be prohibited.
     *
     * @param total Set the maximum number of users allowed in the project. Value can be between 1 and 5000, or null to disable the limit.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateUserLimitPolicy(
        total: Long? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/project/policies/user-limit"

        val apiParams = mutableMapOf<String, Any?>(
            "total" to total,
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
     * Get a policy by its unique ID. This endpoint returns the current configuration for the requested project policy.
     *
     * @param policyId Policy ID. Can be one of: password-dictionary, password-history, password-personal-data, session-alert, session-duration, session-invalidation, session-limit, user-limit, membership-privacy.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun getPolicy(
        policyId: io.appwrite.enums.ProjectPolicyId,
    ): Any {
        val apiPath = "/project/policies/{policyId}"
            .replace("{policyId}", policyId.value)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> Any = {
            val responseMap = it as? Map<String, Any>
                ?: throw Exception("Unable to match response to any expected response model")
            when {
                responseMap["\$id"]?.toString() == "password-dictionary" -> io.appwrite.models.PolicyPasswordDictionary.from(map = responseMap)
                responseMap["\$id"]?.toString() == "password-history" -> io.appwrite.models.PolicyPasswordHistory.from(map = responseMap)
                responseMap["\$id"]?.toString() == "password-personal-data" -> io.appwrite.models.PolicyPasswordPersonalData.from(map = responseMap)
                responseMap["\$id"]?.toString() == "session-alert" -> io.appwrite.models.PolicySessionAlert.from(map = responseMap)
                responseMap["\$id"]?.toString() == "session-duration" -> io.appwrite.models.PolicySessionDuration.from(map = responseMap)
                responseMap["\$id"]?.toString() == "session-invalidation" -> io.appwrite.models.PolicySessionInvalidation.from(map = responseMap)
                responseMap["\$id"]?.toString() == "session-limit" -> io.appwrite.models.PolicySessionLimit.from(map = responseMap)
                responseMap["\$id"]?.toString() == "user-limit" -> io.appwrite.models.PolicyUserLimit.from(map = responseMap)
                responseMap["\$id"]?.toString() == "membership-privacy" -> io.appwrite.models.PolicyMembershipPrivacy.from(map = responseMap)
                else -> throw Exception("Unable to match response to any expected response model")
            }
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
     * Update properties of a specific protocol. Use this endpoint to enable or disable a protocol in your project. 
     *
     * @param protocolId Protocol name. Can be one of: rest, graphql, websocket
     * @param enabled Protocol status.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateProtocol(
        protocolId: io.appwrite.enums.ProjectProtocolId,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/protocols/{protocolId}"
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
     * Update properties of a specific service. Use this endpoint to enable or disable a service in your project. 
     *
     * @param serviceId Service name. Can be one of: account, avatars, databases, tablesdb, locale, health, project, storage, teams, users, vcs, sites, functions, proxy, graphql, migrations, messaging, advisor
     * @param enabled Service status.
     * @return [io.appwrite.models.Project]
     */
    @Throws(AppwriteException::class)
    suspend fun updateService(
        serviceId: io.appwrite.enums.ProjectServiceId,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/project/services/{serviceId}"
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
     * Update the SMTP configuration for your project. Use this endpoint to configure your project's SMTP provider with your custom settings for sending transactional emails.
     *
     * @param host SMTP server hostname (domain)
     * @param port SMTP server port
     * @param username SMTP server username. Leave empty for no authorization.
     * @param password SMTP server password. Leave empty for no authorization. This property is stored securely and cannot be read in future (write-only).
     * @param senderEmail Email address shown in inbox as the sender of the email.
     * @param senderName Name shown in inbox as the sender of the email.
     * @param replyToEmail Email used when user replies to the email.
     * @param replyToName Name used when user replies to the email.
     * @param secure Configures if communication with SMTP server is encrypted. Allowed values are: tls, ssl. Leave empty for no encryption.
     * @param enabled Enable or disable custom SMTP. Custom SMTP is useful for branding purposes, but also allows use of custom email templates.
     * @return [io.appwrite.models.Project]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSMTP(
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        senderEmail: String? = null,
        senderName: String? = null,
        replyToEmail: String? = null,
        replyToName: String? = null,
        secure: io.appwrite.enums.ProjectSMTPSecure? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/project/smtp"

        val apiParams = mutableMapOf<String, Any?>(
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "senderEmail" to senderEmail,
            "senderName" to senderName,
            "replyToEmail" to replyToEmail,
            "replyToName" to replyToName,
            "secure" to secure,
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
     * Send a test email to verify SMTP configuration. 
     *
     * @param emails Array of emails to send test email to. Maximum of 10 emails are allowed.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun createSMTPTest(
        emails: List<String>,
    ): Any {
        val apiPath = "/project/smtp/tests"

        val apiParams = mutableMapOf<String, Any?>(
            "emails" to emails,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get a list of all custom email templates configured for the project. This endpoint returns an array of all configured email templates and their locales.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.EmailTemplateList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listEmailTemplates(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.EmailTemplateList {
        val apiPath = "/project/templates/email"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.EmailTemplateList = {
            io.appwrite.models.EmailTemplateList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EmailTemplateList::class.java,
            converter,
        )
    }

    /**
     * Update a custom email template for the specified locale and type. Use this endpoint to modify the content of your email templates.
     *
     * @param templateId Custom email template type. Can be one of: verification, magicSession, recovery, invitation, mfaChallenge, sessionAlert, otpSession
     * @param locale Custom email template locale. If left empty, the fallback locale (en) will be used.
     * @param subject Subject of the email template. Can be up to 255 characters.
     * @param message Plain or HTML body of the email template message. Can be up to 10MB of content.
     * @param senderName Name of the email sender.
     * @param senderEmail Email of the sender.
     * @param replyToEmail Reply to email.
     * @param replyToName Reply to name.
     * @return [io.appwrite.models.EmailTemplate]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmailTemplate(
        templateId: io.appwrite.enums.ProjectEmailTemplateId,
        locale: io.appwrite.enums.ProjectEmailTemplateLocale? = null,
        subject: String? = null,
        message: String? = null,
        senderName: String? = null,
        senderEmail: String? = null,
        replyToEmail: String? = null,
        replyToName: String? = null,
    ): io.appwrite.models.EmailTemplate {
        val apiPath = "/project/templates/email"

        val apiParams = mutableMapOf<String, Any?>(
            "templateId" to templateId,
            "locale" to locale,
            "subject" to subject,
            "message" to message,
            "senderName" to senderName,
            "senderEmail" to senderEmail,
            "replyToEmail" to replyToEmail,
            "replyToName" to replyToName,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.EmailTemplate = {
            io.appwrite.models.EmailTemplate.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EmailTemplate::class.java,
            converter,
        )
    }

    /**
     * Get a custom email template for the specified locale and type. This endpoint returns the template content, subject, and other configuration details.
     *
     * @param templateId Custom email template type. Can be one of: verification, magicSession, recovery, invitation, mfaChallenge, sessionAlert, otpSession
     * @param locale Custom email template locale. If left empty, the fallback locale (en) will be used.
     * @return [io.appwrite.models.EmailTemplate]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getEmailTemplate(
        templateId: io.appwrite.enums.ProjectEmailTemplateId,
        locale: io.appwrite.enums.ProjectEmailTemplateLocale? = null,
    ): io.appwrite.models.EmailTemplate {
        val apiPath = "/project/templates/email/{templateId}"
            .replace("{templateId}", templateId.value)

        val apiParams = mutableMapOf<String, Any?>(
            "locale" to locale,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.EmailTemplate = {
            io.appwrite.models.EmailTemplate.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EmailTemplate::class.java,
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
     * @param variableId Variable unique ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
     * @param variableId Variable unique ID.
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
     * @param variableId Variable unique ID.
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
     * @param variableId Variable unique ID.
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
