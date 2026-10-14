package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * BackupStorageConfig
 */
data class DedicatedDatabaseBackupStorage(
    /**
     * Storage provider. Possible values: s3 (Amazon S3 or S3-compatible), gcs (Google Cloud Storage), azure (Azure Blob Storage).
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * Storage bucket or container name.
     */
    @SerializedName("bucket")
    val bucket: String,

    /**
     * Storage region.
     */
    @SerializedName("region")
    val region: String,

    /**
     * Object key prefix for backups.
     */
    @SerializedName("prefix")
    val prefix: String,

    /**
     * Custom endpoint for S3-compatible storage.
     */
    @SerializedName("endpoint")
    val endpoint: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "provider" to provider as Any,
        "bucket" to bucket as Any,
        "region" to region as Any,
        "prefix" to prefix as Any,
        "endpoint" to endpoint as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseBackupStorage(
            provider = (if (map.containsKey("provider")) map["provider"] else "") as String,
            bucket = (if (map.containsKey("bucket")) map["bucket"] else "") as String,
            region = (if (map.containsKey("region")) map["region"] else "") as String,
            prefix = (if (map.containsKey("prefix")) map["prefix"] else "backups/") as String,
            endpoint = (if (map.containsKey("endpoint")) map["endpoint"] else "") as String,
        )
    }
}
