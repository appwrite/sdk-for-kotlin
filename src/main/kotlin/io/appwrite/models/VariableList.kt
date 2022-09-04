package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Variables List
 */
data class VariableList(
    /**
     * Total number of variables documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of variables.
     *
     */
    @SerializedName("variables")
    val variables: List<Variable>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = VariableList(
            total = (map["total"] as Number).toLong(),
            variables = (map["variables"] as List<Map<String, Any>>).map { Variable.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "variables" to variables.map { it.toMap() } as Any
    )
}