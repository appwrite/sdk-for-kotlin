package io.appwrite.models

/// Function
data class Function(
    val id: String,
    val permissions: Permissions,
    val name: String,
    val dateCreated: Long,
    val dateUpdated: Long,
    val status: String,
    val runtime: String,
    val tag: String,
    val vars: String,
    val events: List<Any>,
    val schedule: String,
    val scheduleNext: Long,
    val schedulePrevious: Long,
    val timeout: Long
) {
    companion object {
        fun from(map: Map<String, Any>) = Function(
            id = map["\$id"] as String,
            permissions = Permissions.from(map = map["\$permissions"] as Map<String, Any>),
            name = map["name"] as String,
            dateCreated = map["dateCreated"] as Long,
            dateUpdated = map["dateUpdated"] as Long,
            status = map["status"] as String,
            runtime = map["runtime"] as String,
            tag = map["tag"] as String,
            vars = map["vars"] as String,
            events = map["events"] as List<Any>,
            schedule = map["schedule"] as String,
            scheduleNext = map["scheduleNext"] as Long,
            schedulePrevious = map["schedulePrevious"] as Long,
            timeout = map["timeout"] as Long
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$permissions" to permissions.toMap() as Any,
        "name" to name as Any,
        "dateCreated" to dateCreated as Any,
        "dateUpdated" to dateUpdated as Any,
        "status" to status as Any,
        "runtime" to runtime as Any,
        "tag" to tag as Any,
        "vars" to vars as Any,
        "events" to events as Any,
        "schedule" to schedule as Any,
        "scheduleNext" to scheduleNext as Any,
        "schedulePrevious" to schedulePrevious as Any,
        "timeout" to timeout as Any
    )
}