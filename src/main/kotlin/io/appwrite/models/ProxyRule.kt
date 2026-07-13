package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.ProxyRuleDeploymentResourceType
import io.appwrite.enums.ProxyRuleStatus

/**
 * Rule
 */
data class ProxyRule(
    /**
     * Rule ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Rule creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Rule update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Domain name.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Action definition for the rule. Possible values are "api", "deployment", or "redirect"
     */
    @SerializedName("type")
    val type: String,

    /**
     * Defines how the rule was created. Possible values are "manual" or "deployment"
     */
    @SerializedName("trigger")
    val trigger: String,

    /**
     * URL to redirect to. Used if type is "redirect"
     */
    @SerializedName("redirectUrl")
    val redirectUrl: String,

    /**
     * Status code to apply during redirect. Used if type is "redirect"
     */
    @SerializedName("redirectStatusCode")
    val redirectStatusCode: Long,

    /**
     * ID of deployment. Used if type is "deployment"
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * Type of deployment. Possible values are "function", "site". Used if rule's type is "deployment".
     */
    @SerializedName("deploymentResourceType")
    var deploymentResourceType: ProxyRuleDeploymentResourceType?,

    /**
     * ID of deployment's resource (site or function ID). Used if type is "deployment"
     */
    @SerializedName("deploymentResourceId")
    val deploymentResourceId: String,

    /**
     * Name of Git branch that updates rule. Used if type is "deployment"
     */
    @SerializedName("deploymentVcsProviderBranch")
    val deploymentVcsProviderBranch: String,

    /**
     * Domain verification status. Possible values are "unverified", "verifying", "verified"
     */
    @SerializedName("status")
    val status: ProxyRuleStatus,

    /**
     * Logs from rule verification or certificate generation. Certificate generation logs are prioritized if both are available.
     */
    @SerializedName("logs")
    val logs: String,

    /**
     * Certificate auto-renewal date in ISO 8601 format.
     */
    @SerializedName("renewAt")
    val renewAt: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "domain" to domain as Any,
        "type" to type as Any,
        "trigger" to trigger as Any,
        "redirectUrl" to redirectUrl as Any,
        "redirectStatusCode" to redirectStatusCode as Any,
        "deploymentId" to deploymentId as Any,
        "deploymentResourceType" to deploymentResourceType?.value as Any?,
        "deploymentResourceId" to deploymentResourceId as Any,
        "deploymentVcsProviderBranch" to deploymentVcsProviderBranch as Any,
        "status" to status.value as Any,
        "logs" to logs as Any,
        "renewAt" to renewAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProxyRule(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            domain = map["domain"] as String,
            type = map["type"] as String,
            trigger = map["trigger"] as String,
            redirectUrl = map["redirectUrl"] as String,
            redirectStatusCode = (map["redirectStatusCode"] as Number).toLong(),
            deploymentId = map["deploymentId"] as String,
            deploymentResourceType = ProxyRuleDeploymentResourceType.values().find { it.value == (map["deploymentResourceType"] as? String) },
            deploymentResourceId = map["deploymentResourceId"] as String,
            deploymentVcsProviderBranch = map["deploymentVcsProviderBranch"] as String,
            status = ProxyRuleStatus.values().find { it.value == map["status"] as String }!!,
            logs = map["logs"] as String,
            renewAt = map["renewAt"] as String,
        )
    }
}
