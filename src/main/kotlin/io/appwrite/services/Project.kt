package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Project service allows you to manage all the projects in your Appwrite server.
**/
class Project : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Variables
     *
     * Get a list of all project variables. These variables will be accessible in all Appwrite Functions at runtime.
     *
     * @return [io.appwrite.models.VariableList]
     */
    @Throws(AppwriteException::class)
    suspend fun listVariables(
    ): io.appwrite.models.VariableList {
        val apiPath = "/project/variables"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.VariableList = {
            io.appwrite.models.VariableList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.VariableList::class.java,
            converter,
        )
    }

    /**
     * Create Variable
     *
     * Create a new project variable. This variable will be accessible in all Appwrite Functions at runtime.
     *
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun createVariable(
        key: String,
        value: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables"

        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Get Variable
     *
     * Get a project variable by its unique ID.
     *
     * @param variableId Variable unique ID.
     * @return [io.appwrite.models.Variable]
     */
    @Throws(AppwriteException::class)
    suspend fun getVariable(
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Update Variable
     *
     * Update project variable by its unique ID. This variable will be accessible in all Appwrite Functions at runtime.
     *
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @return [io.appwrite.models.Variable]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVariable(
        variableId: String,
        key: String,
        value: String? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Variable = {
            io.appwrite.models.Variable.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.Variable::class.java,
            converter,
        )
    }

    /**
     * Delete Variable
     *
     * Delete a project variable by its unique ID. 
     *
     * @param variableId Variable unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteVariable(
        variableId: String,
    ): Any {
        val apiPath = "/project/variables/{variableId}"
            .replace("{variableId}", variableId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            headers,
            params,
            responseType = Any::class.java,
        )
    }

}