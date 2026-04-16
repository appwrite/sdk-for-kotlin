package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Block
 */
data class Block(
    /**
     * Block creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Resource type that is blocked
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * Resource identifier that is blocked
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Reason for the block. Can be null if no reason was provided.
     */
    @SerializedName("reason")
    var reason: String?,

    /**
     * Block expiration date in ISO 8601 format. Can be null if the block does not expire.
     */
    @SerializedName("expiredAt")
    var expiredAt: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$createdAt" to createdAt as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "reason" to reason as Any,
        "expiredAt" to expiredAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Block(
            createdAt = map["\$createdAt"] as String,
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
            reason = map["reason"] as? String,
            expiredAt = map["expiredAt"] as? String,
        )
    }
}