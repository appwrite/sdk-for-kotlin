package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Policy Password Strength
 */
data class PolicyPasswordStrength(
    /**
     * Policy ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Minimum password length required for user passwords.
     */
    @SerializedName("min")
    val min: Long,

    /**
     * Whether passwords must include at least one uppercase letter.
     */
    @SerializedName("uppercase")
    val uppercase: Boolean,

    /**
     * Whether passwords must include at least one lowercase letter.
     */
    @SerializedName("lowercase")
    val lowercase: Boolean,

    /**
     * Whether passwords must include at least one number.
     */
    @SerializedName("number")
    val number: Boolean,

    /**
     * Whether passwords must include at least one symbol.
     */
    @SerializedName("symbols")
    val symbols: Boolean,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "min" to min as Any,
        "uppercase" to uppercase as Any,
        "lowercase" to lowercase as Any,
        "number" to number as Any,
        "symbols" to symbols as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = PolicyPasswordStrength(
            id = map["\$id"] as String,
            min = (map["min"] as Number).toLong(),
            uppercase = map["uppercase"] as Boolean,
            lowercase = map["lowercase"] as Boolean,
            number = map["number"] as Boolean,
            symbols = map["symbols"] as Boolean,
        )
    }
}