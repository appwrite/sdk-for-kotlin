package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Functions(client: Client) : Service(client) {

    /**
     * List Functions
     *
     * Get a list of all the project's functions. You can use the query params to
     * filter your results.
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of functions to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the function used as the starting point for the query, excluding the function itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.FunctionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.FunctionList {
        val path = "/functions"
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.FunctionList = {
            io.appwrite.models.FunctionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.FunctionList::class.java,
            convert = convert,
        )
    }
    
    /**
     * Create Function
     *
     * Create a new function. You can pass a list of
     * [permissions](/docs/permissions) to allow different project users or team
     * with access to execute the function using the client API.
     *
     * @param functionId Function ID. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Function name. Max length: 128 chars.
     * @param execute An array of strings with execution permissions. By default no user is granted with any execute permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param runtime Execution runtime.
     * @param vars Key-value JSON object that will be passed to the function as environment variables.
     * @param events Events list.
     * @param schedule Schedule CRON syntax.
     * @param timeout Function maximum execution time in seconds.
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		functionId: String,
		name: String,
		execute: List<Any>,
		runtime: String,
		vars: Any? = null,
		events: List<Any>? = null,
		schedule: String? = null,
		timeout: Long? = null
	): io.appwrite.models.Function {
        val path = "/functions"
        val params = mutableMapOf<String, Any?>(
            "functionId" to functionId,
            "name" to name,
            "execute" to execute,
            "runtime" to runtime,
            "vars" to vars,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            convert = convert,
        )
    }
    
    /**
     * List the currently active function runtimes.
     *
     * Get a list of all runtimes that are currently active in your project.
     *
     * @return [io.appwrite.models.RuntimeList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRuntimes(): io.appwrite.models.RuntimeList {
        val path = "/functions/runtimes"
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.RuntimeList = {
            io.appwrite.models.RuntimeList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.RuntimeList::class.java,
            convert = convert,
        )
    }
    
    /**
     * Get Function
     *
     * Get a function by its unique ID.
     *
     * @param functionId Function ID.
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		functionId: String
	): io.appwrite.models.Function {
        val path = "/functions/{functionId}".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            convert = convert,
        )
    }
    
    /**
     * Update Function
     *
     * Update function by its unique ID.
     *
     * @param functionId Function ID.
     * @param name Function name. Max length: 128 chars.
     * @param execute An array of strings with execution permissions. By default no user is granted with any execute permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param vars Key-value JSON object that will be passed to the function as environment variables.
     * @param events Events list.
     * @param schedule Schedule CRON syntax.
     * @param timeout Maximum execution time in seconds.
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		functionId: String,
		name: String,
		execute: List<Any>,
		vars: Any? = null,
		events: List<Any>? = null,
		schedule: String? = null,
		timeout: Long? = null
	): io.appwrite.models.Function {
        val path = "/functions/{functionId}".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "execute" to execute,
            "vars" to vars,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            convert = convert,
        )
    }
    
    /**
     * Delete Function
     *
     * Delete a function by its unique ID.
     *
     * @param functionId Function ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		functionId: String
	): Any {
        val path = "/functions/{functionId}".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Deployments
     *
     * Get a list of all the project's code deployments. You can use the query
     * params to filter your results.
     *
     * @param functionId Function ID.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of deployments to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the deployment used as the starting point for the query, excluding the deployment itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.DeploymentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDeployments(
		functionId: String,
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.DeploymentList {
        val path = "/functions/{functionId}/deployments".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.DeploymentList = {
            io.appwrite.models.DeploymentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DeploymentList::class.java,
            convert = convert,
        )
    }
    
    /**
     * Create Deployment
     *
     * Create a new function code deployment. Use this endpoint to upload a new
     * version of your code function. To execute your newly uploaded code, you'll
     * need to update the function's deployment to use your new deployment UID.
     * 
     * This endpoint accepts a tar.gz file compressed with your code. Make sure to
     * include any dependencies your code has within the compressed file. You can
     * learn more about code packaging in the [Appwrite Cloud Functions
     * tutorial](/docs/functions).
     * 
     * Use the "command" param to set the entry point used to execute your code.
     *
     * @param functionId Function ID.
     * @param entrypoint Entrypoint File.
     * @param code Gzip file with your code package. When used with the Appwrite CLI, pass the path to your code directory, and the CLI will automatically package your code. Use a path that is within the current directory.
     * @param activate Automatically activate the deployment when it is finished building.
     * @return [io.appwrite.models.Deployment]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDeployment(
		functionId: String,
		entrypoint: String,
		code: File,
		activate: Boolean, onProgress: ((UploadProgress) -> Unit)? = null
	): io.appwrite.models.Deployment {
        val path = "/functions/{functionId}/deployments".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "entrypoint" to entrypoint,
            "code" to code,
            "activate" to activate
        )
        val headers = mutableMapOf(
            "content-type" to "multipart/form-data"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it)
        }
        val paramName = "code"
        return client.chunkedUpload(
            path,
            headers,
            params,
            responseType = io.appwrite.models.Deployment::class.java,
            convert = convert,
            paramName,
            onProgress,
        )
    }
    
    /**
     * Get Deployment
     *
     * Get a code deployment by its unique ID.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.DeploymentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDeployment(
		functionId: String,
		deploymentId: String
	): io.appwrite.models.DeploymentList {
        val path = "/functions/{functionId}/deployments/{deploymentId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.DeploymentList = {
            io.appwrite.models.DeploymentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DeploymentList::class.java,
            convert = convert,
        )
    }
    
    /**
     * Update Function Deployment
     *
     * Update the function code deployment ID using the unique function ID. Use
     * this endpoint to switch the code deployment that should be executed by the
     * execution endpoint.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDeployment(
		functionId: String,
		deploymentId: String
	): io.appwrite.models.Function {
        val path = "/functions/{functionId}/deployments/{deploymentId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            convert = convert,
        )
    }
    
    /**
     * Delete Deployment
     *
     * Delete a code deployment by its unique ID.
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDeployment(
		functionId: String,
		deploymentId: String
	): Any {
        val path = "/functions/{functionId}/deployments/{deploymentId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Retry Build
     *
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param buildId Build unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun retryBuild(
		functionId: String,
		deploymentId: String,
		buildId: String
	): Any {
        val path = "/functions/{functionId}/deployments/{deploymentId}/builds/{buildId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId).replace("{buildId}", buildId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Executions
     *
     * Get a list of all the current user function execution logs. You can use the
     * query params to filter your results. On admin mode, this endpoint will
     * return a list of all of the project's executions. [Learn more about
     * different API modes](/docs/admin).
     *
     * @param functionId Function ID.
     * @param limit Maximum number of executions to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param cursor ID of the execution used as the starting point for the query, excluding the execution itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @return [io.appwrite.models.ExecutionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listExecutions(
		functionId: String,
		limit: Long? = null,
		offset: Long? = null,
		search: String? = null,
		cursor: String? = null,
		cursorDirection: String? = null
	): io.appwrite.models.ExecutionList {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "limit" to limit,
            "offset" to offset,
            "search" to search,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.ExecutionList = {
            io.appwrite.models.ExecutionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ExecutionList::class.java,
            convert = convert,
        )
    }
    
    /**
     * Create Execution
     *
     * Trigger a function execution. The returned object will return you the
     * current execution status. You can ping the `Get Execution` endpoint to get
     * updates on the current execution status. Once this endpoint is called, your
     * function execution process will start asynchronously.
     *
     * @param functionId Function ID.
     * @param data String of custom data to send to function.
     * @param async Execute code asynchronously. Default value is true.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createExecution(
		functionId: String,
		data: String? = null,
		async: Boolean? = null
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "async" to async
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            convert = convert,
        )
    }
    
    /**
     * Get Execution
     *
     * Get a function execution log by its unique ID.
     *
     * @param functionId Function ID.
     * @param executionId Execution ID.
     * @return [io.appwrite.models.Execution]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getExecution(
		functionId: String,
		executionId: String
	): io.appwrite.models.Execution {
        val path = "/functions/{functionId}/executions/{executionId}".replace("{functionId}", functionId).replace("{executionId}", executionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            convert = convert,
        )
    }
    
}