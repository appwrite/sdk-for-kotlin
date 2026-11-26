package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Escalation Step
 */
data class EscalationStep(
    /**
     * Seconds to wait before notifying this step: after the alert fires for the first step, after the previous step for the others.
     */
    @SerializedName("delay")
    val delay: Long,

    /**
     * Organization roles whose confirmed members this step notifies.
     */
    @SerializedName("roles")
    val roles: List<String>,

    /**
     * IDs of the organization's members this step notifies, whatever their role.
     */
    @SerializedName("userIds")
    val userIds: List<String>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "delay" to delay as Any,
        "roles" to roles as Any,
        "userIds" to userIds as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EscalationStep(
            delay = ((if (map.containsKey("delay")) map["delay"] else 0) as Number).toLong(),
            roles = (if (map.containsKey("roles")) map["roles"] else listOf<Any?>()) as List<String>,
            userIds = (if (map.containsKey("userIds")) map["userIds"] else listOf<Any?>()) as List<String>,
        )
    }
}
