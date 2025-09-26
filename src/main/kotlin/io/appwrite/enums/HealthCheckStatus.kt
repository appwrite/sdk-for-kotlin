package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class HealthCheckStatus(val value: String) {
    @SerializedName("pass")
    PASS("pass"),
    @SerializedName("fail")
    FAIL("fail");

    override fun toString() = value
}