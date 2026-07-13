package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AdditionalResource
 */
data class AdditionalResource(
    /**
     * Resource name
     */
    @SerializedName("name")
    val name: String,

    /**
     * Resource unit
     */
    @SerializedName("unit")
    val unit: String,

    /**
     * Price currency
     */
    @SerializedName("currency")
    val currency: String,

    /**
     * Price
     */
    @SerializedName("price")
    val price: Double,

    /**
     * Resource value
     */
    @SerializedName("value")
    val value: Long,

    /**
     * Description on invoice
     */
    @SerializedName("invoiceDesc")
    val invoiceDesc: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "name" to name as Any,
        "unit" to unit as Any,
        "currency" to currency as Any,
        "price" to price as Any,
        "value" to value as Any,
        "invoiceDesc" to invoiceDesc as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AdditionalResource(
            name = map["name"] as String,
            unit = map["unit"] as String,
            currency = map["currency"] as String,
            price = (map["price"] as Number).toDouble(),
            value = (map["value"] as Number).toLong(),
            invoiceDesc = map["invoiceDesc"] as String,
        )
    }
}
