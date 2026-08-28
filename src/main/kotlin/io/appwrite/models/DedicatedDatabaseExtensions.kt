package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Extensions
 */
data class DedicatedDatabaseExtensions(
    /**
     * List of installed extensions.
     */
    @SerializedName("installed")
    val installed: List<String>,

    /**
     * List of available extensions that can be installed.
     */
    @SerializedName("available")
    val available: List<String>,

    /**
     * Curated metadata (display name, description, category) for each available extension.
     */
    @SerializedName("metadata")
    val metadata: List<PostgresExtension>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "installed" to installed as Any,
        "available" to available as Any,
        "metadata" to metadata.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseExtensions(
            installed = map["installed"] as List<String>,
            available = map["available"] as List<String>,
            metadata = (map["metadata"] as List<Map<String, Any>>).map { PostgresExtension.from(map = it) },
        )
    }
}
