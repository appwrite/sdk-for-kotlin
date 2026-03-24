package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Webhooks List
 */
data class WebhookList(
    /**
     * Total number of webhooks that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of webhooks.
     */
    @SerializedName("webhooks")
    val webhooks: List<Webhook>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "webhooks" to webhooks.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = WebhookList(
            total = (map["total"] as Number).toLong(),
            webhooks = (map["webhooks"] as List<Map<String, Any>>).map { Webhook.from(map = it) },
        )
    }
}