package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorStatus(val value: String) {
    @SerializedName("ok")
    OK("ok"),
    @SerializedName("firing")
    FIRING("firing");

    override fun toString() = value
}
