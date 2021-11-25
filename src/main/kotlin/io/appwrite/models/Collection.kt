package io.appwrite.models

/// Collection
data class Collection(
    val id: String,
    val read: List<Any>,
    val write: List<Any>,
    val name: String,
    val permission: String,
    val attributes: List<Any>,
    val indexes: List<Index>
) {
    companion object {
        fun from(map: Map<String, Any>) = Collection(
            id = map["\$id"] as String,
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            name = map["name"] as String,
            permission = map["permission"] as String,
            attributes = map["attributes"] as List<Any>,
            indexes = (map["indexes"] as List<Map<String, Any>>).map { Index.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "name" to name as Any,
        "permission" to permission as Any,
        "attributes" to attributes as Any,
        "indexes" to indexes.map { it.toMap() } as Any
    )
}