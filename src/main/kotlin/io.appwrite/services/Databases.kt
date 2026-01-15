package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Databases service allows you to create structured collections of documents, query and filter lists of documents
**/
class Databases(client: Client) : Service(client) {

    /**
     * Get a list of all databases from the current Appwrite project. You can use the search parameter to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.DatabaseList]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.list` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.list")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DatabaseList {
        val apiPath = "/databases"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.DatabaseList = {
            io.appwrite.models.DatabaseList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DatabaseList::class.java,
            converter,
        )
    }

    /**
     * Create a new Database.
     * 
     *
     * @param databaseId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is the database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     * @return [io.appwrite.models.Database]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.create` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.create")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        databaseId: String,
        name: String,
        enabled: Boolean? = null,
    ): io.appwrite.models.Database {
        val apiPath = "/databases"

        val apiParams = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "name" to name,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }

    /**
     * List transactions across all databases.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries).
     * @return [io.appwrite.models.TransactionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listTransactions(
        queries: List<String>? = null,
    ): io.appwrite.models.TransactionList {
        val apiPath = "/databases/transactions"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.TransactionList = {
            io.appwrite.models.TransactionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TransactionList::class.java,
            converter,
        )
    }

    /**
     * Create a new transaction.
     *
     * @param ttl Seconds before the transaction expires.
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTransaction(
        ttl: Long? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions"

        val apiParams = mutableMapOf<String, Any?>(
            "ttl" to ttl,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }

    /**
     * Get a transaction by its unique ID.
     *
     * @param transactionId Transaction ID.
     * @return [io.appwrite.models.Transaction]
     */
    @Throws(AppwriteException::class)
    suspend fun getTransaction(
        transactionId: String,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }

