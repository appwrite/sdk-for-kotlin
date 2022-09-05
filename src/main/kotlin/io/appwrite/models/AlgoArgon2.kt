package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AlgoArgon2
 */
data class AlgoArgon2(
    /**
     * Memory used to compute hash.
     *
     */
    @SerializedName("memoryCost")
    val memoryCost: Long,

    /**
     * Amount of time consumed to compute hash
     *
     */
    @SerializedName("timeCost")
    val timeCost: Long,

    /**
     * Number of threads used to compute hash.
     *
     */
    @SerializedName("threads")
    val threads: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AlgoArgon2(
            memoryCost = (map["memoryCost"] as Number).toLong(),
            timeCost = (map["timeCost"] as Number).toLong(),
            threads = (map["threads"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "memoryCost" to memoryCost as Any,
        "timeCost" to timeCost as Any,
        "threads" to threads as Any
    )
}