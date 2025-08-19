package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Type(val value: String) {
    @SerializedName("tablesdb")
    TABLESDB("tablesdb"),
    @SerializedName("legacy")
    LEGACY("legacy");

    override fun toString() = value
}