package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2 Providers List
 */
data class OAuth2ProviderList(
    /**
     * Total number of OAuth2 providers in the given project.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of OAuth2 providers.
     */
    @SerializedName("providers")
    val providers: List<Map<String, Any?>>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "providers" to providers as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2ProviderList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            providers = (if (map.containsKey("providers")) map["providers"] else listOf<Any?>()) as List<Map<String, Any?>>,
        )
    }
}
