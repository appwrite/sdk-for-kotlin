package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * User
 */
data class User<T>(
    /**
     * User ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * User update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Hashed user password.
     */
    @SerializedName("password")
    var password: String?,

    /**
     * Password hashing algorithm.
     */
    @SerializedName("hash")
    var hash: String?,

    /**
     * Password hashing algorithm configuration.
     */
    @SerializedName("hashOptions")
    var hashOptions: Any?,

    /**
     * User registration date in ISO 8601 format.
     */
    @SerializedName("registration")
    val registration: String,

    /**
     * User status. Pass `true` for enabled and `false` for disabled.
     */
    @SerializedName("status")
    val status: Boolean,

    /**
     * Password update time in ISO 8601 format.
     */
    @SerializedName("passwordUpdate")
    val passwordUpdate: String,

    /**
     * User email address.
     */
    @SerializedName("email")
    val email: String,

    /**
     * User phone number in E.164 format.
     */
    @SerializedName("phone")
    val phone: String,

    /**
     * Email verification status.
     */
    @SerializedName("emailVerification")
    val emailVerification: Boolean,

    /**
     * Phone verification status.
     */
    @SerializedName("phoneVerification")
    val phoneVerification: Boolean,

    /**
     * User preferences as a key-value object
     */
    @SerializedName("prefs")
    val prefs: Preferences<T>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "password" to password as Any,
        "hash" to hash as Any,
        "hashOptions" to hashOptions as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "phone" to phone as Any,
        "emailVerification" to emailVerification as Any,
        "phoneVerification" to phoneVerification as Any,
        "prefs" to prefs.toMap() as Any,
    )

    companion object {
        operator fun invoke(
            id: String,
            createdAt: String,
            updatedAt: String,
            name: String,
            password: String?,
            hash: String?,
            hashOptions: Any?,
            registration: String,
            status: Boolean,
            passwordUpdate: String,
            email: String,
            phone: String,
            emailVerification: Boolean,
            phoneVerification: Boolean,
            prefs: Preferences<Map<String, Any>>,
        ) = User<Map<String, Any>>(
            id,
            createdAt,
            updatedAt,
            name,
            password,
            hash,
            hashOptions,
            registration,
            status,
            passwordUpdate,
            email,
            phone,
            emailVerification,
            phoneVerification,
            prefs,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = User<T>(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            password = map["password"] as? String?,
            hash = map["hash"] as? String?,
            hashOptions = map["hashOptions"] as? Any?,
            registration = map["registration"] as String,
            status = map["status"] as Boolean,
            passwordUpdate = map["passwordUpdate"] as String,
            email = map["email"] as String,
            phone = map["phone"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            phoneVerification = map["phoneVerification"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>, nestedType),
        )
    }
}