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
            baa = (if (map.containsKey("baa")) map["baa"] else false) as Boolean,
            premiumGeoDB = (if (map.containsKey("premiumGeoDB")) map["premiumGeoDB"] else false) as Boolean,
            premiumGeoDBOrg = (if (map.containsKey("premiumGeoDBOrg")) map["premiumGeoDBOrg"] else false) as Boolean,
        )
    }
}
