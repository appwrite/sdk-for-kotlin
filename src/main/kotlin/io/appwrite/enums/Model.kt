package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Model(val value: String) {
    @SerializedName("embeddinggemma")
    EMBEDDINGGEMMA("embeddinggemma");

    override fun toString() = value
}