package io.appwrite.models

/// AttributeString
data class AttributeString(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    val array: Boolean,
    val size: String,
    val default: String
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeString(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as Boolean,
            size = map["size"] as String,
            default = map["default"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "required" to required as Any,
        "array" to array as Any,
        "size" to size as Any,
        "default" to default as Any
    )
}