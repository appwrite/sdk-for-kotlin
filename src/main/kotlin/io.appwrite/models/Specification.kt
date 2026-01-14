package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Specification
 */
data class Specification(
    /**
     * Memory size in MB.
     */
    @SerializedName("memory")
    val memory: Long,

    /**
     * Number of CPUs.
     */
    @SerializedName("cpus")
    val cpus: Double,

    /**
     * Is size enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Size slug.
     */
    @SerializedName("slug")
    val slug: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "memory" to memory as Any,
        "cpus" to cpus as Any,
        "enabled" to enabled as Any,
        "slug" to slug as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Specification(
            memory = (map["memory"] as Number).toLong(),
            cpus = (map["cpus"] as Number).toDouble(),
            enabled = map["enabled"] as Boolean,
            slug = map["slug"] as String,
        )
    }
}