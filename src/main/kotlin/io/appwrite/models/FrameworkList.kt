package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Frameworks List
 */
data class FrameworkList(
    /**
     * Total number of frameworks that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of frameworks.
     */
    @SerializedName("frameworks")
    val frameworks: List<Framework>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "frameworks" to frameworks.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = FrameworkList(
            total = (map["total"] as Number).toLong(),
            frameworks = (map["frameworks"] as List<Map<String, Any>>).map { Framework.from(map = it) },
        )
    }
}