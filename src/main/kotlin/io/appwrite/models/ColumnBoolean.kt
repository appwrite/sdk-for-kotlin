package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * ColumnBoolean
 */
data class ColumnBoolean(
    /**
     * Column Key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Column type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Column status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerializedName("status")
    val status: String,

    /**
     * Error message. Displays error generated on failure of creating or deleting an column.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Is column required?
     */
    @SerializedName("required")
    val required: Boolean,

    /**
     * Is column an array?
     */
    @SerializedName("array")
    var array: Boolean?,

    /**
     * Column creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Column update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Default value for column when not provided. Cannot be set when column is required.
     */
    @SerializedName("default")
    var default: Boolean?,

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
        "default" to default as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnBoolean(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            error = map["error"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean?,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            default = map["default"] as? Boolean?,
        )
    }
}