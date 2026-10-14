package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Insight
 */
data class Insight(
    /**
     * Insight ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Insight creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Insight update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Parent report ID. Insights always belong to a report.
     */
    @SerializedName("reportId")
    val reportId: String,

    /**
     * Insight type. One of databaseIndex (legacy), tablesDBIndex, documentsDBIndex, vectorsDBIndex, databasePerformance, sitePerformance, siteAccessibility, siteSeo, functionPerformance. The index types are engine-specific so each CTA can pair the right service+method (databases.createIndex, tablesDB.createIndex, documentsDB.createIndex, or vectorsDB.createIndex).
     */
    @SerializedName("type")
    val type: String,

    /**
     * Insight severity. One of info, warning, critical.
     */
    @SerializedName("severity")
    val severity: String,

    /**
     * Insight status. One of active, dismissed.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Type of the resource the insight is about. Plural noun, e.g. databases, sites, functions.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * ID of the resource the insight is about.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Plural noun for the parent resource that contains the insight's resource, e.g. an insight about a column index on a table → resourceType=indexes, parentResourceType=tables. Empty when the resource has no parent.
     */
    @SerializedName("parentResourceType")
    val parentResourceType: String,

    /**
     * ID of the parent resource. Empty when the resource has no parent.
     */
    @SerializedName("parentResourceId")
    val parentResourceId: String,

    /**
     * Insight title.
     */
    @SerializedName("title")
    val title: String,

    /**
     * Short markdown summary describing the insight.
     */
    @SerializedName("summary")
    val summary: String,

    /**
     * List of call-to-action buttons attached to this insight.
     */
    @SerializedName("ctas")
    val ctas: List<InsightCTA>,

    /**
     * Time the insight was analyzed in ISO 8601 format.
     */
    @SerializedName("analyzedAt")
    var analyzedAt: String?,

    /**
     * Time the insight was dismissed in ISO 8601 format. Empty when not dismissed.
     */
    @SerializedName("dismissedAt")
    var dismissedAt: String?,

    /**
     * User ID that dismissed the insight. Empty when not dismissed.
     */
    @SerializedName("dismissedBy")
    var dismissedBy: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "reportId" to reportId as Any,
        "type" to type as Any,
        "severity" to severity as Any,
        "status" to status as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "parentResourceType" to parentResourceType as Any,
        "parentResourceId" to parentResourceId as Any,
        "title" to title as Any,
        "summary" to summary as Any,
        "ctas" to ctas.map { it.toMap() } as Any,
        "analyzedAt" to analyzedAt as Any?,
        "dismissedAt" to dismissedAt as Any?,
        "dismissedBy" to dismissedBy as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Insight(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            reportId = (if (map.containsKey("reportId")) map["reportId"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            severity = (if (map.containsKey("severity")) map["severity"] else "info") as String,
            status = (if (map.containsKey("status")) map["status"] else "active") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            parentResourceType = (if (map.containsKey("parentResourceType")) map["parentResourceType"] else "") as String,
            parentResourceId = (if (map.containsKey("parentResourceId")) map["parentResourceId"] else "") as String,
            title = (if (map.containsKey("title")) map["title"] else "") as String,
            summary = (if (map.containsKey("summary")) map["summary"] else "") as String,
            ctas = ((if (map.containsKey("ctas")) map["ctas"] else listOf<Any?>()) as List<Map<String, Any>>).map { InsightCTA.from(map = it) },
            analyzedAt = map["analyzedAt"] as? String,
            dismissedAt = map["dismissedAt"] as? String,
            dismissedBy = map["dismissedBy"] as? String,
        )
    }
}
