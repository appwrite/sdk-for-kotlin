package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Table
 */
data class Table(
    /**
     * Table ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Table creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Table update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Table permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Database ID.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Table name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Table enabled. Can be 'enabled' or 'disabled'. When disabled, the table is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Whether row-level permissions are enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("rowSecurity")
    val rowSecurity: Boolean,

    /**
     * Table columns.
     */
    @SerializedName("columns")
    val columns: List<Map<String, Any?>>,

    /**
     * Table indexes.
     */
    @SerializedName("indexes")
    val indexes: List<ColumnIndex>,

    /**
     * Maximum row size in bytes. Returns 0 when no limit applies.
     */
    @SerializedName("bytesMax")
    val bytesMax: Long,

    /**
     * Currently used row size in bytes based on defined columns.
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
        "enabled" to enabled as Any,
        "rowSecurity" to rowSecurity as Any,
        "columns" to columns as Any,
        "indexes" to indexes.map { it.toMap() } as Any,
        "bytesMax" to bytesMax as Any,
        "bytesUsed" to bytesUsed as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Table(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = map["\$permissions"] as List<String>,
            databaseId = (if (map.containsKey("databaseId")) map["databaseId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            rowSecurity = (if (map.containsKey("rowSecurity")) map["rowSecurity"] else false) as Boolean,
            columns = map["columns"] as List<Map<String, Any?>>,
            indexes = (map["indexes"] as List<Map<String, Any>>).map { ColumnIndex.from(map = it) },
            bytesMax = ((if (map.containsKey("bytesMax")) map["bytesMax"] else 0) as Number).toLong(),
            bytesUsed = ((if (map.containsKey("bytesUsed")) map["bytesUsed"] else 0) as Number).toLong(),
        )
    }
}
