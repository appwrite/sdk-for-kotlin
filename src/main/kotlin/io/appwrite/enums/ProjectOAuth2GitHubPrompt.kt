package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectOAuth2GitHubPrompt(val value: String) {
    @SerializedName("select_account")
    SELECT_ACCOUNT("select_account");

    override fun toString() = value
}
