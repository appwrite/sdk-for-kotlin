package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class SmtpEncryption(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("ssl")
    SSL("ssl"),
    @SerializedName("tls")
    TLS("tls");

    override fun toString() = value
}