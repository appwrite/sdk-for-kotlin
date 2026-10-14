package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectOAuth2DiscordPrompt(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("consent")
    CONSENT("consent");

    override fun toString() = value
}
