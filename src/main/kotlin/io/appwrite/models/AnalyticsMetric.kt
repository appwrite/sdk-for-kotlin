package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AnalyticsMetric
 */
data class AnalyticsMetric(
    /**
     * Dimension value this row covers. Null when no dimension was requested, empty when the dimension could not be derived for those events.
     */
    @SerializedName("value")
    var value: String?,

    /**
     * Start of the time bucket this row covers, in ISO 8601. Null when no interval was requested.
     */
    @SerializedName("date")
    var date: String?,

    /**
     * Unique visitors in the requested range.
     */
    @SerializedName("visitors")
    val visitors: Long,

    /**
     * Unique sessions in the requested range.
     */
    @SerializedName("sessions")
    val sessions: Long,

    /**
     * Total page and screen view events (events named "pageview" or "screen_view") in the requested range. The flat aggregate and the time series compute it; null on breakdown rows.
     */
    @SerializedName("pageviews")
    var pageviews: Long?,

    /**
     * Total events in the requested range.
     */
    @SerializedName("events")
    val events: Long,

    /**
     * Unique identified users in the requested range. Anonymous events are not counted. Null on entry and exit page breakdown rows.
     */
    @SerializedName("users")
    var users: Long?,

    /**
     * Total sessions with activity in the requested range. Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("visits")
    var visits: Long?,

    /**
     * Share of bounced visits, as a percentage; a visit is a bounce unless it records two or more page or screen views, at least one interaction, or ten seconds or more of activity. An interaction is any event that is neither a view nor automatic measurement such as "app_foregrounded", "engagement_time" or "scroll_depth". Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("bounceRate")
    var bounceRate: Double?,

    /**
     * Average session length in seconds, measured first event to last event. Single-event sessions count as 0. Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("visitDuration")
    var visitDuration: Double?,

    /**
     * Average pageviews per session (pageviews divided by visits). Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("viewsPerVisit")
    var viewsPerVisit: Double?,

    /**
     * Average scroll depth across events, as a percentage. Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("scrollDepth")
    var scrollDepth: Double?,

    /**
     * Average engaged time per session in seconds, counting only foreground time. Sessions that reported no engagement are excluded. Only the flat aggregate computes it; null on breakdown and time-series rows.
     */
    @SerializedName("engagementTime")
    var engagementTime: Double?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "value" to value as Any?,
        "date" to date as Any?,
        "visitors" to visitors as Any,
        "sessions" to sessions as Any,
        "pageviews" to pageviews as Any?,
        "events" to events as Any,
        "users" to users as Any?,
        "visits" to visits as Any?,
        "bounceRate" to bounceRate as Any?,
        "visitDuration" to visitDuration as Any?,
        "viewsPerVisit" to viewsPerVisit as Any?,
        "scrollDepth" to scrollDepth as Any?,
        "engagementTime" to engagementTime as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsMetric(
            value = map["value"] as? String,
            date = map["date"] as? String,
            visitors = ((if (map.containsKey("visitors")) map["visitors"] else 0) as Number).toLong(),
            sessions = ((if (map.containsKey("sessions")) map["sessions"] else 0) as Number).toLong(),
            pageviews = (map["pageviews"] as? Number)?.toLong(),
            events = ((if (map.containsKey("events")) map["events"] else 0) as Number).toLong(),
            users = (map["users"] as? Number)?.toLong(),
            visits = (map["visits"] as? Number)?.toLong(),
            bounceRate = (map["bounceRate"] as? Number)?.toDouble(),
            visitDuration = (map["visitDuration"] as? Number)?.toDouble(),
            viewsPerVisit = (map["viewsPerVisit"] as? Number)?.toDouble(),
            scrollDepth = (map["scrollDepth"] as? Number)?.toDouble(),
            engagementTime = (map["engagementTime"] as? Number)?.toDouble(),
        )
    }
}
