package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Ephemeral Key
 */
data class EphemeralKey(
    /**
     * Key ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Key creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Key update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Key name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Key expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * Allowed permission scopes.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * Secret key.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerializedName("accessedAt")
    val accessedAt: String,

    /**
     * List of SDK user agents that used this key.
     */
    @SerializedName("sdks")
    val sdks: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "expire" to expire as Any,
        "scopes" to scopes as Any,
        "secret" to secret as Any,
        "accessedAt" to accessedAt as Any,
        "sdks" to sdks as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EphemeralKey(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            scopes = (if (map.containsKey("scopes")) map["scopes"] else listOf<Any?>()) as List<String>,
            secret = (if (map.containsKey("secret")) map["secret"] else "") as String,
            accessedAt = (if (map.containsKey("accessedAt")) map["accessedAt"] else "") as String,
            sdks = map["sdks"] as List<String>,
        )
    }
}
