package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Replica
 */
data class DatabaseStatusReplica(
    /**
     * StatefulSet pod index (0 = primary, 1+ = replicas).
     */
    @SerializedName("index")
    val index: Long,

    /**
     * Replica role: primary or replica.
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
