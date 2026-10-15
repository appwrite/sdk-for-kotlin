package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.IndexStatus
import io.appwrite.extensions.jsonCast

/**
 * Index
 */
data class Index(
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
     * Index key.
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
    val status: IndexStatus,

    /**
     * Error message. Displays error generated on failure of creating or deleting an index.
     */
    @SerializedName("error")
    val error: String,

    /**
     * Index attributes.
     */
    @SerializedName("attributes")
    val attributes: List<String>,

    /**
     * Index attributes length.
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
        "status" to status.value as Any,
        "error" to error as Any,
        "attributes" to attributes as Any,
        "lengths" to lengths as Any,
        "orders" to orders as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Index(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            status = IndexStatus.values().find { it.value == map["status"] as String }!!,
            error = (if (map.containsKey("error")) map["error"] else "") as String,
            attributes = (if (map.containsKey("attributes")) map["attributes"] else listOf<Any?>()) as List<String>,
            lengths = (if (map.containsKey("lengths")) map["lengths"] else listOf<Any?>()) as List<Long>,
            orders = map["orders"] as? List<String>,
        )
    }
}
