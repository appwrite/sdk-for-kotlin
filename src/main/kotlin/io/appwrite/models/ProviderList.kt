package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Provider list
 */
data class ProviderList(
    /**
     * Total number of providers that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of providers.
     */
    @SerializedName("providers")
    val providers: List<Provider>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "providers" to providers.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProviderList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            providers = ((if (map.containsKey("providers")) map["providers"] else listOf<Any?>()) as List<Map<String, Any>>).map { Provider.from(map = it) },
        )
    }
}
