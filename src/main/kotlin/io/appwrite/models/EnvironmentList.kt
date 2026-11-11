package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Environments list
 */
data class EnvironmentList(
    /**
     * Total number of environments that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of environments.
     */
    @SerializedName("environments")
    val environments: List<Environment>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "environments" to environments.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EnvironmentList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            environments = ((if (map.containsKey("environments")) map["environments"] else listOf<Any?>()) as List<Map<String, Any>>).map { Environment.from(map = it) },
        )
    }
}
