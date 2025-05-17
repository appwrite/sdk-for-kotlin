package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Users service allows you to manage your project users.
**/
class Users(client: Client) : Service(client) {

    /**
     * Get a list of all the project&#039;s users. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, email, phone, status, passwordUpdate, registration, emailVerification, phoneVerification, labels
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.UserList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> list(
        queries: List<String>? = null,
        search: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.UserList<T> {
        val apiPath = "/users"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.UserList<T> = {
            io.appwrite.models.UserList.from(map = it as Map<String, Any>, nestedType)
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
     * Get a list of all the project&#039;s users. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, email, phone, status, passwordUpdate, registration, emailVerification, phoneVerification, labels
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.UserList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.UserList<Map<String, Any>> = list(
        queries,
        search,
        nestedType = classOf(),
    )

    /**
     * Create a new user.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password Plain text user password. Must be at least 8 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> create(
        userId: String,
        email: String? = null,
        phone: String? = null,
        password: String? = null,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "phone" to phone,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password Plain text user password. Must be at least 8 chars.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        userId: String,
        email: String? = null,
        phone: String? = null,
        password: String? = null,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = create(
        userId,
        email,
        phone,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [Argon2](https://en.wikipedia.org/wiki/Argon2) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Argon2.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createArgon2User(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/argon2"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [Argon2](https://en.wikipedia.org/wiki/Argon2) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Argon2.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createArgon2User(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createArgon2User(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [Bcrypt](https://en.wikipedia.org/wiki/Bcrypt) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Bcrypt.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createBcryptUser(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/bcrypt"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [Bcrypt](https://en.wikipedia.org/wiki/Bcrypt) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Bcrypt.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBcryptUser(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createBcryptUser(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Get identities for all users.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, provider, providerUid, providerEmail, providerAccessTokenExpiry
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.IdentityList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIdentities(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.IdentityList {
        val apiPath = "/users/identities"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.IdentityList = {
            io.appwrite.models.IdentityList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.IdentityList::class.java,
            converter,
        )
    }

    /**
     * Delete an identity by its unique ID.
     *
     * @param identityId Identity ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteIdentity(
        identityId: String,
    ): Any {
        val apiPath = "/users/identities/{identityId}"
            .replace("{identityId}", identityId)

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
     * Create a new user. Password provided must be hashed with the [MD5](https://en.wikipedia.org/wiki/MD5) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using MD5.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createMD5User(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/md5"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [MD5](https://en.wikipedia.org/wiki/MD5) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using MD5.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMD5User(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createMD5User(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [PHPass](https://www.openwall.com/phpass/) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or pass the string `ID.unique()`to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using PHPass.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createPHPassUser(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/phpass"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [PHPass](https://www.openwall.com/phpass/) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or pass the string `ID.unique()`to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using PHPass.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createPHPassUser(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createPHPassUser(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [Scrypt](https://github.com/Tarsnap/scrypt) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Scrypt.
     * @param passwordSalt Optional salt used to hash password.
     * @param passwordCpu Optional CPU cost used to hash password.
     * @param passwordMemory Optional memory cost used to hash password.
     * @param passwordParallel Optional parallelization cost used to hash password.
     * @param passwordLength Optional hash length used to hash password.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createScryptUser(
        userId: String,
        email: String,
        password: String,
        passwordSalt: String,
        passwordCpu: Long,
        passwordMemory: Long,
        passwordParallel: Long,
        passwordLength: Long,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/scrypt"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "passwordSalt" to passwordSalt,
            "passwordCpu" to passwordCpu,
            "passwordMemory" to passwordMemory,
            "passwordParallel" to passwordParallel,
            "passwordLength" to passwordLength,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [Scrypt](https://github.com/Tarsnap/scrypt) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Scrypt.
     * @param passwordSalt Optional salt used to hash password.
     * @param passwordCpu Optional CPU cost used to hash password.
     * @param passwordMemory Optional memory cost used to hash password.
     * @param passwordParallel Optional parallelization cost used to hash password.
     * @param passwordLength Optional hash length used to hash password.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createScryptUser(
        userId: String,
        email: String,
        password: String,
        passwordSalt: String,
        passwordCpu: Long,
        passwordMemory: Long,
        passwordParallel: Long,
        passwordLength: Long,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createScryptUser(
        userId,
        email,
        password,
        passwordSalt,
        passwordCpu,
        passwordMemory,
        passwordParallel,
        passwordLength,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [Scrypt Modified](https://gist.github.com/Meldiron/eecf84a0225eccb5a378d45bb27462cc) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Scrypt Modified.
     * @param passwordSalt Salt used to hash password.
     * @param passwordSaltSeparator Salt separator used to hash password.
     * @param passwordSignerKey Signer key used to hash password.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createScryptModifiedUser(
        userId: String,
        email: String,
        password: String,
        passwordSalt: String,
        passwordSaltSeparator: String,
        passwordSignerKey: String,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/scrypt-modified"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "passwordSalt" to passwordSalt,
            "passwordSaltSeparator" to passwordSaltSeparator,
            "passwordSignerKey" to passwordSignerKey,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [Scrypt Modified](https://gist.github.com/Meldiron/eecf84a0225eccb5a378d45bb27462cc) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using Scrypt Modified.
     * @param passwordSalt Salt used to hash password.
     * @param passwordSaltSeparator Salt separator used to hash password.
     * @param passwordSignerKey Signer key used to hash password.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createScryptModifiedUser(
        userId: String,
        email: String,
        password: String,
        passwordSalt: String,
        passwordSaltSeparator: String,
        passwordSignerKey: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createScryptModifiedUser(
        userId,
        email,
        password,
        passwordSalt,
        passwordSaltSeparator,
        passwordSignerKey,
        name,
        nestedType = classOf(),
    )

    /**
     * Create a new user. Password provided must be hashed with the [SHA](https://en.wikipedia.org/wiki/Secure_Hash_Algorithm) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using SHA.
     * @param passwordVersion Optional SHA version used to hash password. Allowed values are: 'sha1', 'sha224', 'sha256', 'sha384', 'sha512/224', 'sha512/256', 'sha512', 'sha3-224', 'sha3-256', 'sha3-384', 'sha3-512'
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createSHAUser(
        userId: String,
        email: String,
        password: String,
        passwordVersion: io.appwrite.enums.PasswordHash? = null,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/sha"

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "passwordVersion" to passwordVersion,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new user. Password provided must be hashed with the [SHA](https://en.wikipedia.org/wiki/Secure_Hash_Algorithm) algorithm. Use the [POST /users](https://appwrite.io/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password User password hashed using SHA.
     * @param passwordVersion Optional SHA version used to hash password. Allowed values are: 'sha1', 'sha224', 'sha256', 'sha384', 'sha512/224', 'sha512/256', 'sha512', 'sha3-224', 'sha3-256', 'sha3-384', 'sha3-512'
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSHAUser(
        userId: String,
        email: String,
        password: String,
        passwordVersion: io.appwrite.enums.PasswordHash? = null,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = createSHAUser(
        userId,
        email,
        password,
        passwordVersion,
        name,
        nestedType = classOf(),
    )

    /**
     * Get a user by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> get(
        userId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
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
     * Get a user by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        userId: String,
    ): io.appwrite.models.User<Map<String, Any>> = get(
        userId,
        nestedType = classOf(),
    )

    /**
     * Delete a user by its unique ID, thereby releasing it&#039;s ID. Since ID is released and can be reused, all user-related resources like documents or storage files should be deleted before user deletion. If you want to keep ID reserved, use the [updateStatus](https://appwrite.io/docs/server/users#usersUpdateStatus) endpoint instead.
     *
     * @param userId User ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        userId: String,
    ): Any {
        val apiPath = "/users/{userId}"
            .replace("{userId}", userId)

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
     * Update the user email by its unique ID.
     *
     * @param userId User ID.
     * @param email User email.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateEmail(
        userId: String,
        email: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/email"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user email by its unique ID.
     *
     * @param userId User ID.
     * @param email User email.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
        userId: String,
        email: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateEmail(
        userId,
        email,
        nestedType = classOf(),
    )

    /**
     * Use this endpoint to create a JSON Web Token for user by its unique ID. You can use the resulting JWT to authenticate on behalf of the user. The JWT secret will become invalid if the session it uses gets deleted.
     *
     * @param userId User ID.
     * @param sessionId Session ID. Use the string 'recent' to use the most recent session. Defaults to the most recent session.
     * @param duration Time in seconds before JWT expires. Default duration is 900 seconds, and maximum is 3600 seconds.
     * @return [io.appwrite.models.Jwt]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createJWT(
        userId: String,
        sessionId: String? = null,
        duration: Long? = null,
    ): io.appwrite.models.Jwt {
        val apiPath = "/users/{userId}/jwts"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "sessionId" to sessionId,
            "duration" to duration,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Jwt = {
            io.appwrite.models.Jwt.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Jwt::class.java,
            converter,
        )
    }

    /**
     * Update the user labels by its unique ID. Labels can be used to grant access to resources. While teams are a way for user&#039;s to share access to a resource, labels can be defined by the developer to grant access without an invitation. See the [Permissions docs](https://appwrite.io/docs/permissions) for more info.
     *
     * @param userId User ID.
     * @param labels Array of user labels. Replaces the previous labels. Maximum of 1000 labels are allowed, each up to 36 alphanumeric characters long.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateLabels(
        userId: String,
        labels: List<String>,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/labels"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "labels" to labels,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
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
     * Update the user labels by its unique ID. Labels can be used to grant access to resources. While teams are a way for user&#039;s to share access to a resource, labels can be defined by the developer to grant access without an invitation. See the [Permissions docs](https://appwrite.io/docs/permissions) for more info.
     *
     * @param userId User ID.
     * @param labels Array of user labels. Replaces the previous labels. Maximum of 1000 labels are allowed, each up to 36 alphanumeric characters long.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateLabels(
        userId: String,
        labels: List<String>,
    ): io.appwrite.models.User<Map<String, Any>> = updateLabels(
        userId,
        labels,
        nestedType = classOf(),
    )

    /**
     * Get the user activity logs list by its unique ID.
     *
     * @param userId User ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listLogs(
        userId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/users/{userId}/logs"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }

    /**
     * Get the user membership list by its unique ID.
     *
     * @param userId User ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, teamId, invited, joined, confirm, roles
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.MembershipList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMemberships(
        userId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.MembershipList {
        val apiPath = "/users/{userId}/memberships"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
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
     * Enable or disable MFA on a user account.
     *
     * @param userId User ID.
     * @param mfa Enable or disable MFA.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateMfa(
        userId: String,
        mfa: Boolean,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/mfa"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "mfa" to mfa,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Enable or disable MFA on a user account.
     *
     * @param userId User ID.
     * @param mfa Enable or disable MFA.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMfa(
        userId: String,
        mfa: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updateMfa(
        userId,
        mfa,
        nestedType = classOf(),
    )

    /**
     * Delete an authenticator app.
     *
     * @param userId User ID.
     * @param type Type of authenticator.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteMfaAuthenticator(
        userId: String,
        type: io.appwrite.enums.AuthenticatorType,
    ): Any {
        val apiPath = "/users/{userId}/mfa/authenticators/{type}"
            .replace("{userId}", userId)
            .replace("{type}", type.value)

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
     * List the factors available on the account to be used as a MFA challange.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MfaFactors]
     */
    @Throws(AppwriteException::class)
    suspend fun listMfaFactors(
        userId: String,
    ): io.appwrite.models.MfaFactors {
        val apiPath = "/users/{userId}/mfa/factors"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaFactors = {
            io.appwrite.models.MfaFactors.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaFactors::class.java,
            converter,
        )
    }

