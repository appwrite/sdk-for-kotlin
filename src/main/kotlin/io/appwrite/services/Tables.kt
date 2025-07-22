package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Tables service allows you to create structured tables of rows, query and filter lists of rows
**/
class Tables(client: Client) : Service(client) {

    /**
     * Get a list of all tables that belong to the provided databaseId. You can use the search parameter to filter your results.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, rowSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.TableList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        databaseId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.TableList {
        val apiPath = "/databases/{databaseId}/tables"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.TableList = {
            io.appwrite.models.TableList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TableList::class.java,
            converter,
        )
    }

    /**
     * Create a new Table. Before using this route, you should create a new database resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Table name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param rowSecurity Enables configuring permissions for individual rows. A user needs one of row or table level permissions to access a row. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is table enabled? When set to 'disabled', users cannot access the table but Server SDKs with and API key can still read and write to the table. No data is lost when this is toggled.
     * @return [io.appwrite.models.Table]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        databaseId: String,
        tableId: String,
        name: String,
        permissions: List<String>? = null,
        rowSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Table {
        val apiPath = "/databases/{databaseId}/tables"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "tableId" to tableId,
            "name" to name,
            "permissions" to permissions,
            "rowSecurity" to rowSecurity,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Table = {
            io.appwrite.models.Table.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Table::class.java,
            converter,
        )
    }

    /**
     * Get a table by its unique ID. This endpoint response returns a JSON object with the table metadata.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @return [io.appwrite.models.Table]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        databaseId: String,
        tableId: String,
    ): io.appwrite.models.Table {
        val apiPath = "/databases/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Table = {
            io.appwrite.models.Table.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Table::class.java,
            converter,
        )
    }

    /**
     * Update a table by its unique ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param name Table name. Max length: 128 chars.
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param rowSecurity Enables configuring permissions for individual rows. A user needs one of row or table level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is table enabled? When set to 'disabled', users cannot access the table but Server SDKs with and API key can still read and write to the table. No data is lost when this is toggled.
     * @return [io.appwrite.models.Table]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        databaseId: String,
        tableId: String,
        name: String,
        permissions: List<String>? = null,
        rowSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Table {
        val apiPath = "/databases/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "rowSecurity" to rowSecurity,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Table = {
            io.appwrite.models.Table.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Table::class.java,
            converter,
        )
    }

    /**
     * Delete a table by its unique ID. Only users with write permissions have access to delete this resource.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        databaseId: String,
        tableId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

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
     * List attributes in the collection.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, size, required, array, status, error
     * @return [io.appwrite.models.ColumnList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listColumns(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.ColumnList {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ColumnList = {
            io.appwrite.models.ColumnList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnList::class.java,
            converter,
        )
    }

    /**
     * Create a boolean column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnBoolean]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBooleanColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnBoolean {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/boolean"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnBoolean = {
            io.appwrite.models.ColumnBoolean.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnBoolean::class.java,
            converter,
        )
    }

    /**
     * Update a boolean column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnBoolean]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBooleanColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnBoolean {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/boolean/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnBoolean = {
            io.appwrite.models.ColumnBoolean.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnBoolean::class.java,
            converter,
        )
    }

    /**
     * Create a date time column according to the ISO 8601 standard.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for the column in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnDatetime]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDatetimeColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnDatetime {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/datetime"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnDatetime = {
            io.appwrite.models.ColumnDatetime.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnDatetime::class.java,
            converter,
        )
    }

    /**
     * Update a date time column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnDatetime]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDatetimeColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnDatetime {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/datetime/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnDatetime = {
            io.appwrite.models.ColumnDatetime.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnDatetime::class.java,
            converter,
        )
    }

    /**
     * Create an email column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnEmail]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmailColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnEmail {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/email"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnEmail = {
            io.appwrite.models.ColumnEmail.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnEmail::class.java,
            converter,
        )
    }

    /**
     * Update an email column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnEmail]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmailColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnEmail {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/email/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnEmail = {
            io.appwrite.models.ColumnEmail.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnEmail::class.java,
            converter,
        )
    }

    /**
     * Create an enumeration column. The `elements` param acts as a white-list of accepted values for this column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param elements Array of enum values.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnEnum]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEnumColumn(
        databaseId: String,
        tableId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnEnum {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/enum"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "elements" to elements,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnEnum = {
            io.appwrite.models.ColumnEnum.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnEnum::class.java,
            converter,
        )
    }

    /**
     * Update an enum column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param elements Updated list of enum values.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnEnum]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEnumColumn(
        databaseId: String,
        tableId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnEnum {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/enum/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "elements" to elements,
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnEnum = {
            io.appwrite.models.ColumnEnum.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnEnum::class.java,
            converter,
        )
    }

    /**
     * Create a float column. Optionally, minimum and maximum values can be provided.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnFloat]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFloatColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        min: Double? = null,
        max: Double? = null,
        default: Double? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnFloat {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/float"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnFloat = {
            io.appwrite.models.ColumnFloat.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnFloat::class.java,
            converter,
        )
    }

    /**
     * Update a float column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnFloat]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFloatColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Double? = null,
        min: Double? = null,
        max: Double? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnFloat {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/float/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnFloat = {
            io.appwrite.models.ColumnFloat.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnFloat::class.java,
            converter,
        )
    }

    /**
     * Create an integer column. Optionally, minimum and maximum values can be provided.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnInteger]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIntegerColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        min: Long? = null,
        max: Long? = null,
        default: Long? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnInteger {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/integer"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnInteger = {
            io.appwrite.models.ColumnInteger.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnInteger::class.java,
            converter,
        )
    }

    /**
     * Update an integer column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnInteger]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateIntegerColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Long? = null,
        min: Long? = null,
        max: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnInteger {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/integer/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnInteger = {
            io.appwrite.models.ColumnInteger.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnInteger::class.java,
            converter,
        )
    }

    /**
     * Create IP address column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnIp]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIpColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnIp {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/ip"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnIp = {
            io.appwrite.models.ColumnIp.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnIp::class.java,
            converter,
        )
    }

    /**
     * Update an ip column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnIp]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateIpColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnIp {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/ip/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnIp = {
            io.appwrite.models.ColumnIp.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnIp::class.java,
            converter,
        )
    }

    /**
     * Create relationship column. [Learn more about relationship columns](https://appwrite.io/docs/databases-relationships#relationship-columns).
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param relatedTableId Related Table ID.
     * @param type Relation type
     * @param twoWay Is Two Way?
     * @param key Column Key.
     * @param twoWayKey Two Way Column Key.
     * @param onDelete Constraints option
     * @return [io.appwrite.models.ColumnRelationship]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRelationshipColumn(
        databaseId: String,
        tableId: String,
        relatedTableId: String,
        type: io.appwrite.enums.RelationshipType,
        twoWay: Boolean? = null,
        key: String? = null,
        twoWayKey: String? = null,
        onDelete: io.appwrite.enums.RelationMutate? = null,
    ): io.appwrite.models.ColumnRelationship {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "relatedTableId" to relatedTableId,
            "type" to type,
            "twoWay" to twoWay,
            "key" to key,
            "twoWayKey" to twoWayKey,
            "onDelete" to onDelete,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnRelationship = {
            io.appwrite.models.ColumnRelationship.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnRelationship::class.java,
            converter,
        )
    }

    /**
     * Create a string column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Column Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @param encrypt Toggle encryption for the column. Encryption enhances security by not storing any plain text values in the database. However, encrypted columns cannot be queried.
     * @return [io.appwrite.models.ColumnString]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createStringColumn(
        databaseId: String,
        tableId: String,
        key: String,
        size: Long,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
        encrypt: Boolean? = null,
    ): io.appwrite.models.ColumnString {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/string"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "size" to size,
            "required" to required,
            "default" to default,
            "array" to array,
            "encrypt" to encrypt,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnString = {
            io.appwrite.models.ColumnString.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnString::class.java,
            converter,
        )
    }

    /**
     * Update a string column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param size Maximum size of the string column.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnString]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateStringColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        size: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnString {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/string/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "size" to size,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnString = {
            io.appwrite.models.ColumnString.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnString::class.java,
            converter,
        )
    }

    /**
     * Create a URL column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @return [io.appwrite.models.ColumnUrl]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUrlColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnUrl {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/url"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnUrl = {
            io.appwrite.models.ColumnUrl.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnUrl::class.java,
            converter,
        )
    }

    /**
     * Update an url column. Changing the `default` value will not update already existing rows.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnUrl]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateUrlColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnUrl {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/url/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnUrl = {
            io.appwrite.models.ColumnUrl.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnUrl::class.java,
            converter,
        )
    }

    /**
     * Get column by ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun getColumn(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Deletes a column.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteColumn(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

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
     * Update relationship column. [Learn more about relationship columns](https://appwrite.io/docs/databases-relationships#relationship-columns).
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param onDelete Constraints option
     * @param newKey New Column Key.
     * @return [io.appwrite.models.ColumnRelationship]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRelationshipColumn(
        databaseId: String,
        tableId: String,
        key: String,
        onDelete: io.appwrite.enums.RelationMutate? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnRelationship {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/columns/{key}/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "onDelete" to onDelete,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnRelationship = {
            io.appwrite.models.ColumnRelationship.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnRelationship::class.java,
            converter,
        )
    }

    /**
     * List indexes in the collection.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, status, attributes, error
     * @return [io.appwrite.models.ColumnIndexList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.ColumnIndexList {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ColumnIndexList = {
            io.appwrite.models.ColumnIndexList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnIndexList::class.java,
            converter,
        )
    }

    /**
     * Creates an index on the attributes listed. Your index should include all the attributes you will query in a single request.Attributes can be `key`, `fulltext`, and `unique`.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Index Key.
     * @param type Index type.
     * @param columns Array of columns to index. Maximum of 100 columns are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @param lengths Length of index. Maximum of 100
     * @return [io.appwrite.models.ColumnIndex]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
        databaseId: String,
        tableId: String,
        key: String,
        type: io.appwrite.enums.IndexType,
        columns: List<String>,
        orders: List<String>? = null,
        lengths: List<Long>? = null,
    ): io.appwrite.models.ColumnIndex {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "columns" to columns,
            "orders" to orders,
            "lengths" to lengths,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ColumnIndex = {
            io.appwrite.models.ColumnIndex.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnIndex::class.java,
            converter,
        )
    }

    /**
     * Get index by ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Index Key.
     * @return [io.appwrite.models.ColumnIndex]
     */
    @Throws(AppwriteException::class)
    suspend fun getIndex(
        databaseId: String,
        tableId: String,
        key: String,
    ): io.appwrite.models.ColumnIndex {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ColumnIndex = {
            io.appwrite.models.ColumnIndex.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ColumnIndex::class.java,
            converter,
        )
    }

