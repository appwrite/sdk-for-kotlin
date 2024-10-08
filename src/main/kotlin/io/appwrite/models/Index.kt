package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Index
 */
data class Index(
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
     * Index attributes.
     */
    @SerializedName("attributes")
    val attributes: List<Any>,

    /**
     * Index orders.
     */
    @SerializedName("orders")
    var orders: List<Any>?,

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

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "error" to error as Any,
        "attributes" to attributes as Any,
        "orders" to orders as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Index(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            error = map["error"] as String,
            attributes = map["attributes"] as List<Any>,
            orders = map["orders"] as? List<Any>?,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
        )
    }
}