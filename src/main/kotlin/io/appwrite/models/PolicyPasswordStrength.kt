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
    fun toMap(): Map<String, Any?> = mapOf(
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
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            min = ((if (map.containsKey("min")) map["min"] else 8) as Number).toLong(),
            uppercase = (if (map.containsKey("uppercase")) map["uppercase"] else false) as Boolean,
            lowercase = (if (map.containsKey("lowercase")) map["lowercase"] else false) as Boolean,
            number = (if (map.containsKey("number")) map["number"] else false) as Boolean,
            symbols = (if (map.containsKey("symbols")) map["symbols"] else false) as Boolean,
        )
    }
}
