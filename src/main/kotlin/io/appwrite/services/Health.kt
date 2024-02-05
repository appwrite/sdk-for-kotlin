package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Health service allows you to both validate and monitor your Appwrite server&#039;s health.
**/
class Health(client: Client) : Service(client) {

    /**
     * Get HTTP
     *
     * Check the Appwrite HTTP server is up and responsive.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get antivirus
     *
     * Check the Appwrite Antivirus server is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthAntivirus]
     */
    @Throws(AppwriteException::class)
    suspend fun getAntivirus(
    ): io.appwrite.models.HealthAntivirus {
        val apiPath = "/health/anti-virus"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthAntivirus = {
            io.appwrite.models.HealthAntivirus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthAntivirus::class.java,
            converter,
        )
    }

    /**
     * Get cache
     *
     * Check the Appwrite in-memory cache servers are up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getCache(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health/cache"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get DB
     *
     * Check the Appwrite database servers are up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getDB(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health/db"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get pubsub
     *
     * Check the Appwrite pub-sub servers are up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getPubSub(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health/pubsub"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get queue
     *
     * Check the Appwrite queue messaging servers are up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getQueue(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health/queue"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get builds queue
     *
     * Get the number of builds that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueBuilds(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/builds"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get certificates queue
     *
     * Get the number of certificates that are waiting to be issued against [Letsencrypt](https://letsencrypt.org/) in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueCertificates(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/certificates"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get databases queue
     *
     * Get the number of database changes that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param name Queue name for which to check the queue size
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueDatabases(
        name: String? = null,
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/databases"

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get deletes queue
     *
     * Get the number of background destructive changes that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueDeletes(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/deletes"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get functions queue
     *
     * 
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueFunctions(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/functions"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get logs queue
     *
     * Get the number of logs that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueLogs(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/logs"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get mails queue
     *
     * Get the number of mails that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueMails(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/mails"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get messaging queue
     *
     * Get the number of messages that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueMessaging(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/messaging"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get migrations queue
     *
     * Get the number of migrations that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueMigrations(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/migrations"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get webhooks queue
     *
     * Get the number of webhooks that are waiting to be processed in the Appwrite internal queue server.
     *
     * @param threshold Queue size threshold. When hit (equal or higher), endpoint returns server error. Default value is 5000.
     * @return [io.appwrite.models.HealthQueue]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getQueueWebhooks(
        threshold: Long? = null,
    ): io.appwrite.models.HealthQueue {
        val apiPath = "/health/queue/webhooks"

        val apiParams = mutableMapOf<String, Any?>(
            "threshold" to threshold,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthQueue = {
            io.appwrite.models.HealthQueue.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthQueue::class.java,
            converter,
        )
    }

    /**
     * Get local storage
     *
     * Check the Appwrite local storage device is up and connection is successful.
     *
     * @return [io.appwrite.models.HealthStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getStorageLocal(
    ): io.appwrite.models.HealthStatus {
        val apiPath = "/health/storage/local"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthStatus = {
            io.appwrite.models.HealthStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthStatus::class.java,
            converter,
        )
    }

    /**
     * Get time
     *
     * Check the Appwrite server time is synced with Google remote NTP server. We use this technology to smoothly handle leap seconds with no disruptive events. The [Network Time Protocol](https://en.wikipedia.org/wiki/Network_Time_Protocol) (NTP) is used by hundreds of millions of computers and devices to synchronize their clocks over the Internet. If your computer sets its own clock, it likely uses NTP.
     *
     * @return [io.appwrite.models.HealthTime]
     */
    @Throws(AppwriteException::class)
    suspend fun getTime(
    ): io.appwrite.models.HealthTime {
        val apiPath = "/health/time"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.HealthTime = {
            io.appwrite.models.HealthTime.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.HealthTime::class.java,
            converter,
        )
    }

}