package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast
import io.appwrite.enums.DatabaseType
import io.appwrite.enums.DatabaseStatus

/**
 * Database
 */
data class Database(
    /**
     * Database ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Database name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Database creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Database update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * If database is enabled. Can be 'enabled' or 'disabled'. When disabled, the database is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Database type.
     */
    @SerializedName("type")
    val type: DatabaseType,

    /**
     * Dedicated database lifecycle status. Null when the database has no valid dedicated backing.
     */
    @SerializedName("status")
    var status: DatabaseStatus?,

    /**
     * Underlying engine of the dedicated backing: postgresql, mysql, mariadb, or mongodb. A managed product (tablesdb, documentsdb, vectorsdb) reports the engine it runs on, so its type and engine can differ. Null when the database has no dedicated backing.
     */
    @SerializedName("engine")
    var engine: String?,

    /**
     * Compute specification identifier of the dedicated backing, e.g. s-2vcpu-2gb. Null when the database has no dedicated backing.
     */
    @SerializedName("specification")
    var specification: String?,

    /**
     * Number of secondary high availability replicas, excluding the primary. Null when backing configuration is unavailable.
     */
    @SerializedName("replicas")
    var replicas: Long?,

    /**
     * Database backup policies.
     */
    @SerializedName("policies")
    var policies: List<BackupPolicy>?,

    /**
     * Database backup archives.
     */
    @SerializedName("archives")
    var archives: List<BackupArchive>?,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "name" to name as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "enabled" to enabled as Any,
        "type" to type.value as Any,
        "status" to status?.value as Any?,
        "engine" to engine as Any?,
        "specification" to specification as Any?,
        "replicas" to replicas as Any?,
        "policies" to policies?.map { it.toMap() } as Any?,
        "archives" to archives?.map { it.toMap() } as Any?,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Database(
            id = map["\$id"] as String,
            name = map["name"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            enabled = map["enabled"] as Boolean,
            type = DatabaseType.values().find { it.value == map["type"] as String }!!,
            status = DatabaseStatus.values().find { it.value == (map["status"] as? String) },
            engine = map["engine"] as? String,
            specification = map["specification"] as? String,
            replicas = (map["replicas"] as? Number)?.toLong(),
            policies = (map["policies"] as? List<Map<String, Any>>)?.map { BackupPolicy.from(map = it) },
            archives = (map["archives"] as? List<Map<String, Any>>)?.map { BackupArchive.from(map = it) },
        )
    }
}
