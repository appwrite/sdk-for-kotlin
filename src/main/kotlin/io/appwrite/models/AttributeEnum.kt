package io.appwrite.models

/// AttributeEnum
data class AttributeEnum(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    var array: Boolean? = ,
    val elements: List<Any>,
    val format: String,
    var default: String? = 
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeEnum(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            elements = map["elements"] as List<Any>,
            format = map["format"] as String,
            default = map["default"] as? String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "required" to required as Any,
        "array" to array as Any,
        "elements" to elements as Any,
        "format" to format as Any,
        "default" to default as Any
    )
}