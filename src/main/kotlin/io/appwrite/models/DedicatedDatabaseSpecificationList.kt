package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * SpecificationList
 */
data class DedicatedDatabaseSpecificationList(
    /**
     * List of dedicated database specifications.
     */
    @SerializedName("specifications")
    val specifications: List<DedicatedDatabaseSpecification>,

    /**
     * Total number of specifications.
     */
    @SerializedName("total")
    val total: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "specifications" to specifications.map { it.toMap() } as Any,
        "total" to total as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseSpecificationList(
            specifications = (map["specifications"] as List<Map<String, Any>>).map { DedicatedDatabaseSpecification.from(map = it) },
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
        )
    }
}
