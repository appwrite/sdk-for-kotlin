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
     * Project description.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Project team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Project logo file ID.
     */
    @SerializedName("logo")
    val logo: String,

    /**
     * Project website URL.
     */
    @SerializedName("url")
    val url: String,

    /**
     * Company legal name.
     */
    @SerializedName("legalName")
    val legalName: String,

    /**
     * Country code in [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1) two-character format.
     */
    @SerializedName("legalCountry")
    val legalCountry: String,

    /**
     * State name.
     */
    @SerializedName("legalState")
    val legalState: String,

    /**
     * City name.
     */
    @SerializedName("legalCity")
    val legalCity: String,

    /**
     * Company Address.
     */
    @SerializedName("legalAddress")
    val legalAddress: String,

    /**
     * Company Tax ID.
     */
    @SerializedName("legalTaxId")
    val legalTaxId: String,

    /**
     * Session duration in seconds.
     */
    @SerializedName("authDuration")
    val authDuration: Long,

    /**
     * Max users allowed. 0 is unlimited.
     */
    @SerializedName("authLimit")
    val authLimit: Long,

    /**
     * Max sessions allowed per user. 100 maximum.
     */
    @SerializedName("authSessionsLimit")
    val authSessionsLimit: Long,

    /**
     * Max allowed passwords in the history list per user. Max passwords limit allowed in history is 20. Use 0 for disabling password history.
     */
    @SerializedName("authPasswordHistory")
    val authPasswordHistory: Long,

    /**
     * Whether or not to check user's password against most commonly used passwords.
     */
    @SerializedName("authPasswordDictionary")
    val authPasswordDictionary: Boolean,

    /**
     * Whether or not to check the user password for similarity with their personal data.
     */
    @SerializedName("authPersonalDataCheck")
    val authPersonalDataCheck: Boolean,

    /**
     * Whether or not to disallow disposable email addresses during signup and email updates.
     */
    @SerializedName("authDisposableEmails")
    val authDisposableEmails: Boolean,

    /**
     * Whether or not to require canonical email addresses during signup and email updates.
     */
    @SerializedName("authCanonicalEmails")
    val authCanonicalEmails: Boolean,

    /**
     * Whether or not to disallow free email addresses during signup and email updates.
     */
    @SerializedName("authFreeEmails")
    val authFreeEmails: Boolean,

    /**
     * An array of mock numbers and their corresponding verification codes (OTPs).
     */
    @SerializedName("authMockNumbers")
    val authMockNumbers: List<MockNumber>,

    /**
     * Whether or not to send session alert emails to users.
     */
    @SerializedName("authSessionAlerts")
    val authSessionAlerts: Boolean,

    /**
     * Whether or not to show user names in the teams membership response.
     */
    @SerializedName("authMembershipsUserName")
    val authMembershipsUserName: Boolean,

    /**
     * Whether or not to show user emails in the teams membership response.
     */
    @SerializedName("authMembershipsUserEmail")
    val authMembershipsUserEmail: Boolean,

    /**
     * Whether or not to show user MFA status in the teams membership response.
     */
    @SerializedName("authMembershipsMfa")
    val authMembershipsMfa: Boolean,

    /**
     * Whether or not all existing sessions should be invalidated on password change
     */
    @SerializedName("authInvalidateSessions")
    val authInvalidateSessions: Boolean,

    /**
     * List of Auth Providers.
     */
    @SerializedName("oAuthProviders")
    val oAuthProviders: List<AuthProvider>,

    /**
     * List of Platforms.
     */
    @SerializedName("platforms")
    val platforms: List<Any>,

    /**
     * List of Webhooks.
     */
    @SerializedName("webhooks")
    val webhooks: List<Webhook>,

    /**
     * List of API Keys.
     */
    @SerializedName("keys")
    val keys: List<Key>,

    /**
     * List of dev keys.
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
     * SMTP reply to email
     */
    @SerializedName("smtpReplyTo")
    val smtpReplyTo: String,

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
     * SMTP server password
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
     * Email/Password auth method status
     */
    @SerializedName("authEmailPassword")
    val authEmailPassword: Boolean,

    /**
     * Magic URL auth method status
     */
    @SerializedName("authUsersAuthMagicURL")
    val authUsersAuthMagicURL: Boolean,

    /**
     * Email (OTP) auth method status
     */
    @SerializedName("authEmailOtp")
    val authEmailOtp: Boolean,

    /**
     * Anonymous auth method status
     */
    @SerializedName("authAnonymous")
    val authAnonymous: Boolean,

    /**
     * Invites auth method status
     */
    @SerializedName("authInvites")
    val authInvites: Boolean,

    /**
     * JWT auth method status
     */
    @SerializedName("authJWT")
    val authJWT: Boolean,

    /**
     * Phone auth method status
     */
    @SerializedName("authPhone")
    val authPhone: Boolean,

    /**
     * Account service status
     */
    @SerializedName("serviceStatusForAccount")
    val serviceStatusForAccount: Boolean,

    /**
     * Avatars service status
     */
    @SerializedName("serviceStatusForAvatars")
    val serviceStatusForAvatars: Boolean,

    /**
     * Databases (legacy) service status
     */
    @SerializedName("serviceStatusForDatabases")
    val serviceStatusForDatabases: Boolean,

    /**
     * TablesDB service status
     */
    @SerializedName("serviceStatusForTablesdb")
    val serviceStatusForTablesdb: Boolean,

    /**
     * Locale service status
     */
    @SerializedName("serviceStatusForLocale")
    val serviceStatusForLocale: Boolean,

    /**
     * Health service status
     */
    @SerializedName("serviceStatusForHealth")
    val serviceStatusForHealth: Boolean,

    /**
     * Project service status
     */
    @SerializedName("serviceStatusForProject")
    val serviceStatusForProject: Boolean,

    /**
     * Storage service status
     */
    @SerializedName("serviceStatusForStorage")
    val serviceStatusForStorage: Boolean,

    /**
     * Teams service status
     */
    @SerializedName("serviceStatusForTeams")
    val serviceStatusForTeams: Boolean,

    /**
     * Users service status
     */
    @SerializedName("serviceStatusForUsers")
    val serviceStatusForUsers: Boolean,

    /**
     * VCS service status
     */
    @SerializedName("serviceStatusForVcs")
    val serviceStatusForVcs: Boolean,

    /**
     * Sites service status
     */
    @SerializedName("serviceStatusForSites")
    val serviceStatusForSites: Boolean,

    /**
     * Functions service status
     */
    @SerializedName("serviceStatusForFunctions")
    val serviceStatusForFunctions: Boolean,

    /**
     * Proxy service status
     */
    @SerializedName("serviceStatusForProxy")
    val serviceStatusForProxy: Boolean,

    /**
     * GraphQL service status
     */
    @SerializedName("serviceStatusForGraphql")
    val serviceStatusForGraphql: Boolean,

    /**
     * Migrations service status
     */
    @SerializedName("serviceStatusForMigrations")
    val serviceStatusForMigrations: Boolean,

    /**
     * Messaging service status
     */
    @SerializedName("serviceStatusForMessaging")
    val serviceStatusForMessaging: Boolean,

    /**
     * REST protocol status
     */
    @SerializedName("protocolStatusForRest")
    val protocolStatusForRest: Boolean,

    /**
     * GraphQL protocol status
     */
    @SerializedName("protocolStatusForGraphql")
    val protocolStatusForGraphql: Boolean,

    /**
     * Websocket protocol status
     */
    @SerializedName("protocolStatusForWebsocket")
    val protocolStatusForWebsocket: Boolean,

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
        "description" to description as Any,
        "teamId" to teamId as Any,
        "logo" to logo as Any,
        "url" to url as Any,
        "legalName" to legalName as Any,
        "legalCountry" to legalCountry as Any,
        "legalState" to legalState as Any,
        "legalCity" to legalCity as Any,
        "legalAddress" to legalAddress as Any,
        "legalTaxId" to legalTaxId as Any,
        "authDuration" to authDuration as Any,
        "authLimit" to authLimit as Any,
        "authSessionsLimit" to authSessionsLimit as Any,
        "authPasswordHistory" to authPasswordHistory as Any,
        "authPasswordDictionary" to authPasswordDictionary as Any,
        "authPersonalDataCheck" to authPersonalDataCheck as Any,
        "authDisposableEmails" to authDisposableEmails as Any,
        "authCanonicalEmails" to authCanonicalEmails as Any,
        "authFreeEmails" to authFreeEmails as Any,
        "authMockNumbers" to authMockNumbers.map { it.toMap() } as Any,
        "authSessionAlerts" to authSessionAlerts as Any,
        "authMembershipsUserName" to authMembershipsUserName as Any,
        "authMembershipsUserEmail" to authMembershipsUserEmail as Any,
        "authMembershipsMfa" to authMembershipsMfa as Any,
        "authInvalidateSessions" to authInvalidateSessions as Any,
        "oAuthProviders" to oAuthProviders.map { it.toMap() } as Any,
        "platforms" to platforms as Any,
        "webhooks" to webhooks.map { it.toMap() } as Any,
        "keys" to keys.map { it.toMap() } as Any,
        "devKeys" to devKeys.map { it.toMap() } as Any,
        "smtpEnabled" to smtpEnabled as Any,
        "smtpSenderName" to smtpSenderName as Any,
        "smtpSenderEmail" to smtpSenderEmail as Any,
        "smtpReplyTo" to smtpReplyTo as Any,
        "smtpHost" to smtpHost as Any,
        "smtpPort" to smtpPort as Any,
        "smtpUsername" to smtpUsername as Any,
        "smtpPassword" to smtpPassword as Any,
        "smtpSecure" to smtpSecure as Any,
        "pingCount" to pingCount as Any,
        "pingedAt" to pingedAt as Any,
        "labels" to labels as Any,
        "status" to status as Any,
        "authEmailPassword" to authEmailPassword as Any,
        "authUsersAuthMagicURL" to authUsersAuthMagicURL as Any,
        "authEmailOtp" to authEmailOtp as Any,
        "authAnonymous" to authAnonymous as Any,
        "authInvites" to authInvites as Any,
        "authJWT" to authJWT as Any,
        "authPhone" to authPhone as Any,
        "serviceStatusForAccount" to serviceStatusForAccount as Any,
        "serviceStatusForAvatars" to serviceStatusForAvatars as Any,
        "serviceStatusForDatabases" to serviceStatusForDatabases as Any,
        "serviceStatusForTablesdb" to serviceStatusForTablesdb as Any,
        "serviceStatusForLocale" to serviceStatusForLocale as Any,
        "serviceStatusForHealth" to serviceStatusForHealth as Any,
        "serviceStatusForProject" to serviceStatusForProject as Any,
        "serviceStatusForStorage" to serviceStatusForStorage as Any,
        "serviceStatusForTeams" to serviceStatusForTeams as Any,
        "serviceStatusForUsers" to serviceStatusForUsers as Any,
        "serviceStatusForVcs" to serviceStatusForVcs as Any,
        "serviceStatusForSites" to serviceStatusForSites as Any,
        "serviceStatusForFunctions" to serviceStatusForFunctions as Any,
        "serviceStatusForProxy" to serviceStatusForProxy as Any,
        "serviceStatusForGraphql" to serviceStatusForGraphql as Any,
        "serviceStatusForMigrations" to serviceStatusForMigrations as Any,
        "serviceStatusForMessaging" to serviceStatusForMessaging as Any,
        "protocolStatusForRest" to protocolStatusForRest as Any,
        "protocolStatusForGraphql" to protocolStatusForGraphql as Any,
        "protocolStatusForWebsocket" to protocolStatusForWebsocket as Any,
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
            description = map["description"] as String,
            teamId = map["teamId"] as String,
            logo = map["logo"] as String,
            url = map["url"] as String,
            legalName = map["legalName"] as String,
            legalCountry = map["legalCountry"] as String,
            legalState = map["legalState"] as String,
            legalCity = map["legalCity"] as String,
            legalAddress = map["legalAddress"] as String,
            legalTaxId = map["legalTaxId"] as String,
            authDuration = (map["authDuration"] as Number).toLong(),
            authLimit = (map["authLimit"] as Number).toLong(),
            authSessionsLimit = (map["authSessionsLimit"] as Number).toLong(),
            authPasswordHistory = (map["authPasswordHistory"] as Number).toLong(),
            authPasswordDictionary = map["authPasswordDictionary"] as Boolean,
            authPersonalDataCheck = map["authPersonalDataCheck"] as Boolean,
            authDisposableEmails = map["authDisposableEmails"] as Boolean,
            authCanonicalEmails = map["authCanonicalEmails"] as Boolean,
            authFreeEmails = map["authFreeEmails"] as Boolean,
            authMockNumbers = (map["authMockNumbers"] as List<Map<String, Any>>).map { MockNumber.from(map = it) },
            authSessionAlerts = map["authSessionAlerts"] as Boolean,
            authMembershipsUserName = map["authMembershipsUserName"] as Boolean,
            authMembershipsUserEmail = map["authMembershipsUserEmail"] as Boolean,
            authMembershipsMfa = map["authMembershipsMfa"] as Boolean,
            authInvalidateSessions = map["authInvalidateSessions"] as Boolean,
            oAuthProviders = (map["oAuthProviders"] as List<Map<String, Any>>).map { AuthProvider.from(map = it) },
            platforms = map["platforms"] as List<Any>,
            webhooks = (map["webhooks"] as List<Map<String, Any>>).map { Webhook.from(map = it) },
            keys = (map["keys"] as List<Map<String, Any>>).map { Key.from(map = it) },
            devKeys = (map["devKeys"] as List<Map<String, Any>>).map { DevKey.from(map = it) },
            smtpEnabled = map["smtpEnabled"] as Boolean,
            smtpSenderName = map["smtpSenderName"] as String,
            smtpSenderEmail = map["smtpSenderEmail"] as String,
            smtpReplyTo = map["smtpReplyTo"] as String,
            smtpHost = map["smtpHost"] as String,
            smtpPort = (map["smtpPort"] as Number).toLong(),
            smtpUsername = map["smtpUsername"] as String,
            smtpPassword = map["smtpPassword"] as String,
            smtpSecure = map["smtpSecure"] as String,
            pingCount = (map["pingCount"] as Number).toLong(),
            pingedAt = map["pingedAt"] as String,
            labels = map["labels"] as List<String>,
            status = map["status"] as String,
            authEmailPassword = map["authEmailPassword"] as Boolean,
            authUsersAuthMagicURL = map["authUsersAuthMagicURL"] as Boolean,
            authEmailOtp = map["authEmailOtp"] as Boolean,
            authAnonymous = map["authAnonymous"] as Boolean,
            authInvites = map["authInvites"] as Boolean,
            authJWT = map["authJWT"] as Boolean,
            authPhone = map["authPhone"] as Boolean,
            serviceStatusForAccount = map["serviceStatusForAccount"] as Boolean,
            serviceStatusForAvatars = map["serviceStatusForAvatars"] as Boolean,
            serviceStatusForDatabases = map["serviceStatusForDatabases"] as Boolean,
            serviceStatusForTablesdb = map["serviceStatusForTablesdb"] as Boolean,
            serviceStatusForLocale = map["serviceStatusForLocale"] as Boolean,
            serviceStatusForHealth = map["serviceStatusForHealth"] as Boolean,
            serviceStatusForProject = map["serviceStatusForProject"] as Boolean,
            serviceStatusForStorage = map["serviceStatusForStorage"] as Boolean,
            serviceStatusForTeams = map["serviceStatusForTeams"] as Boolean,
            serviceStatusForUsers = map["serviceStatusForUsers"] as Boolean,
            serviceStatusForVcs = map["serviceStatusForVcs"] as Boolean,
            serviceStatusForSites = map["serviceStatusForSites"] as Boolean,
            serviceStatusForFunctions = map["serviceStatusForFunctions"] as Boolean,
            serviceStatusForProxy = map["serviceStatusForProxy"] as Boolean,
            serviceStatusForGraphql = map["serviceStatusForGraphql"] as Boolean,
            serviceStatusForMigrations = map["serviceStatusForMigrations"] as Boolean,
            serviceStatusForMessaging = map["serviceStatusForMessaging"] as Boolean,
            protocolStatusForRest = map["protocolStatusForRest"] as Boolean,
            protocolStatusForGraphql = map["protocolStatusForGraphql"] as Boolean,
            protocolStatusForWebsocket = map["protocolStatusForWebsocket"] as Boolean,
            region = map["region"] as String,
            billingLimits = BillingLimits.from(map = map["billingLimits"] as Map<String, Any>),
            blocks = (map["blocks"] as List<Map<String, Any>>).map { Block.from(map = it) },
            consoleAccessedAt = map["consoleAccessedAt"] as String,
        )
    }
}