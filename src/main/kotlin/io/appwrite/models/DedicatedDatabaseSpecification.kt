package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Specification
 */
data class DedicatedDatabaseSpecification(
    /**
     * Specification slug. Use this value when creating a dedicated database.
     */
    @SerializedName("slug")
    val slug: String,

    /**
     * Human readable specification name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Monthly price of the specification in USD.
     */
    @SerializedName("price")
    val price: Double,

    /**
     * Allocated CPU in millicores.
     */
    @SerializedName("cpu")
    val cpu: Long,

    /**
     * Allocated memory in MB.
     */
    @SerializedName("memory")
    val memory: Long,

    /**
     * Maximum number of concurrent connections.
     */
    @SerializedName("maxConnections")
    val maxConnections: Long,

    /**
     * Included storage in GB before overage charges apply.
     */
    @SerializedName("includedStorage")
    val includedStorage: Long,

    /**
     * Included bandwidth in GB before overage charges apply.
     */
    @SerializedName("includedBandwidth")
    val includedBandwidth: Long,

    /**
     * Whether the specification is available on the current plan.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Price per GB of storage above the included amount, per month, in USD.
     */
    @SerializedName("storageOverageRate")
    var storageOverageRate: Double? = null,

    /**
     * Price per GB of bandwidth above the included amount, per month, in USD.
     */
    @SerializedName("bandwidthOverageRate")
    var bandwidthOverageRate: Double? = null,

    /**
     * High availability replica price as a fraction of the specification price.
     */
    @SerializedName("replicaRate")
    var replicaRate: Double? = null,

    /**
     * Point-in-time recovery price as a fraction of the specification price.
     */
    @SerializedName("pitrRate")
    var pitrRate: Double? = null,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "slug" to slug as Any,
        "name" to name as Any,
        "price" to price as Any,
        "storageOverageRate" to storageOverageRate as Any?,
        "bandwidthOverageRate" to bandwidthOverageRate as Any?,
        "replicaRate" to replicaRate as Any?,
        "pitrRate" to pitrRate as Any?,
        "cpu" to cpu as Any,
        "memory" to memory as Any,
        "maxConnections" to maxConnections as Any,
        "includedStorage" to includedStorage as Any,
        "includedBandwidth" to includedBandwidth as Any,
        "enabled" to enabled as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseSpecification(
            slug = map["slug"] as String,
            name = map["name"] as String,
            price = (map["price"] as Number).toDouble(),
            cpu = (map["cpu"] as Number).toLong(),
            memory = (map["memory"] as Number).toLong(),
            maxConnections = (map["maxConnections"] as Number).toLong(),
            includedStorage = (map["includedStorage"] as Number).toLong(),
            includedBandwidth = (map["includedBandwidth"] as Number).toLong(),
            enabled = map["enabled"] as Boolean,
            storageOverageRate = (map["storageOverageRate"] as? Number)?.toDouble(),
            bandwidthOverageRate = (map["bandwidthOverageRate"] as? Number)?.toDouble(),
            replicaRate = (map["replicaRate"] as? Number)?.toDouble(),
            pitrRate = (map["pitrRate"] as? Number)?.toDouble(),
        )
    }
}
