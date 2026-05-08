package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProxyRuleDeploymentResourceType(val value: String) {
    @SerializedName("function")
    FUNCTION("function"),
    @SerializedName("site")
    SITE("site");

    override fun toString() = value
}