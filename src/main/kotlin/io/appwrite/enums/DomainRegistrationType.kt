package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DomainRegistrationType(val value: String) {
    @SerializedName("new")
    NEW("new"),
    @SerializedName("transfer")
    TRANSFER("transfer"),
    @SerializedName("renewal")
    RENEWAL("renewal"),
    @SerializedName("trade")
    TRADE("trade");

    override fun toString() = value
}
