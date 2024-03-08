package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Name(val value: String) {
    @SerializedName("v1-database")
    V1_DATABASE("v1-database"),
    @SerializedName("v1-deletes")
    V1_DELETES("v1-deletes"),
    @SerializedName("v1-audits")
    V1_AUDITS("v1-audits"),
    @SerializedName("v1-mails")
    V1_MAILS("v1-mails"),
    @SerializedName("v1-functions")
    V1_FUNCTIONS("v1-functions"),
    @SerializedName("v1-usage")
    V1_USAGE("v1-usage"),
    @SerializedName("v1-usage-dump")
    V1_USAGE_DUMP("v1-usage-dump"),
    @SerializedName("webhooksv1")
    WEBHOOKSV1("webhooksv1"),
    @SerializedName("v1-certificates")
    V1_CERTIFICATES("v1-certificates"),
    @SerializedName("v1-builds")
    V1_BUILDS("v1-builds"),
    @SerializedName("v1-messaging")
    V1_MESSAGING("v1-messaging"),
    @SerializedName("v1-migrations")
    V1_MIGRATIONS("v1-migrations"),
    @SerializedName("hamsterv1")
    HAMSTERV1("hamsterv1");

    override fun toString() = value
}