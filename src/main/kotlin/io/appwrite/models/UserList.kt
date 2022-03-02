package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Users List
 */
data class UserList(
    /**
     * Total number of users documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

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
            total = (map["total"] as Number).toLong(),
            users = (map["users"] as List<Map<String, Any>>).map { User.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "users" to users.map { it.toMap() } as Any
    )
}