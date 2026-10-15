package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Rule List
 */
data class ProxyRuleList(
    /**
     * Total number of rules that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of rules.
     */
    @SerializedName("rules")
    val rules: List<ProxyRule>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "rules" to rules.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProxyRuleList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            rules = ((if (map.containsKey("rules")) map["rules"] else listOf<Any?>()) as List<Map<String, Any>>).map { ProxyRule.from(map = it) },
        )
    }
}
