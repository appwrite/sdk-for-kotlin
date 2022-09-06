package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Account
 */
data class Account(
    /**
     * User ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * User creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * User update date in ISO 8601 format.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * User name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * User registration date in ISO 8601 format.
     *
     */
    @SerializedName("registration")
    val registration: String,

    /**
     * User status. Pass `true` for enabled and `false` for disabled.
     *
     */
    @SerializedName("status")
    val status: Boolean,

    /**
     * Password update time in ISO 8601 format.
     *
     */
    @SerializedName("passwordUpdate")
    val passwordUpdate: String,

    /**
     * User email address.
     *
     */
    @SerializedName("email")
    val email: String,

    /**
     * User phone number in E.164 format.
     *
     */
    @SerializedName("phone")
    val phone: String,

    /**
     * Email verification status.
     *
     */
    @SerializedName("emailVerification")
    val emailVerification: Boolean,

    /**
     * Phone verification status.
     *
     */
    @SerializedName("phoneVerification")
    val phoneVerification: Boolean,

    /**
     * User preferences as a key-value object
     *
     */
    @SerializedName("prefs")
    val prefs: Preferences
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Account(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            registration = map["registration"] as String,
            status = map["status"] as Boolean,
            passwordUpdate = map["passwordUpdate"] as String,
            email = map["email"] as String,
            phone = map["phone"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            phoneVerification = map["phoneVerification"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>)
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "phone" to phone as Any,
        "emailVerification" to emailVerification as Any,
        "phoneVerification" to phoneVerification as Any,
        "prefs" to prefs.toMap() as Any
    )
}
