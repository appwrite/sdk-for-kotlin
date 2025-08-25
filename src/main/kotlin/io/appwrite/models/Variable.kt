package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Variable
 */
data class Variable(
    /**
     * Variable ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Variable key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Variable value.
     */
    @SerializedName("value")
    val value: String,

    /**
     * Variable secret flag. Secret variables can only be updated or deleted, but never read.
     */
    @SerializedName("secret")
    val secret: Boolean,

    /**
     * Service to which the variable belongs. Possible values are "project", "function"
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * ID of resource to which the variable belongs. If resourceType is "project", it is empty. If resourceType is "function", it is ID of the function.
     */
    @SerializedName("resourceId")
    val resourceId: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "key" to key as Any,
        "value" to value as Any,
        "secret" to secret as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Variable(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            key = map["key"] as String,
            value = map["value"] as String,
            secret = map["secret"] as Boolean,
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
        )
    }
}