    /**
     * Delete an index.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param key Index Key.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteIndex(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{key}", key)

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
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = listRows(
        databaseId,
        tableId,
        queries,
        nestedType = classOf(),
    )

    /**
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "rowId" to rowId,
            "data" to data,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = createRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rows Array of documents data as JSON objects.
     * @return [io.appwrite.models.RowList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "rows" to rows,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate). Make sure to define columns before creating rows.
     * @param rows Array of documents data as JSON objects.
     * @return [io.appwrite.models.RowList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
    ): io.appwrite.models.RowList<Map<String, Any>> = createRows(
        databaseId,
        tableId,
        rows,
        nestedType = classOf(),
    )

    /**
     * Create or update Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @return [io.appwrite.models.RowList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> upsertRows(
        databaseId: String,
        tableId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create or update Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @return [io.appwrite.models.RowList<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun upsertRows(
        databaseId: String,
        tableId: String,
    ): io.appwrite.models.RowList<Map<String, Any>> = upsertRows(
        databaseId,
        tableId,
        nestedType = classOf(),
    )

    /**
     * Update all rows that match your queries, if no queries are submitted then all rows are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param data Row data as JSON object. Include only column and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> updateRows(
        databaseId: String,
        tableId: String,
        data: Any? = null,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update all rows that match your queries, if no queries are submitted then all rows are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param data Row data as JSON object. Include only column and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRows(
        databaseId: String,
        tableId: String,
        data: Any? = null,
        queries: List<String>? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = updateRows(
        databaseId,
        tableId,
        data,
        queries,
        nestedType = classOf(),
    )

    /**
     * Bulk delete rows using queries, if no queries are passed then all rows are deleted.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> deleteRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.RowList<T> = {
            io.appwrite.models.RowList.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Bulk delete rows using queries, if no queries are passed then all rows are deleted.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.RowList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = deleteRows(
        databaseId,
        tableId,
        queries,
        nestedType = classOf(),
    )

    /**
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = getRow(
        databaseId,
        tableId,
        rowId,
        queries,
        nestedType = classOf(),
    )

    /**
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @return [io.appwrite.models.Row<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun <T> upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @return [io.appwrite.models.Row<T>]
     */
    @Throws(AppwriteException::class)
    suspend fun upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
    ): io.appwrite.models.Row<Map<String, Any>> = upsertRow(
        databaseId,
        tableId,
        rowId,
        nestedType = classOf(),
    )

    /**
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = updateRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Delete a row by its unique ID.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/tables#tablesCreate).
     * @param rowId Row ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteRow(
        databaseId: String,
        tableId: String,
        rowId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/decrement"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "min" to min,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = decrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        min,
        nestedType = classOf(),
    )

    /**
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/databases/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/increment"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "max" to max,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Row<T> = {
            io.appwrite.models.Row.from(map = it as Map<String, Any>, nestedType)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            converter,
        )
    }

    /**
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @return [io.appwrite.models.Row<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = incrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        max,
        nestedType = classOf(),
    )

}