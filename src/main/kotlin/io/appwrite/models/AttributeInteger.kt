package io.appwrite.models

/// AttributeInteger
data class AttributeInteger(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    val array: Boolean,
    val min: Long,
    val max: Long,
    val default: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeInteger(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as Boolean,
            min = map["min"] as Long,
            max = map["max"] as Long,
            default = map["default"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "required" to required as Any,
        "array" to array as Any,
        "min" to min as Any,
        "max" to max as Any,
        "default" to default as Any
    )
}