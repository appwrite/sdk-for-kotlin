package io.appwrite.models

/// Functions List
data class FunctionList(
    val sum: Long,
    val functions: List<Function>
) {
    companion object {
        fun from(map: Map<String, Any>) = FunctionList(
            sum = map["sum"] as Long,
            functions = (map["functions"] as List<Map<String, Any>>).map { Function.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "functions" to functions.map { it.toMap() } as Any
    )
}