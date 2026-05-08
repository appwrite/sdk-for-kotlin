package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProxyRuleStatus(val value: String) {
    @SerializedName("unverified")
    UNVERIFIED("unverified"),
    @SerializedName("verifying")
    VERIFYING("verifying"),
    @SerializedName("verified")
    VERIFIED("verified");

    override fun toString() = value
}