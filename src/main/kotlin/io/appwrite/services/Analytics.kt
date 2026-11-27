package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 *
 */
class Analytics(client: Client) : Service(client) {
    /**
     * List analytics properties for the current project.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, domain, enabled, type
     * @param search Search term to filter your list results. Matches the property ID, name and domain. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AnalyticsPropertyList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listProperties(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AnalyticsPropertyList {
        val apiPath = "/analytics/properties"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsPropertyList = {
            io.appwrite.models.AnalyticsPropertyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsPropertyList::class.java,
            converter,
        )
    }

    /**
     * Create a new analytics property to track a website or application.
     *
     * @param propertyId Unique ID. Choose a custom ID or generate a random ID with `ID.unique()`. Max length is 36 chars.
     * @param name Human-readable name for this property.
     * @param domain Primary domain to track (e.g. example.com). May be empty for mobile and agent properties.
     * @param enabled Whether the property accepts events. Events sent to a disabled property are rejected as not found.
     * @param allowedOrigins Allowed origins for tracking. Use ["*"] to allow all.
     * @param identifyUsers Record the signed-in user's ID on events sent from a client session, so traffic can be broken down and counted by user. Off by default.
     * @param type Kind of product this property tracks. Only changes which panels the dashboard shows; ingestion accepts the same events for every type.
     * @return [io.appwrite.models.AnalyticsProperty]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createProperty(
        propertyId: String,
        name: String,
        domain: String? = null,
        enabled: Boolean? = null,
        allowedOrigins: List<String>? = null,
        identifyUsers: Boolean? = null,
        type: io.appwrite.enums.AnalyticsPropertyType? = null,
    ): io.appwrite.models.AnalyticsProperty {
        val apiPath = "/analytics/properties"
        val apiParams = mutableMapOf<String, Any?>(
            "propertyId" to propertyId,
            "name" to name,
            "domain" to domain,
            "enabled" to enabled,
            "allowedOrigins" to allowedOrigins,
            "identifyUsers" to identifyUsers,
            "type" to type,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsProperty = {
            io.appwrite.models.AnalyticsProperty.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsProperty::class.java,
            converter,
        )
    }

    /**
     * Get an analytics property by ID.
     *
     * @param propertyId Analytics property unique ID.
     * @return [io.appwrite.models.AnalyticsProperty]
     */
    @Throws(AppwriteException::class)
    suspend fun getProperty(
        propertyId: String,
    ): io.appwrite.models.AnalyticsProperty {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsProperty = {
            io.appwrite.models.AnalyticsProperty.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsProperty::class.java,
            converter,
        )
    }

    /**
     * Update an analytics property. Only the attributes you pass are changed; omitted attributes keep their current value.
     *
     * @param propertyId Analytics property unique ID.
     * @param name Human-readable name for this property.
     * @param domain Primary domain to track (e.g. example.com). Pass an empty string to clear it.
     * @param enabled Whether the property accepts events. Events sent to a disabled property are rejected as not found.
     * @param allowedOrigins Allowed origins for tracking. Use ["*"] to allow all. On a property linked to a site, Appwrite manages this list: it is rewritten from the site's production domains whenever they change.
     * @param identifyUsers Record the signed-in user's ID on events sent from a client session, so traffic can be broken down and counted by user.
     * @param type Kind of product this property tracks. Only changes which panels the dashboard shows; stored events are kept.
     * @return [io.appwrite.models.AnalyticsProperty]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateProperty(
        propertyId: String,
        name: String? = null,
        domain: String? = null,
        enabled: Boolean? = null,
        allowedOrigins: List<String>? = null,
        identifyUsers: Boolean? = null,
        type: io.appwrite.enums.AnalyticsPropertyType? = null,
    ): io.appwrite.models.AnalyticsProperty {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "domain" to domain,
            "enabled" to enabled,
            "allowedOrigins" to allowedOrigins,
            "identifyUsers" to identifyUsers,
            "type" to type,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsProperty = {
            io.appwrite.models.AnalyticsProperty.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsProperty::class.java,
            converter,
        )
    }

    /**
     * Delete an analytics property along with every event and session collected for it. This cannot be undone.
     *
     * @param propertyId Analytics property unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteProperty(
        propertyId: String,
    ): Any {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * List the annotations of an analytics property. Filter on `date` to fetch the annotations inside a chart's time range.
     *
     * @param propertyId Analytics property unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: date
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AnalyticsAnnotationList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAnnotations(
        propertyId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AnalyticsAnnotationList {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/annotations"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsAnnotationList = {
            io.appwrite.models.AnalyticsAnnotationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsAnnotationList::class.java,
            converter,
        )
    }

    /**
     * Create an annotation that marks a point in time on an analytics property's charts.
     *
     * @param propertyId Analytics property unique ID.
     * @param annotationId Unique ID. Choose a custom ID or generate a random ID with `ID.unique()`. Max length is 36 chars.
     * @param date Point in time the annotation marks, in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format.
     * @param content Annotation text. Max length: 512 chars.
     * @return [io.appwrite.models.AnalyticsAnnotation]
     */
    @Throws(AppwriteException::class)
    suspend fun createAnnotation(
        propertyId: String,
        annotationId: String,
        date: String,
        content: String,
    ): io.appwrite.models.AnalyticsAnnotation {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/annotations"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "annotationId" to annotationId,
            "date" to date,
            "content" to content,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsAnnotation = {
            io.appwrite.models.AnalyticsAnnotation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsAnnotation::class.java,
            converter,
        )
    }

