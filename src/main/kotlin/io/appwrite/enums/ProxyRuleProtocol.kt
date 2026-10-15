package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProxyRuleProtocol(val value: String) {
    @SerializedName("http")
    HTTP("http"),
    @SerializedName("smtp")
    SMTP("smtp");

    override fun toString() = value
}
