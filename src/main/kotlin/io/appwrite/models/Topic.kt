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

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "emailTotal" to emailTotal as Any,
        "smsTotal" to smsTotal as Any,
        "pushTotal" to pushTotal as Any,
        "subscribe" to subscribe as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Topic(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            emailTotal = (map["emailTotal"] as Number).toLong(),
            smsTotal = (map["smsTotal"] as Number).toLong(),
            pushTotal = (map["pushTotal"] as Number).toLong(),
            subscribe = map["subscribe"] as List<String>,
        )
    }
}