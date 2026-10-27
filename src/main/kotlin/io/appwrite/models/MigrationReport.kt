package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Migration Report
 */
data class MigrationReport(
    /**
     * Number of users to be migrated.
     */
    @SerializedName("user")
    val user: Long,

    /**
     * Number of teams to be migrated.
     */
    @SerializedName("team")
    val team: Long,

    /**
     * Number of databases to be migrated.
     */
    @SerializedName("database")
    val database: Long,

    /**
     * Number of rows to be migrated.
     */
    @SerializedName("row")
    val row: Long,

    /**
     * Number of files to be migrated.
     */
    @SerializedName("file")
    val file: Long,

    /**
     * Number of buckets to be migrated.
     */
    @SerializedName("bucket")
    val bucket: Long,

    /**
     * Number of functions to be migrated.
     */
    @SerializedName("function")
    val function: Long,

    /**
     * Number of platforms to be migrated.
     */
    @SerializedName("platform")
    val platform: Long,

    /**
     * Number of API keys to be migrated.
     */
    @SerializedName("api-key")
    val apiKey: Long,

    /**
     * Number of project variables to be migrated.
     */
    @SerializedName("project-variable")
    val projectVariable: Long,

    /**
     * Number of webhooks to be migrated.
     */
    @SerializedName("webhook")
    val webhook: Long,

    /**
     * Number of auth-method configs to be migrated (always 0 or 1 — the project-level flag bundle).
     */
    @SerializedName("auth-methods")
    val authMethods: Long,

    /**
     * Number of protocol configs to be migrated (always 0 or 1 — the project-level REST/GraphQL/WebSocket flags).
     */
    @SerializedName("project-protocols")
    val projectProtocols: Long,

    /**
     * Number of label sets to be migrated (always 0 or 1 — the project-level RBAC label array).
     */
    @SerializedName("project-labels")
    val projectLabels: Long,

    /**
     * Number of service configs to be migrated (always 0 or 1 — the project-level enable/disable flags for all 17 services).
     */
    @SerializedName("project-services")
    val projectServices: Long,

    /**
     * Number of policy bundles to be migrated (always 0 or 1 — the project-level security policies covering password rules, session behavior, user limits, and membership privacy).
     */
    @SerializedName("policies")
    val policies: Long,

    /**
     * Number of SMTP configurations to be migrated (always 0 or 1 — the project-level custom SMTP settings; password is not exposed by the source API).
     */
    @SerializedName("smtp")
    val smtp: Long,

    /**
     * Number of custom-domain proxy rules to be migrated. Auto-generated `.appwrite.network` rules are skipped — they are recreated by parent Function/Site migration.
     */
    @SerializedName("rule")
    val rule: Long,

    /**
     * Number of custom email templates to be migrated (one per templateId × locale pair).
     */
    @SerializedName("project-email-template")
    val projectEmailTemplate: Long,

    /**
     * Number of project environments to be migrated. Each is recreated under a new ID, empty: its own resources belong to a separate project.
     */
    @SerializedName("project-environment")
    val projectEnvironment: Long,

    /**
     * Number of sites to be migrated.
     */
    @SerializedName("site")
    val site: Long,

    /**
     * Number of providers to be migrated.
     */
    @SerializedName("provider")
    val provider: Long,

    /**
     * Number of topics to be migrated.
     */
    @SerializedName("topic")
    val topic: Long,

    /**
     * Number of subscribers to be migrated.
     */
    @SerializedName("subscriber")
    val subscriber: Long,

    /**
     * Number of messages to be migrated.
     */
    @SerializedName("message")
    val message: Long,

    /**
     * Size of files to be migrated in mb.
     */
    @SerializedName("size")
    val size: Long,

    /**
     * Version of the Appwrite instance to be migrated.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Number of OAuth2 provider configurations to be migrated. Secrets (clientSecret, p8File) are never migrated — destination admin must re-enter them per provider.
     */
    @SerializedName("oauth2-provider")
    val oauth2Provider: Long,

    /**
     * Number of backup policies to be migrated.
     */
    @SerializedName("backup-policy")
    val backupPolicy: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "user" to user as Any,
        "team" to team as Any,
        "database" to database as Any,
        "row" to row as Any,
        "file" to file as Any,
        "bucket" to bucket as Any,
        "function" to function as Any,
        "platform" to platform as Any,
        "api-key" to apiKey as Any,
        "project-variable" to projectVariable as Any,
        "webhook" to webhook as Any,
        "auth-methods" to authMethods as Any,
        "project-protocols" to projectProtocols as Any,
        "project-labels" to projectLabels as Any,
        "project-services" to projectServices as Any,
        "policies" to policies as Any,
        "smtp" to smtp as Any,
        "rule" to rule as Any,
        "project-email-template" to projectEmailTemplate as Any,
        "project-environment" to projectEnvironment as Any,
        "site" to site as Any,
        "provider" to provider as Any,
        "topic" to topic as Any,
        "subscriber" to subscriber as Any,
        "message" to message as Any,
        "size" to size as Any,
        "version" to version as Any,
        "oauth2-provider" to oauth2Provider as Any,
        "backup-policy" to backupPolicy as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MigrationReport(
            user = ((if (map.containsKey("user")) map["user"] else 0) as Number).toLong(),
            team = ((if (map.containsKey("team")) map["team"] else 0) as Number).toLong(),
            database = ((if (map.containsKey("database")) map["database"] else 0) as Number).toLong(),
            row = ((if (map.containsKey("row")) map["row"] else 0) as Number).toLong(),
            file = ((if (map.containsKey("file")) map["file"] else 0) as Number).toLong(),
            bucket = ((if (map.containsKey("bucket")) map["bucket"] else 0) as Number).toLong(),
            function = ((if (map.containsKey("function")) map["function"] else 0) as Number).toLong(),
            platform = ((if (map.containsKey("platform")) map["platform"] else 0) as Number).toLong(),
            apiKey = ((if (map.containsKey("api-key")) map["api-key"] else 0) as Number).toLong(),
            projectVariable = ((if (map.containsKey("project-variable")) map["project-variable"] else 0) as Number).toLong(),
            webhook = ((if (map.containsKey("webhook")) map["webhook"] else 0) as Number).toLong(),
            authMethods = ((if (map.containsKey("auth-methods")) map["auth-methods"] else 0) as Number).toLong(),
            projectProtocols = ((if (map.containsKey("project-protocols")) map["project-protocols"] else 0) as Number).toLong(),
            projectLabels = ((if (map.containsKey("project-labels")) map["project-labels"] else 0) as Number).toLong(),
            projectServices = ((if (map.containsKey("project-services")) map["project-services"] else 0) as Number).toLong(),
            policies = ((if (map.containsKey("policies")) map["policies"] else 0) as Number).toLong(),
            smtp = ((if (map.containsKey("smtp")) map["smtp"] else 0) as Number).toLong(),
            rule = ((if (map.containsKey("rule")) map["rule"] else 0) as Number).toLong(),
            projectEmailTemplate = ((if (map.containsKey("project-email-template")) map["project-email-template"] else 0) as Number).toLong(),
            projectEnvironment = ((if (map.containsKey("project-environment")) map["project-environment"] else 0) as Number).toLong(),
            site = ((if (map.containsKey("site")) map["site"] else 0) as Number).toLong(),
            provider = ((if (map.containsKey("provider")) map["provider"] else 0) as Number).toLong(),
            topic = ((if (map.containsKey("topic")) map["topic"] else 0) as Number).toLong(),
            subscriber = ((if (map.containsKey("subscriber")) map["subscriber"] else 0) as Number).toLong(),
            message = ((if (map.containsKey("message")) map["message"] else 0) as Number).toLong(),
            size = ((if (map.containsKey("size")) map["size"] else 0) as Number).toLong(),
            version = (if (map.containsKey("version")) map["version"] else "") as String,
            oauth2Provider = ((if (map.containsKey("oauth2-provider")) map["oauth2-provider"] else 0) as Number).toLong(),
            backupPolicy = ((if (map.containsKey("backup-policy")) map["backup-policy"] else 0) as Number).toLong(),
        )
    }
}
