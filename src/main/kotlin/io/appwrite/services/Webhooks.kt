package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Webhooks(client: Client) : Service(client) {

    /**
     * Get a list of all webhooks belonging to the project. You can use the query params to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, url, authUsername, tls, events, enabled, logs, attempts
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     * @return [io.appwrite.models.WebhookList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.WebhookList {
        val apiPath = "/webhooks"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.WebhookList = {
            io.appwrite.models.WebhookList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.WebhookList::class.java,
            converter,
        )
    }

    /**
     * Create a new webhook. Use this endpoint to configure a URL that will receive events from Appwrite when specific events occur.
     *
     * @param webhookId Webhook ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param url Webhook URL.
     * @param name Webhook name. Max length: 128 chars.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param enabled Enable or disable a webhook.
     * @param tls Certificate verification, false for disabled or true for enabled.
     * @param authUsername Webhook HTTP user. Max length: 256 chars.
     * @param authPassword Webhook HTTP password. Max length: 256 chars.
     * @param secret Webhook secret key. If not provided, a new key will be generated automatically. Key must be at least 8 characters long, and at max 256 characters.
     * @return [io.appwrite.models.Webhook]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
        webhookId: String,
        url: String,
        name: String,
        events: List<String>,
        enabled: Boolean? = null,
        tls: Boolean? = null,
        authUsername: String? = null,
        authPassword: String? = null,
        secret: String? = null,
    ): io.appwrite.models.Webhook {
        val apiPath = "/webhooks"

        val apiParams = mutableMapOf<String, Any?>(
            "webhookId" to webhookId,
            "url" to url,
            "name" to name,
            "events" to events,
            "enabled" to enabled,
            "tls" to tls,
            "authUsername" to authUsername,
            "authPassword" to authPassword,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Webhook = {
            io.appwrite.models.Webhook.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Webhook::class.java,
            converter,
        )
    }

    /**
     * Get a webhook by its unique ID. This endpoint returns details about a specific webhook configured for a project. 
     *
     * @param webhookId Webhook ID.
     * @return [io.appwrite.models.Webhook]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        webhookId: String,
    ): io.appwrite.models.Webhook {
        val apiPath = "/webhooks/{webhookId}"
            .replace("{webhookId}", webhookId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.Webhook = {
            io.appwrite.models.Webhook.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Webhook::class.java,
            converter,
        )
    }

    /**
     * Update a webhook by its unique ID. Use this endpoint to update the URL, events, or status of an existing webhook.
     *
     * @param webhookId Webhook ID.
     * @param name Webhook name. Max length: 128 chars.
     * @param url Webhook URL.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param enabled Enable or disable a webhook.
     * @param tls Certificate verification, false for disabled or true for enabled.
     * @param authUsername Webhook HTTP user. Max length: 256 chars.
     * @param authPassword Webhook HTTP password. Max length: 256 chars.
     * @return [io.appwrite.models.Webhook]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
        webhookId: String,
        name: String,
        url: String,
        events: List<String>,
        enabled: Boolean? = null,
        tls: Boolean? = null,
        authUsername: String? = null,
        authPassword: String? = null,
    ): io.appwrite.models.Webhook {
        val apiPath = "/webhooks/{webhookId}"
            .replace("{webhookId}", webhookId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "url" to url,
            "events" to events,
            "enabled" to enabled,
            "tls" to tls,
            "authUsername" to authUsername,
            "authPassword" to authPassword,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Webhook = {
            io.appwrite.models.Webhook.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Webhook::class.java,
            converter,
        )
    }

    /**
     * Delete a webhook by its unique ID. Once deleted, the webhook will no longer receive project events. 
     *
     * @param webhookId Webhook ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        webhookId: String,
    ): Any {
        val apiPath = "/webhooks/{webhookId}"
            .replace("{webhookId}", webhookId)

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
     * Update the webhook signing key. This endpoint can be used to regenerate the signing key used to sign and validate payload deliveries for a specific webhook.
     *
     * @param webhookId Webhook ID.
     * @param secret Webhook secret key. If not provided, a new key will be generated automatically. Key must be at least 8 characters long, and at max 256 characters.
     * @return [io.appwrite.models.Webhook]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSecret(
        webhookId: String,
        secret: String? = null,
    ): io.appwrite.models.Webhook {
        val apiPath = "/webhooks/{webhookId}/secret"
            .replace("{webhookId}", webhookId)

        val apiParams = mutableMapOf<String, Any?>(
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Webhook = {
            io.appwrite.models.Webhook.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Webhook::class.java,
            converter,
        )
    }

}
