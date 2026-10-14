package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class TablesDBIndexType(val value: String) {
    @SerializedName("key")
    KEY("key"),
    @SerializedName("fulltext")
    FULLTEXT("fulltext"),
    @SerializedName("unique")
    UNIQUE("unique"),
    @SerializedName("spatial")
    SPATIAL("spatial"),
    @SerializedName("trigram")
    TRIGRAM("trigram");

    override fun toString() = value
}
