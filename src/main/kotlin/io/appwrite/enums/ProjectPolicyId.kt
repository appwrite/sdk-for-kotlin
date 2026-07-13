package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectPolicyId(val value: String) {
    @SerializedName("password-dictionary")
    PASSWORD_DICTIONARY("password-dictionary"),
    @SerializedName("password-history")
    PASSWORD_HISTORY("password-history"),
    @SerializedName("password-strength")
    PASSWORD_STRENGTH("password-strength"),
    @SerializedName("password-personal-data")
    PASSWORD_PERSONAL_DATA("password-personal-data"),
    @SerializedName("session-alert")
    SESSION_ALERT("session-alert"),
    @SerializedName("session-duration")
    SESSION_DURATION("session-duration"),
    @SerializedName("session-invalidation")
    SESSION_INVALIDATION("session-invalidation"),
    @SerializedName("session-limit")
    SESSION_LIMIT("session-limit"),
    @SerializedName("user-limit")
    USER_LIMIT("user-limit"),
    @SerializedName("membership-privacy")
    MEMBERSHIP_PRIVACY("membership-privacy"),
    @SerializedName("deny-aliased-email")
    DENY_ALIASED_EMAIL("deny-aliased-email"),
    @SerializedName("deny-disposable-email")
    DENY_DISPOSABLE_EMAIL("deny-disposable-email"),
    @SerializedName("deny-free-email")
    DENY_FREE_EMAIL("deny-free-email"),
    @SerializedName("deny-corporate-email")
    DENY_CORPORATE_EMAIL("deny-corporate-email");

    override fun toString() = value
}