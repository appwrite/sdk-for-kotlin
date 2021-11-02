package io.appwrite.models

/// Locale
data class Locale(
    val ip: String,
    val countryCode: String,
    val country: String,
    val continentCode: String,
    val continent: String,
    val eu: Boolean,
    val currency: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Locale(
            ip = map["ip"] as String,
            countryCode = map["countryCode"] as String,
            country = map["country"] as String,
            continentCode = map["continentCode"] as String,
            continent = map["continent"] as String,
            eu = map["eu"] as Boolean,
            currency = map["currency"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "ip" to ip as Any,
        "countryCode" to countryCode as Any,
        "country" to country as Any,
        "continentCode" to continentCode as Any,
        "continent" to continent as Any,
        "eu" to eu as Any,
        "currency" to currency as Any
    )
}