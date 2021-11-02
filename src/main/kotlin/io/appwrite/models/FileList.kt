package io.appwrite.models

/// Files List
data class FileList(
    val sum: Long,
    val files: List<File>
) {
    companion object {
        fun from(map: Map<String, Any>) = FileList(
            sum = map["sum"] as Long,
            files = (map["files"] as List<Map<String, Any>>).map { File.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "files" to files.map { it.toMap() } as Any
    )
}