package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuth2GooglePrompt(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("consent")
    CONSENT("consent"),
    @SerializedName("select_account")
    SELECT_ACCOUNT("select_account");

    override fun toString() = value
}