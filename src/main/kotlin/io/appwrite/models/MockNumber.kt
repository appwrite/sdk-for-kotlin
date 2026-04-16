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
    @SerializedName("phone")
    val phone: String,

    /**
     * Mock OTP for the number. 
     */
    @SerializedName("otp")
    val otp: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "phone" to phone as Any,
        "otp" to otp as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MockNumber(
            phone = map["phone"] as String,
            otp = map["otp"] as String,
        )
    }
}