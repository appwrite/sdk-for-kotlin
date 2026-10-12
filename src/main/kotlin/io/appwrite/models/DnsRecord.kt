package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * DNSRecord
 */
data class DnsRecord(
    /**
     * DNS Record ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * DNS Record creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * DNS Record update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * DNS record type (e.g. A, CNAME, MX).
     */
    @SerializedName("type")
    val type: String,

    /**
     * Record name or subdomain.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Value of the record (IP address, domain, etc.).
     */
    @SerializedName("value")
    val value: String,

    /**
     * Time to live (in seconds).
     */
    @SerializedName("ttl")
    val ttl: Long,

    /**
     * Record priority (commonly used for MX).
     */
    @SerializedName("priority")
    val priority: Long,

    /**
     * Whether this record is locked (read-only).
     */
    @SerializedName("lock")
    val lock: Boolean,

    /**
     * Record weight (used for SRV records).
     */
    @SerializedName("weight")
    val weight: Long,

    /**
     * Target port (used for SRV records).
     */
    @SerializedName("port")
    val port: Long,

    /**
     * Comment for the DNS record.
     */
    @SerializedName("comment")
    val comment: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "type" to type as Any,
        "name" to name as Any,
        "value" to value as Any,
        "ttl" to ttl as Any,
        "priority" to priority as Any,
        "lock" to lock as Any,
        "weight" to weight as Any,
        "port" to port as Any,
        "comment" to comment as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DnsRecord(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            value = (if (map.containsKey("value")) map["value"] else "") as String,
            ttl = ((if (map.containsKey("ttl")) map["ttl"] else 3600) as Number).toLong(),
            priority = ((if (map.containsKey("priority")) map["priority"] else 0) as Number).toLong(),
            lock = (if (map.containsKey("lock")) map["lock"] else false) as Boolean,
            weight = ((if (map.containsKey("weight")) map["weight"] else 0) as Number).toLong(),
            port = ((if (map.containsKey("port")) map["port"] else 0) as Number).toLong(),
            comment = (if (map.containsKey("comment")) map["comment"] else "") as String,
        )
    }
}
