package io.appwrite.enums

enum class IndexType(val value: String) {
    KEY("key"),
    FULLTEXT("fulltext"),
    UNIQUE("unique"),
    SPATIAL("spatial");

    override fun toString() = value
}