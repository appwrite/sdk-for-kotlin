package io.appwrite.models

/// Documents List
data class DocumentList(
    val sum: Long,
    val documents: List<Document>
) {
    companion object {
        fun from(map: Map<String, Any>) = DocumentList(
            sum = map["sum"] as Long,
            documents = (map["documents"] as List<Map<String, Any>>).map { Document.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "documents" to documents.map { it.toMap() } as Any
    )

    fun <T> convertTo(fromJson: (Map<String, Any>) -> T) =
        documents.map { it.convertTo(fromJson = fromJson) }
}