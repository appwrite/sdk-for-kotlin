package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy MFA Factors
 */
data class PolicyMfaFactors(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether TOTP can be used to complete an MFA challenge.
     */
    @SerializedName("totp")
    val totp: Boolean,

    /**
     * Whether email can be used to complete an MFA challenge.
     */
    @SerializedName("email")
    val email: Boolean,

    /**
     * Whether phone (SMS) can be used to complete an MFA challenge.
     */
    @SerializedName("phone")
    val phone: Boolean,

    /**
     * Whether the custom factor can be used to complete an MFA challenge.
     */
    @SerializedName("custom")
    val custom: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "totp" to totp as Any,
        "email" to email as Any,
        "phone" to phone as Any,
        "custom" to custom as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyMfaFactors(
            id = map["\$id"] as String,
            totp = map["totp"] as Boolean,
            email = map["email"] as Boolean,
            phone = map["phone"] as Boolean,
            custom = map["custom"] as Boolean,
        )
    }
}
