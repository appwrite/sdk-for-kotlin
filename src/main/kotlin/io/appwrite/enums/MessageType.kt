package io.appwrite.enums

enum class MessageType(val value: String) {
    DRAFT("draft"),
    CANCELLED("cancelled"),
    PROCESSING("processing");

    override fun toString() = value
}