package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Membership Privacy
 */
data class PolicyMembershipPrivacy(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Whether user ID is visible in memberships.
     */
    @SerializedName("userId")
    val userId: Boolean,

    /**
     * Whether user email is visible in memberships.
     */
    @SerializedName("userEmail")
    val userEmail: Boolean,

    /**
     * Whether user phone is visible in memberships.
     */
    @SerializedName("userPhone")
    val userPhone: Boolean,

    /**
     * Whether user name is visible in memberships.
     */
    @SerializedName("userName")
    val userName: Boolean,

    /**
     * Whether user MFA status is visible in memberships.
     */
    @SerializedName("userMFA")
    val userMFA: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "userEmail" to userEmail as Any,
        "userPhone" to userPhone as Any,
        "userName" to userName as Any,
        "userMFA" to userMFA as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyMembershipPrivacy(
            id = map["\$id"] as String,
            userId = map["userId"] as Boolean,
            userEmail = map["userEmail"] as Boolean,
            userPhone = map["userPhone"] as Boolean,
            userName = map["userName"] as Boolean,
            userMFA = map["userMFA"] as Boolean,
        )
    }
}