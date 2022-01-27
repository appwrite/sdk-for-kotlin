package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AttributeFloat
 */
data class AttributeFloat(
    /**
     * Attribute Key.
     *
     */
    @SerializedName("key")
    val key: String,

    /**
     * Attribute type.
     *
     */
    @SerializedName("type")
    val type: String,

    /**
     * Attribute status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     *
     */
    @SerializedName("status")
    val status: String,

    /**
     * Is attribute required?
     *
     */
    @SerializedName("required")
    val required: Boolean,

    /**
     * Is attribute an array?
     *
     */
    @SerializedName("array")
    var array: Boolean?,

    /**
     * Minimum value to enforce for new documents.
     *
     */
    @SerializedName("min")
    var min: Double?,

    /**
     * Maximum value to enforce for new documents.
     *
     */
    @SerializedName("max")
    var max: Double?,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     *
     */
    @SerializedName("default")
    var default: Double?
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AttributeFloat(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            min = (map["min"] as? Number)?.toDouble(),
            max = (map["max"] as? Number)?.toDouble(),
            default = (map["default"] as? Number)?.toDouble()
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