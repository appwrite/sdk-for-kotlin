package io.appwrite.models

/// AttributeBoolean
data class AttributeBoolean(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    var array: Boolean? = ,
    var default: Boolean? = 
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeBoolean(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            default = map["default"] as? Boolean
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "required" to required as Any,
        "array" to array as Any,
        "default" to default as Any
    )
}