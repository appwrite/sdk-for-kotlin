package io.appwrite.models

/// Team
data class Team(
    val id: String,
    val name: String,
    val dateCreated: Long,
    val sum: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = Team(
            id = map["\$id"] as String,
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            sum = map["sum"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "sum" to sum as Any
    )
}