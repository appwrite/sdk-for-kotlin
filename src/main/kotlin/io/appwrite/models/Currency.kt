package io.appwrite.models

/// Currency
data class Currency(
    val symbol: String,
    val name: String,
    val symbolNative: String,
    val decimalDigits: Long,
    val rounding: Double,
    val code: String,
    val namePlural: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Currency(
            symbol = map["symbol"] as String,
            name = map["name"] as String,
            symbolNative = map["symbolNative"] as String,
            decimalDigits = map["decimalDigits"] as Long,
            rounding = map["rounding"] as Double,
            code = map["code"] as String,
            namePlural = map["namePlural"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "symbol" to symbol as Any,
        "name" to name as Any,
        "symbolNative" to symbolNative as Any,
        "decimalDigits" to decimalDigits as Any,
        "rounding" to rounding as Any,
        "code" to code as Any,
        "namePlural" to namePlural as Any
    )
}