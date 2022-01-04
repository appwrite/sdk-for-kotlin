package io.appwrite.models

/// Health Time
data class HealthTime(
    val remoteTime: Long,
    val localTime: Long,
    val diff: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = HealthTime(
            remoteTime = map["remoteTime"] as Long,
            localTime = map["localTime"] as Long,
            diff = map["diff"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "remoteTime" to remoteTime as Any,
        "localTime" to localTime as Any,
        "diff" to diff as Any
    )
}