package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Resource Tokens List
 */
data class ResourceTokenList(
    /**
     * Total number of tokens rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of tokens.
     */
    @SerializedName("tokens")
    val tokens: List<ResourceToken>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "tokens" to tokens.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ResourceTokenList(
            total = (map["total"] as Number).toLong(),
            tokens = (map["tokens"] as List<Map<String, Any>>).map { ResourceToken.from(map = it) },
        )
    }
}