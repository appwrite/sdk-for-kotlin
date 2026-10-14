package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Volume
 */
data class DatabaseStatusVolume(
    /**
     * Mount path of the volume.
     */
    @SerializedName("xpath")
    val xpath: String,

    /**
     * Percentage of storage used.
     */
    @SerializedName("usedPercent")
    val usedPercent: String,

    /**
     * Available storage space.
     */
    @SerializedName("available")
    val available: String,

    /**
     * Whether the volume is mounted.
     */
    @SerializedName("mounted")
    val mounted: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "path" to xpath as Any,
        "usedPercent" to usedPercent as Any,
        "available" to available as Any,
        "mounted" to mounted as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseStatusVolume(
            xpath = (if (map.containsKey("path")) map["path"] else "") as String,
            usedPercent = (if (map.containsKey("usedPercent")) map["usedPercent"] else "0%") as String,
            available = (if (map.containsKey("available")) map["available"] else "0GB") as String,
            mounted = (if (map.containsKey("mounted")) map["mounted"] else false) as Boolean,
        )
    }
}
