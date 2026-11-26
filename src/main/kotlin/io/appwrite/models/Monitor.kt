package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.MonitorType
import io.appwrite.enums.MonitorResourceType
import io.appwrite.enums.MonitorSeverity
import io.appwrite.enums.MonitorStatus
import io.appwrite.enums.MonitorMethod
import io.appwrite.enums.MonitorRecord
import io.appwrite.enums.MonitorTlsMode
import io.appwrite.enums.MonitorResult
import io.appwrite.extensions.jsonCast

/**
 * Monitor
 */
data class Monitor(
    /**
     * Monitor ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Monitor creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Monitor update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Monitor name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Rules that must all hold for the monitor to fire, as query strings. A usage monitor has one comparing a metric with a threshold, optionally scoped with `equal('resourceType')` and `equal('resourceId')`. A probe monitor fires when its rules match the check, over these variables: `http` `statusCode`, `latency`, `certificateDays` and `certificateLifetime`; `dns` `answer`, `answers` and `latency`; `tcp` `latency`; `smtp` `code`, `latency`, `certificateDays` and `certificateLifetime`. A failed connection fires whatever the rules.
     */
    @SerializedName("rules")
    val rules: List<String>,

    /**
     * What the monitor checks: `usage` compares a usage metric with a threshold; `http`, `dns`, `tcp` and `smtp` probe a target on their own interval.
     */
    @SerializedName("type")
    val type: MonitorType,

    /**
     * Type of the resource the monitor watches, from its rules: the project, or one database, bucket, function or site.
     */
    @SerializedName("resourceType")
    val resourceType: MonitorResourceType,

    /**
     * ID of the resource the monitor watches, from its rules. The project ID for a project-wide monitor.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Seconds a counter metric is summed over, and a growth metric is measured across. Gauges compare their latest value. Usage is read a short lag behind the evaluation (`_APP_ALERTS_USAGE_LAG`, 120 seconds by default) so events still being written are counted by the next evaluation.
     */
    @SerializedName("window")
    val window: Long,

    /**
     * Minimum seconds between two team notifications of this monitor firing. Events fire on every change regardless.
     */
    @SerializedName("cooldown")
    val cooldown: Long,

    /**
     * Whether the monitor is evaluated.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Empty when the alert events are the only delivery. Not used while `escalationId` is set.
     */
    @SerializedName("notify")
    val notify: List<String>,

    /**
     * ID of the organization's escalation that notifies the team of this monitor's alerts, step by step until one is acknowledged. When set, `notify` is not used. Empty to notify the `notify` roles once.
     */
    @SerializedName("escalationId")
    val escalationId: String,

    /**
     * How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it.
     */
    @SerializedName("severity")
    val severity: MonitorSeverity,

    /**
     * Whether the monitor is firing, as of its last evaluation.
     */
    @SerializedName("status")
    val status: MonitorStatus,

    /**
     * Metric value at the last evaluation. Null before the first evaluation, and when the last evaluation (`evaluatedAt`) found no usage recorded to read: without data a monitor is not compared, so it keeps its status and open alert.
     */
    @SerializedName("value")
    var value: Double?,

    /**
     * Last evaluation date in ISO 8601 format.
     */
    @SerializedName("evaluatedAt")
    var evaluatedAt: String?,

    /**
     * ID of the alert the monitor is firing for. Empty while it is not firing.
     */
    @SerializedName("alertId")
    val alertId: String,

    /**
     * Date the monitor last announced an alert, in ISO 8601 format.
     */
    @SerializedName("triggeredAt")
    var triggeredAt: String?,

    /**
     * Probe monitors: seconds between two checks, read back raised to the plan's minimum. 0 for usage monitors, which are evaluated on the server's interval.
     */
    @SerializedName("interval")
    val interval: Long,

    /**
     * Probe monitors: seconds a check may take before it fails.
     */
    @SerializedName("timeout")
    val timeout: Long,

    /**
     * HTTP monitors: URL requested.
     */
    @SerializedName("url")
    val url: String,

    /**
     * HTTP monitors: method the URL is requested with. Null for other types.
     */
    @SerializedName("method")
    var method: MonitorMethod?,

    /**
     * HTTP monitors: headers sent, as an object of header names and values.
     */
    @SerializedName("headers")
    var headers: Map<String, Any?>?,

    /**
     * HTTP monitors: request body sent.
     */
    @SerializedName("body")
    val body: String,

    /**
     * DNS monitors: domain queried.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * DNS monitors: record type queried. Null for other types.
     */
    @SerializedName("record")
    var record: MonitorRecord?,

    /**
     * DNS monitors: resolver queried. Empty for the server's DNS resolver.
     */
    @SerializedName("resolver")
    val resolver: String,

    /**
     * TCP and SMTP monitors: hostname or IP address connected to.
     */
    @SerializedName("host")
    val host: String,

    /**
     * TCP and SMTP monitors: port connected to.
     */
    @SerializedName("port")
    val port: Long,

    /**
     * SMTP monitors: how the connection is secured. `auto` picks implicit TLS on port 465, STARTTLS on 587 and none otherwise. Null for other types.
     */
    @SerializedName("tlsMode")
    var tlsMode: MonitorTlsMode?,

    /**
     * Probe monitors: what the last check found. `ok` passes; anything else opened the monitor's alert. Null before the first check.
     */
    @SerializedName("result")
    var result: MonitorResult?,

    /**
     * Probe monitors: milliseconds the last check took.
     */
    @SerializedName("latency")
    var latency: Long?,

    /**
     * Probe monitors: last status code an HTTP target answered with, reply code an SMTP server sent, or response code a DNS resolver returned.
     */
    @SerializedName("code")
    var code: Long?,

    /**
     * Probe monitors: expiry date of the TLS certificate the last check saw, in ISO 8601 format. Null without TLS.
     */
    @SerializedName("certificateExpiresAt")
    var certificateExpiresAt: String?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "projectId" to projectId as Any,
        "rules" to rules as Any,
        "type" to type.value as Any,
        "resourceType" to resourceType.value as Any,
        "resourceId" to resourceId as Any,
        "window" to window as Any,
        "cooldown" to cooldown as Any,
        "enabled" to enabled as Any,
        "notify" to notify as Any,
        "escalationId" to escalationId as Any,
        "severity" to severity.value as Any,
        "status" to status.value as Any,
        "value" to value as Any?,
        "evaluatedAt" to evaluatedAt as Any?,
        "alertId" to alertId as Any,
        "triggeredAt" to triggeredAt as Any?,
        "interval" to interval as Any,
        "timeout" to timeout as Any,
        "url" to url as Any,
        "method" to method?.value as Any?,
        "headers" to headers as Any?,
        "body" to body as Any,
        "domain" to domain as Any,
        "record" to record?.value as Any?,
        "resolver" to resolver as Any,
        "host" to host as Any,
        "port" to port as Any,
        "tlsMode" to tlsMode?.value as Any?,
        "result" to result?.value as Any?,
        "latency" to latency as Any?,
        "code" to code as Any?,
        "certificateExpiresAt" to certificateExpiresAt as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Monitor(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            rules = (if (map.containsKey("rules")) map["rules"] else listOf<Any?>()) as List<String>,
            type = MonitorType.values().find { it.value == (if (map.containsKey("type")) map["type"] else "usage") as String }!!,
            resourceType = MonitorResourceType.values().find { it.value == (if (map.containsKey("resourceType")) map["resourceType"] else "project") as String }!!,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            window = ((if (map.containsKey("window")) map["window"] else 3600) as Number).toLong(),
            cooldown = ((if (map.containsKey("cooldown")) map["cooldown"] else 3600) as Number).toLong(),
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            notify = (if (map.containsKey("notify")) map["notify"] else listOf<Any?>("owner")) as List<String>,
            escalationId = (if (map.containsKey("escalationId")) map["escalationId"] else "") as String,
            severity = MonitorSeverity.values().find { it.value == (if (map.containsKey("severity")) map["severity"] else "warning") as String }!!,
            status = MonitorStatus.values().find { it.value == (if (map.containsKey("status")) map["status"] else "ok") as String }!!,
            value = (map["value"] as? Number)?.toDouble(),
            evaluatedAt = map["evaluatedAt"] as? String,
            alertId = (if (map.containsKey("alertId")) map["alertId"] else "") as String,
            triggeredAt = map["triggeredAt"] as? String,
            interval = ((if (map.containsKey("interval")) map["interval"] else 0) as Number).toLong(),
            timeout = ((if (map.containsKey("timeout")) map["timeout"] else 0) as Number).toLong(),
            url = (if (map.containsKey("url")) map["url"] else "") as String,
            method = MonitorMethod.values().find { it.value == (map["method"] as? String) },
            headers = map["headers"] as? Map<String, Any?>,
            body = (if (map.containsKey("body")) map["body"] else "") as String,
            domain = (if (map.containsKey("domain")) map["domain"] else "") as String,
            record = MonitorRecord.values().find { it.value == (map["record"] as? String) },
            resolver = (if (map.containsKey("resolver")) map["resolver"] else "") as String,
            host = (if (map.containsKey("host")) map["host"] else "") as String,
            port = ((if (map.containsKey("port")) map["port"] else 0) as Number).toLong(),
            tlsMode = MonitorTlsMode.values().find { it.value == (map["tlsMode"] as? String) },
            result = MonitorResult.values().find { it.value == (map["result"] as? String) },
            latency = (map["latency"] as? Number)?.toLong(),
            code = (map["code"] as? Number)?.toLong(),
            certificateExpiresAt = map["certificateExpiresAt"] as? String,
        )
    }
}
