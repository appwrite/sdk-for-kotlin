package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password Pwned
 */
data class PolicyPasswordPwned(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether passwords are checked against known data breaches and the result recorded on the user.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Whether a sign-in with a breached password is refused until the password is reset.
     */
    @SerializedName("sessions")
    val sessions: Boolean,

    /**
     * Whether a breached password is rejected when a user signs up or sets a new password.
     */
    @SerializedName("users")
    val users: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "sessions" to sessions as Any,
        "users" to users as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasswordPwned(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            sessions = (if (map.containsKey("sessions")) map["sessions"] else false) as Boolean,
            users = (if (map.containsKey("users")) map["users"] else false) as Boolean,
        )
    }
}
