package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class BillingPlanGroup(val value: String) {
    @SerializedName("starter")
    STARTER("starter"),
    @SerializedName("free")
    FREE("free"),
    @SerializedName("start")
    START("start"),
    @SerializedName("pro")
    PRO("pro"),
    @SerializedName("scale")
    SCALE("scale");

    override fun toString() = value
}
