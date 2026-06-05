package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Usage(client: Client) : Service(client) {

    /**
     * Query usage event metrics from the usage database. Returns individual event rows with full metadata. Pass Query objects as JSON strings to filter, paginate, and order results. Supported query methods: equal, greaterThanEqual, lessThanEqual, orderAsc, orderDesc, limit, offset. Supported filter attributes: metric, path, method, status, resource, resourceId, country, userAgent, time (these match the underlying column names — note that the response surfaces `resource` as `resourceType` and `country` as `countryCode`). When no time filter is supplied the endpoint defaults to the last 7 days. Default `limit(100)` is applied if none is given; user-supplied limits are capped at 500. The `total` field is capped at 5000 to keep counts predictable — pass `total=false` to skip the count entirely.
     *
     * @param queries Array of query strings as JSON. Supported: equal("metric", [...]), equal("path", [...]), equal("method", [...]), equal("status", [...]), equal("resource", [...]), equal("resourceId", [...]), equal("country", [...]), equal("userAgent", [...]), greaterThanEqual("time", "..."), lessThanEqual("time", "..."), orderAsc("time"), orderDesc("time"), limit(N), offset(N).
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.UsageEventList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listEvents(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.UsageEventList {
        val apiPath = "/usage/events"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
        )
        val converter: (Any) -> io.appwrite.models.UsageEventList = {
            io.appwrite.models.UsageEventList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageEventList::class.java,
            converter,
        )
    }

    /**
     * Query usage gauge metrics (point-in-time resource snapshots) from the usage database. Returns individual gauge snapshots with metric, value, timestamp, resourceType, and resourceId. Pass Query objects as JSON strings to filter, paginate, and order results. Supported query methods: equal, greaterThanEqual, lessThanEqual, orderAsc, orderDesc, limit, offset. Supported filter attributes: metric, time. Use `orderDesc("time"), limit(1)` to fetch the most recent snapshot. When no time filter is supplied the endpoint defaults to the last 7 days. Default `limit(100)` is applied if none is given; user-supplied limits are capped at 500. The `total` field is capped at 5000 to keep counts predictable — pass `total=false` to skip the count entirely.
     *
     * @param queries Array of query strings as JSON. Supported: equal("metric", [...]), greaterThanEqual("time", "..."), lessThanEqual("time", "..."), orderAsc("time"), orderDesc("time"), limit(N), offset(N).
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.UsageGaugeList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listGauges(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.UsageGaugeList {
        val apiPath = "/usage/gauges"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
        )
        val converter: (Any) -> io.appwrite.models.UsageGaugeList = {
            io.appwrite.models.UsageGaugeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageGaugeList::class.java,
            converter,
        )
    }

}
