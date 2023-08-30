package io.appwrite.models

import com.google.gson.annotations.SerializedName
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
     * Action definition for the rule. Possible values are &quot;api&quot;, &quot;function&quot;, or &quot;redirect&quot;
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * ID of resource for the action type. If resourceType is &quot;api&quot; or &quot;url&quot;, it is empty. If resourceType is &quot;function&quot;, it is ID of the function.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Domain verification status. Possible values are &quot;created&quot;, &quot;verifying&quot;, &quot;verified&quot; and &quot;unverified&quot;
     */
    @SerializedName("status")
    val status: String,

    /**
     * Certificate generation logs. This will return an empty string if generation did not run, or succeeded.
     */
    @SerializedName("logs")
    val logs: String,

    /**
     * Certificate auto-renewal date in ISO 8601 format.
     */
    @SerializedName("renewAt")
    val renewAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "domain" to domain as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "status" to status as Any,
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
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
            status = map["status"] as String,
            logs = map["logs"] as String,
            renewAt = map["renewAt"] as String,
        )
    }
}