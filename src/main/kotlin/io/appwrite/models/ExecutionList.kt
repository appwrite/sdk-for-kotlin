package io.appwrite.models

/// Executions List
data class ExecutionList(
    val sum: Long,
    val executions: List<Execution>
) {
    companion object {
        fun from(map: Map<String, Any>) = ExecutionList(
            sum = map["sum"] as Long,
            executions = (map["executions"] as List<Map<String, Any>>).map { Execution.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "executions" to executions.map { it.toMap() } as Any
    )
}