package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * PITRWindows
 */
data class DedicatedDatabasePITRWindows(
    /**
     * Earliest available recovery point.
     */
    @SerializedName("earliest")
    val earliest: String,

    /**
     * Latest available recovery point.
     */
    @SerializedName("latest")
    val latest: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "earliest" to earliest as Any,
        "latest" to latest as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabasePITRWindows(
            earliest = (if (map.containsKey("earliest")) map["earliest"] else "") as String,
            latest = (if (map.containsKey("latest")) map["latest"] else "") as String,
        )
    }
}
