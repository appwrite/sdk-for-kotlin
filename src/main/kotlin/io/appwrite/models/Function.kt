package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Function
 */
data class Function(
    /**
     * Function ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Function creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Function update date in ISO 8601 format.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution permissions.
     *
     */
    @SerializedName("execute")
    val execute: List<Any>,

    /**
     * Function name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Function enabled.
     *
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Function execution runtime.
     *
     */
    @SerializedName("runtime")
    val runtime: String,

    /**
     * Function&#039;s active deployment ID.
     *
     */
    @SerializedName("deployment")
    val deployment: String,

    /**
     * Function variables.
     *
     */
    @SerializedName("vars")
    val vars: List<Variable>,

    /**
     * Function trigger events.
     *
     */
    @SerializedName("events")
    val events: List<Any>,

    /**
     * Function execution schedult in CRON format.
     *
     */
    @SerializedName("schedule")
    val schedule: String,

    /**
     * Function&#039;s next scheduled execution time in ISO 8601 format.
     *
     */
    @SerializedName("scheduleNext")
    val scheduleNext: String,

    /**
     * Function&#039;s previous scheduled execution time in ISO 8601 format.
     *
     */
    @SerializedName("schedulePrevious")
    val schedulePrevious: String,

    /**
     * Function execution timeout in seconds.
     *
     */
    @SerializedName("timeout")
    val timeout: Long
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Function(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            execute = map["execute"] as List<Any>,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            runtime = map["runtime"] as String,
            deployment = map["deployment"] as String,
            vars = (map["vars"] as List<Map<String, Any>>).map { Variable.from(map = it) },
            events = map["events"] as List<Any>,
            schedule = map["schedule"] as String,
            scheduleNext = map["scheduleNext"] as String,
            schedulePrevious = map["schedulePrevious"] as String,
            timeout = (map["timeout"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "execute" to execute as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "runtime" to runtime as Any,
        "deployment" to deployment as Any,
        "vars" to vars.map { it.toMap() } as Any,
        "events" to events as Any,
        "schedule" to schedule as Any,
        "scheduleNext" to scheduleNext as Any,
        "schedulePrevious" to schedulePrevious as Any,
        "timeout" to timeout as Any
    )
}
