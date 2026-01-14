package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Compression(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("gzip")
    GZIP("gzip"),
    @SerializedName("zstd")
    ZSTD("zstd");

    override fun toString() = value
}