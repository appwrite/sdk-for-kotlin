package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuth2SalesforcePrompt(val value: String) {
    @SerializedName("login")
    LOGIN("login"),
    @SerializedName("consent")
    CONSENT("consent");

    override fun toString() = value
}
