package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AnalyticsInterval(val value: String) {
    @SerializedName("1h")
    ONE_HOUR("1h"),
    @SerializedName("1d")
    ONE_DAY("1d"),
    @SerializedName("1w")
    ONE_WEEK("1w"),
    @SerializedName("1m")
    ONE_MONTH("1m");

    override fun toString() = value
}
