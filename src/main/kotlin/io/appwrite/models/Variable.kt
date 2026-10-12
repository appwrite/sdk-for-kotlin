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
    fun toMap(): Map<String, Any?> = mapOf(
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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            value = (if (map.containsKey("value")) map["value"] else "") as String,
            secret = (if (map.containsKey("secret")) map["secret"] else false) as Boolean,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
        )
    }
}
