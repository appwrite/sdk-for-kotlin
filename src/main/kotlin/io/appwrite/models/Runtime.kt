package io.appwrite.models

/// Runtime
data class Runtime(
    val id: String,
    val name: String,
    val version: String,
    val base: String,
    val image: String,
    val logo: String,
    val supports: List<Any>
) {
    companion object {
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