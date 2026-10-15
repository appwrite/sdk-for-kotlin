package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * OAuth2Apple
 */
data class OAuth2Apple(
    /**
     * OAuth2 provider ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * OAuth2 provider is active and can be used to create sessions.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Apple OAuth2 service ID.
     */
    @SerializedName("serviceId")
    val serviceId: String,

    /**
     * Apple OAuth2 key ID.
     */
    @SerializedName("keyId")
    val keyId: String,

    /**
     * Apple OAuth2 team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Apple OAuth2 .p8 private key file contents. The secret key wrapped by the PEM markers is 200 characters long.
     */
    @SerializedName("p8File")
    val p8File: String,

    /**
     * Native Sign in with Apple is active and can be used to create sessions from an ID token. Independent of enabled, which only controls the browser-based flow.
     */
    @SerializedName("nativeEnabled")
    val nativeEnabled: Boolean,

    /**
     * App bundle IDs accepted as ID token audiences for native Sign in with Apple, next to the Services ID.
     */
    @SerializedName("nativeClientIds")
    val nativeClientIds: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "serviceId" to serviceId as Any,
        "keyId" to keyId as Any,
        "teamId" to teamId as Any,
        "p8File" to p8File as Any,
        "nativeEnabled" to nativeEnabled as Any,
        "nativeClientIds" to nativeClientIds as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Apple(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else false) as Boolean,
            serviceId = (if (map.containsKey("serviceId")) map["serviceId"] else "") as String,
            keyId = (if (map.containsKey("keyId")) map["keyId"] else "") as String,
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            p8File = (if (map.containsKey("p8File")) map["p8File"] else "") as String,
            nativeEnabled = (if (map.containsKey("nativeEnabled")) map["nativeEnabled"] else false) as Boolean,
            nativeClientIds = (if (map.containsKey("nativeClientIds")) map["nativeClientIds"] else listOf<Any?>()) as List<String>,
        )
    }
}
