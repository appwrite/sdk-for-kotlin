package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Site
 */
data class Site(
    /**
     * Site ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Site creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Site update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Site name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Site enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Is the site deployed with the latest configuration? This is set to false if you've changed an environment variables, entrypoint, commands, or other settings that needs redeploy to be applied. When the value is false, redeploy the site to update it with the latest configuration.
     */
    @SerializedName("live")
    val live: Boolean,

    /**
     * When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     */
    @SerializedName("logging")
    val logging: Boolean,

    /**
     * Site framework.
     */
    @SerializedName("framework")
    val framework: String,

    /**
     * How many days to keep the non-active deployments before they will be automatically deleted.
     */
    @SerializedName("deploymentRetention")
    val deploymentRetention: Long,

    /**
     * Site's active deployment ID.
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * Active deployment creation date in ISO 8601 format.
     */
    @SerializedName("deploymentCreatedAt")
    val deploymentCreatedAt: String,

    /**
     * Screenshot of active deployment with light theme preference file ID.
     */
    @SerializedName("deploymentScreenshotLight")
    val deploymentScreenshotLight: String,

    /**
     * Screenshot of active deployment with dark theme preference file ID.
     */
    @SerializedName("deploymentScreenshotDark")
    val deploymentScreenshotDark: String,

    /**
     * Site's latest deployment ID.
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
     * Site variables.
     */
    @SerializedName("vars")
    val vars: List<Variable>,

    /**
     * Site request timeout in seconds.
     */
    @SerializedName("timeout")
    val timeout: Long,

    /**
     * The install command used to install the site dependencies.
     */
    @SerializedName("installCommand")
    val installCommand: String,

    /**
     * The build command used to build the site.
     */
    @SerializedName("buildCommand")
    val buildCommand: String,

    /**
     * Custom command to use when starting site runtime.
     */
    @SerializedName("startCommand")
    val startCommand: String,

    /**
     * The directory where the site build output is located.
     */
    @SerializedName("outputDirectory")
    val outputDirectory: String,

    /**
     * Site VCS (Version Control System) installation id.
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
     * Path to site in VCS (Version Control System) repository
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
     * Machine specification for SSR executions.
     */
    @SerializedName("runtimeSpecification")
    val runtimeSpecification: String,

    /**
     * Site build runtime.
     */
    @SerializedName("buildRuntime")
    val buildRuntime: String,

    /**
     * Site framework adapter.
     */
    @SerializedName("adapter")
    val adapter: String,

    /**
     * Name of fallback file to use instead of 404 page. If null, Appwrite 404 page will be displayed.
     */
    @SerializedName("fallbackFile")
    val fallbackFile: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "live" to live as Any,
        "logging" to logging as Any,
        "framework" to framework as Any,
        "deploymentRetention" to deploymentRetention as Any,
        "deploymentId" to deploymentId as Any,
        "deploymentCreatedAt" to deploymentCreatedAt as Any,
        "deploymentScreenshotLight" to deploymentScreenshotLight as Any,
        "deploymentScreenshotDark" to deploymentScreenshotDark as Any,
        "latestDeploymentId" to latestDeploymentId as Any,
        "latestDeploymentCreatedAt" to latestDeploymentCreatedAt as Any,
        "latestDeploymentStatus" to latestDeploymentStatus as Any,
        "scopes" to scopes as Any,
        "vars" to vars.map { it.toMap() } as Any,
        "timeout" to timeout as Any,
        "installCommand" to installCommand as Any,
        "buildCommand" to buildCommand as Any,
        "startCommand" to startCommand as Any,
        "outputDirectory" to outputDirectory as Any,
        "installationId" to installationId as Any,
        "providerRepositoryId" to providerRepositoryId as Any,
        "providerBranch" to providerBranch as Any,
        "providerRootDirectory" to providerRootDirectory as Any,
        "providerSilentMode" to providerSilentMode as Any,
        "providerBranches" to providerBranches as Any,
        "providerPaths" to providerPaths as Any,
        "buildSpecification" to buildSpecification as Any,
        "runtimeSpecification" to runtimeSpecification as Any,
        "buildRuntime" to buildRuntime as Any,
        "adapter" to adapter as Any,
        "fallbackFile" to fallbackFile as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Site(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            live = (if (map.containsKey("live")) map["live"] else true) as Boolean,
            logging = (if (map.containsKey("logging")) map["logging"] else true) as Boolean,
            framework = (if (map.containsKey("framework")) map["framework"] else "") as String,
            deploymentRetention = ((if (map.containsKey("deploymentRetention")) map["deploymentRetention"] else 0) as Number).toLong(),
            deploymentId = (if (map.containsKey("deploymentId")) map["deploymentId"] else "") as String,
            deploymentCreatedAt = (if (map.containsKey("deploymentCreatedAt")) map["deploymentCreatedAt"] else "") as String,
            deploymentScreenshotLight = (if (map.containsKey("deploymentScreenshotLight")) map["deploymentScreenshotLight"] else "") as String,
            deploymentScreenshotDark = (if (map.containsKey("deploymentScreenshotDark")) map["deploymentScreenshotDark"] else "") as String,
            latestDeploymentId = (if (map.containsKey("latestDeploymentId")) map["latestDeploymentId"] else "") as String,
            latestDeploymentCreatedAt = (if (map.containsKey("latestDeploymentCreatedAt")) map["latestDeploymentCreatedAt"] else "") as String,
            latestDeploymentStatus = (if (map.containsKey("latestDeploymentStatus")) map["latestDeploymentStatus"] else "") as String,
            scopes = (if (map.containsKey("scopes")) map["scopes"] else listOf<Any?>()) as List<String>,
            vars = ((if (map.containsKey("vars")) map["vars"] else listOf<Any?>()) as List<Map<String, Any>>).map { Variable.from(map = it) },
            timeout = ((if (map.containsKey("timeout")) map["timeout"] else 15) as Number).toLong(),
            installCommand = (if (map.containsKey("installCommand")) map["installCommand"] else "") as String,
            buildCommand = (if (map.containsKey("buildCommand")) map["buildCommand"] else "") as String,
            startCommand = (if (map.containsKey("startCommand")) map["startCommand"] else "") as String,
            outputDirectory = (if (map.containsKey("outputDirectory")) map["outputDirectory"] else "") as String,
            installationId = (if (map.containsKey("installationId")) map["installationId"] else "") as String,
            providerRepositoryId = (if (map.containsKey("providerRepositoryId")) map["providerRepositoryId"] else "") as String,
            providerBranch = (if (map.containsKey("providerBranch")) map["providerBranch"] else "") as String,
            providerRootDirectory = (if (map.containsKey("providerRootDirectory")) map["providerRootDirectory"] else "") as String,
            providerSilentMode = (if (map.containsKey("providerSilentMode")) map["providerSilentMode"] else false) as Boolean,
            providerBranches = (if (map.containsKey("providerBranches")) map["providerBranches"] else listOf<Any?>()) as List<String>,
            providerPaths = (if (map.containsKey("providerPaths")) map["providerPaths"] else listOf<Any?>()) as List<String>,
            buildSpecification = (if (map.containsKey("buildSpecification")) map["buildSpecification"] else "s-1vcpu-512mb") as String,
            runtimeSpecification = (if (map.containsKey("runtimeSpecification")) map["runtimeSpecification"] else "s-1vcpu-512mb") as String,
            buildRuntime = (if (map.containsKey("buildRuntime")) map["buildRuntime"] else "") as String,
            adapter = map["adapter"] as String,
            fallbackFile = map["fallbackFile"] as String,
        )
    }
}
