package io.appwrite.models

/// Health Queue
data class HealthQueue(
    val size: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = HealthQueue(
            size = map["size"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "size" to size as Any
    )
}