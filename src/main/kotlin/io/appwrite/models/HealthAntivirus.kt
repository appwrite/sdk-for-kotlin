package io.appwrite.models

/// Health Antivirus
data class HealthAntivirus(
    val version: String,
    val status: String
) {
    companion object {
        fun from(map: Map<String, Any>) = HealthAntivirus(
            version = map["version"] as String,
            status = map["status"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "version" to version as Any,
        "status" to status as Any
    )
}