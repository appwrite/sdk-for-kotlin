package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Collection
 */
data class Collection(
    /**
     * Collection ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Collection creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Collection update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Collection permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Database ID.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Collection name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Optional description for the collection.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Collection enabled. Can be 'enabled' or 'disabled'. When disabled, the collection is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Whether document-level permissions are enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("documentSecurity")
    val documentSecurity: Boolean,

    /**
     * Collection attributes.
     */
    @SerializedName("attributes")
    val attributes: List<Map<String, Any?>>,

    /**
     * Collection indexes.
     */
    @SerializedName("indexes")
    val indexes: List<Index>,

    /**
     * Maximum document size in bytes. Returns 0 when no limit applies.
     */
    @SerializedName("bytesMax")
    val bytesMax: Long,

    /**
     * Currently used document size in bytes based on defined attributes.
     */
    @SerializedName("bytesUsed")
    val bytesUsed: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "databaseId" to databaseId as Any,
        "name" to name as Any,
        "description" to description as Any,
        "enabled" to enabled as Any,
        "documentSecurity" to documentSecurity as Any,
        "attributes" to attributes as Any,
        "indexes" to indexes.map { it.toMap() } as Any,
        "bytesMax" to bytesMax as Any,
        "bytesUsed" to bytesUsed as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Collection(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = (if (map.containsKey("\$permissions")) map["\$permissions"] else listOf<Any?>()) as List<String>,
            databaseId = (if (map.containsKey("databaseId")) map["databaseId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            documentSecurity = (if (map.containsKey("documentSecurity")) map["documentSecurity"] else false) as Boolean,
            attributes = (if (map.containsKey("attributes")) map["attributes"] else listOf<Any?>()) as List<Map<String, Any?>>,
            indexes = ((if (map.containsKey("indexes")) map["indexes"] else listOf<Any?>()) as List<Map<String, Any>>).map { Index.from(map = it) },
            bytesMax = ((if (map.containsKey("bytesMax")) map["bytesMax"] else 0) as Number).toLong(),
            bytesUsed = ((if (map.containsKey("bytesUsed")) map["bytesUsed"] else 0) as Number).toLong(),
        )
    }
}
