package io.appwrite.models

/**
 * Runtimes List
 */
data class RuntimeList(
    /**
     * Total number of items available on the server.
     *
     */
    val sum: Long,

    /**
     * List of runtimes.
     *
     */
    val runtimes: List<Runtime>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = RuntimeList(
            sum = (map["sum"] as Number).toLong(),
            runtimes = (map["runtimes"] as List<Map<String, Any>>).map { Runtime.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "runtimes" to runtimes.map { it.toMap() } as Any
    )
}