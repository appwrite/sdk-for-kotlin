package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * ActivityEvent
 */
data class ActivityEvent(
    /**
     * Event ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Actor type.
     */
    @SerializedName("actorType")
    val actorType: String,

    /**
     * Actor ID.
     */
    @SerializedName("actorId")
    val actorId: String,

    /**
     * Actor Email.
     */
    @SerializedName("actorEmail")
    val actorEmail: String,

    /**
     * Actor Name.
     */
    @SerializedName("actorName")
    val actorName: String,

    /**
     * Resource parent.
     */
    @SerializedName("resourceParent")
    val resourceParent: String,

    /**
     * Resource type.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * Resource ID.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Resource.
     */
    @SerializedName("resource")
    val resource: String,

    /**
     * Event name.
     */
    @SerializedName("event")
    val event: String,

    /**
     * User agent.
     */
    @SerializedName("userAgent")
    val userAgent: String,

    /**
     * IP address.
     */
    @SerializedName("ip")
    val ip: String,

    /**
     * API mode when event triggered.
     */
    @SerializedName("mode")
    val mode: String,

    /**
     * Location.
     */
    @SerializedName("country")
    val country: String,

    /**
     * Log creation date in ISO 8601 format.
     */
    @SerializedName("time")
    val time: String,

    /**
     * Project ID.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Hostname.
     */
    @SerializedName("hostname")
    val hostname: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "actorType" to actorType as Any,
        "actorId" to actorId as Any,
        "actorEmail" to actorEmail as Any,
        "actorName" to actorName as Any,
        "resourceParent" to resourceParent as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "resource" to resource as Any,
        "event" to event as Any,
        "userAgent" to userAgent as Any,
        "ip" to ip as Any,
        "mode" to mode as Any,
        "country" to country as Any,
        "time" to time as Any,
        "projectId" to projectId as Any,
        "teamId" to teamId as Any,
        "hostname" to hostname as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ActivityEvent(
            id = map["\$id"] as String,
            actorType = map["actorType"] as String,
            actorId = map["actorId"] as String,
            actorEmail = map["actorEmail"] as String,
            actorName = map["actorName"] as String,
            resourceParent = map["resourceParent"] as String,
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
            resource = map["resource"] as String,
            event = map["event"] as String,
            userAgent = map["userAgent"] as String,
            ip = map["ip"] as String,
            mode = map["mode"] as String,
            country = map["country"] as String,
            time = map["time"] as String,
            projectId = map["projectId"] as String,
            teamId = map["teamId"] as String,
            hostname = map["hostname"] as String,
        )
    }
}