package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password History
 */
data class PolicyPasswordHistory(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Password history length. A value of 0 means the policy is disabled.
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
        ) = PolicyPasswordHistory(
            id = map["\$id"] as String,
            total = (map["total"] as Number).toLong(),
        )
    }
}