package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VCSDeploymentType(val value: String) {
    @SerializedName("branch")
    BRANCH("branch"),
    @SerializedName("commit")
    COMMIT("commit"),
    @SerializedName("tag")
    TAG("tag");

    override fun toString() = value
}