package io.appwrite.models

/// Users List
data class UserList(
    val sum: Long,
    val users: List<User>
) {
    companion object {
        fun from(map: Map<String, Any>) = UserList(
            sum = map["sum"] as Long,
            users = (map["users"] as List<Map<String, Any>>).map { User.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "users" to users.map { it.toMap() } as Any
    )
}