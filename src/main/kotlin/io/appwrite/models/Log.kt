package io.appwrite.models

/// Log
data class Log(
    val event: String,
    val ip: String,
    val time: Long,
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
    val countryName: String
) {
    companion object {
        fun from(map: Map<String, Any>) = Log(
            event = map["event"] as String,
            ip = map["ip"] as String,
            time = map["time"] as Long,
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
            countryName = map["countryName"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "event" to event as Any,
        "ip" to ip as Any,
        "time" to time as Any,
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
        "countryName" to countryName as Any
    )
}