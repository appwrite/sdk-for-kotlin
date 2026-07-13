package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Addon
 */
data class BillingPlanAddon(
    /**
     * Addon seats
     */
    @SerializedName("seats")
    val seats: BillingPlanAddonDetails,

    /**
     * Addon projects
     */
    @SerializedName("projects")
    val projects: BillingPlanAddonDetails,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "seats" to seats.toMap() as Any,
        "projects" to projects.toMap() as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = BillingPlanAddon(
            seats = BillingPlanAddonDetails.from(map = map["seats"] as Map<String, Any>),
            projects = BillingPlanAddonDetails.from(map = map["projects"] as Map<String, Any>),
        )
    }
}