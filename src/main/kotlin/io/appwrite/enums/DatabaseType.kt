package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DatabaseType(val value: String) {
    @SerializedName("legacy")
    LEGACY("legacy"),
    @SerializedName("tablesdb")
    TABLESDB("tablesdb"),
    @SerializedName("documentsdb")
    DOCUMENTSDB("documentsdb"),
    @SerializedName("vectorsdb")
    VECTORSDB("vectorsdb"),
    @SerializedName("mysql")
    MYSQL("mysql"),
    @SerializedName("postgresql")
    POSTGRESQL("postgresql"),
    @SerializedName("mongodb")
    MONGODB("mongodb");

    override fun toString() = value
}