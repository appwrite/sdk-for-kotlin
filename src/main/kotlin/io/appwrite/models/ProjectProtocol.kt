package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.ProjectProtocolId

/**
 * ProjectProtocol
 */
data class ProjectProtocol(
    /**
     * Protocol ID.
     */
    @SerializedName("\$id")
    val id: ProjectProtocolId,

    /**
     * Protocol status.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id.value as Any,
        "enabled" to enabled as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ProjectProtocol(
            id = ProjectProtocolId.values().find { it.value == map["\$id"] as String }!!,
            enabled = map["enabled"] as Boolean,
        )
    }
}