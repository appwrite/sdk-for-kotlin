package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Database(client: Client) : Service(client) {

    /**
     * List Collections
     *
     * Get a list of all the user collections. You can use the query params to
     * filter your results. On admin mode, this endpoint will return a list of all
     * of the project's collections. [Learn more about different API
     * modes](/docs/admin).
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of collection to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the collection used as the starting point for the query, excluding the collection itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.CollectionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCollections(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.CollectionList {
        val path = "/database/collections"
        val params = mapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.CollectionList = {
            io.appwrite.models.CollectionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CollectionList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Collection
     *
     * Create a new Collection.
     *
     * @param collectionId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permission Permissions type model to use for reading documents in this collection. You can use collection-level permission set once on the collection using the `read` and `write` params, or you can set document-level permission where each document read and write params will decide who has access to read and write to each document individually. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param read An array of strings with read permissions. By default no user is granted with any read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default no user is granted with any write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCollection(
		collectionId: String,
		name: String,
		permission: String,
		read: List<Any>,
		write: List<Any>
	): io.appwrite.models.Collection {
        val path = "/database/collections"
        val params = mapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permission" to permission,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Collection
     *
     * Get a collection by its unique ID. This endpoint response returns a JSON
     * object with the collection metadata.
     *
     * @param collectionId Collection ID.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCollection(
		collectionId: String
	): io.appwrite.models.Collection {
        val path = "/database/collections/{collectionId}".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Collection
     *
     * Update a collection by its unique ID.
     *
     * @param collectionId Collection ID.
     * @param name Collection name. Max length: 128 chars.
     * @param permission Permissions type model to use for reading documents in this collection. You can use collection-level permission set once on the collection using the `read` and `write` params, or you can set document-level permission where each document read and write params will decide who has access to read and write to each document individually. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param enabled Is collection enabled?
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateCollection(
		collectionId: String,
		name: String,
		permission: String,
		read: List<Any>? = null,
		write: List<Any>? = null,
		enabled: Boolean? = null
	): io.appwrite.models.Collection {
        val path = "/database/collections/{collectionId}".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "name" to name,
            "permission" to permission,
            "read" to read,
            "write" to write,
            "enabled" to enabled
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Collection
     *
     * Delete a collection by its unique ID. Only users with write permissions
     * have access to delete this resource.
     *
     * @param collectionId Collection ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteCollection(
		collectionId: String
	): Any {
        val path = "/database/collections/{collectionId}".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
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
     * List Attributes
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @return [io.appwrite.models.AttributeList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAttributes(
		collectionId: String
	): io.appwrite.models.AttributeList {
        val path = "/database/collections/{collectionId}/attributes".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeList = {
            io.appwrite.models.AttributeList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Boolean Attribute
     *
     * Create a boolean attribute.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeBoolean]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBooleanAttribute(
		collectionId: String,
		key: String,
		required: Boolean,
		default: Boolean? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeBoolean {
        val path = "/database/collections/{collectionId}/attributes/boolean".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeBoolean = {
            io.appwrite.models.AttributeBoolean.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeBoolean::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Email Attribute
     *
     * Create an email attribute.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEmail]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmailAttribute(
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEmail {
        val path = "/database/collections/{collectionId}/attributes/email".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeEmail = {
            io.appwrite.models.AttributeEmail.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEmail::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Enum Attribute
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param elements Array of elements in enumerated type. Uses length of longest element to determine size.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEnum]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEnumAttribute(
		collectionId: String,
		key: String,
		elements: List<Any>,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEnum {
        val path = "/database/collections/{collectionId}/attributes/enum".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "elements" to elements,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeEnum = {
            io.appwrite.models.AttributeEnum.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEnum::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Float Attribute
     *
     * Create a float attribute. Optionally, minimum and maximum values can be
     * provided.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
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
		collectionId: String,
		key: String,
		required: Boolean,
		min: String? = null,
		max: String? = null,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeFloat {
        val path = "/database/collections/{collectionId}/attributes/float".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeFloat = {
            io.appwrite.models.AttributeFloat.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeFloat::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Integer Attribute
     *
     * Create an integer attribute. Optionally, minimum and maximum values can be
     * provided.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
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
		collectionId: String,
		key: String,
		required: Boolean,
		min: Long? = null,
		max: Long? = null,
		default: Long? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeInteger {
        val path = "/database/collections/{collectionId}/attributes/integer".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeInteger = {
            io.appwrite.models.AttributeInteger.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeInteger::class.java,
            convert = convert
        )
    }
    
    /**
     * Create IP Address Attribute
     *
     * Create IP address attribute.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeIp]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIpAttribute(
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeIp {
        val path = "/database/collections/{collectionId}/attributes/ip".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeIp = {
            io.appwrite.models.AttributeIp.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeIp::class.java,
            convert = convert
        )
    }
    
    /**
     * Create String Attribute
     *
     * Create a string attribute.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeString]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createStringAttribute(
		collectionId: String,
		key: String,
		size: Long,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeString {
        val path = "/database/collections/{collectionId}/attributes/string".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "size" to size,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeString = {
            io.appwrite.models.AttributeString.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeString::class.java,
            convert = convert
        )
    }
    
    /**
     * Create URL Attribute
     *
     * Create a URL attribute.
     * 
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeUrl]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUrlAttribute(
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeUrl {
        val path = "/database/collections/{collectionId}/attributes/url".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.AttributeUrl = {
            io.appwrite.models.AttributeUrl.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeUrl::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Attribute
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getAttribute(
		collectionId: String,
		key: String
	): Any {
        val path = "/database/collections/{collectionId}/attributes/{key}".replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Delete Attribute
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteAttribute(
		collectionId: String,
		key: String
	): Any {
        val path = "/database/collections/{collectionId}/attributes/{key}".replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
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
     * List Documents
     *
     * Get a list of all the user documents. You can use the query params to
     * filter your results. On admin mode, this endpoint will return a list of all
     * of the project's documents. [Learn more about different API
     * modes](/docs/admin).
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param queries Array of query strings.
     * @param limit Maximum number of documents to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the document used as the starting point for the query, excluding the document itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursorDirection Direction of the cursor.
     * @param orderAttributes Array of attributes used to sort results.
     * @param orderTypes Array of order directions for sorting attribtues. Possible values are DESC for descending order, or ASC for ascending order.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		collectionId: String,
		queries: List<Any>? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderAttributes: List<Any>? = null,
		orderTypes: List<Any>? = null
	): io.appwrite.models.DocumentList {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "queries" to queries,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderAttributes" to orderAttributes,
            "orderTypes" to orderTypes
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.DocumentList = {
            io.appwrite.models.DocumentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DocumentList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Document
     *
     * Create a new Document. Before using this route, you should create a new
     * collection resource using either a [server
     * integration](/docs/server/database#databaseCreateCollection) API or
     * directly from your database console.
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default only the current user is granted with read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default only the current user is granted with write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON
     * object with the document data.
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		collectionId: String,
		documentId: String
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Document
     *
     * Update a document by its unique ID. Using the patch method you can pass
     * only specific fields that will get updated.
     *
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object.
     * @param read An array of strings with read permissions. By default inherits the existing read permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @param write An array of strings with write permissions. By default inherits the existing write permissions. [learn more about permissions](https://appwrite.io/docs/permissions) and get a full list of available permissions.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		collectionId: String,
		documentId: String,
		data: Any,
		read: List<Any>? = null,
		write: List<Any>? = null
	): io.appwrite.models.Document {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mapOf<String, Any?>(
            "data" to data,
            "read" to read,
            "write" to write
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Document
     *
     * Delete a document by its unique ID. This endpoint deletes only the parent
     * documents, its attributes and relations to other documents. Child documents
     * **will not** be deleted.
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param documentId Document ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		collectionId: String,
		documentId: String
	): Any {
        val path = "/database/collections/{collectionId}/documents/{documentId}".replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
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
     * List Indexes
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @return [io.appwrite.models.IndexList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
		collectionId: String
	): io.appwrite.models.IndexList {
        val path = "/database/collections/{collectionId}/indexes".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.IndexList = {
            io.appwrite.models.IndexList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.IndexList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Index
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index.
     * @param orders Array of index orders.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
		collectionId: String,
		key: String,
		type: String,
		attributes: List<Any>,
		orders: List<Any>? = null
	): io.appwrite.models.Index {
        val path = "/database/collections/{collectionId}/indexes".replace("{collectionId}", collectionId)
        val params = mapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Index
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getIndex(
		collectionId: String,
		key: String
	): io.appwrite.models.Index {
        val path = "/database/collections/{collectionId}/indexes/{key}".replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Index
     *
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/database#createCollection).
     * @param key Index Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteIndex(
		collectionId: String,
		key: String
	): Any {
        val path = "/database/collections/{collectionId}/indexes/{key}".replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
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