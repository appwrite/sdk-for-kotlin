package io.appwrite.models

/// Session
data class Session(
    val id: String,
    val userId: String,
    val expire: Long,
    val provider: String,
    val providerUid: String,
    val providerToken: String,
    val ip: String,
    val osCode: String,
    val osName: String,
    val osVersion: String,
    val clientType: String,
    val clientCode: String,
    val clientName: String,
    val clientVersion: String,
    val clientEngine: String,
    val clientEngineVersion: String,
    val deviceName: String,
    val deviceBrand: String,
    val deviceModel: String,
    val countryCode: String,
    val countryName: String,
    val current: Boolean
) {
    companion object {
        fun from(map: Map<String, Any>) = Session(
            id = map["\$id"] as String,
            userId = map["userId"] as String,
            expire = map["expire"] as Long,
            provider = map["provider"] as String,
            providerUid = map["providerUid"] as String,
            providerToken = map["providerToken"] as String,
            ip = map["ip"] as String,
            osCode = map["osCode"] as String,
            osName = map["osName"] as String,
            osVersion = map["osVersion"] as String,
            clientType = map["clientType"] as String,
            clientCode = map["clientCode"] as String,
            clientName = map["clientName"] as String,
            clientVersion = map["clientVersion"] as String,
            clientEngine = map["clientEngine"] as String,
            clientEngineVersion = map["clientEngineVersion"] as String,
            deviceName = map["deviceName"] as String,
            deviceBrand = map["deviceBrand"] as String,
            deviceModel = map["deviceModel"] as String,
            countryCode = map["countryCode"] as String,
            countryName = map["countryName"] as String,
            current = map["current"] as Boolean
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerToken" to providerToken as Any,
        "ip" to ip as Any,
        "osCode" to osCode as Any,
        "osName" to osName as Any,
        "osVersion" to osVersion as Any,
        "clientType" to clientType as Any,
        "clientCode" to clientCode as Any,
        "clientName" to clientName as Any,
        "clientVersion" to clientVersion as Any,
        "clientEngine" to clientEngine as Any,
        "clientEngineVersion" to clientEngineVersion as Any,
        "deviceName" to deviceName as Any,
        "deviceBrand" to deviceBrand as Any,
        "deviceModel" to deviceModel as Any,
        "countryCode" to countryCode as Any,
        "countryName" to countryName as Any,
        "current" to current as Any
    )
}