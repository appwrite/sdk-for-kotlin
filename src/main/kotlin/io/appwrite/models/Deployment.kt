package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Deployment
 */
data class Deployment(
    /**
     * Deployment ID.
     *
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Deployment creation date in ISO 8601 format.
     *
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Deployment update date in ISO 8601 format.
     *
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Resource ID.
     *
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Resource type.
     *
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * The entrypoint file to use to execute the deployment code.
     *
     */
    @SerializedName("entrypoint")
    val entrypoint: String,

    /**
     * The code size in bytes.
     *
     */
    @SerializedName("size")
    val size: Long,

    /**
     * The current build ID.
     *
     */
    @SerializedName("buildId")
    val buildId: String,

    /**
     * Whether the deployment should be automatically activated.
     *
     */
    @SerializedName("activate")
    val activate: Boolean,

    /**
     * The deployment status. Possible values are &quot;processing&quot;, &quot;building&quot;, &quot;pending&quot;, &quot;ready&quot;, and &quot;failed&quot;.
     *
     */
    @SerializedName("status")
    val status: String,

    /**
     * The build stdout.
     *
     */
    @SerializedName("buildStdout")
    val buildStdout: String,

    /**
     * The build stderr.
     *
     */
    @SerializedName("buildStderr")
    val buildStderr: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = Deployment(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            resourceId = map["resourceId"] as String,
            resourceType = map["resourceType"] as String,
            entrypoint = map["entrypoint"] as String,
            size = (map["size"] as Number).toLong(),
            buildId = map["buildId"] as String,
            activate = map["activate"] as Boolean,
            status = map["status"] as String,
            buildStdout = map["buildStdout"] as String,
            buildStderr = map["buildStderr"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "entrypoint" to entrypoint as Any,
        "size" to size as Any,
        "buildId" to buildId as Any,
        "activate" to activate as Any,
        "status" to status as Any,
        "buildStdout" to buildStdout as Any,
        "buildStderr" to buildStderr as Any
    )
}