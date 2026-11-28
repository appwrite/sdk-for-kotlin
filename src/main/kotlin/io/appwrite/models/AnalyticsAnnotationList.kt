package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Analytics annotations list
 */
data class AnalyticsAnnotationList(
    /**
     * Total number of annotations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of annotations.
     */
    @SerializedName("annotations")
    val annotations: List<AnalyticsAnnotation>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "annotations" to annotations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsAnnotationList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            annotations = ((if (map.containsKey("annotations")) map["annotations"] else listOf<Any?>()) as List<Map<String, Any>>).map { AnalyticsAnnotation.from(map = it) },
        )
    }
}
