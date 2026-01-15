package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * ResourceToken
 */
data class ResourceToken(
    /**
     * Token ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Token creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Resource ID.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Resource type.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * Token expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * JWT encoded string.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "expire" to expire as Any,
        "secret" to secret as Any,
        "accessedAt" to accessedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ResourceToken(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            resourceId = map["resourceId"] as String,
            resourceType = map["resourceType"] as String,
            expire = map["expire"] as String,
            secret = map["secret"] as String,
            accessedAt = map["accessedAt"] as String,
        )
    }
}