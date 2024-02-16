package io.appwrite.enums

enum class MessagingProviderType(val value: String) {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    override fun toString() = value
}