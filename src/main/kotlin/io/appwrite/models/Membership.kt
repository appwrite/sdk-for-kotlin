package io.appwrite.models

/// Membership
data class Membership(
    val id: String,
    val userId: String,
    val teamId: String,
    val name: String,
    val email: String,
    val invited: Long,
    val joined: Long,
    val confirm: Boolean,
    val roles: List<Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = Membership(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            teamId = map["teamId"] as String,
            name = map["name"] as String,
            email = map["email"] as String,
            invited = map["invited"] as Long,
            joined = map["joined"] as Long,
            confirm = map["confirm"] as Boolean,
            roles = map["roles"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "teamId" to teamId as Any,
        "name" to name as Any,
        "email" to email as Any,
        "invited" to invited as Any,
        "joined" to joined as Any,
        "confirm" to confirm as Any,
        "roles" to roles as Any
    )
}