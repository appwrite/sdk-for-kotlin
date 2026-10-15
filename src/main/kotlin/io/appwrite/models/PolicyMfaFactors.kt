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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            totp = (if (map.containsKey("totp")) map["totp"] else true) as Boolean,
            email = (if (map.containsKey("email")) map["email"] else true) as Boolean,
            phone = (if (map.containsKey("phone")) map["phone"] else true) as Boolean,
            custom = (if (map.containsKey("custom")) map["custom"] else false) as Boolean,
        )
    }
}
