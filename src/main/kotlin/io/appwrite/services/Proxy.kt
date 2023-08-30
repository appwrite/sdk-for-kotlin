package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Proxy Service allows you to configure actions for your domains beyond DNS configuration.
**/
class Proxy : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Rules
     *
     * Get a list of all the proxy rules. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: domain, resourceType, resourceId, url
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ProxyRuleList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRules(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.ProxyRuleList {
        val apiPath = "/proxy/rules"

        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRuleList = {
            io.appwrite.models.ProxyRuleList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProxyRuleList::class.java,
            converter,
        )
    }

    /**
     * Create Rule
     *
     * Create a new proxy rule.
     *
     * @param domain Domain name.
     * @param resourceType Action definition for the rule. Possible values are "api", "function"
     * @param resourceId ID of resource for the action type. If resourceType is "api", leave empty. If resourceType is "function", provide ID of the function.
     * @return [io.appwrite.models.ProxyRule]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRule(
        domain: String,
        resourceType: String,
        resourceId: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules"

        val params = mutableMapOf<String, Any?>(
            "domain" to domain,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
     * Get Rule
     *
     * Get a proxy rule by its unique ID.
     *
     * @param ruleId Rule ID.
     * @return [io.appwrite.models.ProxyRule]
     */
    @Throws(AppwriteException::class)
    suspend fun getRule(
        ruleId: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/{ruleId}"
            .replace("{ruleId}", ruleId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
     * Delete Rule
     *
     * Delete a proxy rule by its unique ID.
     *
     * @param ruleId Rule ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteRule(
        ruleId: String,
    ): Any {
        val apiPath = "/proxy/rules/{ruleId}"
            .replace("{ruleId}", ruleId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            headers,
            params,
            responseType = Any::class.java,
        )
    }

    /**
     * Update Rule Verification Status
     *
     * 
     *
     * @param ruleId Rule ID.
     * @return [io.appwrite.models.ProxyRule]
     */
    @Throws(AppwriteException::class)
    suspend fun updateRuleVerification(
        ruleId: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/{ruleId}/verification"
            .replace("{ruleId}", ruleId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

}