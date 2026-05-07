package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Proxy Service allows you to configure actions for your domains beyond DNS configuration.
**/
class Proxy(client: Client) : Service(client) {

    /**
     * Get a list of all the proxy rules. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: domain, type, trigger, deploymentResourceType, deploymentResourceId, deploymentId, deploymentVcsProviderBranch
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.ProxyRuleList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRules(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ProxyRuleList {
        val apiPath = "/proxy/rules"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ProxyRuleList = {
            io.appwrite.models.ProxyRuleList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRuleList::class.java,
            converter,
        )
    }

    /**
     * Create a new proxy rule for serving Appwrite's API on custom domain.
     * 
     * Rule ID is automatically generated as MD5 hash of a rule domain for performance purposes.
     *
     * @param domain Domain name.
     * @return [io.appwrite.models.ProxyRule]
     */
    @Throws(AppwriteException::class)
    suspend fun createAPIRule(
        domain: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/api"

        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
     * Create a new proxy rule for executing Appwrite Function on custom domain.
     * 
     * Rule ID is automatically generated as MD5 hash of a rule domain for performance purposes.
     *
     * @param domain Domain name.
     * @param functionId ID of function to be executed.
     * @param branch Name of VCS branch to deploy changes automatically
     * @return [io.appwrite.models.ProxyRule]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFunctionRule(
        domain: String,
        functionId: String,
        branch: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/function"

        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "functionId" to functionId,
            "branch" to branch,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
     * Create a new proxy rule for to redirect from custom domain to another domain.
     * 
     * Rule ID is automatically generated as MD5 hash of a rule domain for performance purposes.
     *
     * @param domain Domain name.
     * @param url Target URL of redirection
     * @param statusCode Status code of redirection
     * @param resourceId ID of parent resource.
     * @param resourceType Type of parent resource.
     * @return [io.appwrite.models.ProxyRule]
     */
    @Throws(AppwriteException::class)
    suspend fun createRedirectRule(
        domain: String,
        url: String,
        statusCode: io.appwrite.enums.StatusCode,
        resourceId: String,
        resourceType: io.appwrite.enums.ProxyResourceType,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/redirect"

        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "url" to url,
            "statusCode" to statusCode,
            "resourceId" to resourceId,
            "resourceType" to resourceType,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
     * Create a new proxy rule for serving Appwrite Site on custom domain.
     * 
     * Rule ID is automatically generated as MD5 hash of a rule domain for performance purposes.
     *
     * @param domain Domain name.
     * @param siteId ID of site to be executed.
     * @param branch Name of VCS branch to deploy changes automatically
     * @return [io.appwrite.models.ProxyRule]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSiteRule(
        domain: String,
        siteId: String,
        branch: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/site"

        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "siteId" to siteId,
            "branch" to branch,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
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

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

    /**
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
     * If not succeeded yet, retry verification process of a proxy rule domain. This endpoint triggers domain verification by checking DNS records. If verification is successful, a TLS certificate will be automatically provisioned for the domain asynchronously in the background.
     *
     * @param ruleId Rule ID.
     * @return [io.appwrite.models.ProxyRule]
     */
    @Throws(AppwriteException::class)
    suspend fun updateRuleStatus(
        ruleId: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/{ruleId}/status"
            .replace("{ruleId}", ruleId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProxyRule = {
            io.appwrite.models.ProxyRule.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class.java,
            converter,
        )
    }

}
