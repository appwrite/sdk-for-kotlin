package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Project
 */
data class Project(
    /**
     * Project ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Project creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Project update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Project name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Project team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Deprecated since 1.9.5: List of dev keys.
     */
    @SerializedName("devKeys")
    val devKeys: List<DevKey>,

    /**
     * Status for custom SMTP
     */
    @SerializedName("smtpEnabled")
    val smtpEnabled: Boolean,

    /**
     * SMTP sender name
     */
    @SerializedName("smtpSenderName")
    val smtpSenderName: String,

    /**
     * SMTP sender email
     */
    @SerializedName("smtpSenderEmail")
    val smtpSenderEmail: String,

    /**
     * SMTP reply to name
     */
    @SerializedName("smtpReplyToName")
    val smtpReplyToName: String,

    /**
     * SMTP reply to email
     */
    @SerializedName("smtpReplyToEmail")
    val smtpReplyToEmail: String,

    /**
     * SMTP server host name
     */
    @SerializedName("smtpHost")
    val smtpHost: String,

    /**
     * SMTP server port
     */
    @SerializedName("smtpPort")
    val smtpPort: Long,

    /**
     * SMTP server username
     */
    @SerializedName("smtpUsername")
    val smtpUsername: String,

    /**
     * SMTP server password. This property is write-only and always returned empty.
     */
    @SerializedName("smtpPassword")
    val smtpPassword: String,

    /**
     * SMTP server secure protocol
     */
    @SerializedName("smtpSecure")
    val smtpSecure: String,

    /**
     * Number of times the ping was received for this project.
     */
    @SerializedName("pingCount")
    val pingCount: Long,

    /**
     * Last ping datetime in ISO 8601 format.
     */
    @SerializedName("pingedAt")
    val pingedAt: String,

    /**
     * Labels for the project.
     */
    @SerializedName("labels")
    val labels: List<String>,

    /**
     * Project status
     */
    @SerializedName("status")
    val status: String,

    /**
     * List of auth methods.
     */
    @SerializedName("authMethods")
    val authMethods: List<ProjectAuthMethod>,

    /**
     * List of services.
     */
    @SerializedName("services")
    val services: List<ProjectService>,

    /**
     * List of protocols.
     */
    @SerializedName("protocols")
    val protocols: List<ProjectProtocol>,

    /**
     * Project region
     */
    @SerializedName("region")
    val region: String,

    /**
     * Billing limits reached
     */
    @SerializedName("billingLimits")
    val billingLimits: BillingLimits,

    /**
     * Project blocks information
     */
    @SerializedName("blocks")
    val blocks: List<Block>,

    /**
     * Last time the project was accessed via console. Used with plan's projectInactivityDays to determine if project is paused.
     */
    @SerializedName("consoleAccessedAt")
    val consoleAccessedAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "teamId" to teamId as Any,
        "devKeys" to devKeys.map { it.toMap() } as Any,
        "smtpEnabled" to smtpEnabled as Any,
        "smtpSenderName" to smtpSenderName as Any,
        "smtpSenderEmail" to smtpSenderEmail as Any,
        "smtpReplyToName" to smtpReplyToName as Any,
        "smtpReplyToEmail" to smtpReplyToEmail as Any,
        "smtpHost" to smtpHost as Any,
        "smtpPort" to smtpPort as Any,
        "smtpUsername" to smtpUsername as Any,
        "smtpPassword" to smtpPassword as Any,
        "smtpSecure" to smtpSecure as Any,
        "pingCount" to pingCount as Any,
        "pingedAt" to pingedAt as Any,
        "labels" to labels as Any,
        "status" to status as Any,
        "authMethods" to authMethods.map { it.toMap() } as Any,
        "services" to services.map { it.toMap() } as Any,
        "protocols" to protocols.map { it.toMap() } as Any,
        "region" to region as Any,
        "billingLimits" to billingLimits.toMap() as Any,
        "blocks" to blocks.map { it.toMap() } as Any,
        "consoleAccessedAt" to consoleAccessedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Project(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            teamId = map["teamId"] as String,
            devKeys = (map["devKeys"] as List<Map<String, Any>>).map { DevKey.from(map = it) },
            smtpEnabled = map["smtpEnabled"] as Boolean,
            smtpSenderName = map["smtpSenderName"] as String,
            smtpSenderEmail = map["smtpSenderEmail"] as String,
            smtpReplyToName = map["smtpReplyToName"] as String,
            smtpReplyToEmail = map["smtpReplyToEmail"] as String,
            smtpHost = map["smtpHost"] as String,
            smtpPort = (map["smtpPort"] as Number).toLong(),
            smtpUsername = map["smtpUsername"] as String,
            smtpPassword = map["smtpPassword"] as String,
            smtpSecure = map["smtpSecure"] as String,
            pingCount = (map["pingCount"] as Number).toLong(),
            pingedAt = map["pingedAt"] as String,
            labels = map["labels"] as List<String>,
            status = map["status"] as String,
            authMethods = (map["authMethods"] as List<Map<String, Any>>).map { ProjectAuthMethod.from(map = it) },
            services = (map["services"] as List<Map<String, Any>>).map { ProjectService.from(map = it) },
            protocols = (map["protocols"] as List<Map<String, Any>>).map { ProjectProtocol.from(map = it) },
            region = map["region"] as String,
            billingLimits = BillingLimits.from(map = map["billingLimits"] as Map<String, Any>),
            blocks = (map["blocks"] as List<Map<String, Any>>).map { Block.from(map = it) },
            consoleAccessedAt = map["consoleAccessedAt"] as String,
        )
    }
}