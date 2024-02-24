package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Name(val value: String) {
    @SerializedName("v1-database")
    V1DATABASE("v1-database"),
    @SerializedName("v1-deletes")
    V1DELETES("v1-deletes"),
    @SerializedName("v1-audits")
    V1AUDITS("v1-audits"),
    @SerializedName("v1-mails")
    V1MAILS("v1-mails"),
    @SerializedName("v1-functions")
    V1FUNCTIONS("v1-functions"),
    @SerializedName("v1-usage")
    V1USAGE("v1-usage"),
    @SerializedName("webhooksv1")
    WEBHOOKSV1("webhooksv1"),
    @SerializedName("v1-certificates")
    V1CERTIFICATES("v1-certificates"),
    @SerializedName("v1-builds")
    V1BUILDS("v1-builds"),
    @SerializedName("v1-messaging")
    V1MESSAGING("v1-messaging"),
    @SerializedName("v1-migrations")
    V1MIGRATIONS("v1-migrations"),
    @SerializedName("hamsterv1")
    HAMSTERV1("hamsterv1");

    override fun toString() = value
}