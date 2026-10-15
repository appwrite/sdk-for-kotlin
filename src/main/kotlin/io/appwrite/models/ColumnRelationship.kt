package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.ColumnStatus
import io.appwrite.extensions.jsonCast

/**
 * ColumnRelationship
 */
data class ColumnRelationship(
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
     * The ID of the related table.
     */
    @SerializedName("relatedTable")
    val relatedTable: String,

    /**
     * The type of the relationship.
     */
    @SerializedName("relationType")
    val relationType: String,

    /**
     * Is the relationship two-way?
     */
    @SerializedName("twoWay")
    val twoWay: Boolean,

    /**
     * The key of the two-way relationship.
     */
    @SerializedName("twoWayKey")
    val twoWayKey: String,

    /**
     * How deleting the parent document will propagate to child documents.
     */
    @SerializedName("onDelete")
    val onDelete: String,

    /**
     * Whether this is the parent or child side of the relationship
     */
    @SerializedName("side")
    val side: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any?,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "relatedTable" to relatedTable as Any,
        "relationType" to relationType as Any,
        "twoWay" to twoWay as Any,
        "twoWayKey" to twoWayKey as Any,
        "onDelete" to onDelete as Any,
        "side" to side as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnRelationship(
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            status = ColumnStatus.values().find { it.value == map["status"] as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            required = (if (map.containsKey("required")) map["required"] else false) as Boolean,
            array = map["array"] as? Boolean,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            relatedTable = map["relatedTable"] as String,
            relationType = (if (map.containsKey("relationType")) map["relationType"] else "") as String,
            twoWay = (if (map.containsKey("twoWay")) map["twoWay"] else false) as Boolean,
            twoWayKey = (if (map.containsKey("twoWayKey")) map["twoWayKey"] else "") as String,
            onDelete = (if (map.containsKey("onDelete")) map["onDelete"] else "restrict") as String,
            side = (if (map.containsKey("side")) map["side"] else "") as String,
        )
    }
}
