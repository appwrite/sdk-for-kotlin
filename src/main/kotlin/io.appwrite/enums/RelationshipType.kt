package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class RelationshipType(val value: String) {
    @SerializedName("oneToOne")
    ONETOONE("oneToOne"),
    @SerializedName("manyToOne")
    MANYTOONE("manyToOne"),
    @SerializedName("manyToMany")
    MANYTOMANY("manyToMany"),
    @SerializedName("oneToMany")
    ONETOMANY("oneToMany");

    override fun toString() = value
}