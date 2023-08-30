package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Health Status
 */
data class HealthStatus(
    /**
     * Name of the service.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Duration in milliseconds how long the health check took.
     */
    @SerializedName("ping")
    val ping: Long,

    /**
     * Service status. Possible values can are: `pass`, `fail`
     */
    @SerializedName("status")
    val status: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "ping" to ping as Any,
        "status" to status as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = HealthStatus(
            name = map["name"] as String,
            ping = (map["ping"] as Number).toLong(),
            status = map["status"] as String,
        )
    }
}