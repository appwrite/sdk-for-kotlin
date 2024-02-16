package io.appwrite.enums

enum class MessageStatus(val value: String) {
    DRAFT("draft"),
    SCHEDULED("scheduled"),
    PROCESSING("processing");

    override fun toString() = value
}