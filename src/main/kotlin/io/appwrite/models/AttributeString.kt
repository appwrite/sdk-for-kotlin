package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AttributeString
 */
data class AttributeString(
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
    val status: String,

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
     * Attribute size.
     */
    @SerializedName("size")
    val size: Long,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     */
    @SerializedName("default")
    var default: String?,

    /**
     * Defines whether this attribute is encrypted or not.
     */
    @SerializedName("encrypt")
    var encrypt: Boolean?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "size" to size as Any,
        "default" to default as Any,
        "encrypt" to encrypt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AttributeString(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            error = map["error"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean?,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            size = (map["size"] as Number).toLong(),
            default = map["default"] as? String?,
            encrypt = map["encrypt"] as? Boolean?,
        )
    }
}