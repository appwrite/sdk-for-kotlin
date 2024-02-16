package io.appwrite.enums

enum class RelationshipType(val value: String) {
    ONE_TO_ONE("oneToOne"),
    MANY_TO_ONE("manyToOne"),
    MANY_TO_MANY("manyToMany"),
    ONE_TO_MANY("oneToMany");

    override fun toString() = value
}