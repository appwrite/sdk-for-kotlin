package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Database
 */
data class Database(
    /**
     * Database ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Database name.
     *
     */
    @SerializedName("name")
    val name: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Database(
            id = map["\$id"] as String,
            name = map["name"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any
    )
}