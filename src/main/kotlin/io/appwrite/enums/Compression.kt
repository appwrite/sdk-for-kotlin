package io.appwrite.enums

enum class Compression(val value: String) {
    NONE("none"),
    GZIP("gzip"),
    ZSTD("zstd");

    override fun toString() = value
}