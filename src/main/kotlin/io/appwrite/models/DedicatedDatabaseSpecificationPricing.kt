package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * SpecificationPricing
 */
data class DedicatedDatabaseSpecificationPricing(
    /**
     * Price per GB of storage above the included amount, per month, in USD.
     */
    @SerializedName("storageOverageRate")
    val storageOverageRate: Double,

    /**
     * Price per GB of bandwidth above the included amount, per month, in USD.
     */
    @SerializedName("bandwidthOverageRate")
    val bandwidthOverageRate: Double,

    /**
     * High availability replica price as a fraction of the specification cost.
     */
    @SerializedName("replicaRate")
    val replicaRate: Double,

    /**
     * Point-in-time recovery price as a fraction of the specification cost.
     */
    @SerializedName("pitrRate")
    val pitrRate: Double,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "storageOverageRate" to storageOverageRate as Any,
        "bandwidthOverageRate" to bandwidthOverageRate as Any,
        "replicaRate" to replicaRate as Any,
        "pitrRate" to pitrRate as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseSpecificationPricing(
            storageOverageRate = (map["storageOverageRate"] as Number).toDouble(),
            bandwidthOverageRate = (map["bandwidthOverageRate"] as Number).toDouble(),
            replicaRate = (map["replicaRate"] as Number).toDouble(),
            pitrRate = (map["pitrRate"] as Number).toDouble(),
        )
    }
}
