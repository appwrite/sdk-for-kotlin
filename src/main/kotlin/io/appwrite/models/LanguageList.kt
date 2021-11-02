package io.appwrite.models

/// Languages List
data class LanguageList(
    val sum: Long,
    val languages: List<Language>
) {
    companion object {
        fun from(map: Map<String, Any>) = LanguageList(
            sum = map["sum"] as Long,
            languages = (map["languages"] as List<Map<String, Any>>).map { Language.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "languages" to languages.map { it.toMap() } as Any
    )
}