package io.appwrite.models

/// Sessions List
data class SessionList(
    val sum: Long,
    val sessions: List<Session>
) {
    companion object {
        fun from(map: Map<String, Any>) = SessionList(
            sum = map["sum"] as Long,
            sessions = (map["sessions"] as List<Map<String, Any>>).map { Session.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "sessions" to sessions.map { it.toMap() } as Any
    )
}