package io.appwrite.models

import com.google.gson.annotations.SerializedName
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
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "error" to error as Any,
        "required" to required as Any,
        "array" to array as Any,
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
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            error = map["error"] as String,
            required = map["required"] as Boolean,
            array = map["array"] as? Boolean?,
            relatedCollection = map["relatedCollection"] as String,
            relationType = map["relationType"] as String,
            twoWay = map["twoWay"] as Boolean,
            twoWayKey = map["twoWayKey"] as String,
            onDelete = map["onDelete"] as String,
            side = map["side"] as String,
        )
    }
}