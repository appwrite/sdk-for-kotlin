package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Health Queue
 */
data class HealthQueue(
    /**
     * Amount of actions in the queue.
     */
    @SerializedName("size")
    val size: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "size" to size as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = HealthQueue(
            size = (map["size"] as Number).toLong(),
        )
    }
}