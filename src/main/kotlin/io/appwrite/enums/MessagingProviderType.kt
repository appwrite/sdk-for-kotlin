package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MessagingProviderType(val value: String) {
    @SerializedName("email")
    EMAIL("email"),
    @SerializedName("sms")
    SMS("sms"),
    @SerializedName("push")
    PUSH("push");

    override fun toString() = value
}