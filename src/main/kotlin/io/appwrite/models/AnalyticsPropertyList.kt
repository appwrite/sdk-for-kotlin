package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Analytics properties list
 */
data class AnalyticsPropertyList(
    /**
     * Total number of properties that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of properties.
     */
    @SerializedName("properties")
    val properties: List<AnalyticsProperty>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "properties" to properties.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsPropertyList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            properties = ((if (map.containsKey("properties")) map["properties"] else listOf<Any?>()) as List<Map<String, Any>>).map { AnalyticsProperty.from(map = it) },
        )
    }
}
