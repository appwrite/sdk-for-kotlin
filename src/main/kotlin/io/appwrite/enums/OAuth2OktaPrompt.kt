package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuth2OktaPrompt(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("login")
    LOGIN("login"),
    @SerializedName("consent")
    CONSENT("consent");

    override fun toString() = value
}
