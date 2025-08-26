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
    val columns: List<Any>,

    /**
     * Table indexes.
     */
    @SerializedName("indexes")
    val indexes: List<ColumnIndex>,

) {
    fun toMap(): Map<String, Any> = mapOf(
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
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Table(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            databaseId = map["databaseId"] as String,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            rowSecurity = map["rowSecurity"] as Boolean,
            columns = map["columns"] as List<Any>,
            indexes = (map["indexes"] as List<Map<String, Any>>).map { ColumnIndex.from(map = it) },
        )
    }
}