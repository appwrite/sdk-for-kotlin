package io.appwrite.models

/// Memberships List
data class MembershipList(
    val sum: Long,
    val memberships: List<Membership>
) {
    companion object {
        fun from(map: Map<String, Any>) = MembershipList(
            sum = map["sum"] as Long,
            memberships = (map["memberships"] as List<Map<String, Any>>).map { Membership.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "memberships" to memberships.map { it.toMap() } as Any
    )
}