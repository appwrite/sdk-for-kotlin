package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AlertStatus(val value: String) {
    @SerializedName("firing")
    FIRING("firing"),
    @SerializedName("resolved")
    RESOLVED("resolved");

    override fun toString() = value
}
