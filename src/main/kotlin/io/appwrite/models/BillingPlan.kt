package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.BillingPlanGroup
import io.appwrite.extensions.jsonCast

/**
 * billingPlan
 */
data class BillingPlan(
    /**
     * Plan ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Plan name
     */
    @SerializedName("name")
    val name: String,

    /**
     * Plan description
     */
    @SerializedName("desc")
    val desc: String,

    /**
     * Plan order
     */
    @SerializedName("order")
    val order: Long,

    /**
     * Price
     */
    @SerializedName("price")
    val price: Double,

    /**
     * Trial days
     */
    @SerializedName("trial")
    val trial: Long,

    /**
     * Bandwidth
     */
    @SerializedName("bandwidth")
    val bandwidth: Long,

    /**
     * Storage
     */
    @SerializedName("storage")
    val storage: Long,

    /**
     * Image Transformations
     */
    @SerializedName("imageTransformations")
    val imageTransformations: Long,

    /**
     * Screenshots generated
     */
    @SerializedName("screenshotsGenerated")
    val screenshotsGenerated: Long,

    /**
     * Members
     */
    @SerializedName("members")
    var members: Long?,

    /**
     * Webhooks
     */
    @SerializedName("webhooks")
    val webhooks: Long,

    /**
     * Maximum WAF rules per project
     */
    @SerializedName("wafRules")
    val wafRules: Long,

    /**
     * Maximum environments per project. 0 when the plan does not offer environments.
     */
    @SerializedName("environments")
    val environments: Long,

    /**
     * Projects
     */
    @SerializedName("projects")
    val projects: Long,

    /**
     * Platforms
     */
    @SerializedName("platforms")
    val platforms: Long,

    /**
     * Users
     */
    @SerializedName("users")
    val users: Long,

    /**
     * Teams
     */
    @SerializedName("teams")
    val teams: Long,

    /**
     * Databases
     */
    @SerializedName("databases")
    val databases: Long,

    /**
     * Database reads per month
     */
    @SerializedName("databasesReads")
    val databasesReads: Long,

    /**
     * Database writes per month
     */
    @SerializedName("databasesWrites")
    val databasesWrites: Long,

    /**
     * Database batch size limit
     */
    @SerializedName("databasesBatchSize")
    val databasesBatchSize: Long,

    /**
     * Buckets
     */
    @SerializedName("buckets")
    val buckets: Long,

    /**
     * File size
     */
    @SerializedName("fileSize")
    val fileSize: Long,

    /**
     * Functions
     */
    @SerializedName("functions")
    val functions: Long,

    /**
     * Sites
     */
    @SerializedName("sites")
    val sites: Long,

    /**
     * Function executions
     */
    @SerializedName("executions")
    val executions: Long,

    /**
     * Rolling max executions retained per function/site
     */
    @SerializedName("executionsRetentionCount")
    val executionsRetentionCount: Long,

    /**
     * GB hours for functions
     */
    @SerializedName("GBHours")
    val GBHours: Long,

    /**
     * Realtime connections
     */
    @SerializedName("realtime")
    val realtime: Long,

    /**
     * Realtime messages
     */
    @SerializedName("realtimeMessages")
    val realtimeMessages: Long,

    /**
     * Messages per month
     */
    @SerializedName("messages")
    val messages: Long,

    /**
     * Topics for messaging
     */
    @SerializedName("topics")
    val topics: Long,

    /**
     * SMS authentications per month
     */
    @SerializedName("authPhone")
    val authPhone: Long,

    /**
     * Custom domains
     */
    @SerializedName("domains")
    val domains: Long,

    /**
     * Activity log days
     */
    @SerializedName("activityLogs")
    var activityLogs: Long?,

    /**
     * Usage history days
     */
    @SerializedName("usageLogs")
    val usageLogs: Long,

    /**
     * Usage log time intervals allowed for this plan (e.g. 15m, 1h, 1d).
     */
    @SerializedName("usageLogsIntervals")
    var usageLogsIntervals: List<String>?,

    /**
     * Metrics this plan only records as a total. They cannot be broken down by dimension or filtered, because the stored events cover a fraction of the real traffic.
     */
    @SerializedName("usageAggregateOnlyMetrics")
    var usageAggregateOnlyMetrics: List<String>?,

    /**
     * Number of days of console inactivity before a project is paused. 0 means pausing is disabled.
     */
    @SerializedName("projectInactivityDays")
    val projectInactivityDays: Long,

    /**
     * Alert threshold percentage
     */
    @SerializedName("alertLimit")
    val alertLimit: Long,

    /**
     * Additional resources. Null when the plan does not support usage billing.
     */
    @SerializedName("usage")
    var usage: UsageBillingPlan?,

    /**
     * Addons
     */
    @SerializedName("addons")
    val addons: BillingPlanAddon,

    /**
     * Budget cap enabled or disabled.
     */
    @SerializedName("budgetCapEnabled")
    val budgetCapEnabled: Boolean,

    /**
     * Custom SMTP
     */
    @SerializedName("customSmtp")
    val customSmtp: Boolean,

    /**
     * Appwrite branding in email
     */
    @SerializedName("emailBranding")
    val emailBranding: Boolean,

    /**
     * Does plan require payment method
     */
    @SerializedName("requiresPaymentMethod")
    val requiresPaymentMethod: Boolean,

    /**
     * Does plan require billing address
     */
    @SerializedName("requiresBillingAddress")
    val requiresBillingAddress: Boolean,

    /**
     * ISO country codes eligible for this regional plan. Empty means no restriction.
     */
    @SerializedName("eligibleCountries")
    var eligibleCountries: List<String>?,

    /**
     * Is the billing plan available
     */
    @SerializedName("isAvailable")
    val isAvailable: Boolean,

    /**
     * Can user change the plan themselves
     */
    @SerializedName("selfService")
    val selfService: Boolean,

    /**
     * Does plan enable premium support
     */
    @SerializedName("premiumSupport")
    val premiumSupport: Boolean,

    /**
     * Does plan support budget cap
     */
    @SerializedName("budgeting")
    val budgeting: Boolean,

    /**
     * Does plan support mock numbers
     */
    @SerializedName("supportsMockNumbers")
    val supportsMockNumbers: Boolean,

    /**
     * Does plan support organization roles
     */
    @SerializedName("supportsOrganizationRoles")
    val supportsOrganizationRoles: Boolean,

    /**
     * Does plan support credit
     */
    @SerializedName("supportsCredits")
    val supportsCredits: Boolean,

    /**
     * Does plan support dedicated databases.
     */
    @SerializedName("supportsDedicatedDatabases")
    val supportsDedicatedDatabases: Boolean,

    /**
     * Does plan support blocking disposable email addresses.
     */
    @SerializedName("supportsDisposableEmailValidation")
    val supportsDisposableEmailValidation: Boolean,

    /**
     * Does plan support requiring canonical email addresses.
     */
    @SerializedName("supportsCanonicalEmailValidation")
    val supportsCanonicalEmailValidation: Boolean,

    /**
     * Does plan support blocking free email addresses.
     */
    @SerializedName("supportsFreeEmailValidation")
    val supportsFreeEmailValidation: Boolean,

    /**
     * Does plan support restricting sign-ups to corporate email addresses only.
     */
    @SerializedName("supportsCorporateEmailValidation")
    val supportsCorporateEmailValidation: Boolean,

    /**
     * Does plan support project-specific member roles.
     */
    @SerializedName("supportsProjectSpecificRoles")
    val supportsProjectSpecificRoles: Boolean,

    /**
     * Does plan support backup policies.
     */
    @SerializedName("backupsEnabled")
    var backupsEnabled: Boolean?,

    /**
     * Whether usage addons are calculated per project.
     */
    @SerializedName("usagePerProject")
    val usagePerProject: Boolean,

    /**
     * Supported addons for this plan
     */
    @SerializedName("supportedAddons")
    val supportedAddons: BillingPlanSupportedAddons,

    /**
     * How many policies does plan support
     */
    @SerializedName("backupPolicies")
    var backupPolicies: Long?,

    /**
     * Maximum function and site deployment size in MB
     */
    @SerializedName("deploymentSize")
    val deploymentSize: Long,

    /**
     * Maximum function and site deployment size in MB
     */
    @SerializedName("buildSize")
    val buildSize: Long,

    /**
     * Shortest function schedule interval allowed, in minutes. 0 allows every interval.
     */
    @SerializedName("functionsIntervalMinimum")
    val functionsIntervalMinimum: Long,

    /**
     * Does the plan allow cron function schedules or only intervals.
     */
    @SerializedName("functionsAllowCron")
    val functionsAllowCron: Boolean,

    /**
     * Does the plan support encrypted string attributes or not.
     */
    @SerializedName("databasesAllowEncrypt")
    val databasesAllowEncrypt: Boolean,

    /**
     * Plan specific limits
     */
    @SerializedName("limits")
    var limits: BillingPlanLimits?,

    /**
     * Group of this billing plan for variants
     */
    @SerializedName("group")
    val group: BillingPlanGroup,

    /**
     * Details of the program this plan is a part of.
     */
    @SerializedName("program")
    var program: Program?,

    /**
     * Included monthly dedicated-database compute credit in USD. Resets each billing cycle with no roll-over.
     */
    @SerializedName("databaseComputeCredit")
    val databaseComputeCredit: Double,

    /**
     * Dedicated database limits available to this plan.
     */
    @SerializedName("dedicatedDatabases")
    var dedicatedDatabases: BillingPlanDedicatedDatabaseLimits?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "desc" to desc as Any,
        "order" to order as Any,
        "price" to price as Any,
        "trial" to trial as Any,
        "bandwidth" to bandwidth as Any,
        "storage" to storage as Any,
        "imageTransformations" to imageTransformations as Any,
        "screenshotsGenerated" to screenshotsGenerated as Any,
        "members" to members as Any?,
        "webhooks" to webhooks as Any,
        "wafRules" to wafRules as Any,
        "environments" to environments as Any,
        "projects" to projects as Any,
        "platforms" to platforms as Any,
        "users" to users as Any,
        "teams" to teams as Any,
        "databases" to databases as Any,
        "databasesReads" to databasesReads as Any,
        "databasesWrites" to databasesWrites as Any,
        "databasesBatchSize" to databasesBatchSize as Any,
        "buckets" to buckets as Any,
        "fileSize" to fileSize as Any,
        "functions" to functions as Any,
        "sites" to sites as Any,
        "executions" to executions as Any,
        "executionsRetentionCount" to executionsRetentionCount as Any,
        "GBHours" to GBHours as Any,
        "realtime" to realtime as Any,
        "realtimeMessages" to realtimeMessages as Any,
        "messages" to messages as Any,
        "topics" to topics as Any,
        "authPhone" to authPhone as Any,
        "domains" to domains as Any,
        "activityLogs" to activityLogs as Any?,
        "usageLogs" to usageLogs as Any,
        "usageLogsIntervals" to usageLogsIntervals as Any?,
        "usageAggregateOnlyMetrics" to usageAggregateOnlyMetrics as Any?,
        "projectInactivityDays" to projectInactivityDays as Any,
        "alertLimit" to alertLimit as Any,
        "usage" to usage?.toMap() as Any?,
        "addons" to addons.toMap() as Any,
        "budgetCapEnabled" to budgetCapEnabled as Any,
        "customSmtp" to customSmtp as Any,
        "emailBranding" to emailBranding as Any,
        "requiresPaymentMethod" to requiresPaymentMethod as Any,
        "requiresBillingAddress" to requiresBillingAddress as Any,
        "eligibleCountries" to eligibleCountries as Any?,
        "isAvailable" to isAvailable as Any,
        "selfService" to selfService as Any,
        "premiumSupport" to premiumSupport as Any,
        "budgeting" to budgeting as Any,
        "supportsMockNumbers" to supportsMockNumbers as Any,
        "supportsOrganizationRoles" to supportsOrganizationRoles as Any,
        "supportsCredits" to supportsCredits as Any,
        "supportsDedicatedDatabases" to supportsDedicatedDatabases as Any,
        "supportsDisposableEmailValidation" to supportsDisposableEmailValidation as Any,
        "supportsCanonicalEmailValidation" to supportsCanonicalEmailValidation as Any,
        "supportsFreeEmailValidation" to supportsFreeEmailValidation as Any,
        "supportsCorporateEmailValidation" to supportsCorporateEmailValidation as Any,
        "supportsProjectSpecificRoles" to supportsProjectSpecificRoles as Any,
        "backupsEnabled" to backupsEnabled as Any?,
        "usagePerProject" to usagePerProject as Any,
        "supportedAddons" to supportedAddons.toMap() as Any,
        "backupPolicies" to backupPolicies as Any?,
        "deploymentSize" to deploymentSize as Any,
        "buildSize" to buildSize as Any,
        "functionsIntervalMinimum" to functionsIntervalMinimum as Any,
        "functionsAllowCron" to functionsAllowCron as Any,
        "databasesAllowEncrypt" to databasesAllowEncrypt as Any,
        "limits" to limits?.toMap() as Any?,
        "group" to group.value as Any,
        "program" to program?.toMap() as Any?,
        "databaseComputeCredit" to databaseComputeCredit as Any,
        "dedicatedDatabases" to dedicatedDatabases?.toMap() as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlan(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            desc = (if (map.containsKey("desc")) map["desc"] else "") as String,
            order = ((if (map.containsKey("order")) map["order"] else 0) as Number).toLong(),
            price = ((if (map.containsKey("price")) map["price"] else 0.0) as Number).toDouble(),
            trial = ((if (map.containsKey("trial")) map["trial"] else 0) as Number).toLong(),
            bandwidth = ((if (map.containsKey("bandwidth")) map["bandwidth"] else 0) as Number).toLong(),
            storage = ((if (map.containsKey("storage")) map["storage"] else 0) as Number).toLong(),
            imageTransformations = ((if (map.containsKey("imageTransformations")) map["imageTransformations"] else 0) as Number).toLong(),
            screenshotsGenerated = ((if (map.containsKey("screenshotsGenerated")) map["screenshotsGenerated"] else 0) as Number).toLong(),
            members = (map["members"] as? Number)?.toLong(),
            webhooks = ((if (map.containsKey("webhooks")) map["webhooks"] else 0) as Number).toLong(),
            wafRules = ((if (map.containsKey("wafRules")) map["wafRules"] else 0) as Number).toLong(),
            environments = ((if (map.containsKey("environments")) map["environments"] else 0) as Number).toLong(),
            projects = ((if (map.containsKey("projects")) map["projects"] else 0) as Number).toLong(),
            platforms = ((if (map.containsKey("platforms")) map["platforms"] else 0) as Number).toLong(),
            users = ((if (map.containsKey("users")) map["users"] else 0) as Number).toLong(),
            teams = ((if (map.containsKey("teams")) map["teams"] else 0) as Number).toLong(),
            databases = ((if (map.containsKey("databases")) map["databases"] else 0) as Number).toLong(),
            databasesReads = ((if (map.containsKey("databasesReads")) map["databasesReads"] else 0) as Number).toLong(),
            databasesWrites = ((if (map.containsKey("databasesWrites")) map["databasesWrites"] else 0) as Number).toLong(),
            databasesBatchSize = ((if (map.containsKey("databasesBatchSize")) map["databasesBatchSize"] else 0) as Number).toLong(),
            buckets = ((if (map.containsKey("buckets")) map["buckets"] else 0) as Number).toLong(),
            fileSize = ((if (map.containsKey("fileSize")) map["fileSize"] else 0) as Number).toLong(),
            functions = ((if (map.containsKey("functions")) map["functions"] else 0) as Number).toLong(),
            sites = ((if (map.containsKey("sites")) map["sites"] else 0) as Number).toLong(),
            executions = ((if (map.containsKey("executions")) map["executions"] else 0) as Number).toLong(),
            executionsRetentionCount = ((if (map.containsKey("executionsRetentionCount")) map["executionsRetentionCount"] else 1000) as Number).toLong(),
            GBHours = ((if (map.containsKey("GBHours")) map["GBHours"] else 0) as Number).toLong(),
            realtime = ((if (map.containsKey("realtime")) map["realtime"] else 0) as Number).toLong(),
            realtimeMessages = ((if (map.containsKey("realtimeMessages")) map["realtimeMessages"] else 0) as Number).toLong(),
            messages = ((if (map.containsKey("messages")) map["messages"] else 0) as Number).toLong(),
            topics = ((if (map.containsKey("topics")) map["topics"] else 0) as Number).toLong(),
            authPhone = ((if (map.containsKey("authPhone")) map["authPhone"] else 0) as Number).toLong(),
            domains = ((if (map.containsKey("domains")) map["domains"] else 0) as Number).toLong(),
            activityLogs = (map["activityLogs"] as? Number)?.toLong(),
            usageLogs = ((if (map.containsKey("usageLogs")) map["usageLogs"] else 0) as Number).toLong(),
            usageLogsIntervals = map["usageLogsIntervals"] as? List<String>,
            usageAggregateOnlyMetrics = map["usageAggregateOnlyMetrics"] as? List<String>,
            projectInactivityDays = ((if (map.containsKey("projectInactivityDays")) map["projectInactivityDays"] else 0) as Number).toLong(),
            alertLimit = ((if (map.containsKey("alertLimit")) map["alertLimit"] else 80) as Number).toLong(),
            usage = (map["usage"] as? Map<String, Any>)?.let { UsageBillingPlan.from(map = it) },
            addons = BillingPlanAddon.from(map = map["addons"] as Map<String, Any>),
            budgetCapEnabled = (if (map.containsKey("budgetCapEnabled")) map["budgetCapEnabled"] else false) as Boolean,
            customSmtp = (if (map.containsKey("customSmtp")) map["customSmtp"] else false) as Boolean,
            emailBranding = (if (map.containsKey("emailBranding")) map["emailBranding"] else false) as Boolean,
            requiresPaymentMethod = (if (map.containsKey("requiresPaymentMethod")) map["requiresPaymentMethod"] else true) as Boolean,
            requiresBillingAddress = (if (map.containsKey("requiresBillingAddress")) map["requiresBillingAddress"] else false) as Boolean,
            eligibleCountries = map["eligibleCountries"] as? List<String>,
            isAvailable = (if (map.containsKey("isAvailable")) map["isAvailable"] else true) as Boolean,
            selfService = (if (map.containsKey("selfService")) map["selfService"] else true) as Boolean,
            premiumSupport = (if (map.containsKey("premiumSupport")) map["premiumSupport"] else true) as Boolean,
            budgeting = (if (map.containsKey("budgeting")) map["budgeting"] else true) as Boolean,
            supportsMockNumbers = (if (map.containsKey("supportsMockNumbers")) map["supportsMockNumbers"] else true) as Boolean,
            supportsOrganizationRoles = (if (map.containsKey("supportsOrganizationRoles")) map["supportsOrganizationRoles"] else true) as Boolean,
            supportsCredits = (if (map.containsKey("supportsCredits")) map["supportsCredits"] else false) as Boolean,
            supportsDedicatedDatabases = (if (map.containsKey("supportsDedicatedDatabases")) map["supportsDedicatedDatabases"] else false) as Boolean,
            supportsDisposableEmailValidation = (if (map.containsKey("supportsDisposableEmailValidation")) map["supportsDisposableEmailValidation"] else false) as Boolean,
            supportsCanonicalEmailValidation = (if (map.containsKey("supportsCanonicalEmailValidation")) map["supportsCanonicalEmailValidation"] else false) as Boolean,
            supportsFreeEmailValidation = (if (map.containsKey("supportsFreeEmailValidation")) map["supportsFreeEmailValidation"] else false) as Boolean,
            supportsCorporateEmailValidation = (if (map.containsKey("supportsCorporateEmailValidation")) map["supportsCorporateEmailValidation"] else false) as Boolean,
            supportsProjectSpecificRoles = (if (map.containsKey("supportsProjectSpecificRoles")) map["supportsProjectSpecificRoles"] else false) as Boolean,
            backupsEnabled = map["backupsEnabled"] as? Boolean,
            usagePerProject = (if (map.containsKey("usagePerProject")) map["usagePerProject"] else true) as Boolean,
            supportedAddons = BillingPlanSupportedAddons.from(map = map["supportedAddons"] as Map<String, Any>),
            backupPolicies = (map["backupPolicies"] as? Number)?.toLong(),
            deploymentSize = ((if (map.containsKey("deploymentSize")) map["deploymentSize"] else 0) as Number).toLong(),
            buildSize = ((if (map.containsKey("buildSize")) map["buildSize"] else 0) as Number).toLong(),
            functionsIntervalMinimum = ((if (map.containsKey("functionsIntervalMinimum")) map["functionsIntervalMinimum"] else 0) as Number).toLong(),
            functionsAllowCron = (if (map.containsKey("functionsAllowCron")) map["functionsAllowCron"] else true) as Boolean,
            databasesAllowEncrypt = (if (map.containsKey("databasesAllowEncrypt")) map["databasesAllowEncrypt"] else false) as Boolean,
            limits = (map["limits"] as? Map<String, Any>)?.let { BillingPlanLimits.from(map = it) },
            group = BillingPlanGroup.values().find { it.value == map["group"] as String }!!,
            program = (map["program"] as? Map<String, Any>)?.let { Program.from(map = it) },
            databaseComputeCredit = ((if (map.containsKey("databaseComputeCredit")) map["databaseComputeCredit"] else 0.0) as Number).toDouble(),
            dedicatedDatabases = (map["dedicatedDatabases"] as? Map<String, Any>)?.let { BillingPlanDedicatedDatabaseLimits.from(map = it) },
        )
    }
}
