package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Escalations List
 */
data class EscalationList(
    /**
     * Total number of escalations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of escalations.
     */
    @SerializedName("escalations")
    val escalations: List<Escalation>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "escalations" to escalations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EscalationList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            escalations = ((if (map.containsKey("escalations")) map["escalations"] else listOf<Any?>()) as List<Map<String, Any>>).map { Escalation.from(map = it) },
        )
    }
}
