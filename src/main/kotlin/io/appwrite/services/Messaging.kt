package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Messaging service allows you to send messages to any provider type (SMTP, push notification, SMS, etc.).
**/
class Messaging(client: Client) : Service(client) {

    /**
     * List messages
     *
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: scheduledAt, deliveredAt, deliveredTotal, status, description, providerType
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.MessageList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMessages(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.MessageList {
        val apiPath = "/messaging/messages"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.MessageList = {
            io.appwrite.models.MessageList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MessageList::class.java,
            converter,
        )
    }

    /**
     * Create an email.
     *
     * 
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param html Is content of type HTML
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmail(
        messageId: String,
        subject: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        cc: List<String>? = null,
        bcc: List<String>? = null,
        status: MessageStatus? = null,
        html: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/email"

        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "subject" to subject,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "cc" to cc,
            "bcc" to bcc,
            "status" to status,
            "html" to html,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Update an email.
     *
     * 
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param html Is content of type HTML
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateEmail(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        subject: String? = null,
        content: String? = null,
        status: MessageStatus? = null,
        html: Boolean? = null,
        cc: List<String>? = null,
        bcc: List<String>? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/email/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "subject" to subject,
            "content" to content,
            "status" to status,
            "html" to html,
            "cc" to cc,
            "bcc" to bcc,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Create a push notification.
     *
     * 
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param data Additional Data for push notification.
     * @param action Action for push notification.
     * @param icon Icon for push notification. Available only for Android and Web Platform.
     * @param sound Sound for push notification. Available only for Android and IOS Platform.
     * @param color Color for push notification. Available only for Android Platform.
     * @param tag Tag for push notification. Available only for Android Platform.
     * @param badge Badge for push notification. Available only for IOS Platform.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createPush(
        messageId: String,
        title: String,
        body: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        data: Any? = null,
        action: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: String? = null,
        status: MessageStatus? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/push"

        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "title" to title,
            "body" to body,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "data" to data,
            "action" to action,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "status" to status,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Update a push notification.
     *
     * 
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param data Additional Data for push notification.
     * @param action Action for push notification.
     * @param icon Icon for push notification. Available only for Android and Web platforms.
     * @param sound Sound for push notification. Available only for Android and iOS platforms.
     * @param color Color for push notification. Available only for Android platforms.
     * @param tag Tag for push notification. Available only for Android platforms.
     * @param badge Badge for push notification. Available only for iOS platforms.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updatePush(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        title: String? = null,
        body: String? = null,
        data: Any? = null,
        action: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: Long? = null,
        status: MessageStatus? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/push/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "title" to title,
            "body" to body,
            "data" to data,
            "action" to action,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "status" to status,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Create an SMS.
     *
     * 
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param content SMS Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSMS(
        messageId: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        status: MessageStatus? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms"

        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "status" to status,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Update an SMS.
     *
     * 
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param content Email Content.
     * @param status Message Status. Value must be one of: draft, scheduled, processing.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSMS(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        content: String? = null,
        status: MessageStatus? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "content" to content,
            "status" to status,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Get a message
     *
     * 
     *
     * @param messageId Message ID.
     * @return [io.appwrite.models.Message]
     */
    @Throws(AppwriteException::class)
    suspend fun getMessage(
        messageId: String,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Message = {
            io.appwrite.models.Message.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class.java,
            converter,
        )
    }

