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
class Waf(client: Client) : Service(client) {
    /**
     * List WAF rules for the current project.
     *
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.WafRuleList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRules(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.WafRuleList {
        val apiPath = "/waf/rules"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleList = {
            io.appwrite.models.WafRuleList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleList::class.java,
            converter,
        )
    }

    /**
     * Create a bypass WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID. Choose a custom ID or pass `ID.unique()` to generate a unique one.
     * @param resourceType Resource type the rule applies to.
     * @param name Rule name.
     * @param resourceId Resource identifier. Leave empty for the API resource type.
     * @param description Optional description for the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to create the rule in a disabled state.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleBypass]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBypassRule(
        ruleId: String,
        resourceType: String,
        name: String,
        resourceId: String? = null,
        description: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleBypass {
        val apiPath = "/waf/rules/bypass"
        val apiParams = mutableMapOf<String, Any?>(
            "ruleId" to ruleId,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleBypass = {
            io.appwrite.models.WafRuleBypass.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleBypass::class.java,
            converter,
        )
    }

    /**
     * Update a bypass WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID.
     * @param resourceType Resource type the rule applies to.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param name Rule name.
     * @param description Optional description for the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to disable the rule.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleBypass]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBypassRule(
        ruleId: String,
        resourceType: String? = null,
        resourceId: String? = null,
        name: String? = null,
        description: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleBypass {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/bypass/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleBypass = {
            io.appwrite.models.WafRuleBypass.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleBypass::class.java,
            converter,
        )
    }

    /**
     * Create a challenge WAF rule. Use `difficulty` (1 easiest to 5 hardest) to tune the client-side proof-of-work cost, and `ttl` to control how long, in seconds, a visitor stays cleared after passing the challenge before being challenged again. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID. Choose a custom ID or pass `ID.unique()` to generate a unique one.
     * @param resourceType Resource type the rule applies to.
     * @param name Rule name.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param description Optional description for the rule.
     * @param challengeType Challenge type enforced by the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to create the rule in a disabled state.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @param difficulty Challenge difficulty from 1 (easiest) to 5 (hardest). Higher values demand more client-side proof-of-work.
     * @param ttl How long, in seconds, a visitor stays cleared after passing the challenge before being challenged again.
     * @return [io.appwrite.models.WafRuleChallenge]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createChallengeRule(
        ruleId: String,
        resourceType: String,
        name: String,
        resourceId: String? = null,
        description: String? = null,
        challengeType: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
        difficulty: Long? = null,
        ttl: Long? = null,
    ): io.appwrite.models.WafRuleChallenge {
        val apiPath = "/waf/rules/challenge"
        val apiParams = mutableMapOf<String, Any?>(
            "ruleId" to ruleId,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "challengeType" to challengeType,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
            "difficulty" to difficulty,
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleChallenge = {
            io.appwrite.models.WafRuleChallenge.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleChallenge::class.java,
            converter,
        )
    }

    /**
     * Update a challenge WAF rule. Use `difficulty` (1 easiest to 5 hardest) to tune the client-side proof-of-work cost, and `ttl` to control how long, in seconds, a visitor stays cleared after passing the challenge before being challenged again. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID.
     * @param resourceType Resource type the rule applies to.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param name Rule name.
     * @param description Optional description for the rule.
     * @param challengeType Challenge type enforced by the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to disable the rule.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @param difficulty Challenge difficulty from 1 (easiest) to 5 (hardest). Higher values demand more client-side proof-of-work.
     * @param ttl How long, in seconds, a visitor stays cleared after passing the challenge before being challenged again.
     * @return [io.appwrite.models.WafRuleChallenge]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateChallengeRule(
        ruleId: String,
        resourceType: String? = null,
        resourceId: String? = null,
        name: String? = null,
        description: String? = null,
        challengeType: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
        difficulty: Long? = null,
        ttl: Long? = null,
    ): io.appwrite.models.WafRuleChallenge {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/challenge/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "challengeType" to challengeType,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
            "difficulty" to difficulty,
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleChallenge = {
            io.appwrite.models.WafRuleChallenge.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleChallenge::class.java,
            converter,
        )
    }

    /**
     * Create a deny WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID. Choose a custom ID or pass `ID.unique()` to generate a unique one.
     * @param resourceType Resource type the rule applies to.
     * @param name Rule name.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param description Optional description for the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to create the rule in a disabled state.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleDeny]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDenyRule(
        ruleId: String,
        resourceType: String,
        name: String,
        resourceId: String? = null,
        description: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleDeny {
        val apiPath = "/waf/rules/deny"
        val apiParams = mutableMapOf<String, Any?>(
            "ruleId" to ruleId,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleDeny = {
            io.appwrite.models.WafRuleDeny.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleDeny::class.java,
            converter,
        )
    }

    /**
     * Update a deny WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID.
     * @param resourceType Resource type the rule applies to.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param name Rule name.
     * @param description Optional description for the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to disable the rule.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleDeny]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDenyRule(
        ruleId: String,
        resourceType: String? = null,
        resourceId: String? = null,
        name: String? = null,
        description: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleDeny {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/deny/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleDeny = {
            io.appwrite.models.WafRuleDeny.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleDeny::class.java,
            converter,
        )
    }

    /**
     * Create a rate limit WAF rule. Use `key` to choose the counter: `ip` limits per client IP, while `userId` limits per authenticated user (requests without an authenticated user skip `userId` rules). Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID. Choose a custom ID or pass `ID.unique()` to generate a unique one.
     * @param resourceType Resource type the rule applies to.
     * @param name Rule name.
     * @param limit Maximum number of matching requests allowed in the configured interval.
     * @param interval Interval in seconds used for rate limiting.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param description Optional description for the rule.
     * @param key Rate limit key. Use `ip` to limit per client IP or `userId` to limit per authenticated user. Requests without an authenticated user skip `userId` rules.
     * @param strategy Rate limit strategy. `fixedWindow` counts requests in discrete intervals, `slidingWindow` weights the previous interval for smoother limiting, and `tokenBucket` refills allowance continuously to permit short bursts.
     * @param maxBucketSize Maximum number of tokens the bucket can hold for the `tokenBucket` strategy, controlling how large a burst is allowed. The sustained refill rate is `limit / interval`. Defaults to `limit` when omitted. Ignored by other strategies.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to create the rule in a disabled state.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleRateLimit]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRateLimitRule(
        ruleId: String,
        resourceType: String,
        name: String,
        limit: Long,
        interval: Long,
        resourceId: String? = null,
        description: String? = null,
        key: String? = null,
        strategy: String? = null,
        maxBucketSize: Long? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleRateLimit {
        val apiPath = "/waf/rules/rate-limit"
        val apiParams = mutableMapOf<String, Any?>(
            "ruleId" to ruleId,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "limit" to limit,
            "interval" to interval,
            "key" to key,
            "strategy" to strategy,
            "maxBucketSize" to maxBucketSize,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleRateLimit = {
            io.appwrite.models.WafRuleRateLimit.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleRateLimit::class.java,
            converter,
        )
    }

    /**
     * Update a rate limit WAF rule. Use `key` to choose the counter: `ip` limits per client IP, while `userId` limits per authenticated user (requests without an authenticated user skip `userId` rules). Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID.
     * @param resourceType Resource type the rule applies to.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param name Rule name.
     * @param description Optional description for the rule.
     * @param limit Maximum number of matching requests allowed in the configured interval.
     * @param interval Interval in seconds used for rate limiting.
     * @param key Rate limit key. Use `ip` to limit per client IP or `userId` to limit per authenticated user. Requests without an authenticated user skip `userId` rules.
     * @param maxBucketSize Maximum number of tokens the bucket can hold for the `tokenBucket` strategy, controlling how large a burst is allowed. The sustained refill rate is `limit / interval`. Ignored by other strategies. The strategy itself cannot be changed after creation.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to disable the rule.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleRateLimit]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRateLimitRule(
        ruleId: String,
        resourceType: String? = null,
        resourceId: String? = null,
        name: String? = null,
        description: String? = null,
        limit: Long? = null,
        interval: Long? = null,
        key: String? = null,
        maxBucketSize: Long? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleRateLimit {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/rate-limit/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "limit" to limit,
            "interval" to interval,
            "key" to key,
            "maxBucketSize" to maxBucketSize,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleRateLimit = {
            io.appwrite.models.WafRuleRateLimit.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleRateLimit::class.java,
            converter,
        )
    }

    /**
     * Create a redirect WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID. Choose a custom ID or pass `ID.unique()` to generate a unique one.
     * @param resourceType Resource type the rule applies to.
     * @param name Rule name.
     * @param location Location used for redirect responses.
     * @param statusCode Integer status code used for redirect responses.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param description Optional description for the rule.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to create the rule in a disabled state.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleRedirect]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRedirectRule(
        ruleId: String,
        resourceType: String,
        name: String,
        location: String,
        statusCode: Long,
        resourceId: String? = null,
        description: String? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleRedirect {
        val apiPath = "/waf/rules/redirect"
        val apiParams = mutableMapOf<String, Any?>(
            "ruleId" to ruleId,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "location" to location,
            "statusCode" to statusCode,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleRedirect = {
            io.appwrite.models.WafRuleRedirect.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleRedirect::class.java,
            converter,
        )
    }

    /**
     * Update a redirect WAF rule. Conditions can match request attributes including `ip` (plain IPs or CIDR blocks like `10.0.0.0/8`), `method`, `path`, `host`, `country`, `continent`, `headers.<name>`, `query.<key>`, `queryKeys`, `userAgent`, `os`, `osVersion`, `browser`, and `browserVersion`. Conditions on `city` and `state` require the premium Geo DB addon.
     *
     *
     * @param ruleId Rule ID.
     * @param resourceType Resource type the rule applies to.
     * @param resourceId Resource identifier. Required for functions and sites.
     * @param name Rule name.
     * @param description Optional description for the rule.
     * @param location Location used for redirect responses.
     * @param statusCode Integer status code used for redirect responses.
     * @param priority Evaluation priority. Lower numbers run earlier.
     * @param enabled Set to false to disable the rule.
     * @param conditions Array of condition strings generated using the WAF Condition builder. Maximum of 100 conditions are allowed, each 4096 characters long.
     * @return [io.appwrite.models.WafRuleRedirect]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRedirectRule(
        ruleId: String,
        resourceType: String? = null,
        resourceId: String? = null,
        name: String? = null,
        description: String? = null,
        location: String? = null,
        statusCode: Long? = null,
        priority: Long? = null,
        enabled: Boolean? = null,
        conditions: List<String>? = null,
    ): io.appwrite.models.WafRuleRedirect {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/redirect/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "resourceType" to resourceType,
            "resourceId" to resourceId,
            "name" to name,
            "description" to description,
            "location" to location,
            "statusCode" to statusCode,
            "priority" to priority,
            "enabled" to enabled,
            "conditions" to conditions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.WafRuleRedirect = {
            io.appwrite.models.WafRuleRedirect.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WafRuleRedirect::class.java,
            converter,
        )
    }

    /**
     * Get a WAF rule by its ID.
     *
     *
     * @param ruleId Rule ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun getRule(
        ruleId: String,
    ): Any {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/{ruleId}"
            .replace("{ruleId}", ruleId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> Any = {
            val responseMap = it as? Map<String, Any>
                ?: throw Exception("Unable to match response to any expected response model")
            when {
                responseMap["action"]?.toString() == "bypass" -> io.appwrite.models.WafRuleBypass.from(map = responseMap)
                responseMap["action"]?.toString() == "deny" -> io.appwrite.models.WafRuleDeny.from(map = responseMap)
                responseMap["action"]?.toString() == "challenge" -> io.appwrite.models.WafRuleChallenge.from(map = responseMap)
                responseMap["action"]?.toString() == "rateLimit" -> io.appwrite.models.WafRuleRateLimit.from(map = responseMap)
                responseMap["action"]?.toString() == "redirect" -> io.appwrite.models.WafRuleRedirect.from(map = responseMap)
                else -> throw Exception("Unable to match response to any expected response model")
            }
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
            converter,
        )
    }

    /**
     * Delete a WAF rule.
     *
     *
     * @param ruleId Rule ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteRule(
        ruleId: String,
    ): Any {
        if (ruleId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"ruleId\"")
        }
        val apiPath = ("/waf/rules/{ruleId}"
            .replace("{ruleId}", ruleId)
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
