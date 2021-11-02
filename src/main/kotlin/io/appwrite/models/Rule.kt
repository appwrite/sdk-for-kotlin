package io.appwrite.models

/// Rule
data class Rule(
    val id: String,
    val collection: String,
    val type: String,
    val key: String,
    val label: String,
    val default: String,
    val array: Boolean,
    val required: Boolean,
    val list: List<Any>
) {
    companion object {
        fun from(map: Map<String, Any>) = Rule(
            id = map["\$id"] as String,
            collection = map["\$collection"] as String,
            type = map["type"] as String,
            key = map["key"] as String,
            label = map["label"] as String,
            default = map["default"] as String,
            array = map["array"] as Boolean,
            required = map["required"] as Boolean,
            list = map["list"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$collection" to collection as Any,
        "type" to type as Any,
        "key" to key as Any,
        "label" to label as Any,
        "default" to default as Any,
        "array" to array as Any,
        "required" to required as Any,
        "list" to list as Any
    )
}