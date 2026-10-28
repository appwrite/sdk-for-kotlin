package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class FirebaseMigrationResource(val value: String) {
    @SerializedName("user")
    USER("user"),
    @SerializedName("database")
    DATABASE("database"),
    @SerializedName("table")
    TABLE("table"),
    @SerializedName("column")
    COLUMN("column"),
    @SerializedName("row")
    ROW("row"),
    @SerializedName("document")
    DOCUMENT("document"),
    @SerializedName("attribute")
    ATTRIBUTE("attribute"),
    @SerializedName("collection")
    COLLECTION("collection"),
    @SerializedName("bucket")
    BUCKET("bucket"),
    @SerializedName("file")
    FILE("file");

    override fun toString() = value
}
