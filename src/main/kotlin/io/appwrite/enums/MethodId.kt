package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MethodId(val value: String) {
    @SerializedName("email-password")
    EMAIL_PASSWORD("email-password"),
    @SerializedName("magic-url")
    MAGIC_URL("magic-url"),
    @SerializedName("email-otp")
    EMAIL_OTP("email-otp"),
    @SerializedName("anonymous")
    ANONYMOUS("anonymous"),
    @SerializedName("invites")
    INVITES("invites"),
    @SerializedName("jwt")
    JWT("jwt"),
    @SerializedName("phone")
    PHONE("phone");

    override fun toString() = value
}