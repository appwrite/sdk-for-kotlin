package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.AlertStatus
import io.appwrite.enums.MonitorSeverity
import io.appwrite.enums.AlertMetric
import io.appwrite.enums.AlertComparator
import io.appwrite.enums.MonitorType
import io.appwrite.enums.MonitorResourceType
import io.appwrite.enums.MonitorResult
import io.appwrite.extensions.jsonCast

/**
 * Alert
 */
data class Alert(
    /**
     * Alert ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Date the alert started firing, in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Alert update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the monitor that raised the alert.
     */
    @SerializedName("monitorId")
    val monitorId: String,

    /**
     * ID of the project the alert is about. Empty for an alert of the whole organization.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Name of the monitor when the alert fired.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Whether the alert is still firing or has resolved.
     */
    @SerializedName("status")
    val status: AlertStatus,

    /**
     * Date the alert resolved, in ISO 8601 format. Empty while it fires.
     */
    @SerializedName("resolvedAt")
    var resolvedAt: String?,

    /**
     * Date a member acknowledged the alert, in ISO 8601 format. Empty while nobody has.
     */
    @SerializedName("acknowledgedAt")
    var acknowledgedAt: String?,

    /**
     * ID of the user who acknowledged the alert. Empty while nobody has, or when it was acknowledged with an API key.
     */
    @SerializedName("acknowledgedBy")
    val acknowledgedBy: String,

    /**
     * Name of the user who acknowledged the alert, when they did.
     */
    @SerializedName("acknowledgedByName")
    val acknowledgedByName: String,

    /**
     * ID of the escalation notifying the team of this alert. Empty when the monitor notified its `notify` roles instead.
     */
    @SerializedName("escalationId")
    val escalationId: String,

    /**
     * Index of the escalation's next step to notify, counting from 0. Equal to the number of steps once the last round has gone out.
     */
    @SerializedName("escalationStep")
    val escalationStep: Long,

    /**
     * How many times the escalation's steps have been repeated for this alert.
     */
    @SerializedName("escalationRound")
    val escalationRound: Long,

    /**
     * When the next step is notified, in ISO 8601 format. Null when nothing is due: the alert was acknowledged or resolved, or every step has gone out.
     */
    @SerializedName("escalatesAt")
    var escalatesAt: String?,

    /**
     * The monitor's rules when the alert fired, as query strings.
     */
    @SerializedName("rules")
    val rules: List<String>,

    /**
     * The monitor's severity when the alert fired: `info`, `warning`, `error` or `critical`.
     */
    @SerializedName("severity")
    val severity: MonitorSeverity,

    /**
     * Metric the alert fired on. Null for a probe monitor's alert.
     */
    @SerializedName("metric")
    var metric: AlertMetric?,

    /**
     * How the metric was compared with the threshold. Null for a probe monitor's alert.
     */
    @SerializedName("comparator")
    var comparator: AlertComparator?,

    /**
     * Threshold the metric crossed, in the metric's unit.
     */
    @SerializedName("threshold")
    val threshold: Double,

    /**
     * Latest reading while the alert fired: the metric's value for a usage monitor, and for a probe monitor its `latency`.
     */
    @SerializedName("value")
    val value: Double,

    /**
     * Reading furthest past the threshold while the alert fired.
     */
    @SerializedName("peak")
    val peak: Double,

    /**
     * Type of the monitor that raised the alert.
     */
    @SerializedName("type")
    val type: MonitorType,

    /**
     * Type of the resource the alert fired on: the project, or one database, bucket, function or site.
     */
    @SerializedName("resourceType")
    val resourceType: MonitorResourceType,

    /**
     * ID of the resource the alert fired on. The project ID for a project-wide monitor.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * How many times the alert was announced as firing: once when it fired, and again after each cooldown while it kept firing.
     */
    @SerializedName("notifications")
    val notifications: Long,

    /**
     * Probe monitors: response time in milliseconds of the latest check recorded on the alert.
     */
    @SerializedName("latency")
    var latency: Long?,

    /**
     * What the failing check of a probe monitor found when the alert opened, such as `connect_refused`. Null for a usage monitor's alert.
     */
    @SerializedName("result")
    var result: MonitorResult?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "monitorId" to monitorId as Any,
        "projectId" to projectId as Any,
        "name" to name as Any,
        "status" to status.value as Any,
        "resolvedAt" to resolvedAt as Any?,
        "acknowledgedAt" to acknowledgedAt as Any?,
        "acknowledgedBy" to acknowledgedBy as Any,
        "acknowledgedByName" to acknowledgedByName as Any,
        "escalationId" to escalationId as Any,
        "escalationStep" to escalationStep as Any,
        "escalationRound" to escalationRound as Any,
        "escalatesAt" to escalatesAt as Any?,
        "rules" to rules as Any,
        "severity" to severity.value as Any,
        "metric" to metric?.value as Any?,
        "comparator" to comparator?.value as Any?,
        "threshold" to threshold as Any,
        "value" to value as Any,
        "peak" to peak as Any,
        "type" to type.value as Any,
        "resourceType" to resourceType.value as Any,
        "resourceId" to resourceId as Any,
        "notifications" to notifications as Any,
        "latency" to latency as Any?,
        "result" to result?.value as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Alert(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            monitorId = (if (map.containsKey("monitorId")) map["monitorId"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            status = AlertStatus.values().find { it.value == (if (map.containsKey("status")) map["status"] else "firing") as String }!!,
            resolvedAt = map["resolvedAt"] as? String,
            acknowledgedAt = map["acknowledgedAt"] as? String,
            acknowledgedBy = (if (map.containsKey("acknowledgedBy")) map["acknowledgedBy"] else "") as String,
            acknowledgedByName = (if (map.containsKey("acknowledgedByName")) map["acknowledgedByName"] else "") as String,
            escalationId = (if (map.containsKey("escalationId")) map["escalationId"] else "") as String,
            escalationStep = ((if (map.containsKey("escalationStep")) map["escalationStep"] else 0) as Number).toLong(),
            escalationRound = ((if (map.containsKey("escalationRound")) map["escalationRound"] else 0) as Number).toLong(),
            escalatesAt = map["escalatesAt"] as? String,
            rules = (if (map.containsKey("rules")) map["rules"] else listOf<Any?>()) as List<String>,
            severity = MonitorSeverity.values().find { it.value == (if (map.containsKey("severity")) map["severity"] else "warning") as String }!!,
            metric = AlertMetric.values().find { it.value == (map["metric"] as? String) },
            comparator = AlertComparator.values().find { it.value == (map["comparator"] as? String) },
            threshold = ((if (map.containsKey("threshold")) map["threshold"] else 0.0) as Number).toDouble(),
            value = ((if (map.containsKey("value")) map["value"] else 0.0) as Number).toDouble(),
            peak = ((if (map.containsKey("peak")) map["peak"] else 0.0) as Number).toDouble(),
            type = MonitorType.values().find { it.value == (if (map.containsKey("type")) map["type"] else "usage") as String }!!,
            resourceType = MonitorResourceType.values().find { it.value == (if (map.containsKey("resourceType")) map["resourceType"] else "project") as String }!!,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            notifications = ((if (map.containsKey("notifications")) map["notifications"] else 0) as Number).toLong(),
            latency = (map["latency"] as? Number)?.toLong(),
            result = MonitorResult.values().find { it.value == (map["result"] as? String) },
        )
    }
}
