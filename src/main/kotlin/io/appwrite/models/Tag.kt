package io.appwrite.models

/// Tag
data class Tag(
    val id: String,
    val functionId: String,
    val dateCreated: Long,
    val command: String,
    val size: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Tag(
            id = map["\$id"] as String,
            functionId = map["functionId"] as String,
            dateCreated = map["dateCreated"] as Long,
            command = map["command"] as String,
            size = map["size"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "functionId" to functionId as Any,
        "dateCreated" to dateCreated as Any,
        "command" to command as Any,
        "size" to size as Any
    )
}