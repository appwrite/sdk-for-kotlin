package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AlgoScryptModified
 */
data class AlgoScryptModified(
    /**
     * Salt used to compute hash.
     *
     */
    @SerializedName("salt")
    val salt: String,

    /**
     * Separator used to compute hash.
     *
     */
    @SerializedName("saltSeparator")
    val saltSeparator: String,

    /**
     * Key used to compute hash.
     *
     */
    @SerializedName("signerKey")
    val signerKey: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AlgoScryptModified(
            salt = map["salt"] as String,
            saltSeparator = map["saltSeparator"] as String,
            signerKey = map["signerKey"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "salt" to salt as Any,
        "saltSeparator" to saltSeparator as Any,
        "signerKey" to signerKey as Any
    )
}