package io.appwrite.models

/// User
data class User(
    val id: String,
    val name: String,
    val registration: Long,
    val status: Boolean,
    val passwordUpdate: Long,
    val email: String,
    val emailVerification: Boolean,
    val prefs: Preferences
) {
    companion object {
        fun from(map: Map<String, Any>) = User(
            id = map["\$id"] as String,
            name = map["name"] as String,
            registration = map["registration"] as Long,
            status = map["status"] as Boolean,
            passwordUpdate = map["passwordUpdate"] as Long,
            email = map["email"] as String,
            emailVerification = map["emailVerification"] as Boolean,
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>)
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "registration" to registration as Any,
        "status" to status as Any,
        "passwordUpdate" to passwordUpdate as Any,
        "email" to email as Any,
        "emailVerification" to emailVerification as Any,
        "prefs" to prefs.toMap() as Any
    )
}