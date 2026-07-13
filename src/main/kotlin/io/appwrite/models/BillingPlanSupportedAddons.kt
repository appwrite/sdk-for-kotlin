package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BillingPlanSupportedAddons
 */
data class BillingPlanSupportedAddons(
    /**
     * Whether the plan supports BAA (Business Associate Agreement) addon
     */
    @SerializedName("baa")
    val baa: Boolean,

    /**
     * Whether the plan supports Premium Geo DB addon (project-level)
     */
    @SerializedName("premiumGeoDB")
    val premiumGeoDB: Boolean,

    /**
     * Whether the plan supports Premium Geo DB addon (organization-level)
     */
    @SerializedName("premiumGeoDBOrg")
    val premiumGeoDBOrg: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "baa" to baa as Any,
        "premiumGeoDB" to premiumGeoDB as Any,
        "premiumGeoDBOrg" to premiumGeoDBOrg as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlanSupportedAddons(
            baa = map["baa"] as Boolean,
            premiumGeoDB = map["premiumGeoDB"] as Boolean,
            premiumGeoDBOrg = map["premiumGeoDBOrg"] as Boolean,
        )
    }
}
