package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Users service allows you to manage your project users.
**/
class Users : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Users
     *
     * Get a list of all the project&#039;s users. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, email, phone, status, passwordUpdate, registration, emailVerification, phoneVerification
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
        val path = "/users"

        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.UserList<T> = {
                io.appwrite.models.UserList.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * List Users
     *
     * Get a list of all the project&#039;s users. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, email, phone, status, passwordUpdate, registration, emailVerification, phoneVerification
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.UserList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ) = list(
        queries,
        search,
        nestedType = classOf(),
    )

    /**
     * Create User
     *
     * Create a new user.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "phone" to phone,
            "password" to password,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User
     *
     * Create a new user.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = create(
        userId,
        email,
        phone,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create User with Argon2 Password
     *
     * Create a new user. Password provided must be hashed with the [Argon2](https://en.wikipedia.org/wiki/Argon2) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/argon2"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with Argon2 Password
     *
     * Create a new user. Password provided must be hashed with the [Argon2](https://en.wikipedia.org/wiki/Argon2) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createArgon2User(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create User with Bcrypt Password
     *
     * Create a new user. Password provided must be hashed with the [Bcrypt](https://en.wikipedia.org/wiki/Bcrypt) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/bcrypt"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with Bcrypt Password
     *
     * Create a new user. Password provided must be hashed with the [Bcrypt](https://en.wikipedia.org/wiki/Bcrypt) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createBcryptUser(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create User with MD5 Password
     *
     * Create a new user. Password provided must be hashed with the [MD5](https://en.wikipedia.org/wiki/MD5) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/md5"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with MD5 Password
     *
     * Create a new user. Password provided must be hashed with the [MD5](https://en.wikipedia.org/wiki/MD5) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createMD5User(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create User with PHPass Password
     *
     * Create a new user. Password provided must be hashed with the [PHPass](https://www.openwall.com/phpass/) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()`to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/phpass"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with PHPass Password
     *
     * Create a new user. Password provided must be hashed with the [PHPass](https://www.openwall.com/phpass/) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()`to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createPHPassUser(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )

    /**
     * Create User with Scrypt Password
     *
     * Create a new user. Password provided must be hashed with the [Scrypt](https://github.com/Tarsnap/scrypt) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/scrypt"

        val params = mutableMapOf<String, Any?>(
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
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with Scrypt Password
     *
     * Create a new user. Password provided must be hashed with the [Scrypt](https://github.com/Tarsnap/scrypt) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createScryptUser(
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
     * Create User with Scrypt Modified Password
     *
     * Create a new user. Password provided must be hashed with the [Scrypt Modified](https://gist.github.com/Meldiron/eecf84a0225eccb5a378d45bb27462cc) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        val path = "/users/scrypt-modified"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "passwordSalt" to passwordSalt,
            "passwordSaltSeparator" to passwordSaltSeparator,
            "passwordSignerKey" to passwordSignerKey,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with Scrypt Modified Password
     *
     * Create a new user. Password provided must be hashed with the [Scrypt Modified](https://gist.github.com/Meldiron/eecf84a0225eccb5a378d45bb27462cc) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
    ) = createScryptModifiedUser(
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
     * Create User with SHA Password
     *
     * Create a new user. Password provided must be hashed with the [SHA](https://en.wikipedia.org/wiki/Secure_Hash_Algorithm) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        passwordVersion: String? = null,
        name: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val path = "/users/sha"

        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
            "passwordVersion" to passwordVersion,
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create User with SHA Password
     *
     * Create a new user. Password provided must be hashed with the [SHA](https://en.wikipedia.org/wiki/Secure_Hash_Algorithm) algorithm. Use the [POST /users](/docs/server/users#usersCreate) endpoint to create users with a plain text password.
     *
     * @param userId User ID. Choose your own unique ID or pass the string `ID.unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
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
        passwordVersion: String? = null,
        name: String? = null,
    ) = createSHAUser(
        userId,
        email,
        password,
        passwordVersion,
        name,
        nestedType = classOf(),
    )

    /**
     * Get User
     *
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
        val path = "/users/{userId}"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get User
     *
     * Get a user by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        userId: String,
    ) = get(
        userId,
        nestedType = classOf(),
    )

    /**
     * Delete User
     *
     * Delete a user by its unique ID, thereby releasing it&#039;s ID. Since ID is released and can be reused, all user-related resources like documents or storage files should be deleted before user deletion. If you want to keep ID reserved, use the [updateStatus](/docs/server/users#usersUpdateStatus) endpoint instead.
     *
     * @param userId User ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        userId: String,
    ): Any {
        val path = "/users/{userId}"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
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
     * @return [io.appwrite.models.User<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> updateEmail(
        userId: String,
        email: String,
        nestedType: Class<T>,
    ): io.appwrite.models.User<T> {
        val path = "/users/{userId}/email"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "email" to email,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Email
     *
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
    ) = updateEmail(
        userId,
        email,
        nestedType = classOf(),
    )

    /**
     * List User Logs
     *
     * Get the user activity logs list by its unique ID.
     *
     * @param userId User ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listLogs(
        userId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val path = "/users/{userId}/logs"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
                io.appwrite.models.LogList.from(map = it as Map<String, Any>)
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
     * List User Memberships
     *
     * Get the user membership list by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.MembershipList]
     */
    @Throws(AppwriteException::class)
    suspend fun listMemberships(
        userId: String,
    ): io.appwrite.models.MembershipList {
        val path = "/users/{userId}/memberships"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MembershipList = {
                io.appwrite.models.MembershipList.from(map = it as Map<String, Any>)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.MembershipList::class.java,
            converter,
        )
    }

    /**
     * Update Name
     *
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
        val path = "/users/{userId}/name"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Name
     *
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
    ) = updateName(
        userId,
        name,
        nestedType = classOf(),
    )

    /**
     * Update Password
     *
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
        val path = "/users/{userId}/password"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "password" to password,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Password
     *
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
    ) = updatePassword(
        userId,
        password,
        nestedType = classOf(),
    )

    /**
     * Update Phone
     *
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
        val path = "/users/{userId}/phone"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "number" to number,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Phone
     *
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
    ) = updatePhone(
        userId,
        number,
        nestedType = classOf(),
    )

    /**
     * Get User Preferences
     *
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
        val path = "/users/{userId}/prefs"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
                io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get User Preferences
     *
     * Get the user preferences by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.Preferences<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun getPrefs(
        userId: String,
    ) = getPrefs(
        userId,
        nestedType = classOf(),
    )

    /**
     * Update User Preferences
     *
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
        val path = "/users/{userId}/prefs"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "prefs" to prefs,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Preferences<T> = {
                io.appwrite.models.Preferences.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update User Preferences
     *
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
    ) = updatePrefs(
        userId,
        prefs,
        nestedType = classOf(),
    )

    /**
     * List User Sessions
     *
     * Get the user sessions list by its unique ID.
     *
     * @param userId User ID.
     * @return [io.appwrite.models.SessionList]
     */
    @Throws(AppwriteException::class)
    suspend fun listSessions(
        userId: String,
    ): io.appwrite.models.SessionList {
        val path = "/users/{userId}/sessions"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.SessionList = {
                io.appwrite.models.SessionList.from(map = it as Map<String, Any>)
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
     * Delete User Sessions
     *
     * Delete all user&#039;s sessions by using the user&#039;s unique ID.
     *
     * @param userId User ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteSessions(
        userId: String,
    ): Any {
        val path = "/users/{userId}/sessions"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
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
    @Throws(AppwriteException::class)
    suspend fun deleteSession(
        userId: String,
        sessionId: String,
    ): Any {
        val path = "/users/{userId}/sessions/{sessionId}"
            .replace("{userId}", userId)
            .replace("{sessionId}", sessionId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
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
        val path = "/users/{userId}/status"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "status" to status,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update User Status
     *
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
    ) = updateStatus(
        userId,
        status,
        nestedType = classOf(),
    )

    /**
     * Update Email Verification
     *
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
        val path = "/users/{userId}/verification"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "emailVerification" to emailVerification,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Email Verification
     *
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
    ) = updateEmailVerification(
        userId,
        emailVerification,
        nestedType = classOf(),
    )

    /**
     * Update Phone Verification
     *
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
        val path = "/users/{userId}/verification/phone"
            .replace("{userId}", userId)

        val params = mutableMapOf<String, Any?>(
            "phoneVerification" to phoneVerification,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.User<T> = {
                io.appwrite.models.User.from(map = it as Map<String, Any>, nestedType)
                }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update Phone Verification
     *
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
    ) = updatePhoneVerification(
        userId,
        phoneVerification,
        nestedType = classOf(),
    )

}