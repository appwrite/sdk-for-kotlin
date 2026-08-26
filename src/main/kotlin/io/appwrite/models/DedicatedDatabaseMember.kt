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
     * Member role. Possible values: primary (accepts reads and writes), replica (read-only follower), unknown (placement not established; reported while a transition is moving or restarting the topology and this member has not been probed, so no member can be named the write target).
     */
    @SerializedName("role")
    val role: String,

    /**
     * Member pod status. Possible values: pending (configured but absent from the backend topology, so nothing is bringing it up), provisioning (pod missing or Pending), starting (Running but not Ready), active (Running and Ready), failed (Failed phase or CrashLoopBackOff container), or the lowercased pod phase reported by the cluster.
     */
    @SerializedName("status")
    val status: String,

    /**
     * Whether the engine reports this member's replication stream as up. Null when no reading was taken: a primary has no stream to report, and a member that is not active, or whose probe did not answer, has none yet. False is a reading and null is the absence of one, so the two are not interchangeable. Read it beside lagSeconds before expecting a failover that names no target to find a promotable standby: a member streaming at a known lag is one, and a member reporting null is not evidence either way.
     */
    @SerializedName("replicating")
    var replicating: Boolean?,

    /**
     * Replication lag in seconds. Null when the lag is not known: a primary has none to report, and a member the backend has not probed has none yet. Also null against `replicating: true`, for a member that is streaming but whose engine printed no numeric lag.
     */
    @SerializedName("lagSeconds")
    var lagSeconds: Double?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "role" to role as Any,
        "status" to status as Any,
        "replicating" to replicating as Any?,
        "lagSeconds" to lagSeconds as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseMember(
            id = map["\$id"] as String,
            role = map["role"] as String,
            status = map["status"] as String,
            replicating = map["replicating"] as? Boolean,
            lagSeconds = (map["lagSeconds"] as? Number)?.toDouble(),
        )
    }
}
