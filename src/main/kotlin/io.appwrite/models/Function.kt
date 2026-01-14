package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Function
 */
data class Function(
    /**
     * Function ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Function creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Function update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution permissions.
     */
    @SerializedName("execute")
    val execute: List<String>,

    /**
     * Function name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Function enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Is the function deployed with the latest configuration? This is set to false if you've changed an environment variables, entrypoint, commands, or other settings that needs redeploy to be applied. When the value is false, redeploy the function to update it with the latest configuration.
     */
    @SerializedName("live")
    val live: Boolean,

    /**
     * When disabled, executions will exclude logs and errors, and will be slightly faster.
     */
    @SerializedName("logging")
    val logging: Boolean,

    /**
     * Function execution and build runtime.
     */
    @SerializedName("runtime")
    val runtime: String,

    /**
     * Function's active deployment ID.
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * Active deployment creation date in ISO 8601 format.
     */
    @SerializedName("deploymentCreatedAt")
    val deploymentCreatedAt: String,

    /**
     * Function's latest deployment ID.
     */
    @SerializedName("latestDeploymentId")
    val latestDeploymentId: String,

    /**
     * Latest deployment creation date in ISO 8601 format.
     */
    @SerializedName("latestDeploymentCreatedAt")
    val latestDeploymentCreatedAt: String,

    /**
     * Status of latest deployment. Possible values are "waiting", "processing", "building", "ready", and "failed".
     */
    @SerializedName("latestDeploymentStatus")
    val latestDeploymentStatus: String,

    /**
     * Allowed permission scopes.
     */
    @SerializedName("scopes")
    val scopes: List<String>,

    /**
     * Function variables.
     */
    @SerializedName("vars")
    val vars: List<Variable>,

    /**
     * Function trigger events.
     */
    @SerializedName("events")
    val events: List<String>,

    /**
     * Function execution schedule in CRON format.
     */
    @SerializedName("schedule")
    val schedule: String,

    /**
     * Function execution timeout in seconds.
     */
    @SerializedName("timeout")
    val timeout: Long,

    /**
     * The entrypoint file used to execute the deployment.
     */
    @SerializedName("entrypoint")
    val entrypoint: String,

    /**
     * The build command used to build the deployment.
     */
    @SerializedName("commands")
    val commands: String,

    /**
     * Version of Open Runtimes used for the function.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Function VCS (Version Control System) installation id.
     */
    @SerializedName("installationId")
    val installationId: String,

    /**
     * VCS (Version Control System) Repository ID
     */
    @SerializedName("providerRepositoryId")
    val providerRepositoryId: String,

    /**
     * VCS (Version Control System) branch name
     */
    @SerializedName("providerBranch")
    val providerBranch: String,

    /**
     * Path to function in VCS (Version Control System) repository
     */
    @SerializedName("providerRootDirectory")
    val providerRootDirectory: String,

    /**
     * Is VCS (Version Control System) connection is in silent mode? When in silence mode, no comments will be posted on the repository pull or merge requests
     */
    @SerializedName("providerSilentMode")
    val providerSilentMode: Boolean,

    /**
     * Machine specification for builds and executions.
     */
    @SerializedName("specification")
    val specification: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "execute" to execute as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "live" to live as Any,
        "logging" to logging as Any,
        "runtime" to runtime as Any,
        "deploymentId" to deploymentId as Any,
        "deploymentCreatedAt" to deploymentCreatedAt as Any,
        "latestDeploymentId" to latestDeploymentId as Any,
        "latestDeploymentCreatedAt" to latestDeploymentCreatedAt as Any,
        "latestDeploymentStatus" to latestDeploymentStatus as Any,
        "scopes" to scopes as Any,
        "vars" to vars.map { it.toMap() } as Any,
        "events" to events as Any,
        "schedule" to schedule as Any,
        "timeout" to timeout as Any,
        "entrypoint" to entrypoint as Any,
        "commands" to commands as Any,
        "version" to version as Any,
        "installationId" to installationId as Any,
        "providerRepositoryId" to providerRepositoryId as Any,
        "providerBranch" to providerBranch as Any,
        "providerRootDirectory" to providerRootDirectory as Any,
        "providerSilentMode" to providerSilentMode as Any,
        "specification" to specification as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Function(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            execute = map["execute"] as List<String>,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            live = map["live"] as Boolean,
            logging = map["logging"] as Boolean,
            runtime = map["runtime"] as String,
            deploymentId = map["deploymentId"] as String,
            deploymentCreatedAt = map["deploymentCreatedAt"] as String,
            latestDeploymentId = map["latestDeploymentId"] as String,
            latestDeploymentCreatedAt = map["latestDeploymentCreatedAt"] as String,
            latestDeploymentStatus = map["latestDeploymentStatus"] as String,
            scopes = map["scopes"] as List<String>,
            vars = (map["vars"] as List<Map<String, Any>>).map { Variable.from(map = it) },
            events = map["events"] as List<String>,
            schedule = map["schedule"] as String,
            timeout = (map["timeout"] as Number).toLong(),
            entrypoint = map["entrypoint"] as String,
            commands = map["commands"] as String,
            version = map["version"] as String,
            installationId = map["installationId"] as String,
            providerRepositoryId = map["providerRepositoryId"] as String,
            providerBranch = map["providerBranch"] as String,
            providerRootDirectory = map["providerRootDirectory"] as String,
            providerSilentMode = map["providerSilentMode"] as Boolean,
            specification = map["specification"] as String,
        )
    }
}