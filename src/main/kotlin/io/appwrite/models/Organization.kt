package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Organization
 */
data class Organization<T>(
    /**
     * Team ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Team creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Team update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Team name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Total number of team members.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * Team preferences as a key-value object
     */
    @SerializedName("prefs")
    val prefs: Preferences<T>,

    /**
     * Project budget limit
     */
    @SerializedName("billingBudget")
    val billingBudget: Long,

    /**
     * Project budget limit
     */
    @SerializedName("budgetAlerts")
    val budgetAlerts: List<Long>,

    /**
     * Organization's billing plan ID.
     */
    @SerializedName("billingPlan")
    val billingPlan: String,

    /**
     * Organization's billing plan ID.
     */
    @SerializedName("billingPlanId")
    val billingPlanId: String,

    /**
     * Organization's billing plan.
     */
    @SerializedName("billingPlanDetails")
    val billingPlanDetails: BillingPlan,

    /**
     * Billing email set for the organization.
     */
    @SerializedName("billingEmail")
    val billingEmail: String,

    /**
     * Billing cycle start date.
     */
    @SerializedName("billingStartDate")
    val billingStartDate: String,

    /**
     * Current invoice cycle start date.
     */
    @SerializedName("billingCurrentInvoiceDate")
    val billingCurrentInvoiceDate: String,

    /**
     * Next invoice cycle start date.
     */
    @SerializedName("billingNextInvoiceDate")
    val billingNextInvoiceDate: String,

    /**
     * Start date of trial.
     */
    @SerializedName("billingTrialStartDate")
    val billingTrialStartDate: String,

    /**
     * Number of trial days.
     */
    @SerializedName("billingTrialDays")
    val billingTrialDays: Long,

    /**
     * Current active aggregation id.
     */
    @SerializedName("billingAggregationId")
    val billingAggregationId: String,

    /**
     * Current active aggregation id.
     */
    @SerializedName("billingInvoiceId")
    val billingInvoiceId: String,

    /**
     * Default payment method.
     */
    @SerializedName("paymentMethodId")
    val paymentMethodId: String,

    /**
     * Default payment method.
     */
    @SerializedName("billingAddressId")
    val billingAddressId: String,

    /**
     * Backup payment method.
     */
    @SerializedName("backupPaymentMethodId")
    val backupPaymentMethodId: String,

    /**
     * Team status.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Remarks on team status.
     */
    @SerializedName("remarks")
    val remarks: String,

    /**
     * Organization agreements
     */
    @SerializedName("agreementBAA")
    val agreementBAA: String,

    /**
     * Program manager's name.
     */
    @SerializedName("programManagerName")
    val programManagerName: String,

    /**
     * Program manager's calendar link.
     */
    @SerializedName("programManagerCalendar")
    val programManagerCalendar: String,

    /**
     * Program's discord channel name.
     */
    @SerializedName("programDiscordChannelName")
    val programDiscordChannelName: String,

    /**
     * Program's discord channel URL.
     */
    @SerializedName("programDiscordChannelUrl")
    val programDiscordChannelUrl: String,

    /**
     * Billing limits reached
     */
    @SerializedName("billingLimits")
    var billingLimits: BillingLimits?,

    /**
     * Billing plan selected for downgrade.
     */
    @SerializedName("billingPlanDowngrade")
    val billingPlanDowngrade: String,

    /**
     * Tax Id
     */
    @SerializedName("billingTaxId")
    val billingTaxId: String,

    /**
     * Marked for deletion
     */
    @SerializedName("markedForDeletion")
    val markedForDeletion: Boolean,

    /**
     * Product with which the organization is associated (appwrite or imagine)
     */
    @SerializedName("platform")
    val platform: String,

    /**
     * Selected projects
     */
    @SerializedName("projects")
    val projects: List<String>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "total" to total as Any,
        "prefs" to prefs.toMap() as Any,
        "billingBudget" to billingBudget as Any,
        "budgetAlerts" to budgetAlerts as Any,
        "billingPlan" to billingPlan as Any,
        "billingPlanId" to billingPlanId as Any,
        "billingPlanDetails" to billingPlanDetails.toMap() as Any,
        "billingEmail" to billingEmail as Any,
        "billingStartDate" to billingStartDate as Any,
        "billingCurrentInvoiceDate" to billingCurrentInvoiceDate as Any,
        "billingNextInvoiceDate" to billingNextInvoiceDate as Any,
        "billingTrialStartDate" to billingTrialStartDate as Any,
        "billingTrialDays" to billingTrialDays as Any,
        "billingAggregationId" to billingAggregationId as Any,
        "billingInvoiceId" to billingInvoiceId as Any,
        "paymentMethodId" to paymentMethodId as Any,
        "billingAddressId" to billingAddressId as Any,
        "backupPaymentMethodId" to backupPaymentMethodId as Any,
        "status" to status as Any,
        "remarks" to remarks as Any,
        "agreementBAA" to agreementBAA as Any,
        "programManagerName" to programManagerName as Any,
        "programManagerCalendar" to programManagerCalendar as Any,
        "programDiscordChannelName" to programDiscordChannelName as Any,
        "programDiscordChannelUrl" to programDiscordChannelUrl as Any,
        "billingLimits" to billingLimits?.toMap() as Any,
        "billingPlanDowngrade" to billingPlanDowngrade as Any,
        "billingTaxId" to billingTaxId as Any,
        "markedForDeletion" to markedForDeletion as Any,
        "platform" to platform as Any,
        "projects" to projects as Any,
    )

    companion object {
        operator fun invoke(
            id: String,
            createdAt: String,
            updatedAt: String,
            name: String,
            total: Long,
            prefs: Preferences<Map<String, Any>>,
            billingBudget: Long,
            budgetAlerts: List<Long>,
            billingPlan: String,
            billingPlanId: String,
            billingPlanDetails: BillingPlan,
            billingEmail: String,
            billingStartDate: String,
            billingCurrentInvoiceDate: String,
            billingNextInvoiceDate: String,
            billingTrialStartDate: String,
            billingTrialDays: Long,
            billingAggregationId: String,
            billingInvoiceId: String,
            paymentMethodId: String,
            billingAddressId: String,
            backupPaymentMethodId: String,
            status: String,
            remarks: String,
            agreementBAA: String,
            programManagerName: String,
            programManagerCalendar: String,
            programDiscordChannelName: String,
            programDiscordChannelUrl: String,
            billingLimits: BillingLimits?,
            billingPlanDowngrade: String,
            billingTaxId: String,
            markedForDeletion: Boolean,
            platform: String,
            projects: List<String>,
        ) = Organization<Map<String, Any>>(
            id,
            createdAt,
            updatedAt,
            name,
            total,
            prefs,
            billingBudget,
            budgetAlerts,
            billingPlan,
            billingPlanId,
            billingPlanDetails,
            billingEmail,
            billingStartDate,
            billingCurrentInvoiceDate,
            billingNextInvoiceDate,
            billingTrialStartDate,
            billingTrialDays,
            billingAggregationId,
            billingInvoiceId,
            paymentMethodId,
            billingAddressId,
            backupPaymentMethodId,
            status,
            remarks,
            agreementBAA,
            programManagerName,
            programManagerCalendar,
            programDiscordChannelName,
            programDiscordChannelUrl,
            billingLimits,
            billingPlanDowngrade,
            billingTaxId,
            markedForDeletion,
            platform,
            projects,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = Organization<T>(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            total = (map["total"] as Number).toLong(),
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>, nestedType),
            billingBudget = (map["billingBudget"] as Number).toLong(),
            budgetAlerts = map["budgetAlerts"] as List<Long>,
            billingPlan = map["billingPlan"] as String,
            billingPlanId = map["billingPlanId"] as String,
            billingPlanDetails = BillingPlan.from(map = map["billingPlanDetails"] as Map<String, Any>),
            billingEmail = map["billingEmail"] as String,
            billingStartDate = map["billingStartDate"] as String,
            billingCurrentInvoiceDate = map["billingCurrentInvoiceDate"] as String,
            billingNextInvoiceDate = map["billingNextInvoiceDate"] as String,
            billingTrialStartDate = map["billingTrialStartDate"] as String,
            billingTrialDays = (map["billingTrialDays"] as Number).toLong(),
            billingAggregationId = map["billingAggregationId"] as String,
            billingInvoiceId = map["billingInvoiceId"] as String,
            paymentMethodId = map["paymentMethodId"] as String,
            billingAddressId = map["billingAddressId"] as String,
            backupPaymentMethodId = map["backupPaymentMethodId"] as String,
            status = map["status"] as String,
            remarks = map["remarks"] as String,
            agreementBAA = map["agreementBAA"] as String,
            programManagerName = map["programManagerName"] as String,
            programManagerCalendar = map["programManagerCalendar"] as String,
            programDiscordChannelName = map["programDiscordChannelName"] as String,
            programDiscordChannelUrl = map["programDiscordChannelUrl"] as String,
            billingLimits = BillingLimits.from(map = map["billingLimits"] as Map<String, Any>),
            billingPlanDowngrade = map["billingPlanDowngrade"] as String,
            billingTaxId = map["billingTaxId"] as String,
            markedForDeletion = map["markedForDeletion"] as Boolean,
            platform = map["platform"] as String,
            projects = map["projects"] as List<String>,
        )
    }
}