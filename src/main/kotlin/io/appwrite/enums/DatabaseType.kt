package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DatabaseType(val value: String) {
    @SerializedName("legacy")
    LEGACY("legacy"),
    @SerializedName("tablesdb")
    TABLESDB("tablesdb");

    override fun toString() = value
}