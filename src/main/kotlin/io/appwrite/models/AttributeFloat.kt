package io.appwrite.models

/// AttributeFloat
data class AttributeFloat(
    val key: String,
    val type: String,
    val status: String,
    val required: Boolean,
    val array: Boolean,
    val min: Double,
    val max: Double,
    val default: Double
) {
    companion object {
        fun from(map: Map<String, Any>) = AttributeFloat(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as Boolean,
            min = map["min"] as Double,
            max = map["max"] as Double,
            default = map["default"] as Double
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