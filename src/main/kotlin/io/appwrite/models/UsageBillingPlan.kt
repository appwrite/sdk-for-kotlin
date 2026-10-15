package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * usageBillingPlan
 */
data class UsageBillingPlan(
    /**
     * Bandwidth additional resources
     */
    @SerializedName("bandwidth")
    var bandwidth: AdditionalResource?,

    /**
     * Executions additional resources
     */
    @SerializedName("executions")
    var executions: AdditionalResource?,

    /**
     * Member additional resources
     */
    @SerializedName("member")
    var member: AdditionalResource?,

    /**
     * Realtime additional resources
     */
    @SerializedName("realtime")
    var realtime: AdditionalResource?,

    /**
     * Realtime messages additional resources
     */
    @SerializedName("realtimeMessages")
    var realtimeMessages: AdditionalResource?,

    /**
     * Realtime bandwidth additional resources
     */
    @SerializedName("realtimeBandwidth")
    var realtimeBandwidth: AdditionalResource?,

    /**
     * Storage additional resources
     */
    @SerializedName("storage")
    var storage: AdditionalResource?,

    /**
     * User additional resources
     */
    @SerializedName("users")
    var users: AdditionalResource?,

    /**
     * GBHour additional resources
     */
    @SerializedName("GBHours")
    var GBHours: AdditionalResource?,

    /**
     * Image transformation additional resources
     */
    @SerializedName("imageTransformations")
    var imageTransformations: AdditionalResource?,

    /**
     * Credits additional resources
     */
    @SerializedName("credits")
    var credits: AdditionalResource?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "bandwidth" to bandwidth?.toMap() as Any?,
        "executions" to executions?.toMap() as Any?,
        "member" to member?.toMap() as Any?,
        "realtime" to realtime?.toMap() as Any?,
        "realtimeMessages" to realtimeMessages?.toMap() as Any?,
        "realtimeBandwidth" to realtimeBandwidth?.toMap() as Any?,
        "storage" to storage?.toMap() as Any?,
        "users" to users?.toMap() as Any?,
        "GBHours" to GBHours?.toMap() as Any?,
        "imageTransformations" to imageTransformations?.toMap() as Any?,
        "credits" to credits?.toMap() as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageBillingPlan(
            bandwidth = (map["bandwidth"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            executions = (map["executions"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            member = (map["member"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            realtime = (map["realtime"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            realtimeMessages = (map["realtimeMessages"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            realtimeBandwidth = (map["realtimeBandwidth"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            storage = (map["storage"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            users = (map["users"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            GBHours = (map["GBHours"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            imageTransformations = (map["imageTransformations"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            credits = (map["credits"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
        )
    }
}
