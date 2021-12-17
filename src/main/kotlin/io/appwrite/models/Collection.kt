package io.appwrite.models

/// Collection
data class Collection(
    val id: String,
    val permissions: Permissions,
    val name: String,
    val dateCreated: Long,
    val dateUpdated: Long,
    val rules: List<Rule>
) {
    companion object {
        fun from(map: Map<String, Any>) = Collection(
            id = map["\$id"] as String,
            permissions = Permissions.from(map = map["\$permissions"] as Map<String, Any>),
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            dateUpdated = map["dateUpdated"] as Long,
            rules = (map["rules"] as List<Map<String, Any>>).map { Rule.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$permissions" to permissions.toMap() as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "dateUpdated" to dateUpdated as Any,
        "rules" to rules.map { it.toMap() } as Any
    )
}