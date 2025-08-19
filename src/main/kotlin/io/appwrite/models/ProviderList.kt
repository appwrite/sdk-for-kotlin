package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Provider list
 */
data class ProviderList(
    /**
     * Total number of providers rows that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of providers.
     */
    @SerializedName("providers")
    val providers: List<Provider>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "providers" to providers.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProviderList(
            total = (map["total"] as Number).toLong(),
            providers = (map["providers"] as List<Map<String, Any>>).map { Provider.from(map = it) },
        )
    }
}