package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProjectLDAPEncryption(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("ldaps")
    LDAPS("ldaps"),
    @SerializedName("starttls")
    STARTTLS("starttls");

    override fun toString() = value
}
