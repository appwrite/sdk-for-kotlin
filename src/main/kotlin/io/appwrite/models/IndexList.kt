package io.appwrite.models

/// Indexes List
data class IndexList(
    val sum: Long,
    val indexes: List<Index>
) {
    companion object {
        fun from(map: Map<String, Any>) = IndexList(
            sum = map["sum"] as Long,
            indexes = (map["indexes"] as List<Map<String, Any>>).map { Index.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "indexes" to indexes.map { it.toMap() } as Any
    )
}