    /**
     * Delete a message
     *
     * 
     *
     * @param messageId Message ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        messageId: String,
    ): Any {
        val apiPath = "/messaging/messages/{messageId}"
            .replace("{messageId}", messageId)

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
     * List message logs
     *
     * 
     *
     * @param messageId Message ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listMessageLogs(
        messageId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/messages/{messageId}/logs"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }

    /**
     * List message targets
     *
     * List the targets associated with a message as set via the targets attribute.
     *
     * @param messageId Message ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, providerId, identifier, providerType
     * @return [io.appwrite.models.TargetList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listTargets(
        messageId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.TargetList {
        val apiPath = "/messaging/messages/{messageId}/targets"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.TargetList = {
            io.appwrite.models.TargetList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TargetList::class.java,
            converter,
        )
    }

    /**
     * List providers
     *
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, provider, type, enabled
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ProviderList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listProviders(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.ProviderList {
        val apiPath = "/messaging/providers"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProviderList = {
            io.appwrite.models.ProviderList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProviderList::class.java,
            converter,
        )
    }

    /**
     * Create APNS provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createAPNSProvider(
        providerId: String,
        name: String,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update APNS provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateAPNSProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create FCM provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param serviceAccountJSON FCM service account JSON.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFCMProvider(
        providerId: String,
        name: String,
        serviceAccountJSON: Any? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "serviceAccountJSON" to serviceAccountJSON,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update FCM provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param serviceAccountJSON FCM service account JSON.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFCMProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        serviceAccountJSON: Any? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "serviceAccountJSON" to serviceAccountJSON,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Mailgun provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param apiKey Mailgun API Key.
     * @param domain Mailgun Domain.
     * @param isEuRegion Set as EU region.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name. Reply to name must have reply to email as well.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email. Reply to email must have reply to name as well.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMailgunProvider(
        providerId: String,
        name: String,
        apiKey: String? = null,
        domain: String? = null,
        isEuRegion: Boolean? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/mailgun"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "apiKey" to apiKey,
            "domain" to domain,
            "isEuRegion" to isEuRegion,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Mailgun provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param apiKey Mailgun API Key.
     * @param domain Mailgun Domain.
     * @param isEuRegion Set as EU region.
     * @param enabled Set as enabled.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMailgunProvider(
        providerId: String,
        name: String? = null,
        apiKey: String? = null,
        domain: String? = null,
        isEuRegion: Boolean? = null,
        enabled: Boolean? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/mailgun/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "apiKey" to apiKey,
            "domain" to domain,
            "isEuRegion" to isEuRegion,
            "enabled" to enabled,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Msg91 provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param senderId Msg91 Sender ID.
     * @param authKey Msg91 Auth Key.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMsg91Provider(
        providerId: String,
        name: String,
        from: String? = null,
        senderId: String? = null,
        authKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "senderId" to senderId,
            "authKey" to authKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Msg91 provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param senderId Msg91 Sender ID.
     * @param authKey Msg91 Auth Key.
     * @param from Sender number.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMsg91Provider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        senderId: String? = null,
        authKey: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "senderId" to senderId,
            "authKey" to authKey,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Sendgrid provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param apiKey Sendgrid API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSendgridProvider(
        providerId: String,
        name: String,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/sendgrid"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Sendgrid provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param apiKey Sendgrid API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSendgridProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/sendgrid/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create SMTP provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host by using this format: [hostname:port] (e.g. "smtp1.example.com:25;smtp2.example.com"). You can also specify encryption type, for example: (e.g. "tls://smtp1.example.com:587;ssl://smtp2.example.com:465"). Hosts will be tried in order.
     * @param port The default SMTP server port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be omitted, 'ssl', or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSMTPProvider(
        providerId: String,
        name: String,
        host: String,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: SMTPEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update SMTP provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host by using this format: [hostname:port] (e.g. "smtp1.example.com:25;smtp2.example.com"). You can also specify encryption type, for example: (e.g. "tls://smtp1.example.com:587;ssl://smtp2.example.com:465"). Hosts will be tried in order.
     * @param port SMTP port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be 'ssl' or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSMTPProvider(
        providerId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: SMTPEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Telesign provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param customerId Telesign customer ID.
     * @param apiKey Telesign API key.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTelesignProvider(
        providerId: String,
        name: String,
        from: String? = null,
        customerId: String? = null,
        apiKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/telesign"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "customerId" to customerId,
            "apiKey" to apiKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Telesign provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param customerId Telesign customer ID.
     * @param apiKey Telesign API key.
     * @param from Sender number.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTelesignProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        customerId: String? = null,
        apiKey: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/telesign/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "customerId" to customerId,
            "apiKey" to apiKey,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Textmagic provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param username Textmagic username.
     * @param apiKey Textmagic apiKey.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTextmagicProvider(
        providerId: String,
        name: String,
        from: String? = null,
        username: String? = null,
        apiKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/textmagic"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "username" to username,
            "apiKey" to apiKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Textmagic provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param username Textmagic username.
     * @param apiKey Textmagic apiKey.
     * @param from Sender number.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTextmagicProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        username: String? = null,
        apiKey: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/textmagic/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "username" to username,
            "apiKey" to apiKey,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Twilio provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param accountSid Twilio account secret ID.
     * @param authToken Twilio authentication token.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTwilioProvider(
        providerId: String,
        name: String,
        from: String? = null,
        accountSid: String? = null,
        authToken: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/twilio"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "accountSid" to accountSid,
            "authToken" to authToken,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Twilio provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param accountSid Twilio account secret ID.
     * @param authToken Twilio authentication token.
     * @param from Sender number.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTwilioProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        accountSid: String? = null,
        authToken: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/twilio/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "accountSid" to accountSid,
            "authToken" to authToken,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Create Vonage provider
     *
     * 
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param apiKey Vonage API key.
     * @param apiSecret Vonage API secret.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createVonageProvider(
        providerId: String,
        name: String,
        from: String? = null,
        apiKey: String? = null,
        apiSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/vonage"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "apiKey" to apiKey,
            "apiSecret" to apiSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Update Vonage provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param apiKey Vonage API key.
     * @param apiSecret Vonage API secret.
     * @param from Sender number.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateVonageProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        apiKey: String? = null,
        apiSecret: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/vonage/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "apiKey" to apiKey,
            "apiSecret" to apiSecret,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Get provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @return [io.appwrite.models.Provider]
     */
    @Throws(AppwriteException::class)
    suspend fun getProvider(
        providerId: String,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Provider = {
            io.appwrite.models.Provider.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class.java,
            converter,
        )
    }

