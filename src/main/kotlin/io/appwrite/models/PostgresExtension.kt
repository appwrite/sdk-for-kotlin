package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Postgres extension
 */
data class PostgresExtension(
    /**
     * Extension key used with CREATE EXTENSION.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Human-readable extension name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Short description of what the extension provides.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Category the extension belongs to.
     */
    @SerializedName("category")
    val category: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "key" to key as Any,
        "name" to name as Any,
        "description" to description as Any,
        "category" to category as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PostgresExtension(
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            category = (if (map.containsKey("category")) map["category"] else "") as String,
        )
    }
}
