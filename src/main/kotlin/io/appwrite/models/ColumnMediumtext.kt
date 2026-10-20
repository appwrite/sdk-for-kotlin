package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.ColumnStatus
import io.appwrite.extensions.jsonCast

/**
 * ColumnMediumtext
 */
data class ColumnMediumtext(
    /**
     * Column Key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Optional description for the column.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Column type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Column status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerializedName("status")
    val status: ColumnStatus,

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
    var default: String?,

    /**
     * Defines whether this column is encrypted or not.
     */
    @SerializedName("encrypt")
    var encrypt: Boolean?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "key" to key as Any,
        "description" to description as Any,
        "type" to type as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any?,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "default" to default as Any?,
        "encrypt" to encrypt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnMediumtext(
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            status = ColumnStatus.values().find { it.value == map["status"] as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            required = (if (map.containsKey("required")) map["required"] else false) as Boolean,
            array = map["array"] as? Boolean,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            default = map["default"] as? String,
            encrypt = map["encrypt"] as? Boolean,
        )
    }
}
