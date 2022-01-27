package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Users List
 */
data class UserList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of users.
     *
     */
    @SerializedName("users")
    val users: List<User>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = UserList(
            sum = (map["sum"] as Number).toLong(),
            users = (map["users"] as List<Map<String, Any>>).map { User.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "users" to users.map { it.toMap() } as Any
    )
}