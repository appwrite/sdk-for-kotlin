package io.appwrite.enums

enum class RelationMutate(val value: String) {
    CASCADE("cascade"),
    RESTRICT("restrict"),
    SET_NULL("setNull");

    override fun toString() = value
}