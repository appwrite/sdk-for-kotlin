package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Topic
 */
data class Topic(
    /**
     * Topic ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Topic creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Topic update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name of the topic.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Optional description for the topic.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Total count of email subscribers subscribed to the topic.
     */
    @SerializedName("emailTotal")
    val emailTotal: Long,

    /**
     * Total count of SMS subscribers subscribed to the topic.
     */
    @SerializedName("smsTotal")
    val smsTotal: Long,

    /**
     * Total count of push subscribers subscribed to the topic.
     */
    @SerializedName("pushTotal")
    val pushTotal: Long,

    /**
     * Subscribe permissions.
     */
    @SerializedName("subscribe")
    val subscribe: List<String>,

    /**
     * MQTT QoS for delivery on this topic. Null lets the subscriber choose their level.
     */
    @SerializedName("qos")
    var qos: Long?,

    /**
     * Message retention in seconds for offline delivery. Null inherits the lowest expiry of the project's enabled Appwrite providers, or the 7-day ledger window if none sets one.
     */
    @SerializedName("expiry")
    var expiry: Long?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "description" to description as Any,
        "emailTotal" to emailTotal as Any,
        "smsTotal" to smsTotal as Any,
        "pushTotal" to pushTotal as Any,
        "subscribe" to subscribe as Any,
        "qos" to qos as Any?,
        "expiry" to expiry as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Topic(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            emailTotal = ((if (map.containsKey("emailTotal")) map["emailTotal"] else 0) as Number).toLong(),
            smsTotal = ((if (map.containsKey("smsTotal")) map["smsTotal"] else 0) as Number).toLong(),
            pushTotal = ((if (map.containsKey("pushTotal")) map["pushTotal"] else 0) as Number).toLong(),
            subscribe = (if (map.containsKey("subscribe")) map["subscribe"] else listOf<Any?>("users")) as List<String>,
            qos = (map["qos"] as? Number)?.toLong(),
            expiry = (map["expiry"] as? Number)?.toLong(),
        )
    }
}
