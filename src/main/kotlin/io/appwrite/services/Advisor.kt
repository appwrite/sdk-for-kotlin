package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Advisor service surfaces actionable reports about your project resources, with CTA descriptors for one-click remediation in the console.
**/
class Advisor(client: Client) : Service(client) {

    /**
     * Get a list of all the project's analyzer reports. You can use the query params to filter your results.
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: appId, type, targetType, target, analyzedAt
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.ReportList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listReports(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ReportList {
        val apiPath = "/reports"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ReportList = {
            io.appwrite.models.ReportList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ReportList::class.java,
            converter,
        )
    }

    /**
     * Get an analyzer report by its unique ID. The response includes the report's metadata and the nested insights it produced.
     * 
     *
     * @param reportId Report ID.
     * @return [io.appwrite.models.Report]
     */
    @Throws(AppwriteException::class)
    suspend fun getReport(
        reportId: String,
    ): io.appwrite.models.Report {
        val apiPath = "/reports/{reportId}"
            .replace("{reportId}", reportId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Report = {
            io.appwrite.models.Report.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Report::class.java,
            converter,
        )
    }

    /**
     * Delete an analyzer report by its unique ID. Nested insights and CTA metadata are removed asynchronously by the deletes worker.
     * 
     *
     * @param reportId Report ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteReport(
        reportId: String,
    ): Any {
        val apiPath = "/reports/{reportId}"
            .replace("{reportId}", reportId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
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
     * List the insights produced under a single analyzer report. You can use the query params to filter your results further.
     * 
     *
     * @param reportId Parent report ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: type, severity, status, resourceType, resourceId, parentResourceType, parentResourceId, analyzedAt, dismissedAt, dismissedBy
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.InsightList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listInsights(
        reportId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.InsightList {
        val apiPath = "/reports/{reportId}/insights"
            .replace("{reportId}", reportId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.InsightList = {
            io.appwrite.models.InsightList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.InsightList::class.java,
            converter,
        )
    }

    /**
     * Get an insight by its unique ID, scoped to its parent report.
     * 
     *
     * @param reportId Parent report ID.
     * @param insightId Insight ID.
     * @return [io.appwrite.models.Insight]
     */
    @Throws(AppwriteException::class)
    suspend fun getInsight(
        reportId: String,
        insightId: String,
    ): io.appwrite.models.Insight {
        val apiPath = "/reports/{reportId}/insights/{insightId}"
            .replace("{reportId}", reportId)
            .replace("{insightId}", insightId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Insight = {
            io.appwrite.models.Insight.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Insight::class.java,
            converter,
        )
    }

}
