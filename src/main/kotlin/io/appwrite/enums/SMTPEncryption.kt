package io.appwrite.enums

enum class SMTPEncryption(val value: String) {
    NONE("none"),
    SSL("ssl"),
    TLS("tls");

    override fun toString() = value
}