    /**
     * Get recovery codes that can be used as backup for MFA flow by User ID. Before getting codes, they must be generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Throws(AppwriteException::class)
    suspend fun getMfaRecoveryCodes(
        userId: String,
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/users/{userId}/mfa/recovery-codes"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }

    /**
     * Regenerate recovery codes that can be used as backup for MFA flow by User ID. Before regenerating codes, they must be first generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Throws(AppwriteException::class)
    suspend fun updateMfaRecoveryCodes(
        userId: String,
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/users/{userId}/mfa/recovery-codes"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }

    /**
     * Generate recovery codes used as backup for MFA flow for User ID. Recovery codes can be used as a MFA verification type in [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method by client SDK.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MfaRecoveryCodes]
     */
    @Throws(AppwriteException::class)
    suspend fun createMfaRecoveryCodes(
        userId: String,
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/users/{userId}/mfa/recovery-codes"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MfaRecoveryCodes = {
            io.appwrite.models.MfaRecoveryCodes.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MfaRecoveryCodes::class.java,
            converter,
        )
    }

    /**
     * Update the user name by its unique ID.
     *
     * @param userId User ID.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateName(
        userId: String,
        name: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/name"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user name by its unique ID.
     *
     * @param userId User ID.
     * @param name User name. Max length: 128 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateName(
        userId: String,
        name: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateName(
        userId,
        name,
        nestedType = classOf(),
    )

    /**
     * Update the user password by its unique ID.
     *
     * @param userId User ID.
     * @param password New user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updatePassword(
        userId: String,
        password: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/password"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "password" to password,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user password by its unique ID.
     *
     * @param userId User ID.
     * @param password New user password. Must be at least 8 chars.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePassword(
        userId: String,
        password: String,
    ): io.appwrite.models.User<Map<String, Any>> = updatePassword(
        userId,
        password,
        nestedType = classOf(),
    )

    /**
     * Update the user phone by its unique ID.
     *
     * @param userId User ID.
     * @param number User phone number.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updatePhone(
        userId: String,
        number: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/phone"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "number" to number,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user phone by its unique ID.
     *
     * @param userId User ID.
     * @param number User phone number.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePhone(
        userId: String,
        number: String,
    ): io.appwrite.models.User<Map<String, Any>> = updatePhone(
        userId,
        number,
        nestedType = classOf(),
    )

    /**
     * Get the user preferences by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> getPrefs(
        userId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/users/{userId}/prefs"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
            io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
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
     * Get the user preferences by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun getPrefs(
        userId: String,
    ): io.appwrite.models.Preferences<Map<String, Any>> = getPrefs(
        userId,
        nestedType = classOf(),
    )

    /**
     * Update the user preferences by its unique ID. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param userId User ID.
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updatePrefs(
        userId: String,
        prefs: Any,
        nestedType: Class<T>,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/users/{userId}/prefs"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "prefs" to prefs,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
            io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user preferences by its unique ID. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param userId User ID.
     * @param prefs Prefs key-value JSON object.
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePrefs(
        userId: String,
        prefs: Any,
    ): io.appwrite.models.Preferences<Map<String, Any>> = updatePrefs(
        userId,
        prefs,
        nestedType = classOf(),
    )

    /**
     * Get the user sessions list by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.SessionList]
     */
    @Throws(AppwriteException::class)
    suspend fun listSessions(
        userId: String,
    ): io.appwrite.models.SessionList {
        val apiPath = "/users/{userId}/sessions"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.SessionList = {
            io.appwrite.models.SessionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SessionList::class.java,
            converter,
        )
    }

    /**
     * Creates a session for a user. Returns an immediately usable session object.If you want to generate a token for a custom authentication flow, use the [POST /users/{userId}/tokens](https://appwrite.io/docs/server/users#createToken) endpoint.
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @return [io.appwrite.models.Session]
     */
    @Throws(AppwriteException::class)
    suspend fun createSession(
        userId: String,
    ): io.appwrite.models.Session {
        val apiPath = "/users/{userId}/sessions"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Session = {
            io.appwrite.models.Session.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Session::class.java,
            converter,
        )
    }

    /**
     * Delete all user&#039;s sessions by using the user&#039;s unique ID.
     *
     * @param userId User ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteSessions(
        userId: String,
    ): Any {
        val apiPath = "/users/{userId}/sessions"
            .replace("{userId}", userId)

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
     * Delete a user sessions by its unique ID.
     *
     * @param userId User ID.
     * @param sessionId Session ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteSession(
        userId: String,
        sessionId: String,
    ): Any {
        val apiPath = "/users/{userId}/sessions/{sessionId}"
            .replace("{userId}", userId)
            .replace("{sessionId}", sessionId)

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
     * Update the user status by its unique ID. Use this endpoint as an alternative to deleting a user if you want to keep user&#039;s ID reserved.
     *
     * @param userId User ID.
     * @param status User Status. To activate the user pass `true` and to block the user pass `false`.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateStatus(
        userId: String,
        status: Boolean,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/status"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user status by its unique ID. Use this endpoint as an alternative to deleting a user if you want to keep user&#039;s ID reserved.
     *
     * @param userId User ID.
     * @param status User Status. To activate the user pass `true` and to block the user pass `false`.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateStatus(
        userId: String,
        status: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updateStatus(
        userId,
        status,
        nestedType = classOf(),
    )

    /**
     * List the messaging targets that are associated with a user.
     *
     * @param userId User ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, email, phone, status, passwordUpdate, registration, emailVerification, phoneVerification, labels
     * @return [io.appwrite.models.TargetList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listTargets(
        userId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.TargetList {
        val apiPath = "/users/{userId}/targets"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.TargetList = {
            io.appwrite.models.TargetList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TargetList::class.java,
            converter,
        )
    }

    /**
     * Create a messaging target.
     *
     * @param userId User ID.
     * @param targetId Target ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param providerType The target provider type. Can be one of the following: `email`, `sms` or `push`.
     * @param identifier The target identifier (token, email, phone etc.)
     * @param providerId Provider ID. Message will be sent to this target from the specified provider ID. If no provider ID is set the first setup provider will be used.
     * @param name Target name. Max length: 128 chars. For example: My Awesome App Galaxy S23.
     * @return [io.appwrite.models.Target]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTarget(
        userId: String,
        targetId: String,
        providerType: io.appwrite.enums.MessagingProviderType,
        identifier: String,
        providerId: String? = null,
        name: String? = null,
    ): io.appwrite.models.Target {
        val apiPath = "/users/{userId}/targets"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "targetId" to targetId,
            "providerType" to providerType,
            "identifier" to identifier,
            "providerId" to providerId,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Target = {
            io.appwrite.models.Target.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Target::class.java,
            converter,
        )
    }

    /**
     * Get a user&#039;s push notification target by ID.
     *
     * @param userId User ID.
     * @param targetId Target ID.
     * @return [io.appwrite.models.Target]
     */
    @Throws(AppwriteException::class)
    suspend fun getTarget(
        userId: String,
        targetId: String,
    ): io.appwrite.models.Target {
        val apiPath = "/users/{userId}/targets/{targetId}"
            .replace("{userId}", userId)
            .replace("{targetId}", targetId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Target = {
            io.appwrite.models.Target.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Target::class.java,
            converter,
        )
    }

    /**
     * Update a messaging target.
     *
     * @param userId User ID.
     * @param targetId Target ID.
     * @param identifier The target identifier (token, email, phone etc.)
     * @param providerId Provider ID. Message will be sent to this target from the specified provider ID. If no provider ID is set the first setup provider will be used.
     * @param name Target name. Max length: 128 chars. For example: My Awesome App Galaxy S23.
     * @return [io.appwrite.models.Target]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTarget(
        userId: String,
        targetId: String,
        identifier: String? = null,
        providerId: String? = null,
        name: String? = null,
    ): io.appwrite.models.Target {
        val apiPath = "/users/{userId}/targets/{targetId}"
            .replace("{userId}", userId)
            .replace("{targetId}", targetId)

        val apiParams = mutableMapOf<String, Any?>(
            "identifier" to identifier,
            "providerId" to providerId,
            "name" to name,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Target = {
            io.appwrite.models.Target.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Target::class.java,
            converter,
        )
    }

    /**
     * Delete a messaging target.
     *
     * @param userId User ID.
     * @param targetId Target ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteTarget(
        userId: String,
        targetId: String,
    ): Any {
        val apiPath = "/users/{userId}/targets/{targetId}"
            .replace("{userId}", userId)
            .replace("{targetId}", targetId)

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
     * Returns a token with a secret key for creating a session. Use the user ID and secret and submit a request to the [PUT /account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process.
     *
     * @param userId User ID.
     * @param length Token length in characters. The default length is 6 characters
     * @param expire Token expiration period in seconds. The default expiration is 15 minutes.
     * @return [io.appwrite.models.Token]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createToken(
        userId: String,
        length: Long? = null,
        expire: Long? = null,
    ): io.appwrite.models.Token {
        val apiPath = "/users/{userId}/tokens"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "length" to length,
            "expire" to expire,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Token = {
            io.appwrite.models.Token.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Token::class.java,
            converter,
        )
    }

    /**
     * Update the user email verification status by its unique ID.
     *
     * @param userId User ID.
     * @param emailVerification User email verification status.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateEmailVerification(
        userId: String,
        emailVerification: Boolean,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/verification"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "emailVerification" to emailVerification,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user email verification status by its unique ID.
     *
     * @param userId User ID.
     * @param emailVerification User email verification status.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEmailVerification(
        userId: String,
        emailVerification: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updateEmailVerification(
        userId,
        emailVerification,
        nestedType = classOf(),
    )

    /**
     * Update the user phone verification status by its unique ID.
     *
     * @param userId User ID.
     * @param phoneVerification User phone verification status.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updatePhoneVerification(
        userId: String,
        phoneVerification: Boolean,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val apiPath = "/users/{userId}/verification/phone"
            .replace("{userId}", userId)

        val apiParams = mutableMapOf<String, Any?>(
            "phoneVerification" to phoneVerification,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
            io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update the user phone verification status by its unique ID.
     *
     * @param userId User ID.
     * @param phoneVerification User phone verification status.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun updatePhoneVerification(
        userId: String,
        phoneVerification: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updatePhoneVerification(
        userId,
        phoneVerification,
        nestedType = classOf(),
    )

}