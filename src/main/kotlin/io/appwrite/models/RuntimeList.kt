package io.appwrite.models

/// Runtimes List
data class RuntimeList(
    val sum: Long,
    val runtimes: List<Runtime>
) {
    companion object {
        fun from(map: Map<String, Any>) = RuntimeList(
            sum = map["sum"] as Long,
            runtimes = (map["runtimes"] as List<Map<String, Any>>).map { Runtime.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "runtimes" to runtimes.map { it.toMap() } as Any
    )
}