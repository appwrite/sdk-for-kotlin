package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Databases service allows you to create structured collections of documents, query and filter lists of documents
**/
class Databases : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List databases
     *
     * Get a list of all databases from the current Appwrite project. You can use the search parameter to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DatabaseList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.DatabaseList {
        val apiPath = "/databases"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Create database
     *
     * Create a new Database.
     *
     * @param databaseId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is the database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     * @return [io.appwrite.models.Database]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Get database
     *
     * Get a database by its unique ID. This endpoint response returns a JSON object with the database metadata.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.Database]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        databaseId: String,
    ): io.appwrite.models.Database {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Update database
     *
     * Update a database by its unique ID.
     *
     * @param databaseId Database ID.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     * @return [io.appwrite.models.Database]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Delete database
     *
     * Delete a database by its unique ID. Only API keys with with databases.write scope can delete a database.
     *
     * @param databaseId Database ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        databaseId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
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
     * List collections
     *
     * Get a list of all collections that belong to the provided databaseId. You can use the search parameter to filter your results.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, documentSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.CollectionList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCollections(
        databaseId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.CollectionList {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Create collection
     *
     * Create a new Collection. Before using this route, you should create a new database resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is collection enabled? When set to 'disabled', users cannot access the collection but Server SDKs with and API key can still read and write to the collection. No data is lost when this is toggled.
     * @return [io.appwrite.models.Collection]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCollection(
        databaseId: String,
        collectionId: String,
        name: String,
        permissions: List<String>? = null,
        documentSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)

        val apiParams = mutableMapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
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
     * Get collection
     *
     * Get a collection by its unique ID. This endpoint response returns a JSON object with the collection metadata.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [io.appwrite.models.Collection]
     */
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
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Update collection
     *
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
        val apiHeaders = mutableMapOf(
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
     * Delete collection
     *
     * Delete a collection by its unique ID. Only users with write permissions have access to delete this resource.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [Any]
     */
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
        val apiHeaders = mutableMapOf(
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
     * List attributes
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, size, required, array, status, error
     * @return [io.appwrite.models.AttributeList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAttributes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.AttributeList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Create boolean attribute
     *
     * Create a boolean attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeBoolean]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update boolean attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeBoolean]
     */
    @Throws(AppwriteException::class)
    suspend fun updateBooleanAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
    ): io.appwrite.models.AttributeBoolean {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create datetime attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for the attribute in ISO 8601 format. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeDatetime]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update dateTime attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeDatetime]
     */
    @Throws(AppwriteException::class)
    suspend fun updateDatetimeAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeDatetime {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create email attribute
     *
     * Create an email attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEmail]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update email attribute
     *
     * Update an email attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeEmail]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEmailAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeEmail {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/email/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create enum attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param elements Array of elements in enumerated type. Uses length of longest element to determine size. Maximum of 100 elements are allowed, each 4096 characters long.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEnum]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update enum attribute
     *
     * Update an enum attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param elements Array of elements in enumerated type. Uses length of longest element to determine size. Maximum of 100 elements are allowed, each 4096 characters long.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeEnum]
     */
    @Throws(AppwriteException::class)
    suspend fun updateEnumAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeEnum {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/enum/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "elements" to elements,
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create float attribute
     *
     * Create a float attribute. Optionally, minimum and maximum values can be provided.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeFloat]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update float attribute
     *
     * Update a float attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeFloat]
     */
    @Throws(AppwriteException::class)
    suspend fun updateFloatAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Double,
        max: Double,
        default: Double? = null,
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
        )
        val apiHeaders = mutableMapOf(
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
     * Create integer attribute
     *
     * Create an integer attribute. Optionally, minimum and maximum values can be provided.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeInteger]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update integer attribute
     *
     * Update an integer attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeInteger]
     */
    @Throws(AppwriteException::class)
    suspend fun updateIntegerAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Long,
        max: Long,
        default: Long? = null,
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
        )
        val apiHeaders = mutableMapOf(
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
     * Create IP address attribute
     *
     * Create IP address attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeIp]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update IP address attribute
     *
     * Update an ip attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeIp]
     */
    @Throws(AppwriteException::class)
    suspend fun updateIpAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeIp {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/ip/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create relationship attribute
     *
     * Create relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param relatedCollectionId Related Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param type Relation type
     * @param twoWay Is Two Way?
     * @param key Attribute Key.
     * @param twoWayKey Two Way Attribute Key.
     * @param onDelete Constraints option
     * @return [io.appwrite.models.AttributeRelationship]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        relatedCollectionId: String,
        type: String,
        twoWay: Boolean? = null,
        key: String? = null,
        twoWayKey: String? = null,
        onDelete: String? = null,
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
        val apiHeaders = mutableMapOf(
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
     * Create string attribute
     *
     * Create a string attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @param encrypt Toggle encryption for the attribute. Encryption enhances security by not storing any plain text values in the database. However, encrypted attributes cannot be queried.
     * @return [io.appwrite.models.AttributeString]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update string attribute
     *
     * Update a string attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeString]
     */
    @Throws(AppwriteException::class)
    suspend fun updateStringAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeString {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/string/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Create URL attribute
     *
     * Create a URL attribute.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeUrl]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update URL attribute
     *
     * Update an url attribute. Changing the `default` value will not update already existing documents.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @return [io.appwrite.models.AttributeUrl]
     */
    @Throws(AppwriteException::class)
    suspend fun updateUrlAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
    ): io.appwrite.models.AttributeUrl {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/url/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
        )
        val apiHeaders = mutableMapOf(
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
     * Get attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @return [Any]
     */
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
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Delete attribute
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @return [Any]
     */
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
        val apiHeaders = mutableMapOf(
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
     * Update relationship attribute
     *
     * Update relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param onDelete Constraints option
     * @return [io.appwrite.models.AttributeRelationship]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        onDelete: String? = null,
    ): io.appwrite.models.AttributeRelationship {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)

        val apiParams = mutableMapOf<String, Any?>(
            "onDelete" to onDelete,
        )
        val apiHeaders = mutableMapOf(
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
     * List documents
     *
     * Get a list of all the user&#039;s documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * List documents
     *
     * Get a list of all the user&#039;s documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.DocumentList<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = listDocuments(
        databaseId,
        collectionId,
        queries,
        nestedType = classOf(),
    )

    /**
     * Create document
     *
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
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
     * Create document
     *
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = createDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Get document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Only method allowed is select.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Get document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Only method allowed is select.
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = getDocument(
        databaseId,
        collectionId,
        documentId,
        queries,
        nestedType = classOf(),
    )

    /**
     * Update document
     *
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun <T> updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        nestedType: Class<T>,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
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
     * Update document
     *
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @return [io.appwrite.models.Document<T>]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = updateDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        nestedType = classOf(),
    )

    /**
     * Delete document
     *
     * Delete a document by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
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
     * List indexes
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, status, attributes, error
     * @return [io.appwrite.models.IndexList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.IndexList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Create index
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index. Maximum of 100 attributes are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @return [io.appwrite.models.Index]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
        databaseId: String,
        collectionId: String,
        key: String,
        type: String,
        attributes: List<String>,
        orders: List<String>? = null,
    ): io.appwrite.models.Index {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders,
        )
        val apiHeaders = mutableMapOf(
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
     * Get index
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [io.appwrite.models.Index]
     */
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
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
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
     * Delete index
     *
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [Any]
     */
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
        val apiHeaders = mutableMapOf(
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