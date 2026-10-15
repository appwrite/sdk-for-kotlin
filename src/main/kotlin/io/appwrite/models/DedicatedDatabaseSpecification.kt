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
     * High availability replica price as a fraction of the specification price.
     */
    @SerializedName("replicaRate")
    val replicaRate: Double,

    /**
     * Point-in-time recovery price as a fraction of the specification price.
     */
    @SerializedName("pitrRate")
    val pitrRate: Double,

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

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "slug" to slug as Any,
        "name" to name as Any,
        "price" to price as Any,
        "storageOverageRate" to storageOverageRate as Any,
        "bandwidthOverageRate" to bandwidthOverageRate as Any,
        "replicaRate" to replicaRate as Any,
        "pitrRate" to pitrRate as Any,
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
            slug = (if (map.containsKey("slug")) map["slug"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            price = ((if (map.containsKey("price")) map["price"] else 0.0) as Number).toDouble(),
            storageOverageRate = ((if (map.containsKey("storageOverageRate")) map["storageOverageRate"] else 0.0) as Number).toDouble(),
            bandwidthOverageRate = ((if (map.containsKey("bandwidthOverageRate")) map["bandwidthOverageRate"] else 0.0) as Number).toDouble(),
            replicaRate = ((if (map.containsKey("replicaRate")) map["replicaRate"] else 0.0) as Number).toDouble(),
            pitrRate = ((if (map.containsKey("pitrRate")) map["pitrRate"] else 0.0) as Number).toDouble(),
            cpu = ((if (map.containsKey("cpu")) map["cpu"] else 0) as Number).toLong(),
            memory = ((if (map.containsKey("memory")) map["memory"] else 0) as Number).toLong(),
            maxConnections = ((if (map.containsKey("maxConnections")) map["maxConnections"] else 0) as Number).toLong(),
            includedStorage = ((if (map.containsKey("includedStorage")) map["includedStorage"] else 0) as Number).toLong(),
            includedBandwidth = ((if (map.containsKey("includedBandwidth")) map["includedBandwidth"] else 0) as Number).toLong(),
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
        )
    }
}
