package io.appwrite.models

/// Logs List
data class LogList(
    val logs: List<Log>
) {
    companion object {
        fun from(map: Map<String, Any>) = LogList(
            logs = (map["logs"] as List<Map<String, Any>>).map { Log.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "logs" to logs.map { it.toMap() } as Any
    )
}