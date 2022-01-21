package io.appwrite.models

/**
 * Health Status
 */
data class HealthStatus(
    /**
     * Duration in milliseconds how long the health check took.
     *
     */
    val ping: Long,

    /**
     * Service status. Possible values can are: `pass`, `fail`
     *
     */
    val status: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = HealthStatus(
            ping = (map["ping"] as Number).toLong(),
            status = map["status"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "ping" to ping as Any,
        "status" to status as Any
    )
}