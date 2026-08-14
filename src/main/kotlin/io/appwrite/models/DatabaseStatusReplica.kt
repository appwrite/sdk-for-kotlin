package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Replica
 */
data class DatabaseStatusReplica(
    /**
     * Member index within the database. Read `role` for which member accepts writes: a failover moves the primary without renumbering the indexes.
     */
    @SerializedName("index")
    val index: Long,

    /**
     * Member role. Possible values: primary (accepts reads and writes), replica (read-only follower), unknown (placement not established; reported while a transition is moving or restarting the topology, so no member can be named the write target).
     */
    @SerializedName("role")
    val role: String,

    /**
     * Whether the replica is healthy.
     */
    @SerializedName("healthy")
    val healthy: Boolean,

    /**
     * Replication lag in seconds (null for primary).
     */
    @SerializedName("lagSeconds")
    var lagSeconds: Double?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "index" to index as Any,
        "role" to role as Any,
        "healthy" to healthy as Any,
        "lagSeconds" to lagSeconds as Any?,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseStatusReplica(
            index = (map["index"] as Number).toLong(),
            role = map["role"] as String,
            healthy = map["healthy"] as Boolean,
            lagSeconds = (map["lagSeconds"] as? Number)?.toDouble(),
        )
    }
}
