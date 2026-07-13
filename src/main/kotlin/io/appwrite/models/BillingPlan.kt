package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.BillingPlanGroup

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
    val members: Long,

    /**
     * Webhooks
     */
    @SerializedName("webhooks")
    val webhooks: Long,

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
    val activityLogs: Long,

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
     * Additional resources
     */
    @SerializedName("usage")
    val usage: UsageBillingPlan,

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
    val backupsEnabled: Boolean,

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
    val backupPolicies: Long,

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
     * Dedicated database limits available to this plan.
     */
    @SerializedName("dedicatedDatabases")
    var dedicatedDatabases: BillingPlanDedicatedDatabaseLimits?,

) {
    fun toMap(): Map<String, Any> = mapOf(
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
        "members" to members as Any,
        "webhooks" to webhooks as Any,
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
        "activityLogs" to activityLogs as Any,
        "usageLogs" to usageLogs as Any,
        "usageLogsIntervals" to usageLogsIntervals as Any,
        "projectInactivityDays" to projectInactivityDays as Any,
        "alertLimit" to alertLimit as Any,
        "usage" to usage.toMap() as Any,
        "addons" to addons.toMap() as Any,
        "budgetCapEnabled" to budgetCapEnabled as Any,
        "customSmtp" to customSmtp as Any,
        "emailBranding" to emailBranding as Any,
        "requiresPaymentMethod" to requiresPaymentMethod as Any,
        "requiresBillingAddress" to requiresBillingAddress as Any,
        "isAvailable" to isAvailable as Any,
        "selfService" to selfService as Any,
        "premiumSupport" to premiumSupport as Any,
        "budgeting" to budgeting as Any,
        "supportsMockNumbers" to supportsMockNumbers as Any,
        "supportsOrganizationRoles" to supportsOrganizationRoles as Any,
        "supportsCredits" to supportsCredits as Any,
        "supportsDisposableEmailValidation" to supportsDisposableEmailValidation as Any,
        "supportsCanonicalEmailValidation" to supportsCanonicalEmailValidation as Any,
        "supportsFreeEmailValidation" to supportsFreeEmailValidation as Any,
        "supportsCorporateEmailValidation" to supportsCorporateEmailValidation as Any,
        "supportsProjectSpecificRoles" to supportsProjectSpecificRoles as Any,
        "backupsEnabled" to backupsEnabled as Any,
        "usagePerProject" to usagePerProject as Any,
        "supportedAddons" to supportedAddons.toMap() as Any,
        "backupPolicies" to backupPolicies as Any,
        "deploymentSize" to deploymentSize as Any,
        "buildSize" to buildSize as Any,
        "databasesAllowEncrypt" to databasesAllowEncrypt as Any,
        "limits" to limits?.toMap() as Any,
        "group" to group.value as Any,
        "program" to program?.toMap() as Any,
        "dedicatedDatabases" to dedicatedDatabases?.toMap() as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlan(
            id = map["\$id"] as String,
            name = map["name"] as String,
            desc = map["desc"] as String,
            order = (map["order"] as Number).toLong(),
            price = (map["price"] as Number).toDouble(),
            trial = (map["trial"] as Number).toLong(),
            bandwidth = (map["bandwidth"] as Number).toLong(),
            storage = (map["storage"] as Number).toLong(),
            imageTransformations = (map["imageTransformations"] as Number).toLong(),
            screenshotsGenerated = (map["screenshotsGenerated"] as Number).toLong(),
            members = (map["members"] as Number).toLong(),
            webhooks = (map["webhooks"] as Number).toLong(),
            projects = (map["projects"] as Number).toLong(),
            platforms = (map["platforms"] as Number).toLong(),
            users = (map["users"] as Number).toLong(),
            teams = (map["teams"] as Number).toLong(),
            databases = (map["databases"] as Number).toLong(),
            databasesReads = (map["databasesReads"] as Number).toLong(),
            databasesWrites = (map["databasesWrites"] as Number).toLong(),
            databasesBatchSize = (map["databasesBatchSize"] as Number).toLong(),
            buckets = (map["buckets"] as Number).toLong(),
            fileSize = (map["fileSize"] as Number).toLong(),
            functions = (map["functions"] as Number).toLong(),
            sites = (map["sites"] as Number).toLong(),
            executions = (map["executions"] as Number).toLong(),
            executionsRetentionCount = (map["executionsRetentionCount"] as Number).toLong(),
            GBHours = (map["GBHours"] as Number).toLong(),
            realtime = (map["realtime"] as Number).toLong(),
            realtimeMessages = (map["realtimeMessages"] as Number).toLong(),
            messages = (map["messages"] as Number).toLong(),
            topics = (map["topics"] as Number).toLong(),
            authPhone = (map["authPhone"] as Number).toLong(),
            domains = (map["domains"] as Number).toLong(),
            activityLogs = (map["activityLogs"] as Number).toLong(),
            usageLogs = (map["usageLogs"] as Number).toLong(),
            usageLogsIntervals = map["usageLogsIntervals"] as? List<String>,
            projectInactivityDays = (map["projectInactivityDays"] as Number).toLong(),
            alertLimit = (map["alertLimit"] as Number).toLong(),
            usage = UsageBillingPlan.from(map = map["usage"] as Map<String, Any>),
            addons = BillingPlanAddon.from(map = map["addons"] as Map<String, Any>),
            budgetCapEnabled = map["budgetCapEnabled"] as Boolean,
            customSmtp = map["customSmtp"] as Boolean,
            emailBranding = map["emailBranding"] as Boolean,
            requiresPaymentMethod = map["requiresPaymentMethod"] as Boolean,
            requiresBillingAddress = map["requiresBillingAddress"] as Boolean,
            isAvailable = map["isAvailable"] as Boolean,
            selfService = map["selfService"] as Boolean,
            premiumSupport = map["premiumSupport"] as Boolean,
            budgeting = map["budgeting"] as Boolean,
            supportsMockNumbers = map["supportsMockNumbers"] as Boolean,
            supportsOrganizationRoles = map["supportsOrganizationRoles"] as Boolean,
            supportsCredits = map["supportsCredits"] as Boolean,
            supportsDisposableEmailValidation = map["supportsDisposableEmailValidation"] as Boolean,
            supportsCanonicalEmailValidation = map["supportsCanonicalEmailValidation"] as Boolean,
            supportsFreeEmailValidation = map["supportsFreeEmailValidation"] as Boolean,
            supportsCorporateEmailValidation = map["supportsCorporateEmailValidation"] as Boolean,
            supportsProjectSpecificRoles = map["supportsProjectSpecificRoles"] as Boolean,
            backupsEnabled = map["backupsEnabled"] as Boolean,
            usagePerProject = map["usagePerProject"] as Boolean,
            supportedAddons = BillingPlanSupportedAddons.from(map = map["supportedAddons"] as Map<String, Any>),
            backupPolicies = (map["backupPolicies"] as Number).toLong(),
            deploymentSize = (map["deploymentSize"] as Number).toLong(),
            buildSize = (map["buildSize"] as Number).toLong(),
            databasesAllowEncrypt = map["databasesAllowEncrypt"] as Boolean,
            limits = (map["limits"] as? Map<String, Any>)?.let { BillingPlanLimits.from(map = it) },
            group = BillingPlanGroup.values().find { it.value == map["group"] as String }!!,
            program = (map["program"] as? Map<String, Any>)?.let { Program.from(map = it) },
            dedicatedDatabases = (map["dedicatedDatabases"] as? Map<String, Any>)?.let { BillingPlanDedicatedDatabaseLimits.from(map = it) },
        )
    }
}