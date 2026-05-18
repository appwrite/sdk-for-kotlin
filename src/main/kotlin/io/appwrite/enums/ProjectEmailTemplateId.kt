package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectEmailTemplateId(val value: String) {
    @SerializedName("verification")
    VERIFICATION("verification"),
    @SerializedName("magicSession")
    MAGICSESSION("magicSession"),
    @SerializedName("recovery")
    RECOVERY("recovery"),
    @SerializedName("invitation")
    INVITATION("invitation"),
    @SerializedName("mfaChallenge")
    MFACHALLENGE("mfaChallenge"),
    @SerializedName("sessionAlert")
    SESSIONALERT("sessionAlert"),
    @SerializedName("otpSession")
    OTPSESSION("otpSession");

    override fun toString() = value
}