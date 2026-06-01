package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class StatusCode(val value: String) {
    @SerializedName("301")
    MOVEDPERMANENTLY("301"),
    @SerializedName("302")
    FOUND("302"),
    @SerializedName("307")
    TEMPORARYREDIRECT("307"),
    @SerializedName("308")
    PERMANENTREDIRECT("308");

    override fun toString() = value
}