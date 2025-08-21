package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

/**
 * The Sites Service allows you view, create and manage your web applications.
**/
class Sites(client: Client) : Service(client) {

    /**
     * Get a list of all the project's sites. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, framework, deploymentId, buildCommand, installCommand, outputDirectory, installationId
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.SiteList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.SiteList {
        val apiPath = "/sites"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.SiteList = {
            io.appwrite.models.SiteList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SiteList::class.java,
            converter,
        )
    }

    /**
     * Create a new site.
     *
     * @param siteId Site ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Site name. Max length: 128 chars.
     * @param framework Sites framework.
     * @param buildRuntime Runtime to use during build step.
     * @param enabled Is site enabled? When set to 'disabled', users cannot access the site but Server SDKs with and API key can still access the site. No data is lost when this is toggled.
     * @param logging When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     * @param timeout Maximum request time in seconds.
     * @param installCommand Install Command.
     * @param buildCommand Build Command.
     * @param outputDirectory Output Directory for site.
     * @param adapter Framework adapter defining rendering strategy. Allowed values are: static, ssr
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param fallbackFile Fallback file for single page application sites.
     * @param providerRepositoryId Repository ID of the repo linked to the site.
     * @param providerBranch Production branch for the repo linked to the site.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the site? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to site code in the linked repo.
     * @param specification Framework specification for the site and builds.
     * @return [io.appwrite.models.Site]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        siteId: String,
        name: String,
        framework: io.appwrite.enums.Framework,
        buildRuntime: io.appwrite.enums.BuildRuntime,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        timeout: Long? = null,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        adapter: io.appwrite.enums.Adapter? = null,
        installationId: String? = null,
        fallbackFile: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Site {
        val apiPath = "/sites"

        val apiParams = mutableMapOf<String, Any?>(
            "siteId" to siteId,
            "name" to name,
            "framework" to framework,
            "enabled" to enabled,
            "logging" to logging,
            "timeout" to timeout,
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "buildRuntime" to buildRuntime,
            "adapter" to adapter,
            "installationId" to installationId,
            "fallbackFile" to fallbackFile,
            "providerRepositoryId" to providerRepositoryId,
            "providerBranch" to providerBranch,
            "providerSilentMode" to providerSilentMode,
            "providerRootDirectory" to providerRootDirectory,
            "specification" to specification,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Site = {
            io.appwrite.models.Site.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class.java,
            converter,
        )
    }

    /**
     * Get a list of all frameworks that are currently available on the server instance.
     *
     * @return [io.appwrite.models.FrameworkList]
     */
    @Throws(AppwriteException::class)
    suspend fun listFrameworks(
    ): io.appwrite.models.FrameworkList {
        val apiPath = "/sites/frameworks"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.FrameworkList = {
            io.appwrite.models.FrameworkList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.FrameworkList::class.java,
            converter,
        )
    }

    /**
     * List allowed site specifications for this instance.
     *
     * @return [io.appwrite.models.SpecificationList]
     */
    @Throws(AppwriteException::class)
    suspend fun listSpecifications(
    ): io.appwrite.models.SpecificationList {
        val apiPath = "/sites/specifications"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.SpecificationList = {
            io.appwrite.models.SpecificationList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SpecificationList::class.java,
            converter,
        )
    }

