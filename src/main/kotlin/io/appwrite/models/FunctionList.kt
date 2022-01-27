package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Functions List
 */
data class FunctionList(
    /**
     * Total number of items available on the server.
     *
     */
    @SerializedName("sum")
    val sum: Long,

    /**
     * List of functions.
     *
     */
    @SerializedName("functions")
    val functions: List<Function>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = FunctionList(
            sum = (map["sum"] as Number).toLong(),
            functions = (map["functions"] as List<Map<String, Any>>).map { Function.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "functions" to functions.map { it.toMap() } as Any
    )
}