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

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "enabled" to enabled as Any,
        "serviceId" to serviceId as Any,
        "keyId" to keyId as Any,
        "teamId" to teamId as Any,
        "p8File" to p8File as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = OAuth2Apple(
            id = map["\$id"] as String,
            enabled = map["enabled"] as Boolean,
            serviceId = map["serviceId"] as String,
            keyId = map["keyId"] as String,
            teamId = map["teamId"] as String,
            p8File = map["p8File"] as String,
        )
    }
}
