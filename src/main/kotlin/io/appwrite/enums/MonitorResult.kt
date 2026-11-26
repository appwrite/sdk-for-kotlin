package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class MonitorResult(val value: String) {
    @SerializedName("ok")
    OK("ok"),
    @SerializedName("dns_failed")
    DNS_FAILED("dns_failed"),
    @SerializedName("connect_refused")
    CONNECT_REFUSED("connect_refused"),
    @SerializedName("connect_timeout")
    CONNECT_TIMEOUT("connect_timeout"),
    @SerializedName("connect_failed")
    CONNECT_FAILED("connect_failed"),
    @SerializedName("tls_failed")
    TLS_FAILED("tls_failed"),
    @SerializedName("tls_expiring")
    TLS_EXPIRING("tls_expiring"),
    @SerializedName("status_mismatch")
    STATUS_MISMATCH("status_mismatch"),
    @SerializedName("answer_mismatch")
    ANSWER_MISMATCH("answer_mismatch"),
    @SerializedName("smtp_rejected")
    SMTP_REJECTED("smtp_rejected"),
    @SerializedName("target_denied")
    TARGET_DENIED("target_denied"),
    @SerializedName("timeout")
    TIMEOUT("timeout"),
    @SerializedName("rule_matched")
    RULE_MATCHED("rule_matched");

    override fun toString() = value
}
