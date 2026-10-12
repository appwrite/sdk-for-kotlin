package io.appwrite.services

import io.appwrite.Client
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import io.appwrite.models.*
import okhttp3.Cookie
import java.io.File

/**
 *
 */
class Domains(client: Client) : Service(client) {
    /**
     * List all domains registered for this project. This endpoint supports pagination.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on attributes such as domain name, teamInternalId, expiration, etc.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DomainsList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.DomainsList {
        val apiPath = "/domains"
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DomainsList = {
            io.appwrite.models.DomainsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DomainsList::class.java,
            converter,
        )
    }

    /**
     * Create a new domain. Before creating a domain, you need to ensure that your DNS provider is properly configured. After creating the domain, you can use the verification endpoint to check if the domain is ready to be used.
     *
     * @param teamId Team unique ID.
     * @param domain Domain name (e.g. "example.com").
     * @return [io.appwrite.models.Domain]
     */
    @Throws(AppwriteException::class)
    suspend fun create(
        teamId: String,
        domain: String,
    ): io.appwrite.models.Domain {
        val apiPath = "/domains"
        val apiParams = mutableMapOf<String, Any?>(
            "teamId" to teamId,
            "domain" to domain,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }

    /**
     * Get the registration price for a domain name.
     *
     * @param domain Domain name to get price for.
     * @param periodYears Number of years to calculate the domain price for. Must be at least 1.
     * @param registrationType Type of registration pricing to fetch. Allowed values: new, transfer, renewal, trade.
     * @return [io.appwrite.models.DomainPrice]
     */
    @Deprecated(
        message = "This API has been deprecated since 2.0.0. Please use `Domains.listPrices` instead.",
        replaceWith = ReplaceWith("io.appwrite.services.Domains.listPrices")
    )
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getPrice(
        domain: String,
        periodYears: Long? = null,
        registrationType: io.appwrite.enums.DomainRegistrationType? = null,
    ): io.appwrite.models.DomainPrice {
        val apiPath = "/domains/price"
        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "periodYears" to periodYears,
            "registrationType" to registrationType,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DomainPrice = {
            io.appwrite.models.DomainPrice.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DomainPrice::class.java,
            converter,
        )
    }

    /**
     * Check availability and get the requested registration price for one or more domain names. Availability is resolved for all domains in a single registrar lookup. Unavailable domains have a null price for new registrations, but can still be priced for renewal, transfer, or trade. Every priced domain also carries its renewal price for the same period, so a separate renewal lookup is not needed. A domain whose price could not be resolved, for example because its TLD is not supported, is returned with a null price.
     *
     * @param domains Domain names to check availability and price for. Maximum of 50 domains per request.
     * @param periodYears Number of years to calculate the domain price for. Must be at least 1.
     * @param registrationType Type of registration pricing to fetch. Allowed values: new, transfer, renewal, trade.
     * @return [io.appwrite.models.DomainPricesList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listPrices(
        domains: List<String>,
        periodYears: Long? = null,
        registrationType: io.appwrite.enums.DomainRegistrationType? = null,
    ): io.appwrite.models.DomainPricesList {
        val apiPath = "/domains/prices"
        val apiParams = mutableMapOf<String, Any?>(
            "domains" to domains,
            "periodYears" to periodYears,
            "registrationType" to registrationType,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DomainPricesList = {
            io.appwrite.models.DomainPricesList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DomainPricesList::class.java,
            converter,
        )
    }

    /**
     * Get a domain by its unique ID.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.Domain]
     */
    @Throws(AppwriteException::class)
    suspend fun get(
        domainId: String,
    ): io.appwrite.models.Domain {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }

    /**
     * Delete a domain by its unique ID. This endpoint can be used to delete a domain from your project.
     * Once deleted, the domain will no longer be available for use and all associated resources will be removed.
     *
     * @param domainId Domain unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        domainId: String,
    ): Any {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
     * Update the registrar nameservers for the given domain. When nameservers are not provided,
     * the domain will be updated to use Appwrite nameservers.
     *
     * @param domainId Domain unique ID.
     * @param nameservers Nameservers to set for the domain. Defaults to Appwrite nameservers when omitted.
     * @return [io.appwrite.models.Domain]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateNameservers(
        domainId: String,
        nameservers: List<String>? = null,
    ): io.appwrite.models.Domain {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/nameservers"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "nameservers" to nameservers,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }

    /**
     * Verify which NS records are used and update the domain accordingly. This will check the domain's
     * nameservers and update the domain's status based on whether the nameservers match the expected
     * Appwrite nameservers.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.Domain]
     */
    @Throws(AppwriteException::class)
    suspend fun verifyNameservers(
        domainId: String,
    ): io.appwrite.models.Domain {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/nameservers/verification"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }

    /**
     * List Google Workspace DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetGoogleWorkspace(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/google-workspace"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add Google Workspace DNS records to the domain. This will create the required MX records
     * for Google Workspace email hosting.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetGoogleWorkspace(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/google-workspace"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List iCloud DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetICloud(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/icloud"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add iCloud DNS records to the domain. This will create the required MX and SPF records
     * for using iCloud email services with your domain.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetICloud(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/icloud"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List Mailgun DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetMailgun(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/mailgun"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add Mailgun DNS records to the domain. This endpoint will create the required DNS records
     * for Mailgun in the specified domain.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetMailgun(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/mailgun"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List Outlook DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetOutlook(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/outlook"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add Outlook DNS records to the domain. This will create the required MX records
     * for setting up Outlook email hosting for your domain.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetOutlook(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/outlook"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List ProtonMail DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetProtonMail(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/proton-mail"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add ProtonMail DNS records to the domain. This will create the required MX records
     * for using ProtonMail with your custom domain.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetProtonMail(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/proton-mail"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List Zoho DNS records.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun getPresetZoho(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/zoho"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Add Zoho Mail DNS records to the domain. This will create the required MX records
     * for setting up Zoho Mail on your domain.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @Throws(AppwriteException::class)
    suspend fun createPresetZoho(
        domainId: String,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/presets/zoho"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * List DNS records for a given domain. You can use this endpoint to list all the DNS records
     * associated with your domain.
     *
     * @param domainId Domain unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. You may filter on attributes such as type, name, value, etc. Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.DnsRecordsList]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listRecords(
        domainId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.DnsRecordsList {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecordsList = {
            io.appwrite.models.DnsRecordsList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecordsList::class.java,
            converter,
        )
    }

    /**
     * Create a new A record for the given domain. A records are used to point a domain name
     * to an IPv4 address. The record value should be a valid IPv4 address.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value IPv4 address for this A record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment explaining what this record is for.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordA(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/a"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing A record for the given domain. This endpoint allows you to modify
     * the properties of an A record including its name (subdomain), IPv4 address, TTL,
     * and optional comment.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value IPv4 address for this A record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment explaining what this record is for.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordA(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/a/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new AAAA record for the given domain. This endpoint allows you to add a new IPv6 DNS record
     * to your domain. The record will be used to point a hostname to an IPv6 address.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value IPv6 address for this AAAA record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment explaining what this record is for.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordAAAA(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/aaaa"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing AAAA record for the given domain. This endpoint allows you to modify
     * the properties of an existing AAAA record, including its name (subdomain), IPv6 address,
     * TTL, and optional comment.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value IPv6 address for this AAAA record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordAAAA(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/aaaa/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new ALIAS record for the given domain. This record type can be used to point your domain
     * to another domain name that will serve as an alias. This is particularly useful when you want to
     * map your domain to a target domain that may change its IP address.
     *
     * @param domainId Domain unique ID.
     * @param name Record name.
     * @param value Target domain for this ALIAS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordAlias(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/alias"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing ALIAS record for the specified domain. This endpoint allows you to modify
     * the properties of an existing ALIAS record including its name, target domain, TTL, and comment.
     *
     * The ALIAS record type is similar to a CNAME record but can be used at the zone apex (root domain).
     * It provides a way to map one domain name to another.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name.
     * @param value Target domain for this ALIAS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordAlias(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/alias/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new CAA record for the given domain. CAA records are used to specify which
     * Certificate Authorities (CAs) are allowed to issue SSL/TLS certificates for your domain.
     *
     * @param domainId Domain unique ID.
     * @param name Record name.
     * @param value CAA value (e.g. issuer domain).
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordCAA(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/caa"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing CAA record for the given domain. A CAA (Certification Authority Authorization)
     * record is used to specify which certificate authorities (CAs) are authorized to issue certificates
     * for a domain.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name.
     * @param value CAA value (e.g. issuer domain).
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordCAA(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/caa/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new CNAME record for the given domain.
     *
     * A CNAME record maps a subdomain to another domain name, allowing you to create aliases
     * for your domain. For example, you can create a CNAME record to point 'blog.example.com'
     * to 'example.wordpress.com'.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value Canonical target for this CNAME record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordCNAME(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/cname"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing CNAME record for the given domain.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value Canonical target for this CNAME record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordCNAME(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/cname/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new HTTPS record for the given domain. This record is used to configure HTTPS
     * settings for your domain, enabling secure communication over SSL/TLS.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value Target for the HTTPS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordHTTPS(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/https"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing HTTPS record for the given domain. This endpoint allows you to modify
     * the properties of an HTTPS record associated with your domain, including the name (subdomain),
     * target value, TTL, and optional comment.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value Target for the HTTPS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordHTTPS(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/https/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new MX record for the given domain. MX records are used to define the mail servers responsible
     * for accepting email messages for the domain. Multiple MX records can be created with different priorities.
     * The priority parameter determines the order in which mail servers are used, with lower values indicating
     * higher priority.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value Mail server domain for this MX record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param priority MX priority. Lower values are tried first.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordMX(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        priority: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/mx"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "priority" to priority,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing MX record for the given domain.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value Mail server domain for this MX record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param priority MX priority. Lower values are tried first.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordMX(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        priority: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/mx/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "priority" to priority,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new NS record for the given domain. NS records specify the nameservers that are used
     * to resolve the domain name to IP addresses. Each domain can have multiple NS records.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain).
     * @param value Nameserver target for this NS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordNS(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/ns"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing NS record for the given domain. This endpoint allows you to modify
     * the properties of an NS (nameserver) record associated with your domain. You can update
     * the record name (subdomain), target nameserver value, TTL, and add or modify comments
     * for better record management.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain).
     * @param value Nameserver target for this NS record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordNS(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/ns/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new SRV record for the given domain. SRV records are used to define the location
     * of servers for specific services. For example, they can be used to specify which server
     * handles a specific service like SIP or XMPP for the domain.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (service name).
     * @param value Target hostname for this SRV record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param priority Record priority. Lower values are tried first.
     * @param weight Record weight, used to share load between targets of equal priority.
     * @param port Port number for the service.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordSRV(
        domainId: String,
        name: String,
        value: String,
        ttl: Long,
        priority: Long,
        weight: Long,
        port: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/srv"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "priority" to priority,
            "weight" to weight,
            "port" to port,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing SRV record for the given domain.
     *
     * Required parameters:
     * - domainId: Domain unique ID
     * - recordId: DNS record unique ID
     * - name: Record name (service name)
     * - value: Target hostname for this SRV record
     * - ttl: Time to live, in seconds
     * - priority: Record priority
     * - weight: Record weight
     * - port: Port number for the service
     *
     * Optional parameters:
     * - comment: A comment for this record
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (service name).
     * @param value Target hostname for this SRV record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param priority Record priority. Lower values are tried first.
     * @param weight Record weight, used to share load between targets of equal priority.
     * @param port Port number for the service.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordSRV(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        priority: Long,
        weight: Long,
        port: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/srv/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "priority" to priority,
            "weight" to weight,
            "port" to port,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Create a new TXT record for the given domain. TXT records can be used
     * to provide additional information about your domain, such as domain
     * verification records, SPF records, or DKIM records.
     *
     * @param domainId Domain unique ID.
     * @param name Record name (subdomain) for the TXT record.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param value TXT record value.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createRecordTXT(
        domainId: String,
        name: String,
        ttl: Long,
        value: String? = null,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/records/txt"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Update an existing TXT record for the given domain.
     *
     * Update the TXT record details for a specific domain by providing the domain ID,
     * record ID, and the new record configuration including name, value, TTL, and an optional comment.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @param name Record name (subdomain) for the TXT record.
     * @param value TXT record value.
     * @param ttl Time to live, in seconds. Must be between 1 and 2147483647.
     * @param comment A comment for this record.
     * @return [io.appwrite.models.DnsRecord]
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateRecordTXT(
        domainId: String,
        recordId: String,
        name: String,
        value: String,
        ttl: Long,
        comment: String? = null,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/txt/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "value" to value,
            "ttl" to ttl,
            "comment" to comment,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Get a single DNS record for a given domain by record ID.
     *
     * This endpoint allows you to retrieve a specific DNS record associated with a domain
     * using its unique identifier. The record contains information about the DNS configuration
     * such as type, value, and TTL settings.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @return [io.appwrite.models.DnsRecord]
     */
    @Throws(AppwriteException::class)
    suspend fun getRecord(
        domainId: String,
        recordId: String,
    ): io.appwrite.models.DnsRecord {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DnsRecord = {
            io.appwrite.models.DnsRecord.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DnsRecord::class.java,
            converter,
        )
    }

    /**
     * Delete a DNS record for the given domain. This endpoint allows you to delete an existing DNS record
     * from a specific domain.
     *
     * @param domainId Domain unique ID.
     * @param recordId DNS record unique ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun deleteRecord(
        domainId: String,
        recordId: String,
    ): Any {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        if (recordId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"recordId\"")
        }
        val apiPath = ("/domains/{domainId}/records/{recordId}"
            .replace("{domainId}", domainId)
            .replace("{recordId}", recordId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
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
     * Update the team ID for a specific domain. The caller must administer the current
     * team and be an owner of the destination team.
     *
     * Updating the team ID will transfer ownership and access control of the domain
     * and all its DNS records to the new team.
     *
     * @param domainId Domain unique ID.
     * @param teamId New team unique ID.
     * @return [io.appwrite.models.Domain]
     */
    @Throws(AppwriteException::class)
    suspend fun updateTeam(
        domainId: String,
        teamId: String,
    ): io.appwrite.models.Domain {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/team"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "teamId" to teamId,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }

    /**
     * Retrieve the current transfer status for a domain. Returns the status, an optional reason, and a timestamp of the last status change.
     *
     * @param domainId Domain unique ID.
     * @return [io.appwrite.models.DomainTransferStatus]
     */
    @Throws(AppwriteException::class)
    suspend fun getTransferStatus(
        domainId: String,
    ): io.appwrite.models.DomainTransferStatus {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/transfers/status"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.DomainTransferStatus = {
            io.appwrite.models.DomainTransferStatus.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DomainTransferStatus::class.java,
            converter,
        )
    }

    /**
     * Retrieve the DNS zone file for the given domain. This endpoint will return the DNS
     * zone file in a standardized format that can be used to configure DNS servers.
     *
     * @param domainId Domain unique ID.
     * @return [String]
     */
    @Throws(AppwriteException::class)
    suspend fun getZone(
        domainId: String,
    ): String {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/zone"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "accept" to "text/plain",
        )
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = String::class.java,
        )
    }

    /**
     * Update the DNS zone for the given domain using the provided zone file content.
     * All parsed records are imported and then the main domain document is returned.
     *
     * @param domainId Domain unique ID.
     * @param content DNS zone file content as a string.
     * @return [io.appwrite.models.Domain]
     */
    @Throws(AppwriteException::class)
    suspend fun updateZone(
        domainId: String,
        content: String,
    ): io.appwrite.models.Domain {
        if (domainId.isEmpty()) {
            throw AppwriteException("Missing required parameter: \"domainId\"")
        }
        val apiPath = ("/domains/{domainId}/zone"
            .replace("{domainId}", domainId)
        )
        val apiParams = mutableMapOf<String, Any?>(
            "content" to content,
        )
        val apiHeaders = mutableMapOf<String, String>(
            "X-Appwrite-Project" to client.config["project"].orEmpty(),
            "content-type" to "application/json",
            "accept" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Domain = {
            io.appwrite.models.Domain.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Domain::class.java,
            converter,
        )
    }
}
