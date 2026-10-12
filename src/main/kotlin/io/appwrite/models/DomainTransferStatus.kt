package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.DomainTransferStatusEnum
import io.appwrite.extensions.jsonCast

/**
 * domainTransferStatus
 */
data class DomainTransferStatus(
    /**
     * Transfer status.
     */
    @SerializedName("status")
    val status: DomainTransferStatusEnum,

    /**
     * Additional transfer status information.
     */
    @SerializedName("reason")
    val reason: String,

    /**
     * Transfer status timestamp in ISO 8601 format.
     */
    @SerializedName("timestamp")
    val timestamp: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "status" to status.value as Any,
        "reason" to reason as Any,
        "timestamp" to timestamp as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DomainTransferStatus(
            status = DomainTransferStatusEnum.values().find { it.value == (if (map.containsKey("status")) map["status"] else "pending_registry") as String }!!,
            reason = (if (map.containsKey("reason")) map["reason"] else "") as String,
            timestamp = (if (map.containsKey("timestamp")) map["timestamp"] else "") as String,
        )
    }
}
