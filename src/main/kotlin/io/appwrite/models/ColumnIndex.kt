package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Index
 */
data class ColumnIndex(
    /**
     * Index ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Index creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Index update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Index Key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Index type.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Index status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerializedName("status")
    val status: String,

    /**
     * Error message. Displays error generated on failure of creating or deleting an index.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Index columns.
     */
    @SerializedName("columns")
    val columns: List<String>,

    /**
     * Index columns length.
     */
    @SerializedName("lengths")
    val lengths: List<Long>,

    /**
     * Index orders.
     */
    @SerializedName("orders")
    var orders: List<String>?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "error" to error as Any,
        "columns" to columns as Any,
        "lengths" to lengths as Any,
        "orders" to orders as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ColumnIndex(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            status = (if (map.containsKey("status")) map["status"] else "") as String,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            columns = (if (map.containsKey("columns")) map["columns"] else listOf<Any?>()) as List<String>,
            lengths = (if (map.containsKey("lengths")) map["lengths"] else listOf<Any?>()) as List<Long>,
            orders = map["orders"] as? List<String>,
        )
    }
}
