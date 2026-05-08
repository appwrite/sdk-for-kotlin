package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Presence
 */
data class Presence<T>(
    /**
     * Presence ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Presence sequence ID.
     */
    @SerializedName("\$sequence")
    val sequence: String,

    /**
     * Presence creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Presence update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Presence permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * User internal ID.
     */
    @SerializedName("userInternalId")
    val userInternalId: String,

    /**
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Presence status.
     */
    @SerializedName("status")
    var status: String?,

    /**
     * Presence source.
     */
    @SerializedName("source")
    val source: String,

    /**
     * Presence expiry date in ISO 8601 format.
     */
    @SerializedName("expiresAt")
    var expiresAt: String?,

    /**
     * Additional properties
     */
    @SerializedName("data")
    val data: T
) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$sequence" to sequence as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "userInternalId" to userInternalId as Any,
        "userId" to userId as Any,
        "status" to status as Any,
        "source" to source as Any,
        "expiresAt" to expiresAt as Any,
        "data" to data!!.jsonCast(to = Map::class.java)
    )

    companion object {
        operator fun invoke(
            id: String,
            sequence: String,
            createdAt: String,
            updatedAt: String,
            permissions: List<String>,
            userInternalId: String,
            userId: String,
            status: String?,
            source: String,
            expiresAt: String?,
            data: Map<String, Any>
        ) = Presence<Map<String, Any>>(
            id,
            sequence,
            createdAt,
            updatedAt,
            permissions,
            userInternalId,
            userId,
            status,
            source,
            expiresAt,
            data
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = Presence<T>(
            id = map["\$id"] as String,
            sequence = map["\$sequence"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            userInternalId = map["userInternalId"] as String,
            userId = map["userId"] as String,
            status = map["status"] as? String,
            source = map["source"] as String,
            expiresAt = map["expiresAt"] as? String,
            data = map["data"]?.jsonCast(to = nestedType) ?: map.jsonCast(to = nestedType)
        )
    }
}