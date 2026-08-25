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
    val bandwidth: AdditionalResource,

    /**
     * Executions additional resources
     */
    @SerializedName("executions")
    val executions: AdditionalResource,

    /**
     * Member additional resources
     */
    @SerializedName("member")
    var member: AdditionalResource?,

    /**
     * Realtime additional resources
     */
    @SerializedName("realtime")
    val realtime: AdditionalResource,

    /**
     * Realtime messages additional resources
     */
    @SerializedName("realtimeMessages")
    val realtimeMessages: AdditionalResource,

    /**
     * Realtime bandwidth additional resources
     */
    @SerializedName("realtimeBandwidth")
    var realtimeBandwidth: AdditionalResource?,

    /**
     * Storage additional resources
     */
    @SerializedName("storage")
    val storage: AdditionalResource,

    /**
     * User additional resources
     */
    @SerializedName("users")
    val users: AdditionalResource,

    /**
     * GBHour additional resources
     */
    @SerializedName("GBHours")
    val GBHours: AdditionalResource,

    /**
     * Image transformation additional resources
     */
    @SerializedName("imageTransformations")
    val imageTransformations: AdditionalResource,

    /**
     * Credits additional resources
     */
    @SerializedName("credits")
    var credits: AdditionalResource?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "bandwidth" to bandwidth.toMap() as Any,
        "executions" to executions.toMap() as Any,
        "member" to member?.toMap() as Any?,
        "realtime" to realtime.toMap() as Any,
        "realtimeMessages" to realtimeMessages.toMap() as Any,
        "realtimeBandwidth" to realtimeBandwidth?.toMap() as Any?,
        "storage" to storage.toMap() as Any,
        "users" to users.toMap() as Any,
        "GBHours" to GBHours.toMap() as Any,
        "imageTransformations" to imageTransformations.toMap() as Any,
        "credits" to credits?.toMap() as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageBillingPlan(
            bandwidth = AdditionalResource.from(map = map["bandwidth"] as Map<String, Any>),
            executions = AdditionalResource.from(map = map["executions"] as Map<String, Any>),
            member = (map["member"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            realtime = AdditionalResource.from(map = map["realtime"] as Map<String, Any>),
            realtimeMessages = AdditionalResource.from(map = map["realtimeMessages"] as Map<String, Any>),
            realtimeBandwidth = (map["realtimeBandwidth"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
            storage = AdditionalResource.from(map = map["storage"] as Map<String, Any>),
            users = AdditionalResource.from(map = map["users"] as Map<String, Any>),
            GBHours = AdditionalResource.from(map = map["GBHours"] as Map<String, Any>),
            imageTransformations = AdditionalResource.from(map = map["imageTransformations"] as Map<String, Any>),
            credits = (map["credits"] as? Map<String, Any>)?.let { AdditionalResource.from(map = it) },
        )
    }
}
