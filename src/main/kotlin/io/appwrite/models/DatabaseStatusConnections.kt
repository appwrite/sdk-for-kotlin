package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Connections
 */
data class DatabaseStatusConnections(
    /**
     * Current number of active connections.
     */
    @SerializedName("current")
    val current: Long,

    /**
     * The engine's own max_connections. On a pooled database this is the backend limit the pooler multiplexes onto, not the ceiling a client pool may reach — that is networkMaxConnections on the database resource.
     */
    @SerializedName("max")
    val max: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "current" to current as Any,
        "max" to max as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseStatusConnections(
            current = ((if (map.containsKey("current")) map["current"] else 0) as Number).toLong(),
            max = ((if (map.containsKey("max")) map["max"] else 100) as Number).toLong(),
        )
    }
}