    /**
     * Delete provider
     *
     * 
     *
     * @param providerId Provider ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteProvider(
        providerId: String,
    ): Any {
        val apiPath = "/messaging/providers/{providerId}"
            .replace("{providerId}", providerId)

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
     * List provider logs
     *
     * 
     *
     * @param providerId Provider ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listProviderLogs(
        providerId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/providers/{providerId}/logs"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }

    /**
     * List subscriber logs
     *
     * 
     *
     * @param subscriberId Subscriber ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listSubscriberLogs(
        subscriberId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/subscribers/{subscriberId}/logs"
            .replace("{subscriberId}", subscriberId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }

    /**
     * List topics.
     *
     * 
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, description, emailTotal, smsTotal, pushTotal
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.TopicList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listTopics(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.TopicList {
        val apiPath = "/messaging/topics"

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.TopicList = {
            io.appwrite.models.TopicList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TopicList::class.java,
            converter,
        )
    }

    /**
     * Create a topic.
     *
     * 
     *
     * @param topicId Topic ID. Choose a custom Topic ID or a new Topic ID.
     * @param name Topic Name.
     * @param subscribe An array of role strings with subscribe permission. By default all users are granted with any subscribe permission. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @return [io.appwrite.models.Topic]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createTopic(
        topicId: String,
        name: String,
        subscribe: List<String>? = null,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics"

        val apiParams = mutableMapOf<String, Any?>(
            "topicId" to topicId,
            "name" to name,
            "subscribe" to subscribe,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Topic = {
            io.appwrite.models.Topic.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class.java,
            converter,
        )
    }

    /**
     * Get a topic.
     *
     * 
     *
     * @param topicId Topic ID.
     * @return [io.appwrite.models.Topic]
     */
    @Throws(AppwriteException::class)
    suspend fun getTopic(
        topicId: String,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Topic = {
            io.appwrite.models.Topic.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class.java,
            converter,
        )
    }

    /**
     * Update a topic.
     *
     * 
     *
     * @param topicId Topic ID.
     * @param name Topic Name.
     * @return [io.appwrite.models.Topic]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTopic(
        topicId: String,
        name: String? = null,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Topic = {
            io.appwrite.models.Topic.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class.java,
            converter,
        )
    }

    /**
     * Delete a topic.
     *
     * 
     *
     * @param topicId Topic ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteTopic(
        topicId: String,
    ): Any {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)

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
     * List topic logs
     *
     * 
     *
     * @param topicId Topic ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @return [io.appwrite.models.LogList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listTopicLogs(
        topicId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/topics/{topicId}/logs"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.LogList = {
            io.appwrite.models.LogList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class.java,
            converter,
        )
    }

    /**
     * List subscribers.
     *
     * 
     *
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, provider, type, enabled
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.SubscriberList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listSubscribers(
        topicId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.SubscriberList {
        val apiPath = "/messaging/topics/{topicId}/subscribers"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.SubscriberList = {
            io.appwrite.models.SubscriberList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SubscriberList::class.java,
            converter,
        )
    }

    /**
     * Create a subscriber.
     *
     * 
     *
     * @param topicId Topic ID. The topic ID to subscribe to.
     * @param subscriberId Subscriber ID. Choose a custom Subscriber ID or a new Subscriber ID.
     * @param targetId Target ID. The target ID to link to the specified Topic ID.
     * @return [io.appwrite.models.Subscriber]
     */
    @Throws(AppwriteException::class)
    suspend fun createSubscriber(
        topicId: String,
        subscriberId: String,
        targetId: String,
    ): io.appwrite.models.Subscriber {
        val apiPath = "/messaging/topics/{topicId}/subscribers"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
            "subscriberId" to subscriberId,
            "targetId" to targetId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Subscriber = {
            io.appwrite.models.Subscriber.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Subscriber::class.java,
            converter,
        )
    }

    /**
     * Get a subscriber.
     *
     * 
     *
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param subscriberId Subscriber ID.
     * @return [io.appwrite.models.Subscriber]
     */
    @Throws(AppwriteException::class)
    suspend fun getSubscriber(
        topicId: String,
        subscriberId: String,
    ): io.appwrite.models.Subscriber {
        val apiPath = "/messaging/topics/{topicId}/subscribers/{subscriberId}"
            .replace("{topicId}", topicId)
            .replace("{subscriberId}", subscriberId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Subscriber = {
            io.appwrite.models.Subscriber.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Subscriber::class.java,
            converter,
        )
    }

    /**
     * Delete a subscriber.
     *
     * 
     *
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param subscriberId Subscriber ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteSubscriber(
        topicId: String,
        subscriberId: String,
    ): Any {
        val apiPath = "/messaging/topics/{topicId}/subscribers/{subscriberId}"
            .replace("{topicId}", topicId)
            .replace("{subscriberId}", subscriberId)

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