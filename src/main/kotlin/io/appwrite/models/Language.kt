package io.appwrite.models

/// Language
data class Language(
    val name: String,
    val code: String,
    val nativeName: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Language(
            name = map["name"] as String,
            code = map["code"] as String,
            nativeName = map["nativeName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
        "nativeName" to nativeName as Any
    )
}