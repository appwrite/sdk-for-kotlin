package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OnDuplicate(val value: String) {
    @SerializedName("fail")
    FAIL("fail"),
    @SerializedName("skip")
    SKIP("skip"),
    @SerializedName("overwrite")
    OVERWRITE("overwrite");

    override fun toString() = value
}
