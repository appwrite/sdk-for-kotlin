package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Deployments List
 */
data class DeploymentList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of deployments.
     *
     */
    @SerializedName("deployments")
    val deployments: List<Deployment>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = DeploymentList(
            sum = (map["sum"] as Number).toLong(),
            deployments = (map["deployments"] as List<Map<String, Any>>).map { Deployment.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "deployments" to deployments.map { it.toMap() } as Any
    )
}