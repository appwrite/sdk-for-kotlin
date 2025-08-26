package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Target list
 */
data class TargetList(
    /**
     * Total number of targets that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of targets.
     */
    @SerializedName("targets")
    val targets: List<Target>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "targets" to targets.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = TargetList(
            total = (map["total"] as Number).toLong(),
            targets = (map["targets"] as List<Map<String, Any>>).map { Target.from(map = it) },
        )
    }
}