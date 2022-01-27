package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Health Time
 */
data class HealthTime(
    /**
     * Current unix timestamp on trustful remote server.
     *
     */
    @SerializedName("remoteTime")
    val remoteTime: Long,

    /**
     * Current unix timestamp of local server where Appwrite runs.
     *
     */
    @SerializedName("localTime")
    val localTime: Long,

    /**
     * Difference of unix remote and local timestamps in milliseconds.
     *
     */
    @SerializedName("diff")
    val diff: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = HealthTime(
            remoteTime = (map["remoteTime"] as Number).toLong(),
            localTime = (map["localTime"] as Number).toLong(),
            diff = (map["diff"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "remoteTime" to remoteTime as Any,
        "localTime" to localTime as Any,
        "diff" to diff as Any
    )
}