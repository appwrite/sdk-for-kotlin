package io.appwrite.models

/// Country
data class Country(
    val name: String,
    val code: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Country(
            name = map["name"] as String,
            code = map["code"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any
    )
}