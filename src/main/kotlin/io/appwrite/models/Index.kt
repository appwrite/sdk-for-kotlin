package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Index
 */
data class Index(
    /**
     * Index Key.
     *
     */
    @SerializedName("key")
    val key: String,

    /**
     * Index type.
     *
     */
    @SerializedName("type")
    val type: String,

    /**
     * Index status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     *
     */
    @SerializedName("status")
    val status: String,

    /**
     * Index attributes.
     *
     */
    @SerializedName("attributes")
    val attributes: List<Any>,

    /**
     * Index orders.
     *
     */
    @SerializedName("orders")
    val orders: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Index(
            key = map["key"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            attributes = map["attributes"] as List<Any>,
            orders = map["orders"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "type" to type as Any,
        "status" to status as Any,
        "attributes" to attributes as Any,
        "orders" to orders as Any
    )
}