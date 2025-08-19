package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Functions List
 */
data class FunctionList(
    /**
     * Total number of functions rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of functions.
     */
    @SerializedName("functions")
    val functions: List<Function>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "functions" to functions.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = FunctionList(
            total = (map["total"] as Number).toLong(),
            functions = (map["functions"] as List<Map<String, Any>>).map { Function.from(map = it) },
        )
    }
}