package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VCSReferenceType(val value: String) {
    @SerializedName("branch")
    BRANCH("branch"),
    @SerializedName("commit")
    COMMIT("commit");

    override fun toString() = value
}