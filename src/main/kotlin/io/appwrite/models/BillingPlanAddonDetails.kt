package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Details
 */
data class BillingPlanAddonDetails(
    /**
     * Is the addon supported in the plan?
     */
    @SerializedName("supported")
    val supported: Boolean,

    /**
     * Addon plan included value
     */
    @SerializedName("planIncluded")
    val planIncluded: Long,

    /**
     * Addon limit
     */
    @SerializedName("limit")
    val limit: Long,

    /**
     * Addon type
     */
    @SerializedName("type")
    val type: String,

    /**
     * Price currency
     */
    @SerializedName("currency")
    var currency: String?,

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
        "supported" to supported as Any,
        "planIncluded" to planIncluded as Any,
        "limit" to limit as Any,
        "type" to type as Any,
        "currency" to currency as Any?,
        "price" to price as Any,
        "value" to value as Any,
        "invoiceDesc" to invoiceDesc as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlanAddonDetails(
            supported = (if (map.containsKey("supported")) map["supported"] else false) as Boolean,
            planIncluded = ((if (map.containsKey("planIncluded")) map["planIncluded"] else 0) as Number).toLong(),
            limit = ((if (map.containsKey("limit")) map["limit"] else 0) as Number).toLong(),
            type = (if (map.containsKey("type")) map["type"] else "numeric") as String,
            currency = map["currency"] as? String,
            price = ((if (map.containsKey("price")) map["price"] else 0.0) as Number).toDouble(),
            value = ((if (map.containsKey("value")) map["value"] else 0) as Number).toLong(),
            invoiceDesc = (if (map.containsKey("invoiceDesc")) map["invoiceDesc"] else "") as String,
        )
    }
}
