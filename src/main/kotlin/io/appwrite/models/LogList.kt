package io.appwrite.models

/// Logs List
data class LogList(
    val sum: Long,
    val logs: List<Log>
) {
    companion object {
        fun from(map: Map<String, Any>) = LogList(
            sum = map["sum"] as Long,
            logs = (map["logs"] as List<Map<String, Any>>).map { Log.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "logs" to logs.map { it.toMap() } as Any
    )
}