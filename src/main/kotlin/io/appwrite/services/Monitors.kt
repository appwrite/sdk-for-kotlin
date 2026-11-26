package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 * The Monitors service watches your project's usage and raises an alert when a monitor's rules hold, announced by email, in the console or to a webhook.
 */
class Monitors(client: Client) : Service(client) {
    /**
     * Get a list of the project's monitors of every type. Use queries to filter by type, resource, severity or status, and `Query.search('search', term)` to search monitor IDs, names, metrics and resources.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, type, resourceType, resourceId, enabled, severity, escalationId, status, evaluatedAt, triggeredAt, search
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.MonitorList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.MonitorList {
        val apiPath = "/monitors"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MonitorList = {
            io.appwrite.models.MonitorList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MonitorList::class.java,
            converter,
        )
    }

    /**
     * Create a DNS monitor. It asks a resolver for a domain's records of one type on its own interval, and opens an alert when the resolver fails, or when its rules match the answers, by default when there is no such record. Each alert fires the `monitors.[monitorId].alerts.[alertId].create` event when it opens and `.update` when a check passes again, for project webhooks, functions and realtime, and notifies the organization's members by email and in the console.
     *
     * @param monitorId Monitor ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Monitor name. Max length: 128 chars.
     * @param domain Domain to query, such as `example.com`.
     * @param record Record type to query: `A`, `AAAA`, `CNAME`, `MX`, `TXT` or `NS`. Defaults to `A`.
     * @param resolver Resolver to query, as an IP address with an optional port, such as `1.1.1.1` or `[2606:4700:4700::1111]:53`. Defaults to the server's DNS resolver.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `answer` (the first record returned, compared lowercased without the trailing dot), `answers` (number of records returned), `latency` (milliseconds the check took). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. `answer` takes `equal` and `notEqual` only. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires when the resolver returns no answers.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Defaults to 60, or to the shortest interval your plan allows when that is longer. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Set to false to create the monitor without checking it.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Defaults to owners; pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Leave empty to notify the `notify` roles once.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDnsMonitor(
        monitorId: String,
        name: String,
        domain: String,
        record: io.appwrite.enums.MonitorRecord? = null,
        resolver: String? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        val apiPath = "/monitors/dns"
        val apiParams = mutableMapOf<String, Any?>(
            "monitorId" to monitorId,
            "name" to name,
            "domain" to domain,
            "record" to record,
            "resolver" to resolver,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Update a DNS monitor by its unique ID. Only the parameters passed change; the monitor's state, its last check and its open alert are kept. Passing `rules` replaces all of them.
     *
     * @param monitorId Monitor ID.
     * @param name Monitor name. Max length: 128 chars.
     * @param domain Domain to query, such as `example.com`.
     * @param record Record type to query: `A`, `AAAA`, `CNAME`, `MX`, `TXT` or `NS`.
     * @param resolver Resolver to query, as an IP address with an optional port, such as `1.1.1.1` or `[2606:4700:4700::1111]:53`. Pass an empty string to use the server's DNS resolver.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `answer` (the first record returned, compared lowercased without the trailing dot), `answers` (number of records returned), `latency` (milliseconds the check took). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. `answer` takes `equal` and `notEqual` only. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires when the resolver returns no answers. Replaces the current rules; an empty list restores the defaults.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Whether the monitor is checked.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Pass an empty string to go back to the `notify` roles.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDnsMonitor(
        monitorId: String,
        name: String? = null,
        domain: String? = null,
        record: io.appwrite.enums.MonitorRecord? = null,
        resolver: String? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/dns/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "domain" to domain,
            "record" to record,
            "resolver" to resolver,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Create an HTTP monitor. It requests a URL on its own interval, following redirects, and opens an alert when the request fails or when its rules match the response, by default a status outside 2xx or the certificate of an HTTPS URL about to expire. The response body is discarded as it arrives. Each alert fires the `monitors.[monitorId].alerts.[alertId].create` event when it opens and `.update` when a check passes again, for project webhooks, functions and realtime, and notifies the organization's members by email and in the console.
     *
     * @param monitorId Monitor ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Monitor name. Max length: 128 chars.
     * @param url URL to request, with an `http` or `https` scheme.
     * @param method HTTP method to request the URL with: `GET`, `HEAD`, `POST`, `PUT`, `PATCH`, `DELETE` or `OPTIONS`. Defaults to `GET`.
     * @param headers HTTP headers to send, as an object of header names and values. Each name must be a valid HTTP header name.
     * @param body Request body to send. Max length: 16384 chars.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `statusCode` (HTTP status), `latency` (milliseconds the check took), `certificateDays` (whole days until the certificate expires), `certificateLifetime` (percent of the certificate's lifetime left). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on a status code outside 200 to 299, or on a certificate with fewer than 14 days and less than 25% of its lifetime left.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Defaults to 60, or to the shortest interval your plan allows when that is longer. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Set to false to create the monitor without checking it.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Defaults to owners; pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Leave empty to notify the `notify` roles once.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createHttpMonitor(
        monitorId: String,
        name: String,
        url: String,
        method: io.appwrite.enums.MonitorMethod? = null,
        headers: Map<String, Any?>? = null,
        body: String? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        val apiPath = "/monitors/http"
        val apiParams = mutableMapOf<String, Any?>(
            "monitorId" to monitorId,
            "name" to name,
            "url" to url,
            "method" to method,
            "headers" to headers,
            "body" to body,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Update an HTTP monitor by its unique ID. Only the parameters passed change; the monitor's state, its last check and its open alert are kept. Passing `rules` replaces all of them.
     *
     * @param monitorId Monitor ID.
     * @param name Monitor name. Max length: 128 chars.
     * @param url URL to request, with an `http` or `https` scheme.
     * @param method HTTP method to request the URL with: `GET`, `HEAD`, `POST`, `PUT`, `PATCH`, `DELETE` or `OPTIONS`.
     * @param headers HTTP headers to send, as an object of header names and values. Each name must be a valid HTTP header name.
     * @param body Request body to send. Max length: 16384 chars.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `statusCode` (HTTP status), `latency` (milliseconds the check took), `certificateDays` (whole days until the certificate expires), `certificateLifetime` (percent of the certificate's lifetime left). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on a status code outside 200 to 299, or on a certificate with fewer than 14 days and less than 25% of its lifetime left. Replaces the current rules; an empty list restores the defaults.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Whether the monitor is checked.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Pass an empty string to go back to the `notify` roles.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateHttpMonitor(
        monitorId: String,
        name: String? = null,
        url: String? = null,
        method: io.appwrite.enums.MonitorMethod? = null,
        headers: Map<String, Any?>? = null,
        body: String? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/http/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "url" to url,
            "method" to method,
            "headers" to headers,
            "body" to body,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Create an SMTP monitor. It reads a mail server's greeting, sends `EHLO` and, as its TLS mode asks, upgrades with `STARTTLS` or speaks TLS from the start, on its own interval. It opens an alert when the server cannot be reached, refuses the session or fails the TLS handshake, or when its rules match. It never authenticates or sends mail. Each alert fires the `monitors.[monitorId].alerts.[alertId].create` event when it opens and `.update` when a check passes again, for project webhooks, functions and realtime, and notifies the organization's members by email and in the console.
     *
     * @param monitorId Monitor ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Monitor name. Max length: 128 chars.
     * @param host Hostname or IP address of the mail server.
     * @param port Port to connect to, such as 25, 465 or 587.
     * @param tlsMode TLS mode: `auto` (`implicit` on port 465, `starttls` on 587 and `none` otherwise), `none`, `starttls` (upgrade after the greeting, and fail when the server does not offer it) or `implicit` (TLS from the first byte). Defaults to `auto`.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `code` (SMTP reply code), `latency` (milliseconds the check took), `certificateDays` (whole days until the certificate expires), `certificateLifetime` (percent of the certificate's lifetime left). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on transport failures only.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Defaults to 60, or to the shortest interval your plan allows when that is longer. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Set to false to create the monitor without checking it.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Defaults to owners; pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Leave empty to notify the `notify` roles once.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSmtpMonitor(
        monitorId: String,
        name: String,
        host: String,
        port: Long,
        tlsMode: io.appwrite.enums.MonitorTlsMode? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        val apiPath = "/monitors/smtp"
        val apiParams = mutableMapOf<String, Any?>(
            "monitorId" to monitorId,
            "name" to name,
            "host" to host,
            "port" to port,
            "tlsMode" to tlsMode,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Update an SMTP monitor by its unique ID. Only the parameters passed change; the monitor's state, its last check and its open alert are kept. Passing `rules` replaces all of them.
     *
     * @param monitorId Monitor ID.
     * @param name Monitor name. Max length: 128 chars.
     * @param host Hostname or IP address of the mail server.
     * @param port Port to connect to, such as 25, 465 or 587.
     * @param tlsMode TLS mode: `auto` (`implicit` on port 465, `starttls` on 587 and `none` otherwise), `none`, `starttls` (upgrade after the greeting, and fail when the server does not offer it) or `implicit` (TLS from the first byte).
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `code` (SMTP reply code), `latency` (milliseconds the check took), `certificateDays` (whole days until the certificate expires), `certificateLifetime` (percent of the certificate's lifetime left). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on transport failures only. Replaces the current rules; an empty list removes them.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Whether the monitor is checked.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Pass an empty string to go back to the `notify` roles.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSmtpMonitor(
        monitorId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        tlsMode: io.appwrite.enums.MonitorTlsMode? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/smtp/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "host" to host,
            "port" to port,
            "tlsMode" to tlsMode,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Create a TCP monitor. It opens a connection to a host and port on its own interval and closes it at once, and opens an alert when the connection cannot be made, or when its rules match. Each alert fires the `monitors.[monitorId].alerts.[alertId].create` event when it opens and `.update` when a check passes again, for project webhooks, functions and realtime, and notifies the organization's members by email and in the console.
     *
     * @param monitorId Monitor ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Monitor name. Max length: 128 chars.
     * @param host Hostname or IP address to connect to.
     * @param port Port to connect to.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `latency` (milliseconds the check took). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on transport failures only.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Defaults to 60, or to the shortest interval your plan allows when that is longer. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Set to false to create the monitor without checking it.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Defaults to owners; pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Leave empty to notify the `notify` roles once.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTcpMonitor(
        monitorId: String,
        name: String,
        host: String,
        port: Long,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        val apiPath = "/monitors/tcp"
        val apiParams = mutableMapOf<String, Any?>(
            "monitorId" to monitorId,
            "name" to name,
            "host" to host,
            "port" to port,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Update a TCP monitor by its unique ID. Only the parameters passed change; the monitor's state, its last check and its open alert are kept. Passing `rules` replaces all of them.
     *
     * @param monitorId Monitor ID.
     * @param name Monitor name. Max length: 128 chars.
     * @param host Hostname or IP address to connect to.
     * @param port Port to connect to.
     * @param rules Rules that describe the failing state, as query strings generated with the Query class. The monitor fires when they match. Transport failures, such as timeouts, DNS failures, refused connections and denied targets, always fire. Variables: `latency` (milliseconds the check took). Operators: `equal`, `notEqual`, `lessThan`, `lessThanEqual`, `greaterThan`, `greaterThanEqual`, `between`, `notBetween`. Combine rules with `or` and `and`; top-level rules must all match. Without rules it fires on transport failures only. Replaces the current rules; an empty list removes them.
     * @param interval Seconds between two checks, between 1 and 2592000. The scheduler runs on a one second tick, so one second is the shortest interval. Reads back raised to your plan's minimum interval when the plan no longer allows it.
     * @param timeout Seconds a check may take before it fails, between 1 and 60, and no longer than the interval.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Whether the monitor is checked.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Pass an empty string to go back to the `notify` roles.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTcpMonitor(
        monitorId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        rules: List<String>? = null,
        interval: Long? = null,
        timeout: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/tcp/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "host" to host,
            "port" to port,
            "rules" to rules,
            "interval" to interval,
            "timeout" to timeout,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Create a usage monitor. It reads a usage metric of the project, or of one of its databases, buckets, functions or sites, on a schedule, and opens an alert when all its rules hold. Each alert fires the `monitors.[monitorId].alerts.[alertId].create` event when it opens and `.update` when usage recovers, for project webhooks, functions and realtime, and notifies the confirmed members of the `notify` roles by email and in the console, or the steps of the escalation set by `escalationId`.
     *
     * @param monitorId Monitor ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Monitor name. Max length: 128 chars.
     * @param rules Rules that must all hold for the monitor to fire, as query strings generated with the Query class: one comparing a usage metric, named as the usage endpoints name it (such as `network.outbound` or `databases.operations.reads`), with a threshold in the metric's unit (bytes for storage and bandwidth, MB-seconds for GB-hours, a count otherwise), and optionally `equal` rules on `resourceType` and `resourceId` to watch one database, bucket, function or site instead of the whole project.
     * @param window Seconds a counter metric is summed over, between 60 and 2592000. Gauges compare their latest value.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Set to false to create the monitor without evaluating it.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Defaults to owners; pass an empty list to rely on the alert events alone.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Leave empty to notify the `notify` roles once.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUsageMonitor(
        monitorId: String,
        name: String,
        rules: List<String>,
        window: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        val apiPath = "/monitors/usage"
        val apiParams = mutableMapOf<String, Any?>(
            "monitorId" to monitorId,
            "name" to name,
            "rules" to rules,
            "window" to window,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Update a usage monitor by its unique ID. Only the parameters passed change; the monitor's state and its open alert are kept. Passing `rules` replaces all of them.
     *
     * @param monitorId Monitor ID.
     * @param name Monitor name. Max length: 128 chars.
     * @param rules Rules that must all hold for the monitor to fire, as query strings generated with the Query class: one comparing a usage metric, named as the usage endpoints name it (such as `network.outbound` or `databases.operations.reads`), with a threshold in the metric's unit (bytes for storage and bandwidth, MB-seconds for GB-hours, a count otherwise), and optionally `equal` rules on `resourceType` and `resourceId` to watch one database, bucket, function or site instead of the whole project. Replaces the current rules.
     * @param window Seconds a counter metric is summed over, between 60 and 2592000. Gauges compare their latest value.
     * @param cooldown Minimum seconds between two team notifications of this monitor firing, between 300 and 2592000. Events fire on every change between firing and resolved regardless.
     * @param enabled Whether the monitor is evaluated.
     * @param notify Organization roles whose confirmed members get an email and a console notification when the monitor fires and resolves. Each must be an organization role, such as `owner` or `developer`. Pass an empty list to rely on the alert events alone; pass null or omit to keep the current roles.
     * @param severity How urgent the monitor's alerts are: `info`, `warning`, `error` or `critical`. Critical alerts may be delivered with higher urgency by the notification channels that support it, such as a push that rings through silent mode. Omit to keep the current one.
     * @param escalationId ID of an escalation of the organization that notifies the team of this monitor's alerts step by step, until a member acknowledges the alert or it resolves. When set, `notify` is not used. Pass an empty string to go back to the `notify` roles; pass null or omit to keep the current one.
     * @return [io.appwrite.models.Monitor]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateUsageMonitor(
        monitorId: String,
        name: String? = null,
        rules: List<String>? = null,
        window: Long? = null,
        cooldown: Long? = null,
        enabled: Boolean? = null,
        notify: List<String>? = null,
        severity: io.appwrite.enums.MonitorSeverity? = null,
        escalationId: String? = null,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/usage/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "rules" to rules,
            "window" to window,
            "cooldown" to cooldown,
            "enabled" to enabled,
            "notify" to notify,
            "severity" to severity,
            "escalationId" to escalationId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Get a monitor by its unique ID, with its state as of its last evaluation.
     *
     * @param monitorId Monitor ID.
     * @return [io.appwrite.models.Monitor]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        monitorId: String,
    ): io.appwrite.models.Monitor {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Monitor = {
            io.appwrite.models.Monitor.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Monitor::class.java,
            converter,
        )
    }

    /**
     * Delete a monitor by its unique ID. It stops being evaluated; an alert it is firing is resolved and kept with the rest of its alert history.
     *
     * @param monitorId Monitor ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        monitorId: String,
    ): Any {
        if (monitorId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"monitorId\"")
        }
        val apiPath = ("/monitors/{monitorId}"
            .replace("{monitorId}", Client.encodePath(monitorId))
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
}
