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
class Activities(client: Client) : Service(client) {

    /**
     * List all events for selected filters.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on attributes such as userId, teamId, etc.
     * @return [io.appwrite.models.ActivityEventList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listEvents(
        queries: String? = null,
    ): io.appwrite.models.ActivityEventList {
        val apiPath = "/activities/events"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ActivityEventList = {
            io.appwrite.models.ActivityEventList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ActivityEventList::class.java,
            converter,
        )
    }

    /**
     * Get event by ID.
     * 
     *
     * @param eventId Event ID.
     * @return [io.appwrite.models.ActivityEvent]
     */
    @Throws(AppwriteException::class)
    suspend fun getEvent(
        eventId: String,
    ): io.appwrite.models.ActivityEvent {
        val apiPath = "/activities/events/{eventId}"
            .replace("{eventId}", eventId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
        )
        val converter: (Any) -> io.appwrite.models.ActivityEvent = {
            io.appwrite.models.ActivityEvent.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ActivityEvent::class.java,
            converter,
        )
    }

}