package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorSeverity(val value: String) {
    @SerializedName("info")
    INFO("info"),
    @SerializedName("warning")
    WARNING("warning"),
    @SerializedName("error")
    ERROR("error"),
    @SerializedName("critical")
    CRITICAL("critical");

    override fun toString() = value
}
