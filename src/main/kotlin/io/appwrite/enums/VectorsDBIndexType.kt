package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VectorsDBIndexType(val value: String) {
    @SerializedName("hnsw_euclidean")
    HNSW_EUCLIDEAN("hnsw_euclidean"),
    @SerializedName("hnsw_dot")
    HNSW_DOT("hnsw_dot"),
    @SerializedName("hnsw_cosine")
    HNSW_COSINE("hnsw_cosine"),
    @SerializedName("object")
    OBJECT("object"),
    @SerializedName("key")
    KEY("key"),
    @SerializedName("unique")
    UNIQUE("unique");

    override fun toString() = value
}