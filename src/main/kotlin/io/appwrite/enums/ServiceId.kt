package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ServiceId(val value: String) {
    @SerializedName("account")
    ACCOUNT("account"),
    @SerializedName("avatars")
    AVATARS("avatars"),
    @SerializedName("databases")
    DATABASES("databases"),
    @SerializedName("tablesdb")
    TABLESDB("tablesdb"),
    @SerializedName("locale")
    LOCALE("locale"),
    @SerializedName("health")
    HEALTH("health"),
    @SerializedName("project")
    PROJECT("project"),
    @SerializedName("storage")
    STORAGE("storage"),
    @SerializedName("teams")
    TEAMS("teams"),
    @SerializedName("users")
    USERS("users"),
    @SerializedName("vcs")
    VCS("vcs"),
    @SerializedName("sites")
    SITES("sites"),
    @SerializedName("functions")
    FUNCTIONS("functions"),
    @SerializedName("proxy")
    PROXY("proxy"),
    @SerializedName("graphql")
    GRAPHQL("graphql"),
    @SerializedName("migrations")
    MIGRATIONS("migrations"),
    @SerializedName("messaging")
    MESSAGING("messaging");

    override fun toString() = value
}