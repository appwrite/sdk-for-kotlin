package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DatabaseStatus(val value: String) {
    @SerializedName("provisioning")
    PROVISIONING("provisioning"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("failed")
    FAILED("failed");

    override fun toString() = value
}