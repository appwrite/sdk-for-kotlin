package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Session Limit
 */
data class PolicySessionLimit(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Maximum number of sessions allowed per user. A value of 0 means the policy is disabled.
     */
    @SerializedName("total")
    val total: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "total" to total as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicySessionLimit(
            id = map["\$id"] as String,
            total = (map["total"] as Number).toLong(),
        )
    }
}