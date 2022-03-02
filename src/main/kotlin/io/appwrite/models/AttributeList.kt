package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Attributes List
 */
data class AttributeList(
    /**
     * Total number of attributes in the given collection.
     *
     */
    @SerializedName("total")
    val total: Long,

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
            total = (map["total"] as Number).toLong(),
            attributes = map["attributes"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "attributes" to attributes as Any
    )
}