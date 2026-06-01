package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OrganizationKeyScopes(val value: String) {
    @SerializedName("projects.read")
    PROJECTS_READ("projects.read"),
    @SerializedName("projects.write")
    PROJECTS_WRITE("projects.write"),
    @SerializedName("devKeys.read")
    DEVKEYS_READ("devKeys.read"),
    @SerializedName("devKeys.write")
    DEVKEYS_WRITE("devKeys.write"),
    @SerializedName("organization.keys.read")
    ORGANIZATION_KEYS_READ("organization.keys.read"),
    @SerializedName("organization.keys.write")
    ORGANIZATION_KEYS_WRITE("organization.keys.write"),
    @SerializedName("domains.read")
    DOMAINS_READ("domains.read"),
    @SerializedName("domains.write")
    DOMAINS_WRITE("domains.write"),
    @SerializedName("keys.read")
    KEYS_READ("keys.read"),
    @SerializedName("keys.write")
    KEYS_WRITE("keys.write");

    override fun toString() = value
}