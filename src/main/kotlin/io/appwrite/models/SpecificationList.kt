package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Specifications List
 */
data class SpecificationList(
    /**
     * Total number of specifications documents that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of specifications.
     */
    @SerializedName("specifications")
    val specifications: List<Specification>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "specifications" to specifications.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = SpecificationList(
            total = (map["total"] as Number).toLong(),
            specifications = (map["specifications"] as List<Map<String, Any>>).map { Specification.from(map = it) },
        )
    }
}