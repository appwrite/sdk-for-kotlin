package io.appwrite.models

/// Token
data class Token(
    val id: String,
    val userId: String,
    val secret: String,
    val expire: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = Token(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            secret = map["secret"] as String,
            expire = map["expire"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "secret" to secret as Any,
        "expire" to expire as Any
    )
}