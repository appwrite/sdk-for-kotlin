package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Health Certificate
 */
data class HealthCertificate(
    /**
     * Certificate name
     */
    @SerializedName("name")
    val name: String,

    /**
     * Subject SN
     */
    @SerializedName("subjectSN")
    val subjectSN: String,

    /**
     * Issuer organisation
     */
    @SerializedName("issuerOrganisation")
    val issuerOrganisation: String,

    /**
     * Valid from
     */
    @SerializedName("validFrom")
    val validFrom: String,

    /**
     * Valid to
     */
    @SerializedName("validTo")
    val validTo: String,

    /**
     * Signature type SN
     */
    @SerializedName("signatureTypeSN")
    val signatureTypeSN: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "subjectSN" to subjectSN as Any,
        "issuerOrganisation" to issuerOrganisation as Any,
        "validFrom" to validFrom as Any,
        "validTo" to validTo as Any,
        "signatureTypeSN" to signatureTypeSN as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = HealthCertificate(
            name = map["name"] as String,
            subjectSN = map["subjectSN"] as String,
            issuerOrganisation = map["issuerOrganisation"] as String,
            validFrom = map["validFrom"] as String,
            validTo = map["validTo"] as String,
            signatureTypeSN = map["signatureTypeSN"] as String,
        )
    }
}