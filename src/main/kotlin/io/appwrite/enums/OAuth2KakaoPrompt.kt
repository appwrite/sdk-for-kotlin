package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuth2KakaoPrompt(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("login")
    LOGIN("login"),
    @SerializedName("create")
    CREATE("create"),
    @SerializedName("select_account")
    SELECT_ACCOUNT("select_account");

    override fun toString() = value
}
