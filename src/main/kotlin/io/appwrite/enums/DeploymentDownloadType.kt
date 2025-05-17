package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DeploymentDownloadType(val value: String) {
    @SerializedName("source")
    SOURCE("source"),
    @SerializedName("output")
    OUTPUT("output");

    override fun toString() = value
}