package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Adapter(val value: String) {
    @SerializedName("static")
    STATIC("static"),
    @SerializedName("ssr")
    SSR("ssr");

    override fun toString() = value
}