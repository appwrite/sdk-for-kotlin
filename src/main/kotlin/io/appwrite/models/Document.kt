package io.appwrite.models

/// Document
data class Document(
    val id: String,
    val collection: String,
    val permissions: Permissions,
    val data: Map<String, Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = Document(
            id = map["\$id"] as String,
            collection = map["\$collection"] as String,
            permissions = Permissions.from(map = map["\$permissions"] as Map<String, Any>),
            data = map
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collection" to collection as Any,
        "\$permissions" to permissions.toMap() as Any,
        "data" to data
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T): T {
        return fromJson(data)
    }
}