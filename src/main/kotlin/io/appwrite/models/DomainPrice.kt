package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * DomainPrice
 */
data class DomainPrice(
    /**
     * Domain name.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Top-level domain for the requested domain.
     */
    @SerializedName("tld")
    val tld: String,

    /**
     * Whether the domain is currently available for registration.
     */
    @SerializedName("available")
    val available: Boolean,

    /**
     * Domain registration price. Null when the price could not be resolved, for example for an unsupported TLD.
     */
    @SerializedName("price")
    var price: Double?,

    /**
     * Price period in years.
     */
    @SerializedName("periodYears")
    val periodYears: Long,

    /**
     * Whether the domain is a premium domain.
     */
    @SerializedName("premium")
    val premium: Boolean,

    /**
     * Domain renewal price for the same period. Null when the domain was not priced or the registrar has no renewal price for it.
     */
    @SerializedName("renewalPrice")
    var renewalPrice: Double?,

    /**
     * Renewal price period in years.
     */
    @SerializedName("renewalPeriodYears")
    val renewalPeriodYears: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "domain" to domain as Any,
        "tld" to tld as Any,
        "available" to available as Any,
        "price" to price as Any?,
        "periodYears" to periodYears as Any,
        "premium" to premium as Any,
        "renewalPrice" to renewalPrice as Any?,
        "renewalPeriodYears" to renewalPeriodYears as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DomainPrice(
            domain = (if (map.containsKey("domain")) map["domain"] else "") as String,
            tld = (if (map.containsKey("tld")) map["tld"] else "") as String,
            available = (if (map.containsKey("available")) map["available"] else false) as Boolean,
            price = (map["price"] as? Number)?.toDouble(),
            periodYears = ((if (map.containsKey("periodYears")) map["periodYears"] else 1) as Number).toLong(),
            premium = (if (map.containsKey("premium")) map["premium"] else false) as Boolean,
            renewalPrice = (map["renewalPrice"] as? Number)?.toDouble(),
            renewalPeriodYears = ((if (map.containsKey("renewalPeriodYears")) map["renewalPeriodYears"] else 1) as Number).toLong(),
        )
    }
}
