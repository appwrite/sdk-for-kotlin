package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class RelationshipType(val value: String) {
    @SerializedName("oneToOne")
    ONE_TO_ONE("oneToOne"),
    @SerializedName("manyToOne")
    MANY_TO_ONE("manyToOne"),
    @SerializedName("manyToMany")
    MANY_TO_MANY("manyToMany"),
    @SerializedName("oneToMany")
    ONE_TO_MANY("oneToMany");

    override fun toString() = value
}