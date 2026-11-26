package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AlertComparator(val value: String) {
    @SerializedName("greaterThan")
    GREATERTHAN("greaterThan"),
    @SerializedName("greaterThanEqual")
    GREATERTHANEQUAL("greaterThanEqual"),
    @SerializedName("lessThan")
    LESSTHAN("lessThan"),
    @SerializedName("lessThanEqual")
    LESSTHANEQUAL("lessThanEqual");

    override fun toString() = value
}
