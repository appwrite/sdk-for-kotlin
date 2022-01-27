package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Attributes List
 */
data class AttributeList(
    /**
     * Total sum of items in the list.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of attributes.
     *
     */
    @SerializedName("attributes")
    val attributes: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AttributeList(
            sum = (map["sum"] as Number).toLong(),
            attributes = map["attributes"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "attributes" to attributes as Any
    )
}