package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DatabaseStatus(val value: String) {
    @SerializedName("provisioning")
    PROVISIONING("provisioning"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("inactive")
    INACTIVE("inactive"),
    @SerializedName("paused")
    PAUSED("paused"),
    @SerializedName("failed")
    FAILED("failed"),
    @SerializedName("deleting")
    DELETING("deleting"),
    @SerializedName("deleted")
    DELETED("deleted"),
    @SerializedName("restoring")
    RESTORING("restoring"),
    @SerializedName("scaling")
    SCALING("scaling"),
    @SerializedName("upgrading")
    UPGRADING("upgrading"),
    @SerializedName("migrating")
    MIGRATING("migrating"),
    @SerializedName("pausing")
    PAUSING("pausing"),
    @SerializedName("resuming")
    RESUMING("resuming"),
    @SerializedName("failing-over")
    FAILING_OVER("failing-over");

    override fun toString() = value
}