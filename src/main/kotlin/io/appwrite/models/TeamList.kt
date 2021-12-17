package io.appwrite.models

/// Teams List
data class TeamList(
    val sum: Long,
    val teams: List<Team>
) {
    companion object {
        fun from(map: Map<String, Any>) = TeamList(
            sum = map["sum"] as Long,
            teams = (map["teams"] as List<Map<String, Any>>).map { Team.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "teams" to teams.map { it.toMap() } as Any
    )
}