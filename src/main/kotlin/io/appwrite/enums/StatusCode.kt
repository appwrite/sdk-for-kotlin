package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class StatusCode(val value: String) {
    @SerializedName("301")
    MOVED_PERMANENTLY_301("301"),
    @SerializedName("302")
    FOUND_302("302"),
    @SerializedName("307")
    TEMPORARY_REDIRECT_307("307"),
    @SerializedName("308")
    PERMANENT_REDIRECT_308("308");

    override fun toString() = value
}