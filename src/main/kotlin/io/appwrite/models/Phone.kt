package io.appwrite.models

/// Phone
data class Phone(
    val code: String,
    val countryCode: String,
    val countryName: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Phone(
            code = map["code"] as String,
            countryCode = map["countryCode"] as String,
            countryName = map["countryName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "code" to code as Any,
        "countryCode" to countryCode as Any,
        "countryName" to countryName as Any
    )
}