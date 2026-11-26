package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorType(val value: String) {
    @SerializedName("usage")
    USAGE("usage"),
    @SerializedName("http")
    HTTP("http"),
    @SerializedName("dns")
    DNS("dns"),
    @SerializedName("tcp")
    TCP("tcp"),
    @SerializedName("smtp")
    SMTP("smtp"),
    @SerializedName("budget")
    BUDGET("budget");

    override fun toString() = value
}
