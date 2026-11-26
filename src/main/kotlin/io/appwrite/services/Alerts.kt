package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 * The Alerts service lists the alerts your monitors raised: when each fired, the readings while it fired, and when it resolved.
 */
class Alerts(client: Client) : Service(client) {
    /**
     * Get a list of the alerts the project's monitors raised, open and resolved. An alert is created when a monitor starts firing and resolved when it recovers. Use queries to filter by monitor, status, type or resource, order by `$createdAt` for the latest first, and `Query.search('search', term)` to search alert and monitor IDs, names and metrics.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: monitorId, name, status, type, resourceType, resourceId, metric, resolvedAt, severity, acknowledgedAt, escalationId, search
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AlertList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AlertList {
        val apiPath = "/alerts"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AlertList = {
            io.appwrite.models.AlertList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AlertList::class.java,
            converter,
        )
    }

    /**
     * Get an alert by its unique ID: the monitor that raised it, when it fired and resolved, and the readings while it fired.
     *
     * @param alertId Alert ID.
     * @return [io.appwrite.models.Alert]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        alertId: String,
    ): io.appwrite.models.Alert {
        if (alertId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"alertId\"")
        }
        val apiPath = ("/alerts/{alertId}"
            .replace("{alertId}", Client.encodePath(alertId))
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Alert = {
            io.appwrite.models.Alert.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Alert::class.java,
            converter,
        )
    }

    /**
     * Acknowledge a firing alert, or undo that. Everyone who can read the alert sees who acknowledged it and when. The alert keeps firing until its monitor recovers; a resolved alert keeps its acknowledgement and cannot be changed.
     *
     * @param alertId Alert ID.
     * @param acknowledged Whether the alert is acknowledged. False undoes an acknowledgement.
     * @return [io.appwrite.models.Alert]
     */
    @Throws(AppwriteException::class)
    suspend fun update(
        alertId: String,
        acknowledged: Boolean,
    ): io.appwrite.models.Alert {
        if (alertId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"alertId\"")
        }
        val apiPath = ("/alerts/{alertId}"
            .replace("{alertId}", Client.encodePath(alertId))
        )
        val apiParams = mutableMapOf<String, Any?>(
            "acknowledged" to acknowledged,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Alert = {
            io.appwrite.models.Alert.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Alert::class.java,
            converter,
        )
    }
}
