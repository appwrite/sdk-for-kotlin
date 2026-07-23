package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Member
 */
data class DedicatedDatabaseMember(
    /**
     * Member identifier.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Member role. Possible values: primary (accepts reads and writes), replica (read-only follower).
     */
    @SerializedName("role")
    val role: String,

    /**
     * Member pod status. Possible values: provisioning (pod missing or Pending), starting (Running but not Ready), active (Running and Ready), failed (Failed phase or CrashLoopBackOff container), or the lowercased pod phase reported by the cluster.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Replication lag in seconds.
     */
    @SerializedName("lagSeconds")
    val lagSeconds: Double,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "role" to role as Any,
        "status" to status as Any,
        "lagSeconds" to lagSeconds as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseMember(
            id = map["\$id"] as String,
            role = map["role"] as String,
            status = map["status"] as String,
            lagSeconds = (map["lagSeconds"] as Number).toDouble(),
        )
    }
}
