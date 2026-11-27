package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AnalyticsPropertyType(val value: String) {
    @SerializedName("web")
    WEB("web"),
    @SerializedName("mobile")
    MOBILE("mobile"),
    @SerializedName("agent")
    AGENT("agent");

    override fun toString() = value
}
