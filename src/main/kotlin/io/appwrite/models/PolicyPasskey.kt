package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Passkey
 */
data class PolicyPasskey(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Relying party ID passkeys are bound to. Empty until configured.
     */
    @SerializedName("rpId")
    val rpId: String,

    /**
     * Web origins passkeys work on, from the project's platforms on the relying party ID and a localhost web platform. Read-only.
     */
    @SerializedName("origins")
    val origins: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "rpId" to rpId as Any,
        "origins" to origins as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasskey(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            rpId = (if (map.containsKey("rpId")) map["rpId"] else "") as String,
            origins = (if (map.containsKey("origins")) map["origins"] else listOf<Any?>()) as List<String>,
        )
    }
}
