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
     * How many days to keep the non-active deployments before they will be automatically deleted.
     */
    @SerializedName("deploymentRetention")
    val deploymentRetention: Long,

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
     * Minutes between scheduled executions. 0 when the function has no interval.
     */
    @SerializedName("interval")
    var interval: Long?,

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
     * List of branch name patterns that trigger automatic deployments. Supports glob wildcards. Empty list deploys on all branches.
     */
    @SerializedName("providerBranches")
    val providerBranches: List<String>,

    /**
     * List of file path patterns that trigger automatic deployments. Supports glob wildcards. Empty list deploys on all file changes.
     */
    @SerializedName("providerPaths")
    val providerPaths: List<String>,

    /**
     * Machine specification for deployment builds.
     */
    @SerializedName("buildSpecification")
    val buildSpecification: String,

    /**
     * Machine specification for executions.
     */
    @SerializedName("runtimeSpecification")
    val runtimeSpecification: String,

    /**
     * Whether inbound email (SMTP) may trigger this function. Opt-in; default is false. When disabled, recipients for this function are rejected.
     */
    @SerializedName("emailEnabled")
    var emailEnabled: Boolean?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "execute" to execute as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "live" to live as Any,
        "logging" to logging as Any,
        "runtime" to runtime as Any,
        "deploymentRetention" to deploymentRetention as Any,
        "deploymentId" to deploymentId as Any,
        "deploymentCreatedAt" to deploymentCreatedAt as Any,
        "latestDeploymentId" to latestDeploymentId as Any,
        "latestDeploymentCreatedAt" to latestDeploymentCreatedAt as Any,
        "latestDeploymentStatus" to latestDeploymentStatus as Any,
        "scopes" to scopes as Any,
        "vars" to vars.map { it.toMap() } as Any,
        "events" to events as Any,
        "schedule" to schedule as Any,
        "interval" to interval as Any?,
        "timeout" to timeout as Any,
        "entrypoint" to entrypoint as Any,
        "commands" to commands as Any,
        "version" to version as Any,
        "installationId" to installationId as Any,
        "providerRepositoryId" to providerRepositoryId as Any,
        "providerBranch" to providerBranch as Any,
        "providerRootDirectory" to providerRootDirectory as Any,
        "providerSilentMode" to providerSilentMode as Any,
        "providerBranches" to providerBranches as Any,
        "providerPaths" to providerPaths as Any,
        "buildSpecification" to buildSpecification as Any,
        "runtimeSpecification" to runtimeSpecification as Any,
        "emailEnabled" to emailEnabled as Any?,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Function(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            execute = (if (map.containsKey("execute")) map["execute"] else listOf<Any?>()) as List<String>,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            live = (if (map.containsKey("live")) map["live"] else true) as Boolean,
            logging = (if (map.containsKey("logging")) map["logging"] else true) as Boolean,
            runtime = (if (map.containsKey("runtime")) map["runtime"] else "") as String,
            deploymentRetention = ((if (map.containsKey("deploymentRetention")) map["deploymentRetention"] else 0) as Number).toLong(),
            deploymentId = (if (map.containsKey("deploymentId")) map["deploymentId"] else "") as String,
            deploymentCreatedAt = (if (map.containsKey("deploymentCreatedAt")) map["deploymentCreatedAt"] else "") as String,
            latestDeploymentId = (if (map.containsKey("latestDeploymentId")) map["latestDeploymentId"] else "") as String,
            latestDeploymentCreatedAt = (if (map.containsKey("latestDeploymentCreatedAt")) map["latestDeploymentCreatedAt"] else "") as String,
            latestDeploymentStatus = (if (map.containsKey("latestDeploymentStatus")) map["latestDeploymentStatus"] else "") as String,
            scopes = (if (map.containsKey("scopes")) map["scopes"] else listOf<Any?>()) as List<String>,
            vars = ((if (map.containsKey("vars")) map["vars"] else listOf<Any?>()) as List<Map<String, Any>>).map { Variable.from(map = it) },
            events = (if (map.containsKey("events")) map["events"] else listOf<Any?>()) as List<String>,
            schedule = (if (map.containsKey("schedule")) map["schedule"] else "") as String,
            interval = (map["interval"] as? Number)?.toLong(),
            timeout = ((if (map.containsKey("timeout")) map["timeout"] else 15) as Number).toLong(),
            entrypoint = (if (map.containsKey("entrypoint")) map["entrypoint"] else "") as String,
            commands = (if (map.containsKey("commands")) map["commands"] else "") as String,
            version = (if (map.containsKey("version")) map["version"] else "v5") as String,
            installationId = (if (map.containsKey("installationId")) map["installationId"] else "") as String,
            providerRepositoryId = (if (map.containsKey("providerRepositoryId")) map["providerRepositoryId"] else "") as String,
            providerBranch = (if (map.containsKey("providerBranch")) map["providerBranch"] else "") as String,
            providerRootDirectory = (if (map.containsKey("providerRootDirectory")) map["providerRootDirectory"] else "") as String,
            providerSilentMode = (if (map.containsKey("providerSilentMode")) map["providerSilentMode"] else false) as Boolean,
            providerBranches = (if (map.containsKey("providerBranches")) map["providerBranches"] else listOf<Any?>()) as List<String>,
            providerPaths = (if (map.containsKey("providerPaths")) map["providerPaths"] else listOf<Any?>()) as List<String>,
            buildSpecification = (if (map.containsKey("buildSpecification")) map["buildSpecification"] else "s-1vcpu-512mb") as String,
            runtimeSpecification = (if (map.containsKey("runtimeSpecification")) map["runtimeSpecification"] else "s-1vcpu-512mb") as String,
            emailEnabled = map["emailEnabled"] as? Boolean,
        )
    }
}
