package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Sites List
 */
data class SiteList(
    /**
     * Total number of sites that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of sites.
     */
    @SerializedName("sites")
    val sites: List<Site>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "sites" to sites.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = SiteList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            sites = ((if (map.containsKey("sites")) map["sites"] else listOf<Any?>()) as List<Map<String, Any>>).map { Site.from(map = it) },
        )
    }
}
