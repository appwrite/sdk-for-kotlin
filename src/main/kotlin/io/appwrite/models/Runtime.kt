package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Runtime
 */
data class Runtime(
    /**
     * Runtime ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Runtime Name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Runtime version.
     *
     */
    @SerializedName("version")
    val version: String,

    /**
     * Base Docker image used to build the runtime.
     *
     */
    @SerializedName("base")
    val base: String,

    /**
     * Image name of Docker Hub.
     *
     */
    @SerializedName("image")
    val image: String,

    /**
     * Name of the logo image.
     *
     */
    @SerializedName("logo")
    val logo: String,

    /**
     * List of supported architectures.
     *
     */
    @SerializedName("supports")
    val supports: List<Any>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Runtime(
            id = map["\$id"] as String,
            name = map["name"] as String,
            version = map["version"] as String,
            base = map["base"] as String,
            image = map["image"] as String,
            logo = map["logo"] as String,
            supports = map["supports"] as List<Any>
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "version" to version as Any,
        "base" to base as Any,
        "image" to image as Any,
        "logo" to logo as Any,
        "supports" to supports as Any
    )
}