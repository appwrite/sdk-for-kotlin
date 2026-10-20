package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Bucket
 */
data class Bucket(
    /**
     * Bucket ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Bucket creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Bucket update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Bucket permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("\$permissions")
    val permissions: List<String>,

    /**
     * Whether file-level security is enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerializedName("fileSecurity")
    val fileSecurity: Boolean,

    /**
     * Bucket name.
     */
    @SerializedName("name")
    val name: String,

    /**
     * Optional description for the bucket.
     */
    @SerializedName("description")
    val description: String,

    /**
     * Bucket enabled.
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Maximum file size supported.
     */
    @SerializedName("maximumFileSize")
    val maximumFileSize: Long,

    /**
     * Allowed file extensions.
     */
    @SerializedName("allowedFileExtensions")
    val allowedFileExtensions: List<String>,

    /**
     * Compression algorithm chosen for compression. Will be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd).
     */
    @SerializedName("compression")
    val compression: String,

    /**
     * Bucket is encrypted.
     */
    @SerializedName("encryption")
    val encryption: Boolean,

    /**
     * Virus scanning is enabled.
     */
    @SerializedName("antivirus")
    val antivirus: Boolean,

    /**
     * Image transformations are enabled.
     */
    @SerializedName("transformations")
    val transformations: Boolean,

    /**
     * Metadata such as location, device and capture time is removed from uploaded images.
     */
    @SerializedName("stripMetadata")
    val stripMetadata: Boolean,

    /**
     * Total size of this bucket in bytes.
     */
    @SerializedName("totalSize")
    val totalSize: Long,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "fileSecurity" to fileSecurity as Any,
        "name" to name as Any,
        "description" to description as Any,
        "enabled" to enabled as Any,
        "maximumFileSize" to maximumFileSize as Any,
        "allowedFileExtensions" to allowedFileExtensions as Any,
        "compression" to compression as Any,
        "encryption" to encryption as Any,
        "antivirus" to antivirus as Any,
        "transformations" to transformations as Any,
        "stripMetadata" to stripMetadata as Any,
        "totalSize" to totalSize as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Bucket(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            permissions = (if (map.containsKey("\$permissions")) map["\$permissions"] else listOf<Any?>()) as List<String>,
            fileSecurity = (if (map.containsKey("fileSecurity")) map["fileSecurity"] else false) as Boolean,
            name = (if (map.containsKey("name")) map["name"] else "") as String,
            description = (if (map.containsKey("description")) map["description"] else "") as String,
            enabled = (if (map.containsKey("enabled")) map["enabled"] else true) as Boolean,
            maximumFileSize = ((if (map.containsKey("maximumFileSize")) map["maximumFileSize"] else 0) as Number).toLong(),
            allowedFileExtensions = (if (map.containsKey("allowedFileExtensions")) map["allowedFileExtensions"] else listOf<Any?>()) as List<String>,
            compression = (if (map.containsKey("compression")) map["compression"] else "") as String,
            encryption = (if (map.containsKey("encryption")) map["encryption"] else true) as Boolean,
            antivirus = (if (map.containsKey("antivirus")) map["antivirus"] else true) as Boolean,
            transformations = (if (map.containsKey("transformations")) map["transformations"] else true) as Boolean,
            stripMetadata = (if (map.containsKey("stripMetadata")) map["stripMetadata"] else false) as Boolean,
            totalSize = ((if (map.containsKey("totalSize")) map["totalSize"] else 0) as Number).toLong(),
        )
    }
}