    /**
     * Update a transaction, to either commit or roll back its operations.
     *
     * @param transactionId Transaction ID.
     * @param commit Commit transaction?
     * @param rollback Rollback transaction?
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTransaction(
        transactionId: String,
        commit: Boolean? = null,
        rollback: Boolean? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
            "commit" to commit,
            "rollback" to rollback,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }

    /**
     * Delete a transaction by its unique ID.
     *
     * @param transactionId Transaction ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteTransaction(
        transactionId: String,
    ): Any {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)

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
     * Create multiple operations in a single transaction.
     *
     * @param transactionId Transaction ID.
     * @param operations Array of staged operations.
     * @return [io.appwrite.models.Transaction]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createOperations(
        transactionId: String,
        operations: List<Any>? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}/operations"
            .replace("{transactionId}", transactionId)

        val apiParams = mutableMapOf<String, Any?>(
            "operations" to operations,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Transaction = {
            io.appwrite.models.Transaction.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Transaction::class.java,
            converter,
        )
    }

    /**
     * Get a database by its unique ID. This endpoint response returns a JSON object with the database metadata.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.Database]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.get` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.get")
    )
    @Throws(AppwriteException::class)
    suspend fun get(
        databaseId: String,
    ): io.appwrite.models.Database {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }

    /**
     * Update a database by its unique ID.
     *
     * @param databaseId Database ID.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     * @return [io.appwrite.models.Database]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.update` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.update")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        databaseId: String,
        name: String,
        enabled: Boolean? = null,
    ): io.appwrite.models.Database {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }

    /**
     * Delete a database by its unique ID. Only API keys with with databases.write scope can delete a database.
     *
     * @param databaseId Database ID.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.delete` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.delete")
    )
    @Throws(AppwriteException::class)
    suspend fun delete(
        databaseId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)

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
     * Get a list of all collections that belong to the provided databaseId. You can use the search parameter to filter your results.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, documentSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.CollectionList]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.listTables` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.listTables")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCollections(
        databaseId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.CollectionList {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.CollectionList = {
            io.appwrite.models.CollectionList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.CollectionList::class.java,
            converter,
        )
    }

    /**
     * Create a new Collection. Before using this route, you should create a new database resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is collection enabled? When set to 'disabled', users cannot access the collection but Server SDKs with and API key can still read and write to the collection. No data is lost when this is toggled.
     * @param attributes Array of attribute definitions to create. Each attribute should contain: key (string), type (string: string, integer, float, boolean, datetime), size (integer, required for string type), required (boolean, optional), default (mixed, optional), array (boolean, optional), and type-specific options.
     * @param indexes Array of index definitions to create. Each index should contain: key (string), type (string: key, fulltext, unique, spatial), attributes (array of attribute keys), orders (array of ASC/DESC, optional), and lengths (array of integers, optional).
     * @return [io.appwrite.models.Collection]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createTable` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createTable")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCollection(
        databaseId: String,
        collectionId: String,
        name: String,
        permissions: List<String>? = null,
        documentSecurity: Boolean? = null,
        enabled: Boolean? = null,
        attributes: List<Any>? = null,
        indexes: List<Any>? = null,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
            "enabled" to enabled,
            "attributes" to attributes,
            "indexes" to indexes,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }

    /**
     * Get a collection by its unique ID. This endpoint response returns a JSON object with the collection metadata.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [io.appwrite.models.Collection]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.getTable` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.getTable")
    )
    @Throws(AppwriteException::class)
    suspend fun getCollection(
        databaseId: String,
        collectionId: String,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }

    /**
     * Update a collection by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is collection enabled? When set to 'disabled', users cannot access the collection but Server SDKs with and API key can still read and write to the collection. No data is lost when this is toggled.
     * @return [io.appwrite.models.Collection]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateTable` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateTable")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateCollection(
        databaseId: String,
        collectionId: String,
        name: String,
        permissions: List<String>? = null,
        documentSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }

    /**
     * Delete a collection by its unique ID. Only users with write permissions have access to delete this resource.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteTable` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteTable")
    )
    @Throws(AppwriteException::class)
    suspend fun deleteCollection(
        databaseId: String,
        collectionId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

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
     * @param collectionId Collection ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, size, required, array, status, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.AttributeList]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.listColumns` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.listColumns")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAttributes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AttributeList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.AttributeList = {
            io.appwrite.models.AttributeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeList::class.java,
            converter,
        )
    }

    /**
     * Create a boolean attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeBoolean]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createBooleanColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createBooleanColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBooleanAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeBoolean {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeBoolean = {
            io.appwrite.models.AttributeBoolean.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeBoolean::class.java,
            converter,
        )
    }

    /**
     * Update a boolean attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     * @return [io.appwrite.models.AttributeBoolean]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateBooleanColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateBooleanColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBooleanAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeBoolean {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeBoolean = {
            io.appwrite.models.AttributeBoolean.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeBoolean::class.java,
            converter,
        )
    }

    /**
     * Create a date time attribute according to the ISO 8601 standard.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for the attribute in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeDatetime]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createDatetimeColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createDatetimeColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDatetimeAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeDatetime {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeDatetime = {
            io.appwrite.models.AttributeDatetime.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeDatetime::class.java,
            converter,
        )
    }

    /**
     * Update a date time attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     * @return [io.appwrite.models.AttributeDatetime]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateDatetimeColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateDatetimeColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDatetimeAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeDatetime {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeDatetime = {
            io.appwrite.models.AttributeDatetime.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeDatetime::class.java,
            converter,
        )
    }

    /**
     * Create an email attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEmail]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createEmailColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createEmailColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmailAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeEmail {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/email"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeEmail = {
            io.appwrite.models.AttributeEmail.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeEmail::class.java,
            converter,
        )
    }

    /**
     * Update an email attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeEmail]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateEmailColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateEmailColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmailAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeEmail {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/email/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeEmail = {
            io.appwrite.models.AttributeEmail.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeEmail::class.java,
            converter,
        )
    }

    /**
     * Create an enum attribute. The `elements` param acts as a white-list of accepted values for this attribute. 
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param elements Array of enum values.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEnum]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createEnumColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createEnumColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEnumAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeEnum {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/enum"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

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
        val converter: (Any) -> io.appwrite.models.AttributeEnum = {
            io.appwrite.models.AttributeEnum.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeEnum::class.java,
            converter,
        )
    }

    /**
     * Update an enum attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param elements Updated list of enum values.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeEnum]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateEnumColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateEnumColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEnumAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeEnum {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/enum/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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
        val converter: (Any) -> io.appwrite.models.AttributeEnum = {
            io.appwrite.models.AttributeEnum.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeEnum::class.java,
            converter,
        )
    }

    /**
     * Create a float attribute. Optionally, minimum and maximum values can be provided.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value.
     * @param max Maximum value.
     * @param default Default value. Cannot be set when required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeFloat]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createFloatColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createFloatColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFloatAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Double? = null,
        max: Double? = null,
        default: Double? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeFloat {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/float"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

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
        val converter: (Any) -> io.appwrite.models.AttributeFloat = {
            io.appwrite.models.AttributeFloat.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeFloat::class.java,
            converter,
        )
    }

    /**
     * Update a float attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when required.
     * @param min Minimum value.
     * @param max Maximum value.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeFloat]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateFloatColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateFloatColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFloatAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Double? = null,
        min: Double? = null,
        max: Double? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeFloat {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/float/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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
        val converter: (Any) -> io.appwrite.models.AttributeFloat = {
            io.appwrite.models.AttributeFloat.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeFloat::class.java,
            converter,
        )
    }

    /**
     * Create an integer attribute. Optionally, minimum and maximum values can be provided.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeInteger]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createIntegerColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createIntegerColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIntegerAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Long? = null,
        max: Long? = null,
        default: Long? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeInteger {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/integer"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

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
        val converter: (Any) -> io.appwrite.models.AttributeInteger = {
            io.appwrite.models.AttributeInteger.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeInteger::class.java,
            converter,
        )
    }

    /**
     * Update an integer attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeInteger]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateIntegerColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateIntegerColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateIntegerAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Long? = null,
        min: Long? = null,
        max: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeInteger {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/integer/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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
        val converter: (Any) -> io.appwrite.models.AttributeInteger = {
            io.appwrite.models.AttributeInteger.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeInteger::class.java,
            converter,
        )
    }

    /**
     * Create IP address attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeIp]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createIpColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createIpColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIpAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeIp {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/ip"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeIp = {
            io.appwrite.models.AttributeIp.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeIp::class.java,
            converter,
        )
    }

    /**
     * Update an ip attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeIp]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateIpColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateIpColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateIpAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeIp {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/ip/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeIp = {
            io.appwrite.models.AttributeIp.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeIp::class.java,
            converter,
        )
    }

    /**
     * Create a geometric line attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeLine]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createLineColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createLineColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createLineAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributeLine {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/line"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeLine = {
            io.appwrite.models.AttributeLine.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeLine::class.java,
            converter,
        )
    }

    /**
     * Update a line attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     * @return [io.appwrite.models.AttributeLine]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateLineColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateLineColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateLineAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeLine {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/line/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeLine = {
            io.appwrite.models.AttributeLine.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeLine::class.java,
            converter,
        )
    }

    /**
     * Create a geometric point attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributePoint]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createPointColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createPointColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createPointAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributePoint {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/point"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributePoint = {
            io.appwrite.models.AttributePoint.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributePoint::class.java,
            converter,
        )
    }

    /**
     * Update a point attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     * @return [io.appwrite.models.AttributePoint]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updatePointColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updatePointColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePointAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributePoint {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/point/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributePoint = {
            io.appwrite.models.AttributePoint.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributePoint::class.java,
            converter,
        )
    }

    /**
     * Create a geometric polygon attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributePolygon]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createPolygonColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createPolygonColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createPolygonAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributePolygon {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/polygon"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributePolygon = {
            io.appwrite.models.AttributePolygon.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributePolygon::class.java,
            converter,
        )
    }

    /**
     * Update a polygon attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     * @return [io.appwrite.models.AttributePolygon]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updatePolygonColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updatePolygonColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePolygonAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributePolygon {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/polygon/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributePolygon = {
            io.appwrite.models.AttributePolygon.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributePolygon::class.java,
            converter,
        )
    }

    /**
     * Create relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param relatedCollectionId Related Collection ID.
     * @param type Relation type
     * @param twoWay Is Two Way?
     * @param key Attribute Key.
     * @param twoWayKey Two Way Attribute Key.
     * @param onDelete Constraints option
     * @return [io.appwrite.models.AttributeRelationship]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createRelationshipColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createRelationshipColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        relatedCollectionId: String,
        type: io.appwrite.enums.RelationshipType,
        twoWay: Boolean? = null,
        key: String? = null,
        twoWayKey: String? = null,
        onDelete: io.appwrite.enums.RelationMutate? = null,
    ): io.appwrite.models.AttributeRelationship {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "relatedCollectionId" to relatedCollectionId,
            "type" to type,
            "twoWay" to twoWay,
            "key" to key,
            "twoWayKey" to twoWayKey,
            "onDelete" to onDelete,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeRelationship = {
            io.appwrite.models.AttributeRelationship.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeRelationship::class.java,
            converter,
        )
    }

    /**
     * Create a string attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @param encrypt Toggle encryption for the attribute. Encryption enhances security by not storing any plain text values in the database. However, encrypted attributes cannot be queried.
     * @return [io.appwrite.models.AttributeString]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createStringColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createStringColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createStringAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        size: Long,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
        encrypt: Boolean? = null,
    ): io.appwrite.models.AttributeString {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/string"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

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
        val converter: (Any) -> io.appwrite.models.AttributeString = {
            io.appwrite.models.AttributeString.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeString::class.java,
            converter,
        )
    }

    /**
     * Update a string attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param size Maximum size of the string attribute.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeString]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateStringColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateStringColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateStringAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        size: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeString {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/string/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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
        val converter: (Any) -> io.appwrite.models.AttributeString = {
            io.appwrite.models.AttributeString.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeString::class.java,
            converter,
        )
    }

    /**
     * Create a URL attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeUrl]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createUrlColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createUrlColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUrlAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeUrl {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/url"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeUrl = {
            io.appwrite.models.AttributeUrl.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeUrl::class.java,
            converter,
        )
    }

    /**
     * Update an url attribute. Changing the `default` value will not update already existing documents.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeUrl]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateUrlColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateUrlColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateUrlAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeUrl {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/url/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeUrl = {
            io.appwrite.models.AttributeUrl.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeUrl::class.java,
            converter,
        )
    }

    /**
     * Get attribute by ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.getColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.getColumn")
    )
    @Throws(AppwriteException::class)
    suspend fun getAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> Any = {
            io.appwrite.models.AttributeBoolean.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
            converter,
        )
    }

    /**
     * Deletes an attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteColumn")
    )
    @Throws(AppwriteException::class)
    suspend fun deleteAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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
     * Update relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param onDelete Constraints option
     * @param newKey New Attribute Key.
     * @return [io.appwrite.models.AttributeRelationship]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateRelationshipColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateRelationshipColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        onDelete: io.appwrite.enums.RelationMutate? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeRelationship {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "onDelete" to onDelete,
            "newKey" to newKey,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.AttributeRelationship = {
            io.appwrite.models.AttributeRelationship.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.AttributeRelationship::class.java,
            converter,
        )
    }

    /**
     * Get a list of all the user's documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.listRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.listRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
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
     * Get a list of all the user's documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.listRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.listRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = listDocuments(
        databaseId,
        collectionId,
        queries,
        transactionId,
        total,
        nestedType = classOf(),
    )

    /**
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = createDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documents" to documents,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
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
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = createDocuments(
        databaseId,
        collectionId,
        documents,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Create or update Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documents Array of document data as JSON objects. May contain partial documents.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.upsertRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.upsertRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> upsertDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documents" to documents,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
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
     * Create or update Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documents Array of document data as JSON objects. May contain partial documents.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.upsertRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.upsertRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun upsertDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = upsertDocuments(
        databaseId,
        collectionId,
        documents,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update all documents that match your queries, if no queries are submitted then all documents are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> updateDocuments(
        databaseId: String,
        collectionId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
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
     * Update all documents that match your queries, if no queries are submitted then all documents are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocuments(
        databaseId: String,
        collectionId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = updateDocuments(
        databaseId,
        collectionId,
        data,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Bulk delete documents using queries, if no queries are passed then all documents are deleted.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> deleteDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DocumentList<T> = {
            io.appwrite.models.DocumentList.from(map = it as Map<String, Any>, nestedType)
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
     * Bulk delete documents using queries, if no queries are passed then all documents are deleted.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteRows` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteRows")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = deleteDocuments(
        databaseId,
        collectionId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.getRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.getRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.getRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.getRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = getDocument(
        databaseId,
        collectionId,
        documentId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required attributes of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.upsertRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.upsertRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required attributes of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.upsertRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.upsertRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = upsertDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.updateRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.updateRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = updateDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete a document by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param transactionId Transaction ID for staging the operation.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteRow` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteRow")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        transactionId: String? = null,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "transactionId" to transactionId,
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
     * Decrement a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.decrementRowColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.decrementRowColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/decrement"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)
            .replace("{attribute}", attribute)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "min" to min,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Decrement a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.decrementRowColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.decrementRowColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = decrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        min,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Increment a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.incrementRowColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.incrementRowColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/increment"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)
            .replace("{attribute}", attribute)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "max" to max,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Document<T> = {
            io.appwrite.models.Document.from(map = it as Map<String, Any>, nestedType)
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
     * Increment a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     * @return [io.appwrite.models.Document<T>]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.incrementRowColumn` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.incrementRowColumn")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = incrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        max,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * List indexes in the collection.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, status, attributes, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.IndexList]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.listIndexes` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.listIndexes")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.IndexList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.IndexList = {
            io.appwrite.models.IndexList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.IndexList::class.java,
            converter,
        )
    }

    /**
     * Creates an index on the attributes listed. Your index should include all the attributes you will query in a single request.
     * Attributes can be `key`, `fulltext`, and `unique`.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index. Maximum of 100 attributes are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @param lengths Length of index. Maximum of 100
     * @return [io.appwrite.models.Index]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.createIndex` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.createIndex")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
        databaseId: String,
        collectionId: String,
        key: String,
        type: io.appwrite.enums.IndexType,
        attributes: List<String>,
        orders: List<String>? = null,
        lengths: List<Long>? = null,
    ): io.appwrite.models.Index {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders,
            "lengths" to lengths,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }

    /**
     * Get an index by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [io.appwrite.models.Index]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.getIndex` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.getIndex")
    )
    @Throws(AppwriteException::class)
    suspend fun getIndex(
        databaseId: String,
        collectionId: String,
        key: String,
    ): io.appwrite.models.Index {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }

    /**
     * Delete an index.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [Any]
     */
    @Deprecated(
        message = "This API has been deprecated since 1.8.0. Please use `TablesDB.deleteIndex` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.TablesDB.deleteIndex")
    )
    @Throws(AppwriteException::class)
    suspend fun deleteIndex(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
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

}