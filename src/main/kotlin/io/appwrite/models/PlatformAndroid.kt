package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.PlatformType
import io.appwrite.extensions.jsonCast

/**
 * Platform Android
 */
data class PlatformAndroid(
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
     * Android application ID.
     */
    @SerializedName("applicationId")
    val applicationId: String,

    /**
     * SHA-256 fingerprints of the certificates the app is signed with. Passkeys created in the app are accepted when its signature matches one.
     */
    @SerializedName("fingerprints")
    val fingerprints: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "type" to type.value as Any,
        "applicationId" to applicationId as Any,
        "fingerprints" to fingerprints as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PlatformAndroid(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            type = PlatformType.values().find { it.value == map["type"] as String }!!,
            applicationId = (if (map.containsKey("applicationId")) map["applicationId"] else "") as String,
            fingerprints = (if (map.containsKey("fingerprints")) map["fingerprints"] else listOf<Any?>()) as List<String>,
        )
    }
}
