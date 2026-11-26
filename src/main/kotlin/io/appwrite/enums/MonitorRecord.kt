package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorRecord(val value: String) {
    @SerializedName("A")
    A("A"),
    @SerializedName("AAAA")
    AAAA("AAAA"),
    @SerializedName("CNAME")
    CNAME("CNAME"),
    @SerializedName("MX")
    MX("MX"),
    @SerializedName("TXT")
    TXT("TXT"),
    @SerializedName("NS")
    NS("NS");

    override fun toString() = value
}
