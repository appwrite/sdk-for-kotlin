package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.AttributeStatus

/**
 * AttributeInteger
 */
data class AttributeInteger(
    /**
     * Attribute Key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Attribute type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Attribute status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerializedName("status")
    val status: AttributeStatus,

    /**
     * Error message. Displays error generated on failure of creating or deleting an attribute.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Is attribute required?
     */
    @SerializedName("required")
    val required: Boolean,

    /**
     * Is attribute an array?
     */
    @SerializedName("array")
    var array: Boolean?,

    /**
     * Attribute creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Attribute update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Minimum value to enforce for new documents.
     */
    @SerializedName("min")
    var min: Long?,

    /**
     * Maximum value to enforce for new documents.
     */
    @SerializedName("max")
    var max: Long?,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     */
    @SerializedName("default")
    var default: Long?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "min" to min as Any,
        "max" to max as Any,
        "default" to default as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AttributeInteger(
            key = map["key"] as String,
            type = map["type"] as String,
            status = AttributeStatus.values().find { it.value == map["status"] as String }!!,
            error = map["error"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            min = (map["min"] as? Number)?.toLong(),
            max = (map["max"] as? Number)?.toLong(),
            default = (map["default"] as? Number)?.toLong(),
        )
    }
}