package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Health Queue
 */
data class HealthQueue(
    /**
     * Amount of actions in the queue.
     *
     */
    @SerializedName("size")
    val size: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = HealthQueue(
            size = (map["size"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "size" to size as Any
    )
}