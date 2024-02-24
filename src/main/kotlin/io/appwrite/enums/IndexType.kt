package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class IndexType(val value: String) {
    @SerializedName("key")
    KEY("key"),
    @SerializedName("fulltext")
    FULLTEXT("fulltext"),
    @SerializedName("unique")
    UNIQUE("unique"),
    @SerializedName("spatial")
    SPATIAL("spatial");

    override fun toString() = value
}