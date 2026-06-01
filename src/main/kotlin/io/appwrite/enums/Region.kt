package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Region(val value: String) {
    @SerializedName("fra")
    FRA("fra"),
    @SerializedName("nyc")
    NYC("nyc"),
    @SerializedName("syd")
    SYD("syd"),
    @SerializedName("sfo")
    SFO("sfo"),
    @SerializedName("sgp")
    SGP("sgp"),
    @SerializedName("tor")
    TOR("tor");

    override fun toString() = value
}