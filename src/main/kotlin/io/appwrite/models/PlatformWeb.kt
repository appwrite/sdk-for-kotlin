package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.PlatformType

/**
 * Platform Web
 */
data class PlatformWeb(
    /**
     * Platform ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Platform creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Platform update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Platform name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Platform type. Possible values are: windows, apple, android, linux, web.
     */
    @SerializedName("type")
    val type: PlatformType,

    /**
     * Web app hostname. Empty string for other platforms.
     */
    @SerializedName("hostname")
    val hostname: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "type" to type.value as Any,
        "hostname" to hostname as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PlatformWeb(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            type = PlatformType.values().find { it.value == map["type"] as String }!!,
            hostname = map["hostname"] as String,
        )
    }
}