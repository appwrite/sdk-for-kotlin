package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectOAuth2OidcPrompt(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("login")
    LOGIN("login"),
    @SerializedName("consent")
    CONSENT("consent"),
    @SerializedName("select_account")
    SELECT_ACCOUNT("select_account");

    override fun toString() = value
}