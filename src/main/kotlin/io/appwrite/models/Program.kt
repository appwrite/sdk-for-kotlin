package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Program
 */
data class Program(
    /**
     * Program ID
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Program title
     */
    @SerializedName("title")
    val title: String,

    /**
     * Program description
     */
    @SerializedName("description")
    val description: String,

    /**
     * Program tag for highlighting on console
     */
    @SerializedName("tag")
    val tag: String,

    /**
     * Program icon for highlighting on console
     */
    @SerializedName("icon")
    val icon: String,

    /**
     * URL for more information on this program
     */
    @SerializedName("url")
    val url: String,

    /**
     * Whether this program is active
     */
    @SerializedName("active")
    val active: Boolean,

    /**
     * Whether this program is external
     */
    @SerializedName("external")
    val external: Boolean,

    /**
     * Billing plan ID that this is program is associated with.
     */
    @SerializedName("billingPlanId")
    val billingPlanId: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "title" to title as Any,
        "description" to description as Any,
        "tag" to tag as Any,
        "icon" to icon as Any,
        "url" to url as Any,
        "active" to active as Any,
        "external" to external as Any,
        "billingPlanId" to billingPlanId as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Program(
            id = map["\$id"] as String,
            title = map["title"] as String,
            description = map["description"] as String,
            tag = map["tag"] as String,
            icon = map["icon"] as String,
            url = map["url"] as String,
            active = map["active"] as Boolean,
            external = map["external"] as Boolean,
            billingPlanId = map["billingPlanId"] as String,
        )
    }
}
