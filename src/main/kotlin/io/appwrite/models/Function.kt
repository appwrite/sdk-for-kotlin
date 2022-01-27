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
     * Execution permissions.
     *
     */
    @SerializedName("execute")
    val execute: String,

    /**
     * Function name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Function creation date in Unix timestamp.
     *
     */
    @SerializedName("dateCreated")
    val dateCreated: Long,

    /**
     * Function update date in Unix timestamp.
     *
     */
    @SerializedName("dateUpdated")
    val dateUpdated: Long,

    /**
     * Function status. Possible values: `disabled`, `enabled`
     *
     */
    @SerializedName("status")
    val status: String,

    /**
     * Function execution runtime.
     *
     */
    @SerializedName("runtime")
    val runtime: String,

    /**
     * Function active tag ID.
     *
     */
    @SerializedName("tag")
    val tag: String,

    /**
     * Function environment variables.
     *
     */
    @SerializedName("vars")
    val vars: String,

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
     * Function next scheduled execution date in Unix timestamp.
     *
     */
    @SerializedName("scheduleNext")
    val scheduleNext: Long,

    /**
     * Function next scheduled execution date in Unix timestamp.
     *
     */
    @SerializedName("schedulePrevious")
    val schedulePrevious: Long,

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
            execute = map["execute"] as String,
            name = map["name"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
            dateUpdated = (map["dateUpdated"] as Number).toLong(),
            status = map["status"] as String,
            runtime = map["runtime"] as String,
            tag = map["tag"] as String,
            vars = map["vars"] as String,
            events = map["events"] as List<Any>,
            schedule = map["schedule"] as String,
            scheduleNext = (map["scheduleNext"] as Number).toLong(),
            schedulePrevious = (map["schedulePrevious"] as Number).toLong(),
            timeout = (map["timeout"] as Number).toLong()
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "execute" to execute as Any,
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