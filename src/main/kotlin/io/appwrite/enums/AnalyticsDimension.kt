package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AnalyticsDimension(val value: String) {
    @SerializedName("country")
    COUNTRY("country"),
    @SerializedName("region")
    REGION("region"),
    @SerializedName("city")
    CITY("city"),
    @SerializedName("browser")
    BROWSER("browser"),
    @SerializedName("browserVersion")
    BROWSERVERSION("browserVersion"),
    @SerializedName("operatingSystem")
    OPERATINGSYSTEM("operatingSystem"),
    @SerializedName("operatingSystemVersion")
    OPERATINGSYSTEMVERSION("operatingSystemVersion"),
    @SerializedName("device")
    DEVICE("device"),
    @SerializedName("screenSize")
    SCREENSIZE("screenSize"),
    @SerializedName("referrerSource")
    REFERRERSOURCE("referrerSource"),
    @SerializedName("channel")
    CHANNEL("channel"),
    @SerializedName("utmSource")
    UTMSOURCE("utmSource"),
    @SerializedName("utmMedium")
    UTMMEDIUM("utmMedium"),
    @SerializedName("utmCampaign")
    UTMCAMPAIGN("utmCampaign"),
    @SerializedName("utmContent")
    UTMCONTENT("utmContent"),
    @SerializedName("utmTerm")
    UTMTERM("utmTerm"),
    @SerializedName("page")
    PAGE("page"),
    @SerializedName("hostname")
    HOSTNAME("hostname"),
    @SerializedName("entryPage")
    ENTRYPAGE("entryPage"),
    @SerializedName("exitPage")
    EXITPAGE("exitPage"),
    @SerializedName("trafficType")
    TRAFFICTYPE("trafficType"),
    @SerializedName("botName")
    BOTNAME("botName"),
    @SerializedName("botCategory")
    BOTCATEGORY("botCategory"),
    @SerializedName("userId")
    USERID("userId"),
    @SerializedName("eventName")
    EVENTNAME("eventName"),
    @SerializedName("props")
    PROPS("props");

    override fun toString() = value
}
