package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Session Duration
 */
data class PolicySessionDuration(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Session duration in seconds.
     */
    @SerializedName("duration")
    val duration: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "duration" to duration as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicySessionDuration(
            id = map["\$id"] as String,
            duration = (map["duration"] as Number).toLong(),
        )
    }
}