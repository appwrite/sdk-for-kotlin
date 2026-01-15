package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class HealthAntivirusStatus(val value: String) {
    @SerializedName("disabled")
    DISABLED("disabled"),
    @SerializedName("offline")
    OFFLINE("offline"),
    @SerializedName("online")
    ONLINE("online");

    override fun toString() = value
}