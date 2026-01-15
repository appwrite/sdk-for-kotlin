package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Framework
 */
data class Framework(
    /**
     * Framework key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Framework Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Default runtime version.
     */
    @SerializedName("buildRuntime")
    val buildRuntime: String,

    /**
     * List of supported runtime versions.
     */
    @SerializedName("runtimes")
    val runtimes: List<String>,

    /**
     * List of supported adapters.
     */
    @SerializedName("adapters")
    val adapters: List<FrameworkAdapter>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "name" to name as Any,
        "buildRuntime" to buildRuntime as Any,
        "runtimes" to runtimes as Any,
        "adapters" to adapters.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Framework(
            key = map["key"] as String,
            name = map["name"] as String,
            buildRuntime = map["buildRuntime"] as String,
            runtimes = map["runtimes"] as List<String>,
            adapters = (map["adapters"] as List<Map<String, Any>>).map { FrameworkAdapter.from(map = it) },
        )
    }
}