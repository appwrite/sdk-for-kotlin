package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Runtime
 */
data class Runtime(
    /**
     * Runtime ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Parent runtime key.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Runtime Name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Runtime version.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Base Docker image used to build the runtime.
     */
    @SerializedName("base")
    val base: String,

    /**
     * Image name of Docker Hub.
     */
    @SerializedName("image")
    val image: String,

    /**
     * Name of the logo image.
     */
    @SerializedName("logo")
    val logo: String,

    /**
     * List of supported architectures.
     */
    @SerializedName("supports")
    val supports: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "key" to key as Any,
        "name" to name as Any,
        "version" to version as Any,
        "base" to base as Any,
        "image" to image as Any,
        "logo" to logo as Any,
        "supports" to supports as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Runtime(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            key = (if (map.containsKey("key")) map["key"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            version = (if (map.containsKey("version")) map["version"] else "") as String,
            base = (if (map.containsKey("base")) map["base"] else "") as String,
            image = (if (map.containsKey("image")) map["image"] else "") as String,
            logo = (if (map.containsKey("logo")) map["logo"] else "") as String,
            supports = map["supports"] as List<String>,
        )
    }
}
