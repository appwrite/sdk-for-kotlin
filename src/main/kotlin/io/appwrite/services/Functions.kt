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
 * The Functions Service allows you view, create and manage your Cloud Functions.
**/
class Functions(client: Client) : Service(client) {

    /**
     * Get a list of all the project's functions. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, runtime, deploymentId, schedule, scheduleNext, schedulePrevious, timeout, entrypoint, commands, installationId
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.FunctionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.FunctionList {
        val apiPath = "/functions"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.FunctionList = {
            io.appwrite.models.FunctionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.FunctionList::class.java,
            converter,
        )
    }

    /**
     * Create a new function. You can pass a list of [permissions](https://appwrite.io/docs/permissions) to allow different project users or team with access to execute the function using the client API.
     *
     * @param functionId Function ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Function name. Max length: 128 chars.
     * @param runtime Execution runtime.
     * @param execute An array of role strings with execution permissions. By default no user is granted with any execute permissions. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Function maximum execution time in seconds.
     * @param enabled Is function enabled? When set to 'disabled', users cannot access the function but Server SDKs with and API key can still access the function. No data is lost when this is toggled.
     * @param logging When disabled, executions will exclude logs and errors, and will be slightly faster.
     * @param entrypoint Entrypoint File. This path is relative to the "providerRootDirectory".
     * @param commands Build Commands.
     * @param scopes List of scopes allowed for API key auto-generated for every execution. Maximum of 100 scopes are allowed.
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the function.
     * @param providerBranch Production branch for the repo linked to the function.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the function? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to function code in the linked repo.
     * @param specification Runtime specification for the function and builds.
     * @return [io.appwrite.models.Function]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        functionId: String,
        name: String,
        runtime: io.appwrite.enums.Runtime,
        execute: List<String>? = null,
        events: List<String>? = null,
        schedule: String? = null,
        timeout: Long? = null,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        entrypoint: String? = null,
        commands: String? = null,
        scopes: List<String>? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Function {
        val apiPath = "/functions"

        val apiParams = mutableMapOf<String, Any?>(
            "functionId" to functionId,
            "name" to name,
            "runtime" to runtime,
            "execute" to execute,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled,
            "logging" to logging,
            "entrypoint" to entrypoint,
            "commands" to commands,
            "scopes" to scopes,
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
        val converter: (Any) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }

    /**
     * Get a list of all runtimes that are currently active on your instance.
     *
     * @return [io.appwrite.models.RuntimeList]
     */
    @Throws(AppwriteException::class)
    suspend fun listRuntimes(
    ): io.appwrite.models.RuntimeList {
        val apiPath = "/functions/runtimes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.RuntimeList = {
            io.appwrite.models.RuntimeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.RuntimeList::class.java,
            converter,
        )
    }

    /**
     * List allowed function specifications for this instance.
     *
     * @return [io.appwrite.models.SpecificationList]
     */
    @Throws(AppwriteException::class)
    suspend fun listSpecifications(
    ): io.appwrite.models.SpecificationList {
        val apiPath = "/functions/specifications"

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
     * Get a function by its unique ID.
     *
     * @param functionId Function ID.
     * @return [io.appwrite.models.Function]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        functionId: String,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }

    /**
     * Update function by its unique ID.
     *
     * @param functionId Function ID.
     * @param name Function name. Max length: 128 chars.
     * @param runtime Execution runtime.
     * @param execute An array of role strings with execution permissions. By default no user is granted with any execute permissions. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Maximum execution time in seconds.
     * @param enabled Is function enabled? When set to 'disabled', users cannot access the function but Server SDKs with and API key can still access the function. No data is lost when this is toggled.
     * @param logging When disabled, executions will exclude logs and errors, and will be slightly faster.
     * @param entrypoint Entrypoint File. This path is relative to the "providerRootDirectory".
     * @param commands Build Commands.
     * @param scopes List of scopes allowed for API Key auto-generated for every execution. Maximum of 100 scopes are allowed.
     * @param installationId Appwrite Installation ID for VCS (Version Controle System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the function
     * @param providerBranch Production branch for the repo linked to the function
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the function? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to function code in the linked repo.
     * @param specification Runtime specification for the function and builds.
     * @return [io.appwrite.models.Function]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        functionId: String,
        name: String,
        runtime: io.appwrite.enums.Runtime? = null,
        execute: List<String>? = null,
        events: List<String>? = null,
        schedule: String? = null,
        timeout: Long? = null,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        entrypoint: String? = null,
        commands: String? = null,
        scopes: List<String>? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "runtime" to runtime,
            "execute" to execute,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled,
            "logging" to logging,
            "entrypoint" to entrypoint,
            "commands" to commands,
            "scopes" to scopes,
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
        val converter: (Any) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }

    /**
     * Delete a function by its unique ID.
     *
     * @param functionId Function ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        functionId: String,
    ): Any {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)

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
     * Update the function active deployment. Use this endpoint to switch the code deployment that should be used when visitor opens your function.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Function]
     */
    @Throws(AppwriteException::class)
    suspend fun updateFunctionDeployment(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}/deployment"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }

    /**
     * Get a list of all the function's code deployments. You can use the query params to filter your results.
     *
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: buildSize, sourceSize, totalSize, buildDuration, status, activate, type
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DeploymentList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDeployments(
        functionId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.DeploymentList {
        val apiPath = "/functions/{functionId}/deployments"
            .replace("{functionId}", functionId)

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
     * Create a new function code deployment. Use this endpoint to upload a new version of your code function. To execute your newly uploaded code, you'll need to update the function's deployment to use your new deployment UID.
    * 
    * This endpoint accepts a tar.gz file compressed with your code. Make sure to include any dependencies your code has within the compressed file. You can learn more about code packaging in the [Appwrite Cloud Functions tutorial](https://appwrite.io/docs/functions).
    * 
    * Use the "command" param to set the entrypoint used to execute your code.
     *
     * @param functionId Function ID.
     * @param code Gzip file with your code package. When used with the Appwrite CLI, pass the path to your code directory, and the CLI will automatically package your code. Use a path that is within the current directory.
     * @param activate Automatically activate the deployment when it is finished building.
     * @param entrypoint Entrypoint File.
     * @param commands Build Commands.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDeployment(
        functionId: String,
        code: InputFile,
        activate: Boolean,
        entrypoint: String? = null,
        commands: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "entrypoint" to entrypoint,
            "commands" to commands,
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
     * Create a new build for an existing function deployment. This endpoint allows you to rebuild a deployment with the updated function configuration, including its entrypoint and build commands if they have been modified. The build process will be queued and executed asynchronously. The original deployment's code will be preserved and used for the new build.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param buildId Build unique ID.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDuplicateDeployment(
        functionId: String,
        deploymentId: String,
        buildId: String? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/duplicate"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
            "buildId" to buildId,
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
    * Use this endpoint with combination of [listTemplates](https://appwrite.io/docs/server/functions#listTemplates) to find the template details.
     *
     * @param functionId Function ID.
     * @param repository Repository name of the template.
     * @param owner The name of the owner of the template.
     * @param rootDirectory Path to function code in the template repo.
     * @param version Version (tag) for the repo linked to the function template.
     * @param activate Automatically activate the deployment when it is finished building.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTemplateDeployment(
        functionId: String,
        repository: String,
        owner: String,
        rootDirectory: String,
        version: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/template"
            .replace("{functionId}", functionId)

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
     * Create a deployment when a function is connected to VCS.
    * 
    * This endpoint lets you create deployment from a branch, commit, or a tag.
     *
     * @param functionId Function ID.
     * @param type Type of reference passed. Allowed values are: branch, commit
     * @param reference VCS reference to create deployment from. Depending on type this can be: branch name, commit hash
     * @param activate Automatically activate the deployment when it is finished building.
     * @return [io.appwrite.models.Deployment]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVcsDeployment(
        functionId: String,
        type: io.appwrite.enums.VCSDeploymentType,
        reference: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/vcs"
            .replace("{functionId}", functionId)

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
     * Get a function deployment by its unique ID.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Deployment]
     */
    @Throws(AppwriteException::class)
    suspend fun getDeployment(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}"
            .replace("{functionId}", functionId)
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
     * Delete a code deployment by its unique ID.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteDeployment(
        functionId: String,
        deploymentId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}"
            .replace("{functionId}", functionId)
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
     * Get a function deployment content by its unique ID. The endpoint response return with a 'Content-Disposition: attachment' header that tells the browser to start downloading the file to user downloads directory.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param type Deployment file to download. Can be: "source", "output".
     * @return [ByteArray]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDeploymentDownload(
        functionId: String,
        deploymentId: String,
        type: io.appwrite.enums.DeploymentDownloadType? = null,
    ): ByteArray {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}/download"
            .replace("{functionId}", functionId)
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
     * Cancel an ongoing function deployment build. If the build is already in progress, it will be stopped and marked as canceled. If the build hasn't started yet, it will be marked as canceled without executing. You cannot cancel builds that have already completed (status 'ready') or failed. The response includes the final build status and details.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Deployment]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDeploymentStatus(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}/status"
            .replace("{functionId}", functionId)
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
     * Get a list of all the current user function execution logs. You can use the query params to filter your results.
     *
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @return [io.appwrite.models.ExecutionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listExecutions(
        functionId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)

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
     * Trigger a function execution. The returned object will return you the current execution status. You can ping the `Get Execution` endpoint to get updates on the current execution status. Once this endpoint is called, your function execution process will start asynchronously.
     *
     * @param functionId Function ID.
     * @param body HTTP body of execution. Default value is empty string.
     * @param async Execute code in the background. Default value is false.
     * @param path HTTP path of execution. Path can include query params. Default value is /
     * @param method HTTP method of execution. Default value is GET.
     * @param headers HTTP headers of execution. Defaults to empty.
     * @param scheduledAt Scheduled execution time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future with precision in minutes.
     * @return [io.appwrite.models.Execution]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createExecution(
        functionId: String,
        body: String? = null,
        async: Boolean? = null,
        path: String? = null,
        method: io.appwrite.enums.ExecutionMethod? = null,
        headers: Any? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)

        val apiParams = mutableMapOf<String, Any?>(
            "body" to body,
            "async" to async,
            "path" to path,
            "method" to method,
            "headers" to headers,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }

    /**
     * Get a function execution log by its unique ID.
     *
     * @param functionId Function ID.
     * @param executionId Execution ID.
     * @return [io.appwrite.models.Execution]
     */
    @Throws(AppwriteException::class)
    suspend fun getExecution(
        functionId: String,
        executionId: String,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions/{executionId}"
            .replace("{functionId}", functionId)
            .replace("{executionId}", executionId)

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
     * Delete a function execution by its unique ID.
     *
     * @param functionId Function ID.
     * @param executionId Execution ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteExecution(
        functionId: String,
        executionId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/executions/{executionId}"
            .replace("{functionId}", functionId)
            .replace("{executionId}", executionId)

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
     * Get a list of all variables of a specific function.
     *
     * @param functionId Function unique ID.
     * @return [io.appwrite.models.VariableList]
     */
    @Throws(AppwriteException::class)
    suspend fun listVariables(
        functionId: String,
    ): io.appwrite.models.VariableList {
        val apiPath = "/functions/{functionId}/variables"
            .replace("{functionId}", functionId)

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
     * Create a new function environment variable. These variables can be accessed in the function at runtime as environment variables.
     *
     * @param functionId Function unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only functions can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVariable(
        functionId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables"
            .replace("{functionId}", functionId)

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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun getVariable(
        functionId: String,
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only functions can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
        functionId: String,
        variableId: String,
        key: String,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
        functionId: String,
        variableId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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