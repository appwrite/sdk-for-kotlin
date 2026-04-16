package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BillingLimits
 */
data class BillingLimits(
    /**
     * Bandwidth limit
     */
    @SerializedName("bandwidth")
    val bandwidth: Long,

    /**
     * Storage limit
     */
    @SerializedName("storage")
    val storage: Long,

    /**
     * Users limit
     */
    @SerializedName("users")
    val users: Long,

    /**
     * Executions limit
     */
    @SerializedName("executions")
    val executions: Long,

    /**
     * GBHours limit
     */
    @SerializedName("GBHours")
    val GBHours: Long,

    /**
     * Image transformations limit
     */
    @SerializedName("imageTransformations")
    val imageTransformations: Long,

    /**
     * Auth phone limit
     */
    @SerializedName("authPhone")
    val authPhone: Long,

    /**
     * Budget limit percentage
     */
    @SerializedName("budgetLimit")
    val budgetLimit: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "bandwidth" to bandwidth as Any,
        "storage" to storage as Any,
        "users" to users as Any,
        "executions" to executions as Any,
        "GBHours" to GBHours as Any,
        "imageTransformations" to imageTransformations as Any,
        "authPhone" to authPhone as Any,
        "budgetLimit" to budgetLimit as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingLimits(
            bandwidth = (map["bandwidth"] as Number).toLong(),
            storage = (map["storage"] as Number).toLong(),
            users = (map["users"] as Number).toLong(),
            executions = (map["executions"] as Number).toLong(),
            GBHours = (map["GBHours"] as Number).toLong(),
            imageTransformations = (map["imageTransformations"] as Number).toLong(),
            authPhone = (map["authPhone"] as Number).toLong(),
            budgetLimit = (map["budgetLimit"] as Number).toLong(),
        )
    }
}