package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProxyResourceType(val value: String) {
    @SerializedName("site")
    SITE("site"),
    @SerializedName("function")
    FUNCTION("function");

    override fun toString() = value
}