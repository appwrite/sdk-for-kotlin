package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class RelationMutate(val value: String) {
    @SerializedName("cascade")
    CASCADE("cascade"),
    @SerializedName("restrict")
    RESTRICT("restrict"),
    @SerializedName("setNull")
    SET_NULL("setNull");

    override fun toString() = value
}