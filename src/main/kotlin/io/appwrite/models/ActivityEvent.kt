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
     * Continent code.
     */
    @SerializedName("continentCode")
    val continentCode: String,

    /**
     * City name.
     */
    @SerializedName("city")
    val city: String,

    /**
     * Region/state chain.
     */
    @SerializedName("subdivisions")
    val subdivisions: String,

    /**
     * Internet service provider.
     */
    @SerializedName("isp")
    val isp: String,

    /**
     * Autonomous System Number (ASN).
     */
    @SerializedName("autonomousSystemNumber")
    val autonomousSystemNumber: String,

    /**
     * Organization that owns the ASN.
     */
    @SerializedName("autonomousSystemOrganization")
    val autonomousSystemOrganization: String,

    /**
     * Connection type (e.g. cable, cellular, corporate).
     */
    @SerializedName("connectionType")
    val connectionType: String,

    /**
     * User type (e.g. residential, business, hosting).
     */
    @SerializedName("connectionUsageType")
    val connectionUsageType: String,

    /**
     * Registered organization of the IP.
     */
    @SerializedName("connectionOrganization")
    val connectionOrganization: String,

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

    /**
     * Name of the SDK that triggered the event.
     */
    @SerializedName("sdk")
    val sdk: String,

    /**
     * Version of the SDK that triggered the event.
     */
    @SerializedName("sdkVersion")
    val sdkVersion: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
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
        "continentCode" to continentCode as Any,
        "city" to city as Any,
        "subdivisions" to subdivisions as Any,
        "isp" to isp as Any,
        "autonomousSystemNumber" to autonomousSystemNumber as Any,
        "autonomousSystemOrganization" to autonomousSystemOrganization as Any,
        "connectionType" to connectionType as Any,
        "connectionUsageType" to connectionUsageType as Any,
        "connectionOrganization" to connectionOrganization as Any,
        "time" to time as Any,
        "projectId" to projectId as Any,
        "teamId" to teamId as Any,
        "hostname" to hostname as Any,
        "sdk" to sdk as Any,
        "sdkVersion" to sdkVersion as Any,
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
            continentCode = map["continentCode"] as String,
            city = map["city"] as String,
            subdivisions = map["subdivisions"] as String,
            isp = map["isp"] as String,
            autonomousSystemNumber = map["autonomousSystemNumber"] as String,
            autonomousSystemOrganization = map["autonomousSystemOrganization"] as String,
            connectionType = map["connectionType"] as String,
            connectionUsageType = map["connectionUsageType"] as String,
            connectionOrganization = map["connectionOrganization"] as String,
            time = map["time"] as String,
            projectId = map["projectId"] as String,
            teamId = map["teamId"] as String,
            hostname = map["hostname"] as String,
            sdk = map["sdk"] as String,
            sdkVersion = map["sdkVersion"] as String,
        )
    }
}
