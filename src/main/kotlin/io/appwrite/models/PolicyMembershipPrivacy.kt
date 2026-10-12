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

    /**
     * Whether user last access time is visible in memberships.
     */
    @SerializedName("userAccessedAt")
    val userAccessedAt: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "userEmail" to userEmail as Any,
        "userPhone" to userPhone as Any,
        "userName" to userName as Any,
        "userMFA" to userMFA as Any,
        "userAccessedAt" to userAccessedAt as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyMembershipPrivacy(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else false) as Boolean,
            userEmail = (if (map.containsKey("userEmail")) map["userEmail"] else false) as Boolean,
            userPhone = (if (map.containsKey("userPhone")) map["userPhone"] else false) as Boolean,
            userName = (if (map.containsKey("userName")) map["userName"] else false) as Boolean,
            userMFA = (if (map.containsKey("userMFA")) map["userMFA"] else false) as Boolean,
            userAccessedAt = (if (map.containsKey("userAccessedAt")) map["userAccessedAt"] else false) as Boolean,
        )
    }
}
