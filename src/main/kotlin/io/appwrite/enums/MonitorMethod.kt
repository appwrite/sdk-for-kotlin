package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorMethod(val value: String) {
    @SerializedName("GET")
    GET("GET"),
    @SerializedName("HEAD")
    HEAD("HEAD"),
    @SerializedName("POST")
    POST("POST"),
    @SerializedName("PUT")
    PUT("PUT"),
    @SerializedName("PATCH")
    PATCH("PATCH"),
    @SerializedName("DELETE")
    DELETE("DELETE"),
    @SerializedName("OPTIONS")
    OPTIONS("OPTIONS");

    override fun toString() = value
}
