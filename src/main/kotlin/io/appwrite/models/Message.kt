package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Message
 */
data class Message(
    /**
     * Message ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Message creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Message update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Message provider type.
     */
    @SerializedName("providerType")
    val providerType: String,

    /**
     * Topic IDs set as recipients.
     */
    @SerializedName("topics")
    val topics: List<Any>,

    /**
     * User IDs set as recipients.
     */
    @SerializedName("users")
    val users: List<Any>,

    /**
     * Target IDs set as recipients.
     */
    @SerializedName("targets")
    val targets: List<Any>,

    /**
     * The scheduled time for message.
     */
    @SerializedName("scheduledAt")
    var scheduledAt: String?,

    /**
     * The time when the message was delivered.
     */
    @SerializedName("deliveredAt")
    var deliveredAt: String?,

    /**
     * Delivery errors if any.
     */
    @SerializedName("deliveryErrors")
    var deliveryErrors: List<Any>?,

    /**
     * Number of recipients the message was delivered to.
     */
    @SerializedName("deliveredTotal")
    val deliveredTotal: Long,

    /**
     * Data of the message.
     */
    @SerializedName("data")
    val data: Any,

    /**
     * Status of delivery.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Message description.
     */
    @SerializedName("description")
    var description: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "providerType" to providerType as Any,
        "topics" to topics as Any,
        "users" to users as Any,
        "targets" to targets as Any,
        "scheduledAt" to scheduledAt as Any,
        "deliveredAt" to deliveredAt as Any,
        "deliveryErrors" to deliveryErrors as Any,
        "deliveredTotal" to deliveredTotal as Any,
        "data" to data as Any,
        "status" to status as Any,
        "description" to description as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Message(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            providerType = map["providerType"] as String,
            topics = map["topics"] as List<Any>,
            users = map["users"] as List<Any>,
            targets = map["targets"] as List<Any>,
            scheduledAt = map["scheduledAt"] as? String?,
            deliveredAt = map["deliveredAt"] as? String?,
            deliveryErrors = map["deliveryErrors"] as? List<Any>?,
            deliveredTotal = (map["deliveredTotal"] as Number).toLong(),
            data = map["data"] as Any,
            status = map["status"] as String,
            description = map["description"] as? String?,
        )
    }
}