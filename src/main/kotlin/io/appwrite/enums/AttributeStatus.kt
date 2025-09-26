package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AttributeStatus(val value: String) {
    @SerializedName("available")
    AVAILABLE("available"),
    @SerializedName("processing")
    PROCESSING("processing"),
    @SerializedName("deleting")
    DELETING("deleting"),
    @SerializedName("stuck")
    STUCK("stuck"),
    @SerializedName("failed")
    FAILED("failed");

    override fun toString() = value
}