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
     * Compression algorithm choosen for compression. Will be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd).
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

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "fileSecurity" to fileSecurity as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "maximumFileSize" to maximumFileSize as Any,
        "allowedFileExtensions" to allowedFileExtensions as Any,
        "compression" to compression as Any,
        "encryption" to encryption as Any,
        "antivirus" to antivirus as Any,
        "transformations" to transformations as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Bucket(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<String>,
            fileSecurity = map["fileSecurity"] as Boolean,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            maximumFileSize = (map["maximumFileSize"] as Number).toLong(),
            allowedFileExtensions = map["allowedFileExtensions"] as List<String>,
            compression = map["compression"] as String,
            encryption = map["encryption"] as Boolean,
            antivirus = map["antivirus"] as Boolean,
            transformations = map["transformations"] as Boolean,
        )
    }
}