package io.appwrite.models

/// Health Status
data class HealthStatus(
    val ping: Long,
    val status: String
) {
    companion object {
        fun from(map: Map<String, Any>) = HealthStatus(
            ping = map["ping"] as Long,
            status = map["status"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "ping" to ping as Any,
        "status" to status as Any
    )
}