package io.appwrite.models

/// Attributes List
data class AttributeList(
    val sum: Long,
    val attributes: List<Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeList(
            sum = map["sum"] as Long,
            attributes = map["attributes"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "attributes" to attributes as Any
    )
}