package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * DNS records list
 */
data class DnsRecordsList(
    /**
     * Total number of dnsRecords that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of dnsRecords.
     */
    @SerializedName("dnsRecords")
    val dnsRecords: List<DnsRecord>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "dnsRecords" to dnsRecords.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DnsRecordsList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            dnsRecords = ((if (map.containsKey("dnsRecords")) map["dnsRecords"] else listOf<Any?>()) as List<Map<String, Any>>).map { DnsRecord.from(map = it) },
        )
    }
}
