package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class AlertMetric(val value: String) {
    @SerializedName("network.requests")
    NETWORK_REQUESTS("network.requests"),
    @SerializedName("network.inbound")
    NETWORK_INBOUND("network.inbound"),
    @SerializedName("network.outbound")
    NETWORK_OUTBOUND("network.outbound"),
    @SerializedName("executions")
    EXECUTIONS("executions"),
    @SerializedName("executions.mbSeconds")
    EXECUTIONS_MBSECONDS("executions.mbSeconds"),
    @SerializedName("realtime.connections")
    REALTIME_CONNECTIONS("realtime.connections"),
    @SerializedName("webhooks.events.sent")
    WEBHOOKS_EVENTS_SENT("webhooks.events.sent"),
    @SerializedName("webhooks.events.failed")
    WEBHOOKS_EVENTS_FAILED("webhooks.events.failed"),
    @SerializedName("users.mau")
    USERS_MAU("users.mau"),
    @SerializedName("auth.method.phone")
    AUTH_METHOD_PHONE("auth.method.phone"),
    @SerializedName("users")
    USERS("users"),
    @SerializedName("databases.operations.reads")
    DATABASES_OPERATIONS_READS("databases.operations.reads"),
    @SerializedName("databases.operations.writes")
    DATABASES_OPERATIONS_WRITES("databases.operations.writes"),
    @SerializedName("databases.storage")
    DATABASES_STORAGE("databases.storage"),
    @SerializedName("storage")
    STORAGE("storage"),
    @SerializedName("files.storage")
    FILES_STORAGE("files.storage"),
    @SerializedName("messages.sent")
    MESSAGES_SENT("messages.sent"),
    @SerializedName("messages.sms.sent")
    MESSAGES_SMS_SENT("messages.sms.sent"),
    @SerializedName("messages.failed")
    MESSAGES_FAILED("messages.failed"),
    @SerializedName("avatars.screenshotsGenerated")
    AVATARS_SCREENSHOTSGENERATED("avatars.screenshotsGenerated"),
    @SerializedName("dedicatedDatabases.cpu")
    DEDICATEDDATABASES_CPU("dedicatedDatabases.cpu"),
    @SerializedName("dedicatedDatabases.memory")
    DEDICATEDDATABASES_MEMORY("dedicatedDatabases.memory"),
    @SerializedName("dedicatedDatabases.storage")
    DEDICATEDDATABASES_STORAGE("dedicatedDatabases.storage"),
    @SerializedName("dedicatedDatabases.connections")
    DEDICATEDDATABASES_CONNECTIONS("dedicatedDatabases.connections"),
    @SerializedName("dedicatedDatabases.qps")
    DEDICATEDDATABASES_QPS("dedicatedDatabases.qps"),
    @SerializedName("dedicatedDatabases.iopsRead")
    DEDICATEDDATABASES_IOPSREAD("dedicatedDatabases.iopsRead"),
    @SerializedName("dedicatedDatabases.iopsWrite")
    DEDICATEDDATABASES_IOPSWRITE("dedicatedDatabases.iopsWrite"),
    @SerializedName("analytics.events")
    ANALYTICS_EVENTS("analytics.events"),
    @SerializedName("analytics.pageviews")
    ANALYTICS_PAGEVIEWS("analytics.pageviews"),
    @SerializedName("billing.budgetUsed")
    BILLING_BUDGETUSED("billing.budgetUsed");

    override fun toString() = value
}
