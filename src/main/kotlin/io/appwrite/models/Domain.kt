package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.DomainTransferStatusEnum
import io.appwrite.extensions.jsonCast

/**
 * Domain
 */
data class Domain(
    /**
     * Domain ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Domain creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Domain update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Domain name.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * Domain registrar (e.g. "appwrite" or "third_party").
     */
    @SerializedName("registrar")
    val registrar: String,

    /**
     * Nameservers setting. "Appwrite" or empty string.
     */
    @SerializedName("nameservers")
    val nameservers: String,

    /**
     * Domain expiry date in ISO 8601 format.
     */
    @SerializedName("expire")
    val expire: String,

    /**
     * Domain renewal date in ISO 8601 format.
     */
    @SerializedName("renewal")
    val renewal: String,

    /**
     * If set to true, the domain will automatically renew.
     */
    @SerializedName("autoRenewal")
    val autoRenewal: Boolean,

    /**
     * Renewal price (in cents).
     */
    @SerializedName("renewalPrice")
    val renewalPrice: Long,

    /**
     * Transfer status for domains being transferred in. Null when the domain is not being transferred.
     */
    @SerializedName("transferStatus")
    var transferStatus: DomainTransferStatusEnum?,

    /**
     * Team ID.
     */
    @SerializedName("teamId")
    val teamId: String,

    /**
     * Dns records
     */
    @SerializedName("dnsRecords")
    val dnsRecords: List<DnsRecord>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "domain" to domain as Any,
        "registrar" to registrar as Any,
        "nameservers" to nameservers as Any,
        "expire" to expire as Any,
        "renewal" to renewal as Any,
        "autoRenewal" to autoRenewal as Any,
        "renewalPrice" to renewalPrice as Any,
        "transferStatus" to transferStatus?.value as Any?,
        "teamId" to teamId as Any,
        "dnsRecords" to dnsRecords.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Domain(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            domain = (if (map.containsKey("domain")) map["domain"] else "") as String,
            registrar = (if (map.containsKey("registrar")) map["registrar"] else "") as String,
            nameservers = (if (map.containsKey("nameservers")) map["nameservers"] else "") as String,
            expire = (if (map.containsKey("expire")) map["expire"] else "") as String,
            renewal = (if (map.containsKey("renewal")) map["renewal"] else "") as String,
            autoRenewal = (if (map.containsKey("autoRenewal")) map["autoRenewal"] else false) as Boolean,
            renewalPrice = ((if (map.containsKey("renewalPrice")) map["renewalPrice"] else 0) as Number).toLong(),
            transferStatus = DomainTransferStatusEnum.values().find { it.value == (map["transferStatus"] as? String) },
            teamId = (if (map.containsKey("teamId")) map["teamId"] else "") as String,
            dnsRecords = ((if (map.containsKey("dnsRecords")) map["dnsRecords"] else listOf<Any?>()) as List<Map<String, Any>>).map { DnsRecord.from(map = it) },
        )
    }
}
