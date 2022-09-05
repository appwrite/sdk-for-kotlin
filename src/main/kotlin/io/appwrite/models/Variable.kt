package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Variable
 */
data class Variable(
    /**
     * Variable ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Variable creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Variable creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Variable key.
     *
     */
    @SerializedName("key")
    val key: String,

    /**
     * Variable value.
     *
     */
    @SerializedName("value")
    val value: String,

    /**
     * Function ID.
     *
     */
    @SerializedName("functionId")
    val functionId: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Variable(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            key = map["key"] as String,
            value = map["value"] as String,
            functionId = map["functionId"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "key" to key as Any,
        "value" to value as Any,
        "functionId" to functionId as Any
    )
}