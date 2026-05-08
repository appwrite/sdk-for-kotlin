package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Secure(val value: String) {
    @SerializedName("tls")
    TLS("tls"),
    @SerializedName("ssl")
    SSL("ssl");

    override fun toString() = value
}