package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class EmbeddingModel(val value: String) {
    @SerializedName("nomic-embed-text")
    NOMIC_EMBED_TEXT("nomic-embed-text"),
    @SerializedName("all-minilm")
    ALL_MINILM("all-minilm");

    override fun toString() = value
}
