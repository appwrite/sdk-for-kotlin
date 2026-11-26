package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorResourceType(val value: String) {
    @SerializedName("project")
    PROJECT("project"),
    @SerializedName("database")
    DATABASE("database"),
    @SerializedName("bucket")
    BUCKET("bucket"),
    @SerializedName("function")
    FUNCTION("function"),
    @SerializedName("site")
    SITE("site"),
    @SerializedName("dedicatedDatabase")
    DEDICATEDDATABASE("dedicatedDatabase"),
    @SerializedName("organization")
    ORGANIZATION("organization");

    override fun toString() = value
}
