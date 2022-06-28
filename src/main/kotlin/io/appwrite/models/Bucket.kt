package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Bucket
 */
data class Bucket(
    /**
     * Bucket ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Bucket creation date in Unix timestamp.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: Long,

    /**
     * Bucket update date in Unix timestamp.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: Long,

    /**
     * File read permissions.
     *
     */
    @SerializedName("\$read")
    val read: List<Any>,

    /**
     * File write permissions.
     *
     */
    @SerializedName("\$write")
    val write: List<Any>,

    /**
     * Bucket permission model. Possible values: `bucket` or `file`
     *
     */
    @SerializedName("permission")
    val permission: String,

    /**
     * Bucket name.
     *
     */
    @SerializedName("name")
    val name: String,

    /**
     * Bucket enabled.
     *
     */
    @SerializedName("enabled")
    val enabled: Boolean,

    /**
     * Maximum file size supported.
     *
     */
    @SerializedName("maximumFileSize")
    val maximumFileSize: Long,

    /**
     * Allowed file extensions.
     *
     */
    @SerializedName("allowedFileExtensions")
    val allowedFileExtensions: List<Any>,

    /**
     * Bucket is encrypted.
     *
     */
    @SerializedName("encryption")
    val encryption: Boolean,

    /**
     * Virus scanning is enabled.
     *
     */
    @SerializedName("antivirus")
    val antivirus: Boolean
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Bucket(
            id = map["\$id"] as String,
            createdAt = (map["\$createdAt"] as Number).toLong(),
            updatedAt = (map["\$updatedAt"] as Number).toLong(),
            read = map["\$read"] as List<Any>,
            write = map["\$write"] as List<Any>,
            permission = map["permission"] as String,
            name = map["name"] as String,
            enabled = map["enabled"] as Boolean,
            maximumFileSize = (map["maximumFileSize"] as Number).toLong(),
            allowedFileExtensions = map["allowedFileExtensions"] as List<Any>,
            encryption = map["encryption"] as Boolean,
            antivirus = map["antivirus"] as Boolean
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$read" to read as Any,
        "\$write" to write as Any,
        "permission" to permission as Any,
        "name" to name as Any,
        "enabled" to enabled as Any,
        "maximumFileSize" to maximumFileSize as Any,
        "allowedFileExtensions" to allowedFileExtensions as Any,
        "encryption" to encryption as Any,
        "antivirus" to antivirus as Any
    )
}