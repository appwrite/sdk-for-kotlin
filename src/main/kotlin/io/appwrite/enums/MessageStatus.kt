package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MessageStatus(val value: String) {
    @SerializedName("draft")
    DRAFT("draft"),
    @SerializedName("scheduled")
    SCHEDULED("scheduled"),
    @SerializedName("processing")
    PROCESSING("processing");

    override fun toString() = value
}