package io.appwrite.models

/// AttributeURL
data class AttributeUrl(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    var array: Boolean? = ,
    val format: String,
    var default: String? = 
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeUrl(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
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
        "format" to format as Any,
        "default" to default as Any
    )
}