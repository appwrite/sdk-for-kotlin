package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ProtocolId(val value: String) {
    @SerializedName("rest")
    REST("rest"),
    @SerializedName("graphql")
    GRAPHQL("graphql"),
    @SerializedName("websocket")
    WEBSOCKET("websocket");

    override fun toString() = value
}