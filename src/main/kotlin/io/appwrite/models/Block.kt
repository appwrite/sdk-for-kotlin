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
     * Block mode. full blocks reads and writes; readOnly blocks writes only.
     */
    @SerializedName("mode")
    val mode: String,

    /**
     * Block expiration date in ISO 8601 format. Can be null if the block does not expire.
     */
    @SerializedName("expiredAt")
    var expiredAt: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$createdAt" to createdAt as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "mode" to mode as Any,
        "expiredAt" to expiredAt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Block(
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            mode = (if (map.containsKey("mode")) map["mode"] else "full") as String,
            expiredAt = map["expiredAt"] as? String,
        )
    }
}
