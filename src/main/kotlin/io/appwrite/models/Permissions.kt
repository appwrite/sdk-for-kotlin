package io.appwrite.models

/// Permissions
data class Permissions(
    val read: List<Any>,
    val write: List<Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = Permissions(
            read = map["read"] as List<Any>,
            write = map["write"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "read" to read as Any,
        "write" to write as Any
    )
}