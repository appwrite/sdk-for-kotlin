package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class EmbeddingModel(val value: String) {
    @SerializedName("nomic-embed-text")
    NOMIC_EMBED_TEXT("nomic-embed-text"),
    @SerializedName("embedding-gemma")
    EMBEDDING_GEMMA("embedding-gemma"),
    @SerializedName("all-minilm")
    ALL_MINILM("all-minilm"),
    @SerializedName("bge-small")
    BGE_SMALL("bge-small");

    override fun toString() = value
}
