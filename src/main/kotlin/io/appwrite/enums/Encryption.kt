package io.appwrite.enums

enum class Encryption(val value: String) {
    NONE("none"),
    SSL("ssl"),
    TLS("tls");

    override fun toString() = value
}