package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * ExecutionColumn
 */
data class DedicatedDatabaseExecutionColumn(
    /**
     * Column name as returned by the database.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Engine-specific column type (e.g. int4, text, timestamptz).
     */
    @SerializedName("type")
    val type: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "name" to name as Any,
        "type" to type as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseExecutionColumn(
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
        )
    }
}
