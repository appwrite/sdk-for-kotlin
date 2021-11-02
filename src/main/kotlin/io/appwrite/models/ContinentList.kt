package io.appwrite.models

/// Continents List
data class ContinentList(
    val sum: Long,
    val continents: List<Continent>
) {
    companion object {
        fun from(map: Map<String, Any>) = ContinentList(
            sum = map["sum"] as Long,
            continents = (map["continents"] as List<Map<String, Any>>).map { Continent.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "continents" to continents.map { it.toMap() } as Any
    )
}