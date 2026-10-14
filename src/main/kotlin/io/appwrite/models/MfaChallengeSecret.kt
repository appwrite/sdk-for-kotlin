package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * MFA Challenge Secret
 */
data class MfaChallengeSecret(
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
     * User ID.
     */
    @SerializedName("userId")
    val userId: String,

    /**
     * Token expiration date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * Challenge code to be delivered to the end user through a custom channel.
     */
    @SerializedName("code")
    val code: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
        "code" to code as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaChallengeSecret(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            code = (if (map.containsKey("code")) map["code"] else "") as String,
        )
    }
}
