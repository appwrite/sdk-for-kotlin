package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorTlsMode(val value: String) {
    @SerializedName("none")
    NONE("none"),
    @SerializedName("starttls")
    STARTTLS("starttls"),
    @SerializedName("implicit")
    IMPLICIT("implicit"),
    @SerializedName("auto")
    AUTO("auto");

    override fun toString() = value
}
