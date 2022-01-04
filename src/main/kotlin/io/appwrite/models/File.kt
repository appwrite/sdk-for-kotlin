package io.appwrite.models

/// File
data class File(
    val id: String,
    val read: List<Any>,
    val write: List<Any>,
    val name: String,
    val dateCreated: Long,
    val signature: String,
    val mimeType: String,
    val sizeOriginal: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = File(
            id = map["\$id"] as String,
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            signature = map["signature"] as String,
            mimeType = map["mimeType"] as String,
            sizeOriginal = map["sizeOriginal"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "signature" to signature as Any,
        "mimeType" to mimeType as Any,
        "sizeOriginal" to sizeOriginal as Any
    )
}