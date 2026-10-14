package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectOAuth2ZohoPrompt(val value: String) {
    @SerializedName("consent")
    CONSENT("consent");

    override fun toString() = value
}
