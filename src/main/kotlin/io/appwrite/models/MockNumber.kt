package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Mock Number
 */
data class MockNumber(
    /**
     * Mock phone number for testing phone authentication. Useful for testing phone authentication without sending an SMS.
     */
    @SerializedName("number")
    val number: String,

    /**
     * Mock OTP for the number. 
     */
    @SerializedName("otp")
    val otp: String,

    /**
     * Attribute creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Attribute update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "number" to number as Any,
        "otp" to otp as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MockNumber(
            number = map["number"] as String,
            otp = map["otp"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
        )
    }
}