    /**
     * Get a site by its unique ID.
     *
     * @param siteId Site ID.
     * @return [io.appwrite.models.Site]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        siteId: String,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Site = {
            io.appwrite.models.Site.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class.java,
            converter,
        )
    }

    /**
     * Update site by its unique ID.
     *
     * @param siteId Site ID.
     * @param name Site name. Max length: 128 chars.
     * @param framework Sites framework.
     * @param enabled Is site enabled? When set to 'disabled', users cannot access the site but Server SDKs with and API key can still access the site. No data is lost when this is toggled.
     * @param logging When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     * @param timeout Maximum request time in seconds.
     * @param installCommand Install Command.
     * @param buildCommand Build Command.
     * @param outputDirectory Output Directory for site.
     * @param buildRuntime Runtime to use during build step.
     * @param adapter Framework adapter defining rendering strategy. Allowed values are: static, ssr
     * @param fallbackFile Fallback file for single page application sites.
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the site.
     * @param providerBranch Production branch for the repo linked to the site.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the site? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to site code in the linked repo.
     * @param specification Framework specification for the site and builds.
     * @return [io.appwrite.models.Site]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        siteId: String,
        name: String,
        framework: io.appwrite.enums.Framework,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        timeout: Long? = null,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        buildRuntime: io.appwrite.enums.BuildRuntime? = null,
        adapter: io.appwrite.enums.Adapter? = null,
        fallbackFile: String? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "framework" to framework,
            "enabled" to enabled,
            "logging" to logging,
            "timeout" to timeout,
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "buildRuntime" to buildRuntime,
            "adapter" to adapter,
            "fallbackFile" to fallbackFile,
            "installationId" to installationId,
            "providerRepositoryId" to providerRepositoryId,
            "providerBranch" to providerBranch,
            "providerSilentMode" to providerSilentMode,
            "providerRootDirectory" to providerRootDirectory,
            "specification" to specification,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Site = {
            io.appwrite.models.Site.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class.java,
            converter,
        )
    }

    /**
     * Delete a site by its unique ID.
     *
     * @param siteId Site ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        siteId: String,
    ): Any {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Update the site active deployment. Use this endpoint to switch the code deployment that should be used when visitor opens your site.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Site]
     */
    @Throws(AppwriteException::class)
    suspend fun updateSiteDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}/deployment"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Site = {
            io.appwrite.models.Site.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class.java,
            converter,
        )
    }

    /**
     * Get a list of all the site's code deployments. You can use the query params to filter your results.
     *
     * @param siteId Site ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: buildSize, sourceSize, totalSize, buildDuration, status, activate, type
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DeploymentList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDeployments(
        siteId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.DeploymentList {
        val apiPath = "/sites/{siteId}/deployments"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.DeploymentList = {
            io.appwrite.models.DeploymentList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DeploymentList::class.java,
            converter,
        )
    }

    /**
     * Create a new site code deployment. Use this endpoint to upload a new version of your site code. To activate your newly uploaded code, you'll need to update the function's deployment to use your new deployment ID.
     *
     * @param siteId Site ID.
     * @param code Gzip file with your code package. When used with the Appwrite CLI, pass the path to your code directory, and the CLI will automatically package your code. Use a path that is within the current directory.
     * @param activate Automatically activate the deployment when it is finished building.
     * @param installCommand Install Commands.
     * @param buildCommand Build Commands.
     * @param outputDirectory Output Directory.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDeployment(
        siteId: String,
        code: InputFile,
        activate: Boolean,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "code" to code,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "multipart/form-data",
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        val idParamName: String? = null
        val paramName = "code"
        return client.chunkedUpload(
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
            paramName,
            idParamName,
            onProgress,
        )
    }

    /**
     * Create a new build for an existing site deployment. This endpoint allows you to rebuild a deployment with the updated site configuration, including its commands and output directory if they have been modified. The build process will be queued and executed asynchronously. The original deployment's code will be preserved and used for the new build.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Deployment]
     */
    @Throws(AppwriteException::class)
    suspend fun createDuplicateDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/duplicate"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
        )
    }

    /**
     * Create a deployment based on a template.
    * 
    * Use this endpoint with combination of [listTemplates](https://appwrite.io/docs/server/sites#listTemplates) to find the template details.
     *
     * @param siteId Site ID.
     * @param repository Repository name of the template.
     * @param owner The name of the owner of the template.
     * @param rootDirectory Path to site code in the template repo.
     * @param version Version (tag) for the repo linked to the site template.
     * @param activate Automatically activate the deployment when it is finished building.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTemplateDeployment(
        siteId: String,
        repository: String,
        owner: String,
        rootDirectory: String,
        version: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/template"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "repository" to repository,
            "owner" to owner,
            "rootDirectory" to rootDirectory,
            "version" to version,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
        )
    }

    /**
     * Create a deployment when a site is connected to VCS.
    * 
    * This endpoint lets you create deployment from a branch, commit, or a tag.
     *
     * @param siteId Site ID.
     * @param type Type of reference passed. Allowed values are: branch, commit
     * @param reference VCS reference to create deployment from. Depending on type this can be: branch name, commit hash
     * @param activate Automatically activate the deployment when it is finished building.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVcsDeployment(
        siteId: String,
        type: io.appwrite.enums.VCSDeploymentType,
        reference: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/vcs"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
            "reference" to reference,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
        )
    }

    /**
     * Get a site deployment by its unique ID.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Deployment]
     */
    @Throws(AppwriteException::class)
    suspend fun getDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
        )
    }

    /**
     * Delete a site deployment by its unique ID.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteDeployment(
        siteId: String,
        deploymentId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get a site deployment content by its unique ID. The endpoint response return with a 'Content-Disposition: attachment' header that tells the browser to start downloading the file to user downloads directory.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @param type Deployment file to download. Can be: "source", "output".
     * @return [ByteArray]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDeploymentDownload(
        siteId: String,
        deploymentId: String,
        type: io.appwrite.enums.DeploymentDownloadType? = null,
    ): ByteArray {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}/download"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)

        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class.java
        )
    }

    /**
     * Cancel an ongoing site deployment build. If the build is already in progress, it will be stopped and marked as canceled. If the build hasn't started yet, it will be marked as canceled without executing. You cannot cancel builds that have already completed (status 'ready') or failed. The response includes the final build status and details.
     *
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Deployment]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDeploymentStatus(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}/status"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
        )
    }

    /**
     * Get a list of all site logs. You can use the query params to filter your results.
     *
     * @param siteId Site ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @return [io.appwrite.models.ExecutionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listLogs(
        siteId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/sites/{siteId}/logs"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ExecutionList = {
            io.appwrite.models.ExecutionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ExecutionList::class.java,
            converter,
        )
    }

    /**
     * Get a site request log by its unique ID.
     *
     * @param siteId Site ID.
     * @param logId Log ID.
     * @return [io.appwrite.models.Execution]
     */
    @Throws(AppwriteException::class)
    suspend fun getLog(
        siteId: String,
        logId: String,
    ): io.appwrite.models.Execution {
        val apiPath = "/sites/{siteId}/logs/{logId}"
            .replace("{siteId}", siteId)
            .replace("{logId}", logId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }

    /**
     * Delete a site log by its unique ID.
     *
     * @param siteId Site ID.
     * @param logId Log ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteLog(
        siteId: String,
        logId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/logs/{logId}"
            .replace("{siteId}", siteId)
            .replace("{logId}", logId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get a list of all variables of a specific site.
     *
     * @param siteId Site unique ID.
     * @return [io.appwrite.models.VariableList]
     */
    @Throws(AppwriteException::class)
    suspend fun listVariables(
        siteId: String,
    ): io.appwrite.models.VariableList {
        val apiPath = "/sites/{siteId}/variables"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.VariableList = {
            io.appwrite.models.VariableList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VariableList::class.java,
            converter,
        )
    }

    /**
     * Create a new site variable. These variables can be accessed during build and runtime (server-side rendering) as environment variables.
     *
     * @param siteId Site unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only sites can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVariable(
        siteId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables"
            .replace("{siteId}", siteId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Get a variable by its unique ID.
     *
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun getVariable(
        siteId: String,
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Update variable by its unique ID.
     *
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only sites can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
        siteId: String,
        variableId: String,
        key: String,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Delete a variable by its unique ID.
     *
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
        siteId: String,
        variableId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

}