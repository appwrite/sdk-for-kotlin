package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AttributeURL
 */
data class AttributeUrl(
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
     * String format.
     *
     */
    @SerializedName("format")
    val format: String,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     *
     */
    @SerializedName("default")
    var default: String?
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
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