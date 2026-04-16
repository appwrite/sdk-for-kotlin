package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AuthProvider
 */
data class AuthProvider(
    /**
     * Auth Provider.
     */
    @SerializedName("key")
    val key: String,

    /**
     * Auth Provider name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * OAuth 2.0 application ID.
     */
    @SerializedName("appId")
    val appId: String,

    /**
     * OAuth 2.0 application secret. Might be JSON string if provider requires extra configuration.
     */
    @SerializedName("secret")
    val secret: String,

    /**
     * Auth Provider is active and can be used to create session.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "key" to key as Any,
        "name" to name as Any,
        "appId" to appId as Any,
        "secret" to secret as Any,
        "enabled" to enabled as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AuthProvider(
            key = map["key"] as String,
            name = map["name"] as String,
            appId = map["appId"] as String,
            secret = map["secret"] as String,
            enabled = map["enabled"] as Boolean,
        )
    }
}