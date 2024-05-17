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
     * Get a list of all messages from the current Appwrite project.
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
     * Create email
     *
     * Create a new email message.
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param attachments Array of compound ID strings of bucket IDs and file IDs to be attached to the email. They should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param draft Is message a draft
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
        attachments: List<String>? = null,
        draft: Boolean? = null,
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
            "attachments" to attachments,
            "draft" to draft,
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
     * Update email
     *
     * Update an email message by its unique ID.
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param draft Is message a draft
     * @param html Is content of type HTML
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @param attachments Array of compound ID strings of bucket IDs and file IDs to be attached to the email. They should be formatted as <BUCKET_ID>:<FILE_ID>.
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
        draft: Boolean? = null,
        html: Boolean? = null,
        cc: List<String>? = null,
        bcc: List<String>? = null,
        scheduledAt: String? = null,
        attachments: List<String>? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/email/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "subject" to subject,
            "content" to content,
            "draft" to draft,
            "html" to html,
            "cc" to cc,
            "bcc" to bcc,
            "scheduledAt" to scheduledAt,
            "attachments" to attachments,
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
     * Create push notification
     *
     * Create a new push notification.
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param data Additional Data for push notification.
     * @param action Action for push notification.
     * @param image Image for push notification. Must be a compound bucket ID to file ID of a jpeg, png, or bmp image in Appwrite Storage. It should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param icon Icon for push notification. Available only for Android and Web Platform.
     * @param sound Sound for push notification. Available only for Android and IOS Platform.
     * @param color Color for push notification. Available only for Android Platform.
     * @param tag Tag for push notification. Available only for Android Platform.
     * @param badge Badge for push notification. Available only for IOS Platform.
     * @param draft Is message a draft
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
        image: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: String? = null,
        draft: Boolean? = null,
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
            "image" to image,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "draft" to draft,
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
     * Update push notification
     *
     * Update a push notification by its unique ID.
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param data Additional Data for push notification.
     * @param action Action for push notification.
     * @param image Image for push notification. Must be a compound bucket ID to file ID of a jpeg, png, or bmp image in Appwrite Storage. It should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param icon Icon for push notification. Available only for Android and Web platforms.
     * @param sound Sound for push notification. Available only for Android and iOS platforms.
     * @param color Color for push notification. Available only for Android platforms.
     * @param tag Tag for push notification. Available only for Android platforms.
     * @param badge Badge for push notification. Available only for iOS platforms.
     * @param draft Is message a draft
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
        image: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: Long? = null,
        draft: Boolean? = null,
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
            "image" to image,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "draft" to draft,
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
     * Create SMS
     *
     * Create a new SMS message.
     *
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param content SMS Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createSms(
        messageId: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms"

        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "draft" to draft,
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
     * Update SMS
     *
     * Update an email message by its unique ID.
     *
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param content Email Content.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @return [io.appwrite.models.Message]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateSms(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        content: String? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms/{messageId}"
            .replace("{messageId}", messageId)

        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "content" to content,
            "draft" to draft,
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
     * Get message
     *
     * Get a message by its unique ID.
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
     * Delete message
     *
     * Delete a message. If the message is not a draft or scheduled, but has been sent, this will not recall the message.
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
     * Get the message activity logs listed by its unique ID.
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
     * Get a list of the targets associated with a message.
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
     * Get a list of all providers from the current Appwrite project.
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
     * Create a new Apple Push Notification service provider.
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createApnsProvider(
        providerId: String,
        name: String,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
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
            "sandbox" to sandbox,
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
     * Update a Apple Push Notification service provider by its unique ID.
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateApnsProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
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
            "sandbox" to sandbox,
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
     * Create a new Firebase Cloud Messaging provider.
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param serviceAccountJSON FCM service account JSON.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFcmProvider(
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
     * Update a Firebase Cloud Messaging provider by its unique ID.
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param serviceAccountJSON FCM service account JSON.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFcmProvider(
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
     * Create a new Mailgun provider.
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
     * Update a Mailgun provider by its unique ID.
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
     * Create a new MSG91 provider.
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param templateId Msg91 template ID
     * @param senderId Msg91 sender ID.
     * @param authKey Msg91 auth key.
     * @param enabled Set as enabled.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMsg91Provider(
        providerId: String,
        name: String,
        templateId: String? = null,
        senderId: String? = null,
        authKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91"

        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "templateId" to templateId,
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
     * Update a MSG91 provider by its unique ID.
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param templateId Msg91 template ID.
     * @param senderId Msg91 sender ID.
     * @param authKey Msg91 auth key.
     * @return [io.appwrite.models.Provider]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMsg91Provider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        templateId: String? = null,
        senderId: String? = null,
        authKey: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91/{providerId}"
            .replace("{providerId}", providerId)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "templateId" to templateId,
            "senderId" to senderId,
            "authKey" to authKey,
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
     * Create a new Sendgrid provider.
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
     * Update a Sendgrid provider by its unique ID.
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
     * Create a new SMTP provider.
     *
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
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
    suspend fun createSmtpProvider(
        providerId: String,
        name: String,
        host: String,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
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
     * Update a SMTP provider by its unique ID.
     *
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
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
    suspend fun updateSmtpProvider(
        providerId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
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
     * Create a new Telesign provider.
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
     * Update a Telesign provider by its unique ID.
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
     * Create a new Textmagic provider.
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
     * Update a Textmagic provider by its unique ID.
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
     * Create a new Twilio provider.
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
     * Update a Twilio provider by its unique ID.
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
     * Create a new Vonage provider.
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
     * Update a Vonage provider by its unique ID.
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
     * Get a provider by its unique ID.
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
     * Delete a provider by its unique ID.
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
     * Get the provider activity logs listed by its unique ID.
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
     * Get the subscriber activity logs listed by its unique ID.
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
     * List topics
     *
     * Get a list of all topics from the current Appwrite project.
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
     * Create topic
     *
     * Create a new topic.
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
     * Get topic
     *
     * Get a topic by its unique ID.
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
     * Update topic
     *
     * Update a topic by its unique ID.
     *
     * @param topicId Topic ID.
     * @param name Topic Name.
     * @param subscribe An array of role strings with subscribe permission. By default all users are granted with any subscribe permission. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @return [io.appwrite.models.Topic]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateTopic(
        topicId: String,
        name: String? = null,
        subscribe: List<String>? = null,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
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
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class.java,
            converter,
        )
    }

    /**
     * Delete topic
     *
     * Delete a topic by its unique ID.
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
     * Get the topic activity logs listed by its unique ID.
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
     * List subscribers
     *
     * Get a list of all subscribers from the current Appwrite project.
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
     * Create subscriber
     *
     * Create a new subscriber.
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
     * Get subscriber
     *
     * Get a subscriber by its unique ID.
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
     * Delete subscriber
     *
     * Delete a subscriber by its unique ID.
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