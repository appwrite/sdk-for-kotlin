package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * usageEvent
 */
data class UsageEvent(
    /**
     * The metric key.
     */
    @SerializedName("metric")
    val metric: String,

    /**
     * The metric value.
     */
    @SerializedName("value")
    val value: Long,

    /**
     * The event timestamp.
     */
    @SerializedName("time")
    val time: String,

    /**
     * The API endpoint path.
     */
    @SerializedName("xpath")
    val xpath: String,

    /**
     * The HTTP method.
     */
    @SerializedName("method")
    val method: String,

    /**
     * HTTP status code. Stored as string to preserve unset state (empty string = not available).
     */
    @SerializedName("status")
    val status: String,

    /**
     * The resource type.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * The resource ID.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Country code in [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1) two-character format.
     */
    @SerializedName("countryCode")
    val countryCode: String,

    /**
     * The user agent string.
     */
    @SerializedName("userAgent")
    val userAgent: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "metric" to metric as Any,
        "value" to value as Any,
        "time" to time as Any,
        "path" to xpath as Any,
        "method" to method as Any,
        "status" to status as Any,
        "resourceType" to resourceType as Any,
        "resourceId" to resourceId as Any,
        "countryCode" to countryCode as Any,
        "userAgent" to userAgent as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = UsageEvent(
            metric = map["metric"] as String,
            value = (map["value"] as Number).toLong(),
            time = map["time"] as String,
            xpath = map["path"] as String,
            method = map["method"] as String,
            status = map["status"] as String,
            resourceType = map["resourceType"] as String,
            resourceId = map["resourceId"] as String,
            countryCode = map["countryCode"] as String,
            userAgent = map["userAgent"] as String,
        )
    }
}