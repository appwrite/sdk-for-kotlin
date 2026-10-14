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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            actorType = (if (map.containsKey("actorType")) map["actorType"] else "") as String,
            actorId = (if (map.containsKey("actorId")) map["actorId"] else "") as String,
            actorEmail = (if (map.containsKey("actorEmail")) map["actorEmail"] else "") as String,
            actorName = (if (map.containsKey("actorName")) map["actorName"] else "") as String,
            resourceParent = (if (map.containsKey("resourceParent")) map["resourceParent"] else "") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            resource = (if (map.containsKey("resource")) map["resource"] else "") as String,
            event = (if (map.containsKey("event")) map["event"] else "") as String,
            userAgent = (if (map.containsKey("userAgent")) map["userAgent"] else "") as String,
            ip = (if (map.containsKey("ip")) map["ip"] else "") as String,
            mode = (if (map.containsKey("mode")) map["mode"] else "") as String,
            country = (if (map.containsKey("country")) map["country"] else "") as String,
            continentCode = (if (map.containsKey("continentCode")) map["continentCode"] else "") as String,
            city = (if (map.containsKey("city")) map["city"] else "") as String,
            subdivisions = (if (map.containsKey("subdivisions")) map["subdivisions"] else "") as String,
            isp = (if (map.containsKey("isp")) map["isp"] else "") as String,
            autonomousSystemNumber = (if (map.containsKey("autonomousSystemNumber")) map["autonomousSystemNumber"] else "") as String,
            autonomousSystemOrganization = (if (map.containsKey("autonomousSystemOrganization")) map["autonomousSystemOrganization"] else "") as String,
            connectionType = (if (map.containsKey("connectionType")) map["connectionType"] else "") as String,
            connectionUsageType = (if (map.containsKey("connectionUsageType")) map["connectionUsageType"] else "") as String,
            connectionOrganization = (if (map.containsKey("connectionOrganization")) map["connectionOrganization"] else "") as String,
            time = (if (map.containsKey("time")) map["time"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            hostname = (if (map.containsKey("hostname")) map["hostname"] else "") as String,
            sdk = (if (map.containsKey("sdk")) map["sdk"] else "") as String,
            sdkVersion = (if (map.containsKey("sdkVersion")) map["sdkVersion"] else "") as String,
        )
    }
}
