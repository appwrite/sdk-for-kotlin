package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Operation
 */
data class DedicatedDatabaseOperation(
    /**
     * Operation ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Operation creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Database ID the operation ran against.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Operation type, such as provision, update, credentials-update, restore, pausing, resuming, failover, backup-create or cross-region-enable.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Operation status. Possible values: queued (accepted and waiting to resume), running (in progress), completed (finished successfully), failed (ended in an error).
     */
    @SerializedName("status")
    val status: String,

    /**
     * Number of times this operation has been attempted.
     */
    @SerializedName("attempts")
    val attempts: Long,

    /**
     * Time the operation was requested, in ISO 8601 format.
     */
    @SerializedName("requestedAt")
    var requestedAt: String?,

    /**
     * Time the operation started, in ISO 8601 format.
     */
    @SerializedName("startedAt")
    var startedAt: String?,

    /**
     * Time the operation reached a terminal state, in ISO 8601 format.
     */
    @SerializedName("completedAt")
    var completedAt: String?,

    /**
     * Machine-readable failure code. `Interrupted` marks an attempt that ended before its outcome could be confirmed.
     */
    @SerializedName("errorCode")
    val errorCode: String,

    /**
     * Failure message if the operation failed.
     */
    @SerializedName("errorMessage")
    val errorMessage: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "databaseId" to databaseId as Any,
        "type" to type as Any,
        "status" to status as Any,
        "attempts" to attempts as Any,
        "requestedAt" to requestedAt as Any?,
        "startedAt" to startedAt as Any?,
        "completedAt" to completedAt as Any?,
        "errorCode" to errorCode as Any,
        "errorMessage" to errorMessage as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseOperation(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            databaseId = map["databaseId"] as String,
            type = map["type"] as String,
            status = map["status"] as String,
            attempts = (map["attempts"] as Number).toLong(),
            requestedAt = map["requestedAt"] as? String,
            startedAt = map["startedAt"] as? String,
            completedAt = map["completedAt"] as? String,
            errorCode = map["errorCode"] as String,
            errorMessage = map["errorMessage"] as String,
        )
    }
}
