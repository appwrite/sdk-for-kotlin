package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Domain prices list
 */
data class DomainPricesList(
    /**
     * Total number of prices that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of prices.
     */
    @SerializedName("prices")
    val prices: List<DomainPrice>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "prices" to prices.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DomainPricesList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            prices = ((if (map.containsKey("prices")) map["prices"] else listOf<Any?>()) as List<Map<String, Any>>).map { DomainPrice.from(map = it) },
        )
    }
}
