package io.appwrite.models

import com.google.gson.annotations.SerializedName
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
    val status: String,

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
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "error" to error as Any,
        "attributes" to attributes as Any,
        "lengths" to lengths as Any,
        "orders" to orders as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Index(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            error = map["error"] as String,
            attributes = map["attributes"] as List<String>,
            lengths = map["lengths"] as List<Long>,
            orders = map["orders"] as? List<String>?,
        )
    }
}