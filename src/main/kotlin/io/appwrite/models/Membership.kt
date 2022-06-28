package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Membership
 */
data class Membership(
    /**
     * Membership ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Membership creation date in Unix timestamp.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: Long,

    /**
     * Membership update date in Unix timestamp.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: Long,

    /**
     * User ID.
     *
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * User name.
     *
     */
    @SerializedName("userName")
    val userName: String,

    /**
     * User email address.
     *
     */
    @SerializedName("userEmail")
    val userEmail: String,

    /**
     * Team ID.
     *
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Team name.
     *
     */
    @SerializedName("teamName")
    val teamName: String,

    /**
     * Date, the user has been invited to join the team in Unix timestamp.
     *
     */
    @SerializedName("invited")
    val invited: Long,

    /**
     * Date, the user has accepted the invitation to join the team in Unix timestamp.
     *
     */
    @SerializedName("joined")
    val joined: Long,

    /**
     * User confirmation status, true if the user has joined the team or false otherwise.
     *
     */
    @SerializedName("confirm")
    val confirm: Boolean,

    /**
     * User list of roles
     *
     */
    @SerializedName("roles")
    val roles: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Membership(
            id = map["\$id"] as String,
            createdAt = (map["\$createdAt"] as Number).toLong(),
            updatedAt = (map["\$updatedAt"] as Number).toLong(),
            userId = map["userId"] as String,
            userName = map["userName"] as String,
            userEmail = map["userEmail"] as String,
            teamId = map["teamId"] as String,
            teamName = map["teamName"] as String,
            invited = (map["invited"] as Number).toLong(),
            joined = (map["joined"] as Number).toLong(),
            confirm = map["confirm"] as Boolean,
            roles = map["roles"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "userName" to userName as Any,
        "userEmail" to userEmail as Any,
        "teamId" to teamId as Any,
        "teamName" to teamName as Any,
        "invited" to invited as Any,
        "joined" to joined as Any,
        "confirm" to confirm as Any,
        "roles" to roles as Any
    )
}