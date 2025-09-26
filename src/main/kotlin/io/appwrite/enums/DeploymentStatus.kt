package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DeploymentStatus(val value: String) {
    @SerializedName("waiting")
    WAITING("waiting"),
    @SerializedName("processing")
    PROCESSING("processing"),
    @SerializedName("building")
    BUILDING("building"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("failed")
    FAILED("failed");

    override fun toString() = value
}