    /**
     * Get an analytics annotation by ID.
     *
     * @param propertyId Analytics property unique ID.
     * @param annotationId Annotation unique ID.
     * @return [io.appwrite.models.AnalyticsAnnotation]
     */
    @Throws(AppwriteException::class)
    suspend fun getAnnotation(
        propertyId: String,
        annotationId: String,
    ): io.appwrite.models.AnalyticsAnnotation {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        if (annotationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"annotationId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/annotations/{annotationId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
            .replace("{annotationId}", Client.encodePath(annotationId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsAnnotation = {
            io.appwrite.models.AnalyticsAnnotation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsAnnotation::class.java,
            converter,
        )
    }

    /**
     * Update an analytics annotation. Only the attributes you pass are changed; omitted attributes keep their current value.
     *
     * @param propertyId Analytics property unique ID.
     * @param annotationId Annotation unique ID.
     * @param date Point in time the annotation marks, in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format.
     * @param content Annotation text. Max length: 512 chars.
     * @return [io.appwrite.models.AnalyticsAnnotation]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateAnnotation(
        propertyId: String,
        annotationId: String,
        date: String? = null,
        content: String? = null,
    ): io.appwrite.models.AnalyticsAnnotation {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        if (annotationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"annotationId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/annotations/{annotationId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
            .replace("{annotationId}", Client.encodePath(annotationId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "date" to date,
            "content" to content,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsAnnotation = {
            io.appwrite.models.AnalyticsAnnotation.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsAnnotation::class.java,
            converter,
        )
    }

    /**
     * Delete an analytics annotation.
     *
     * @param propertyId Analytics property unique ID.
     * @param annotationId Annotation unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteAnnotation(
        propertyId: String,
        annotationId: String,
    ): Any {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        if (annotationId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"annotationId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/annotations/{annotationId}"
            .replace("{propertyId}", Client.encodePath(propertyId))
            .replace("{annotationId}", Client.encodePath(annotationId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Send a tracking event from a browser, native app, or server-side SDK.
     *
     * @param propertyId Analytics property ID.
     * @param name Event name. "pageview" and "screen_view" are counted as views, every other name is a custom event.
     * @param url Full page URL or screen identifier.
     * @param domain Hostname (e.g. example.com).
     * @param referrer Referrer URL.
     * @param screenWidth Viewport width in CSS pixels.
     * @param sessionHash Optional session hash (provided by SDK).
     * @param scrollDepth Scroll depth percentage 0-100.
     * @param engagementTime Engagement time in seconds, 0-4294967295.
     * @param props Custom string properties as a flat key=value list (max 32 entries, alternating key,value).
     * @param userId Override user ID. Pass an opaque ID, not personal data such as an email. Requires API-key auth with analytics.write scope.
     * @param ip Override IP address. Requires API-key auth with analytics.write scope.
     * @param userAgent Override user agent. Requires API-key auth with analytics.write scope.
     * @param interactive Whether this event is a visitor interaction that ends a bounce. Set false for telemetry such as heartbeats or background syncs. Defaults to true for custom events and false for the automatic engagement, scroll and app lifecycle events. Ignored for views.
     * @return [Any]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEvent(
        propertyId: String,
        name: String,
        url: String,
        domain: String? = null,
        referrer: String? = null,
        screenWidth: Long? = null,
        sessionHash: String? = null,
        scrollDepth: Long? = null,
        engagementTime: Long? = null,
        props: List<String>? = null,
        userId: String? = null,
        ip: String? = null,
        userAgent: String? = null,
        interactive: Boolean? = null,
    ): Any {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/events"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "url" to url,
            "domain" to domain,
            "referrer" to referrer,
            "screenWidth" to screenWidth,
            "sessionHash" to sessionHash,
            "scrollDepth" to scrollDepth,
            "engagementTime" to engagementTime,
            "props" to props,
            "userId" to userId,
            "ip" to ip,
            "userAgent" to userAgent,
            "interactive" to interactive,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Read analytics metrics (visitors, sessions, pageviews, events, bounceRate, …) for a property over a date range.
     *
     * **Three response shapes**, chosen by `dimensions[]` and `interval`:
     * - Neither: one row aggregating the whole window, with `value` and `date` null. Only this shape carries `visits`, `bounceRate`, `visitDuration`, `viewsPerVisit`, `scrollDepth` and `engagementTime`.
     * - `dimensions[]`: one row per dimension value, ranked by visitors, with `value` set and `date` null.
     * - `interval`: one row per time bucket in chronological order, with `date` set and `value` null.
     *
     * `pageviews` is carried by the flat aggregate and by `interval`, but not by a breakdown.
     *
     * `userId` and `users` cover identified traffic only: events sent with an API key's `userId`, or from a signed-in session on a property with `identifyUsers` on. A `userId` breakdown leaves out anonymous events; returned values are the project's user IDs.
     *
     * Custom event props: `dimensions[]=props` ranks the prop keys seen in the window, and adding `propKey` ranks the values of that one key. `queries[]` filters on a prop's value with the `props.<key>` attribute, e.g. `equal("props.plan", ["pro"])`.
     *
     * Combining `dimensions[]` with `interval` is not supported yet. `queries[]` filters the underlying events using standard Utopia query syntax.
     *
     * @param propertyId Analytics property unique ID.
     * @param queries Up to 10 filter queries in Utopia syntax. Allowed attributes: country, region, city, browser, browserVersion, operatingSystem, operatingSystemVersion, device, screenSize, referrerSource, channel, utmSource, utmMedium, utmCampaign, utmContent, utmTerm, page, hostname, trafficType, botName, botCategory, userId, eventName, and `props.<key>` for a custom prop. page, userId, eventName and `props.<key>` are only accepted alongside `interval`, or with a breakdown on a dimension other than entryPage, exitPage. Allowed methods: equal, notEqual, contains, startsWith, endsWith. Example: `queries[]=equal("country", ["US"])`.
     * @param interval Time bucket size. Omit (null) for a flat aggregate over the whole window. Allowed: 1h, 1d, 1w, 1m.
     * @param dimensions Dimension to break the metrics down by. One at most for now; the parameter is a list so that cap can be raised without a breaking change. Allowed: country, region, city, browser, browserVersion, operatingSystem, operatingSystemVersion, device, screenSize, referrerSource, channel, utmSource, utmMedium, utmCampaign, utmContent, utmTerm, page, hostname, entryPage, exitPage, trafficType, botName, botCategory, userId, eventName, props.
     * @param propKey Custom prop key whose values to rank, with `dimensions[]=props`. Omit to rank the prop keys themselves.
     * @param dateRange Date range shorthand (e.g. 7d, 30d). Ignored for any bound you supply explicitly via startAt/endAt.
     * @param startAt Explicit window start in ISO 8601. Defaults to endAt minus dateRange.
     * @param endAt Explicit window end in ISO 8601. Defaults to the current time.
     * @param limit Maximum number of ranked values to return.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AnalyticsMetricList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMetrics(
        propertyId: String,
        queries: List<String>? = null,
        interval: io.appwrite.enums.AnalyticsInterval? = null,
        dimensions: List<io.appwrite.enums.AnalyticsDimension>? = null,
        propKey: String? = null,
        dateRange: String? = null,
        startAt: String? = null,
        endAt: String? = null,
        limit: Long? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AnalyticsMetricList {
        if (propertyId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"propertyId\"")
        }
        val apiPath = ("/analytics/properties/{propertyId}/metrics"
            .replace("{propertyId}", Client.encodePath(propertyId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "interval" to interval,
            "dimensions" to dimensions,
            "propKey" to propKey,
            "dateRange" to dateRange,
            "startAt" to startAt,
            "endAt" to endAt,
            "limit" to limit,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AnalyticsMetricList = {
            io.appwrite.models.AnalyticsMetricList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AnalyticsMetricList::class.java,
            converter,
        )
    }
}
