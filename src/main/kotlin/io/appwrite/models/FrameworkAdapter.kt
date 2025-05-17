package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Framework Adapter
 */
data class FrameworkAdapter(
    /**
     * Adapter key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Default command to download dependencies.
     */
    @SerializedName("installCommand")
    val installCommand: String,

    /**
     * Default command to build site into output directory.
     */
    @SerializedName("buildCommand")
    val buildCommand: String,

    /**
     * Default output directory of build.
     */
    @SerializedName("outputDirectory")
    val outputDirectory: String,

    /**
     * Name of fallback file to use instead of 404 page. If null, Appwrite 404 page will be displayed.
     */
    @SerializedName("fallbackFile")
    val fallbackFile: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "installCommand" to installCommand as Any,
        "buildCommand" to buildCommand as Any,
        "outputDirectory" to outputDirectory as Any,
        "fallbackFile" to fallbackFile as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = FrameworkAdapter(
            key = map["key"] as String,
            installCommand = map["installCommand"] as String,
            buildCommand = map["buildCommand"] as String,
            outputDirectory = map["outputDirectory"] as String,
            fallbackFile = map["fallbackFile"] as String,
        )
    }
}