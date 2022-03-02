package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Runtimes List
 */
data class RuntimeList(
    /**
     * Total number of runtimes documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of runtimes.
     *
     */
    @SerializedName("runtimes")
    val runtimes: List<Runtime>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = RuntimeList(
            total = (map["total"] as Number).toLong(),
            runtimes = (map["runtimes"] as List<Map<String, Any>>).map { Runtime.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "runtimes" to runtimes.map { it.toMap() } as Any
    )
}