package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class InvalidationType(val value: String) {
    @SerializedName("tag")
    TAG("tag"),
    @SerializedName("path")
    PATH("path"),
    @SerializedName("all")
    ALL("all");

    override fun toString() = value
}