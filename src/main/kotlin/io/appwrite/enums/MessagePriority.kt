package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MessagePriority(val value: String) {
    @SerializedName("normal")
    NORMAL("normal"),
    @SerializedName("high")
    HIGH("high");

    override fun toString() = value
}