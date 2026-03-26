package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Project service allows you to manage all the projects in your Appwrite server.
**/
class Project(client: Client) : Service(client) {

    /**
     * Get a list of all project environment variables.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, resourceType, resourceId, secret
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.VariableList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listVariables(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.VariableList {
        val apiPath = "/project/variables"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
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
     * Create a new project environment variable. These variables can be accessed by all functions and sites in the project.
     *
     * @param variableId Variable ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVariable(
        variableId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables"

        val apiParams = mutableMapOf<String, Any?>(
            "variableId" to variableId,
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
     * @param variableId Variable ID.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun getVariable(
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
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
     * @param variableId Variable ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
        variableId: String,
        key: String? = null,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
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
     * @param variableId Variable ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
        variableId: String,
    ): Any {
        val apiPath = "/project/variables/{variableId}"
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