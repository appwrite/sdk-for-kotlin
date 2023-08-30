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
     * Service to which the variable belongs. Possible values are &quot;project&quot;, &quot;function&quot;
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * ID of resource to which the variable belongs. If resourceType is &quot;project&quot;, it is empty. If resourceType is &quot;function&quot;, it is ID of the function.
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
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
        )
    }
}