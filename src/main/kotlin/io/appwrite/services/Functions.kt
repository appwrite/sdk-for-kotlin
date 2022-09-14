package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Functions : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Functions
     *
     * Get a list of all the project's functions. You can use the query params to
     * filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, runtime, deployment, schedule, scheduleNext, schedulePrevious, timeout
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.FunctionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.FunctionList {
        val path = "/functions"
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.FunctionList = {
            io.appwrite.models.FunctionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.FunctionList::class.java,
            converter,
        )
    }
    
    /**
     * Create Function
     *
     * Create a new function. You can pass a list of
     * [permissions](/docs/permissions) to allow different project users or team
     * with access to execute the function using the client API.
     *
     * @param functionId Function ID. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Function name. Max length: 128 chars.
     * @param execute An array of strings with execution roles. By default no user is granted with any execute permissions. [learn more about permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 64 characters long.
     * @param runtime Execution runtime.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Function maximum execution time in seconds.
     * @param enabled Is function enabled?
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		functionId: String,
		name: String,
		execute: List<String>,
		runtime: String,
		events: List<String>? = null,
		schedule: String? = null,
		timeout: Long? = null,
		enabled: Boolean? = null
	): io.appwrite.models.Function {
        val path = "/functions"
        val params = mutableMapOf<String, Any?>(
            "functionId" to functionId,
            "name" to name,
            "execute" to execute,
            "runtime" to runtime,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }
    
    /**
     * List runtimes
     *
     * Get a list of all runtimes that are currently active on your instance.
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
        val converter: (Map<String, Any>) -> io.appwrite.models.RuntimeList = {
            io.appwrite.models.RuntimeList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.RuntimeList::class.java,
            converter,
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
        val converter: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            converter,
        )
    }
    
    /**
     * Update Function
     *
     * Update function by its unique ID.
     *
     * @param functionId Function ID.
     * @param name Function name. Max length: 128 chars.
     * @param execute An array of strings with execution roles. By default no user is granted with any execute permissions. [learn more about permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 64 characters long.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Maximum execution time in seconds.
     * @param enabled Is function enabled?
     * @return [io.appwrite.models.Function]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		functionId: String,
		name: String,
		execute: List<String>,
		events: List<String>? = null,
		schedule: String? = null,
		timeout: Long? = null,
		enabled: Boolean? = null
	): io.appwrite.models.Function {
        val path = "/functions/{functionId}".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "execute" to execute,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            converter,
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
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: entrypoint, size, buildId, activate
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DeploymentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDeployments(
		functionId: String,
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.DeploymentList {
        val path = "/functions/{functionId}/deployments".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.DeploymentList = {
            io.appwrite.models.DeploymentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DeploymentList::class.java,
            converter,
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
		code: InputFile,
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
        val converter: (Map<String, Any>) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it)
        }
        val idParamName: String? = null
        val paramName = "code"
        return client.chunkedUpload(
            path,
            headers,
            params,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
            paramName,
            idParamName,
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
     * @return [io.appwrite.models.Deployment]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDeployment(
		functionId: String,
		deploymentId: String
	): io.appwrite.models.Deployment {
        val path = "/functions/{functionId}/deployments/{deploymentId}".replace("{functionId}", functionId).replace("{deploymentId}", deploymentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Deployment = {
            io.appwrite.models.Deployment.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Deployment::class.java,
            converter,
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
        val converter: (Map<String, Any>) -> io.appwrite.models.Function = {
            io.appwrite.models.Function.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Function::class.java,
            converter,
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
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, statusCode, duration
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ExecutionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listExecutions(
		functionId: String,
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.ExecutionList {
        val path = "/functions/{functionId}/executions".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.ExecutionList = {
            io.appwrite.models.ExecutionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.ExecutionList::class.java,
            converter,
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
     * @param async Execute code in the background. Default value is false.
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
        val converter: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
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
        val converter: (Map<String, Any>) -> io.appwrite.models.Execution = {
            io.appwrite.models.Execution.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Execution::class.java,
            converter,
        )
    }
    
    /**
     * List Variables
     *
     * Get a list of all variables of a specific function.
     *
     * @param functionId Function unique ID.
     * @return [io.appwrite.models.VariableList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listVariables(
		functionId: String
	): io.appwrite.models.VariableList {
        val path = "/functions/{functionId}/variables".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.VariableList = {
            io.appwrite.models.VariableList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.VariableList::class.java,
            converter,
        )
    }
    
    /**
     * Create Variable
     *
     * Create a new function variable. These variables can be accessed within
     * function in the `env` object under the request variable.
     *
     * @param functionId Function unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @return [io.appwrite.models.Variable]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVariable(
		functionId: String,
		key: String,
		value: String
	): io.appwrite.models.Variable {
        val path = "/functions/{functionId}/variables".replace("{functionId}", functionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }
    
    /**
     * Get Variable
     *
     * Get a variable by its unique ID.
     *
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @return [io.appwrite.models.Variable]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getVariable(
		functionId: String,
		variableId: String
	): io.appwrite.models.Variable {
        val path = "/functions/{functionId}/variables/{variableId}".replace("{functionId}", functionId).replace("{variableId}", variableId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }
    
    /**
     * Update Variable
     *
     * Update variable by its unique ID.
     *
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @return [io.appwrite.models.Variable]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
		functionId: String,
		variableId: String,
		key: String,
		value: String? = null
	): io.appwrite.models.Variable {
        val path = "/functions/{functionId}/variables/{variableId}".replace("{functionId}", functionId).replace("{variableId}", variableId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }
    
    /**
     * Delete Variable
     *
     * Delete a variable by its unique ID.
     *
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
		functionId: String,
		variableId: String
	): Any {
        val path = "/functions/{functionId}/variables/{variableId}".replace("{functionId}", functionId).replace("{variableId}", variableId)
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
    
}
