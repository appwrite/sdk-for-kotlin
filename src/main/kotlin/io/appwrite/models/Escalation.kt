package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Escalation
 */
data class Escalation(
    /**
     * Escalation ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Escalation creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Escalation update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Escalation name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Who is notified of a firing alert, in order, until a member acknowledges it.
     */
    @SerializedName("steps")
    val steps: List<EscalationStep>,

    /**
     * How many more times the steps run from the first, a monitor's cooldown after the last step, while nobody has acknowledged the alert.
     */
    @SerializedName("repeat")
    val repeat: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "steps" to steps.map { it.toMap() } as Any,
        "repeat" to repeat as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Escalation(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            steps = ((if (map.containsKey("steps")) map["steps"] else listOf<Any?>()) as List<Map<String, Any>>).map { EscalationStep.from(map = it) },
            repeat = ((if (map.containsKey("repeat")) map["repeat"] else 0) as Number).toLong(),
        )
    }
}
