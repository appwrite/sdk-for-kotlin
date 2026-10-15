package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.ProxyRuleDeploymentResourceType
import io.appwrite.enums.ProxyRuleStatus
import io.appwrite.enums.ProxyRuleProtocol
import io.appwrite.extensions.jsonCast

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
     * Type of deployment resource: function, site, or dedicatedDatabase.
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

    /**
     * Ingress protocol for the rule.
     */
    @SerializedName("protocol")
    val protocol: ProxyRuleProtocol,

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
        "protocol" to protocol.value as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProxyRule(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            domain = (if (map.containsKey("domain")) map["domain"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            trigger = (if (map.containsKey("trigger")) map["trigger"] else "") as String,
            redirectUrl = (if (map.containsKey("redirectUrl")) map["redirectUrl"] else "") as String,
            redirectStatusCode = ((if (map.containsKey("redirectStatusCode")) map["redirectStatusCode"] else 301) as Number).toLong(),
            deploymentId = (if (map.containsKey("deploymentId")) map["deploymentId"] else "") as String,
            deploymentResourceType = ProxyRuleDeploymentResourceType.values().find { it.value == (map["deploymentResourceType"] as? String) },
            deploymentResourceId = (if (map.containsKey("deploymentResourceId")) map["deploymentResourceId"] else "") as String,
            deploymentVcsProviderBranch = (if (map.containsKey("deploymentVcsProviderBranch")) map["deploymentVcsProviderBranch"] else "") as String,
            status = ProxyRuleStatus.values().find { it.value == (if (map.containsKey("status")) map["status"] else "unverified") as String }!!,
            logs = (if (map.containsKey("logs")) map["logs"] else "") as String,
            renewAt = map["renewAt"] as String,
            protocol = ProxyRuleProtocol.values().find { it.value == (if (map.containsKey("protocol")) map["protocol"] else "http") as String }!!,
        )
    }
}
