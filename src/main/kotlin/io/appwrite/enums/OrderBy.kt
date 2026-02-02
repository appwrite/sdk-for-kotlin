package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OrderBy(val value: String) {
    @SerializedName("asc")
    ASC("asc"),
    @SerializedName("desc")
    DESC("desc");

    override fun toString() = value
}