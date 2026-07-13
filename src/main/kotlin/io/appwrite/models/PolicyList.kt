package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policies List
 */
data class PolicyList(
    /**
     * Total number of policies in the given project.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of policies.
     */
    @SerializedName("policies")
    val policies: List<Any>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "policies" to policies as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyList(
            total = (map["total"] as Number).toLong(),
            policies = map["policies"] as List<Any>,
        )
    }
}
