package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class DomainTransferStatusEnum(val value: String) {
    @SerializedName("transferrable")
    TRANSFERRABLE("transferrable"),
    @SerializedName("not_transferrable")
    NOT_TRANSFERRABLE("not_transferrable"),
    @SerializedName("pending_owner")
    PENDING_OWNER("pending_owner"),
    @SerializedName("pending_admin")
    PENDING_ADMIN("pending_admin"),
    @SerializedName("pending_registry")
    PENDING_REGISTRY("pending_registry"),
    @SerializedName("completed")
    COMPLETED("completed"),
    @SerializedName("cancelled")
    CANCELLED("cancelled"),
    @SerializedName("service_unavailable")
    SERVICE_UNAVAILABLE("service_unavailable");

    override fun toString() = value
}
