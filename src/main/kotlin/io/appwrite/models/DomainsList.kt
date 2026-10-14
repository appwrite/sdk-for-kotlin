package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Domains list
 */
data class DomainsList(
    /**
     * Total number of domains that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of domains.
     */
    @SerializedName("domains")
    val domains: List<Domain>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "domains" to domains.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DomainsList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            domains = ((if (map.containsKey("domains")) map["domains"] else listOf<Any?>()) as List<Map<String, Any>>).map { Domain.from(map = it) },
        )
    }
}
