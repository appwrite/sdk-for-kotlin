package io.appwrite.models

/// Currencies List
data class CurrencyList(
    val sum: Long,
    val currencies: List<Currency>
) {
    companion object {
        fun from(map: Map<String, Any>) = CurrencyList(
            sum = map["sum"] as Long,
            currencies = (map["currencies"] as List<Map<String, Any>>).map { Currency.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "sum" to sum as Any,
        "currencies" to currencies.map { it.toMap() } as Any
    )
}