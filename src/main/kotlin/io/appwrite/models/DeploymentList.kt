package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Deployments List
 */
data class DeploymentList(
    /**
     * Total number of deployments documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

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
            total = (map["total"] as Number).toLong(),
            deployments = (map["deployments"] as List<Map<String, Any>>).map { Deployment.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "deployments" to deployments.map { it.toMap() } as Any
    )
}