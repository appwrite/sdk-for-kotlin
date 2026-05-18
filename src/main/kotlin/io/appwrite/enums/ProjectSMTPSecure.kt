package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectSMTPSecure(val value: String) {
    @SerializedName("tls")
    TLS("tls"),
    @SerializedName("ssl")
    SSL("ssl");

    override fun toString() = value
}