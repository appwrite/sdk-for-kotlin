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
     * Project region
     */
    @SerializedName("region")
    val region: String,

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
     * Stage progress (completed or skipped) with timestamps and actor types, keyed by stage id.
     */
    @SerializedName("onboarding")
    val onboarding: Any,

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
     * Project blocks information
     */
    @SerializedName("blocks")
    val blocks: List<Block>,

    /**
     * Last time the project was accessed via console. Used with plan's projectInactivityDays to determine if project is paused.
     */
    @SerializedName("consoleAccessedAt")
    val consoleAccessedAt: String,

    /**
     * Billing limits reached
     */
    @SerializedName("billingLimits")
    var billingLimits: BillingLimits?,

    /**
     * OAuth2 server status
     */
    @SerializedName("oAuth2ServerEnabled")
    var oAuth2ServerEnabled: Boolean?,

    /**
     * OAuth2 server authorization URL
     */
    @SerializedName("oAuth2ServerAuthorizationUrl")
    var oAuth2ServerAuthorizationUrl: String?,

    /**
     * OAuth2 server allowed scopes
     */
    @SerializedName("oAuth2ServerScopes")
    var oAuth2ServerScopes: List<String>?,

    /**
     * OAuth2 server scopes used when an authorization request omits the scope parameter
     */
    @SerializedName("oAuth2ServerDefaultScopes")
    var oAuth2ServerDefaultScopes: List<String>?,

    /**
     * OAuth2 server accepted RFC 9396 authorization_details types
     */
    @SerializedName("oAuth2ServerAuthorizationDetailsTypes")
    var oAuth2ServerAuthorizationDetailsTypes: List<String>?,

    /**
     * OAuth2 server access token duration in seconds for confidential clients
     */
    @SerializedName("oAuth2ServerAccessTokenDuration")
    var oAuth2ServerAccessTokenDuration: Long?,

    /**
     * OAuth2 server refresh token duration in seconds for confidential clients
     */
    @SerializedName("oAuth2ServerRefreshTokenDuration")
    var oAuth2ServerRefreshTokenDuration: Long?,

    /**
     * OAuth2 server access token duration in seconds for public clients (SPAs, mobile, native)
     */
    @SerializedName("oAuth2ServerPublicAccessTokenDuration")
    var oAuth2ServerPublicAccessTokenDuration: Long?,

    /**
     * OAuth2 server refresh token duration in seconds for public clients (SPAs, mobile, native)
     */
    @SerializedName("oAuth2ServerPublicRefreshTokenDuration")
    var oAuth2ServerPublicRefreshTokenDuration: Long?,

    /**
     * When enabled, PKCE is required for confidential clients (server-side flows using client_secret). PKCE is always required for public clients regardless of this setting.
     */
    @SerializedName("oAuth2ServerConfidentialPkce")
    var oAuth2ServerConfidentialPkce: Boolean?,

    /**
     * URL to your application page where users enter the device flow user code. Empty when the Device Authorization Grant is not configured.
     */
    @SerializedName("oAuth2ServerVerificationUrl")
    var oAuth2ServerVerificationUrl: String?,

    /**
     * Number of characters in the device flow user code, excluding the formatting separator.
     */
    @SerializedName("oAuth2ServerUserCodeLength")
    var oAuth2ServerUserCodeLength: Long?,

    /**
     * Character set for device flow user codes: `numeric`, `alphabetic`, or `alphanumeric`.
     */
    @SerializedName("oAuth2ServerUserCodeFormat")
    var oAuth2ServerUserCodeFormat: String?,

    /**
     * Lifetime in seconds of device flow device codes and user codes.
     */
    @SerializedName("oAuth2ServerDeviceCodeDuration")
    var oAuth2ServerDeviceCodeDuration: Long?,

    /**
     * OAuth2 server discovery URL
     */
    @SerializedName("oAuth2ServerDiscoveryUrl")
    var oAuth2ServerDiscoveryUrl: String?,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "teamId" to teamId as Any,
        "region" to region as Any,
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
        "onboarding" to onboarding as Any,
        "authMethods" to authMethods.map { it.toMap() } as Any,
        "services" to services.map { it.toMap() } as Any,
        "protocols" to protocols.map { it.toMap() } as Any,
        "blocks" to blocks.map { it.toMap() } as Any,
        "consoleAccessedAt" to consoleAccessedAt as Any,
        "billingLimits" to billingLimits?.toMap() as Any,
        "oAuth2ServerEnabled" to oAuth2ServerEnabled as Any,
        "oAuth2ServerAuthorizationUrl" to oAuth2ServerAuthorizationUrl as Any,
        "oAuth2ServerScopes" to oAuth2ServerScopes as Any,
        "oAuth2ServerDefaultScopes" to oAuth2ServerDefaultScopes as Any,
        "oAuth2ServerAuthorizationDetailsTypes" to oAuth2ServerAuthorizationDetailsTypes as Any,
        "oAuth2ServerAccessTokenDuration" to oAuth2ServerAccessTokenDuration as Any,
        "oAuth2ServerRefreshTokenDuration" to oAuth2ServerRefreshTokenDuration as Any,
        "oAuth2ServerPublicAccessTokenDuration" to oAuth2ServerPublicAccessTokenDuration as Any,
        "oAuth2ServerPublicRefreshTokenDuration" to oAuth2ServerPublicRefreshTokenDuration as Any,
        "oAuth2ServerConfidentialPkce" to oAuth2ServerConfidentialPkce as Any,
        "oAuth2ServerVerificationUrl" to oAuth2ServerVerificationUrl as Any,
        "oAuth2ServerUserCodeLength" to oAuth2ServerUserCodeLength as Any,
        "oAuth2ServerUserCodeFormat" to oAuth2ServerUserCodeFormat as Any,
        "oAuth2ServerDeviceCodeDuration" to oAuth2ServerDeviceCodeDuration as Any,
        "oAuth2ServerDiscoveryUrl" to oAuth2ServerDiscoveryUrl as Any,
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
            region = map["region"] as String,
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
            onboarding = map["onboarding"] as Any,
            authMethods = (map["authMethods"] as List<Map<String, Any>>).map { ProjectAuthMethod.from(map = it) },
            services = (map["services"] as List<Map<String, Any>>).map { ProjectService.from(map = it) },
            protocols = (map["protocols"] as List<Map<String, Any>>).map { ProjectProtocol.from(map = it) },
            blocks = (map["blocks"] as List<Map<String, Any>>).map { Block.from(map = it) },
            consoleAccessedAt = map["consoleAccessedAt"] as String,
            billingLimits = (map["billingLimits"] as? Map<String, Any>)?.let { BillingLimits.from(map = it) },
            oAuth2ServerEnabled = map["oAuth2ServerEnabled"] as? Boolean,
            oAuth2ServerAuthorizationUrl = map["oAuth2ServerAuthorizationUrl"] as? String,
            oAuth2ServerScopes = map["oAuth2ServerScopes"] as? List<String>,
            oAuth2ServerDefaultScopes = map["oAuth2ServerDefaultScopes"] as? List<String>,
            oAuth2ServerAuthorizationDetailsTypes = map["oAuth2ServerAuthorizationDetailsTypes"] as? List<String>,
            oAuth2ServerAccessTokenDuration = (map["oAuth2ServerAccessTokenDuration"] as? Number)?.toLong(),
            oAuth2ServerRefreshTokenDuration = (map["oAuth2ServerRefreshTokenDuration"] as? Number)?.toLong(),
            oAuth2ServerPublicAccessTokenDuration = (map["oAuth2ServerPublicAccessTokenDuration"] as? Number)?.toLong(),
            oAuth2ServerPublicRefreshTokenDuration = (map["oAuth2ServerPublicRefreshTokenDuration"] as? Number)?.toLong(),
            oAuth2ServerConfidentialPkce = map["oAuth2ServerConfidentialPkce"] as? Boolean,
            oAuth2ServerVerificationUrl = map["oAuth2ServerVerificationUrl"] as? String,
            oAuth2ServerUserCodeLength = (map["oAuth2ServerUserCodeLength"] as? Number)?.toLong(),
            oAuth2ServerUserCodeFormat = map["oAuth2ServerUserCodeFormat"] as? String,
            oAuth2ServerDeviceCodeDuration = (map["oAuth2ServerDeviceCodeDuration"] as? Number)?.toLong(),
            oAuth2ServerDiscoveryUrl = map["oAuth2ServerDiscoveryUrl"] as? String,
        )
    }
}