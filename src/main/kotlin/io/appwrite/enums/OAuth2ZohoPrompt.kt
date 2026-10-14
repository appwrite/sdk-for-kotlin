package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuth2ZohoPrompt(val value: String) {
    @SerializedName("consent")
    CONSENT("consent");

    override fun toString() = value
}
