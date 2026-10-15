package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Dedicated database restorations list
 */
data class DedicatedDatabaseRestorationList(
    /**
     * Total number of restorations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of restorations.
     */
    @SerializedName("restorations")
    val restorations: List<DedicatedDatabaseRestoration>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "restorations" to restorations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseRestorationList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            restorations = ((if (map.containsKey("restorations")) map["restorations"] else listOf<Any?>()) as List<Map<String, Any>>).map { DedicatedDatabaseRestoration.from(map = it) },
        )
    }
}
