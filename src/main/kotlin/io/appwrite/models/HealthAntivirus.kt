package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Health Antivirus
 */
data class HealthAntivirus(
    /**
     * Antivirus version.
     *
     */
    @SerializedName("version")
    val version: String,

    /**
     * Antivirus status. Possible values can are: `disabled`, `offline`, `online`
     *
     */
    @SerializedName("status")
    val status: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
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