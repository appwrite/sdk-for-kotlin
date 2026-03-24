package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class BackupServices(val value: String) {
    @SerializedName("databases")
    DATABASES("databases"),
    @SerializedName("tablesdb")
    TABLESDB("tablesdb"),
    @SerializedName("documentsdb")
    DOCUMENTSDB("documentsdb"),
    @SerializedName("vectorsdb")
    VECTORSDB("vectorsdb"),
    @SerializedName("functions")
    FUNCTIONS("functions"),
    @SerializedName("storage")
    STORAGE("storage");

    override fun toString() = value
}