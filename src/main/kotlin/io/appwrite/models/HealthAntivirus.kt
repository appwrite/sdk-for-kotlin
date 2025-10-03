package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.HealthAntivirusStatus

/**
 * Health Antivirus
 */
data class HealthAntivirus(
    /**
     * Antivirus version.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Antivirus status. Possible values are: `disabled`, `offline`, `online`
     */
    @SerializedName("status")
    val status: HealthAntivirusStatus,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "version" to version as Any,
        "status" to status.value as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = HealthAntivirus(
            version = map["version"] as String,
            status = HealthAntivirusStatus.values().find { it.value == map["status"] as String }!!,
        )
    }
}