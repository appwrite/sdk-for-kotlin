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
     * Is the site deployed with the latest configuration? This is set to false if you&#039;ve changed an environment variables, entrypoint, commands, or other settings that needs redeploy to be applied. When the value is false, redeploy the site to update it with the latest configuration.
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
     * Site&#039;s active deployment ID.
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
     * Site&#039;s latest deployment ID.
     */
    @SerializedName("latestDeploymentId")
    val latestDeploymentId: String,

    /**
     * Latest deployment creation date in ISO 8601 format.
     */
    @SerializedName("latestDeploymentCreatedAt")
    val latestDeploymentCreatedAt: String,

    /**
     * Status of latest deployment. Possible values are &quot;waiting&quot;, &quot;processing&quot;, &quot;building&quot;, &quot;ready&quot;, and &quot;failed&quot;.
     */
    @SerializedName("latestDeploymentStatus")
    val latestDeploymentStatus: String,

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
     * Machine specification for builds and executions.
     */
    @SerializedName("specification")
    val specification: String,

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
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "live" to live as Any,
        "logging" to logging as Any,
        "framework" to framework as Any,
        "deploymentId" to deploymentId as Any,
        "deploymentCreatedAt" to deploymentCreatedAt as Any,
        "deploymentScreenshotLight" to deploymentScreenshotLight as Any,
        "deploymentScreenshotDark" to deploymentScreenshotDark as Any,
        "latestDeploymentId" to latestDeploymentId as Any,
        "latestDeploymentCreatedAt" to latestDeploymentCreatedAt as Any,
        "latestDeploymentStatus" to latestDeploymentStatus as Any,
        "vars" to vars.map { it.toMap() } as Any,
        "timeout" to timeout as Any,
        "installCommand" to installCommand as Any,
        "buildCommand" to buildCommand as Any,
        "outputDirectory" to outputDirectory as Any,
        "installationId" to installationId as Any,
        "providerRepositoryId" to providerRepositoryId as Any,
        "providerBranch" to providerBranch as Any,
        "providerRootDirectory" to providerRootDirectory as Any,
        "providerSilentMode" to providerSilentMode as Any,
        "specification" to specification as Any,
        "buildRuntime" to buildRuntime as Any,
        "adapter" to adapter as Any,
        "fallbackFile" to fallbackFile as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Site(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            live = map["live"] as Boolean,
            logging = map["logging"] as Boolean,
            framework = map["framework"] as String,
            deploymentId = map["deploymentId"] as String,
            deploymentCreatedAt = map["deploymentCreatedAt"] as String,
            deploymentScreenshotLight = map["deploymentScreenshotLight"] as String,
            deploymentScreenshotDark = map["deploymentScreenshotDark"] as String,
            latestDeploymentId = map["latestDeploymentId"] as String,
            latestDeploymentCreatedAt = map["latestDeploymentCreatedAt"] as String,
            latestDeploymentStatus = map["latestDeploymentStatus"] as String,
            vars = (map["vars"] as List<Map<String, Any>>).map { Variable.from(map = it) },
            timeout = (map["timeout"] as Number).toLong(),
            installCommand = map["installCommand"] as String,
            buildCommand = map["buildCommand"] as String,
            outputDirectory = map["outputDirectory"] as String,
            installationId = map["installationId"] as String,
            providerRepositoryId = map["providerRepositoryId"] as String,
            providerBranch = map["providerBranch"] as String,
            providerRootDirectory = map["providerRootDirectory"] as String,
            providerSilentMode = map["providerSilentMode"] as Boolean,
            specification = map["specification"] as String,
            buildRuntime = map["buildRuntime"] as String,
            adapter = map["adapter"] as String,
            fallbackFile = map["fallbackFile"] as String,
        )
    }
}