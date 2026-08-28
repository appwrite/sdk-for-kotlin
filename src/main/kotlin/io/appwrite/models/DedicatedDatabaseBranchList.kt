package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BranchList
 */
data class DedicatedDatabaseBranchList(
    /**
     * Total number of branches.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of branches.
     */
    @SerializedName("branches")
    val branches: List<DedicatedDatabaseBranch>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "branches" to branches.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseBranchList(
            total = (map["total"] as Number).toLong(),
            branches = (map["branches"] as List<Map<String, Any>>).map { DedicatedDatabaseBranch.from(map = it) },
        )
    }
}
