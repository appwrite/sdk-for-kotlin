package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Environment
 */
data class Environment(
    /**
     * Environment ID, as passed in the X-Appwrite-Environment header.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Environment creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Environment update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the project the environment belongs to, as passed in the X-Appwrite-Project header.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Environment name.
     */
    @SerializedName("name")
    val name: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "projectId" to projectId as Any,
        "name" to name as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Environment(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
        )
    }
}
