package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Reports List
 */
data class ReportList(
    /**
     * Total number of reports that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of reports.
     */
    @SerializedName("reports")
    val reports: List<Report>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "reports" to reports.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ReportList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            reports = ((if (map.containsKey("reports")) map["reports"] else listOf<Any?>()) as List<Map<String, Any>>).map { Report.from(map = it) },
        )
    }
}
