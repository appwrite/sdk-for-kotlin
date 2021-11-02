package io.appwrite.models

/// Execution
data class Execution(
    val id: String,
    val permissions: Permissions,
    val functionId: String,
    val dateCreated: Long,
    val trigger: String,
    val status: String,
    val exitCode: Long,
    val stdout: String,
    val stderr: String,
    val time: Double
) {
    companion object {
        fun from(map: Map<String, Any>) = Execution(
            id = map["\$id"] as String,
            permissions = Permissions.from(map = map["\$permissions"] as Map<String, Any>),
            functionId = map["functionId"] as String,
            dateCreated = map["dateCreated"] as Long,
            trigger = map["trigger"] as String,
            status = map["status"] as String,
            exitCode = map["exitCode"] as Long,
            stdout = map["stdout"] as String,
            stderr = map["stderr"] as String,
            time = map["time"] as Double
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$permissions" to permissions.toMap() as Any,
        "functionId" to functionId as Any,
        "dateCreated" to dateCreated as Any,
        "trigger" to trigger as Any,
        "status" to status as Any,
        "exitCode" to exitCode as Any,
        "stdout" to stdout as Any,
        "stderr" to stderr as Any,
        "time" to time as Any
    )
}