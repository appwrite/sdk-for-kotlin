package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * PlanLimits
 */
data class BillingPlanLimits(
    /**
     * Credits limit per billing cycle
     */
    @SerializedName("credits")
    var credits: Long?,

    /**
     * Daily credits limit (if applicable)
     */
    @SerializedName("dailyCredits")
    var dailyCredits: Long?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "credits" to credits as Any,
        "dailyCredits" to dailyCredits as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlanLimits(
            credits = (map["credits"] as? Number)?.toLong(),
            dailyCredits = (map["dailyCredits"] as? Number)?.toLong(),
        )
    }
}