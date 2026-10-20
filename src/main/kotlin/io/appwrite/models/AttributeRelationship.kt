package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.AttributeStatus
import io.appwrite.extensions.jsonCast

/**
 * AttributeRelationship
 */
data class AttributeRelationship(
    /**
     * Attribute Key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Optional description for the attribute.
     */
    @SerializedName("description")
    val description: String,

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
     * The ID of the related collection.
     */
    @SerializedName("relatedCollection")
    val relatedCollection: String,

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
        "description" to description as Any,
        "type" to type as Any,
        "status" to status.value as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any?,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "relatedCollection" to relatedCollection as Any,
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
        ) = AttributeRelationship(
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            status = AttributeStatus.values().find { it.value == map["status"] as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            required = (if (map.containsKey("required")) map["required"] else false) as Boolean,
            array = map["array"] as? Boolean,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            relatedCollection = map["relatedCollection"] as String,
            relationType = (if (map.containsKey("relationType")) map["relationType"] else "") as String,
            twoWay = (if (map.containsKey("twoWay")) map["twoWay"] else false) as Boolean,
            twoWayKey = (if (map.containsKey("twoWayKey")) map["twoWayKey"] else "") as String,
            onDelete = (if (map.containsKey("onDelete")) map["onDelete"] else "restrict") as String,
            side = (if (map.containsKey("side")) map["side"] else "") as String,
        )
    }
}
