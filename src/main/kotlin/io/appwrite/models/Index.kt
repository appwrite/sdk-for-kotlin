package io.appwrite.models

/// Index
data class Index(
    val key: String,
    val type: String,
    val status: String,
    val attributes: List<Any>,
    val orders: List<Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = Index(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            attributes = map["attributes"] as List<Any>,
            orders = map["orders"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "attributes" to attributes as Any,
        "orders" to orders as Any
    )
}