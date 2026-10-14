package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class WafRuleAction(val value: String) {
    @SerializedName("bypass")
    BYPASS("bypass"),
    @SerializedName("deny")
    DENY("deny"),
    @SerializedName("challenge")
    CHALLENGE("challenge"),
    @SerializedName("rateLimit")
    RATELIMIT("rateLimit"),
    @SerializedName("redirect")
    REDIRECT("redirect");

    override fun toString() = value
}
