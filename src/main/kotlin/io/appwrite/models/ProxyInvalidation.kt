package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Invalidation
 */
data class ProxyInvalidation(
    /**
     * Domain name.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Invalidation type. Possible values are "tag", "path", or "all".
     */
    @SerializedName("type")
    val type: String,

    /**
     * Invalidated reference. Depending on type this is a cache tag name, a URL path, or empty when type is all.
     */
    @SerializedName("reference")
    val reference: String,

    /**
     * Invalidation status.
     */
    @SerializedName("status")
    val status: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "domain" to domain as Any,
        "type" to type as Any,
        "reference" to reference as Any,
        "status" to status as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProxyInvalidation(
            domain = map["domain"] as String,
            type = map["type"] as String,
            reference = map["reference"] as String,
            status = map["status"] as String,
        )
    }
}
