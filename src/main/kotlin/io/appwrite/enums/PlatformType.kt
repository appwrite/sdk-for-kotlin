package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class PlatformType(val value: String) {
    @SerializedName("windows")
    WINDOWS("windows"),
    @SerializedName("apple")
    APPLE("apple"),
    @SerializedName("android")
    ANDROID("android"),
    @SerializedName("linux")
    LINUX("linux"),
    @SerializedName("web")
    WEB("web");

    override fun toString() = value
}