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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            title = (if (map.containsKey("title")) map["title"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            tag = (if (map.containsKey("tag")) map["tag"] else "") as String,
            icon = (if (map.containsKey("icon")) map["icon"] else "") as String,
            url = (if (map.containsKey("url")) map["url"] else "") as String,
            active = (if (map.containsKey("active")) map["active"] else true) as Boolean,
            external = (if (map.containsKey("external")) map["external"] else true) as Boolean,
            billingPlanId = (if (map.containsKey("billingPlanId")) map["billingPlanId"] else "") as String,
        )
    }
}
