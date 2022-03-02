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
     * The deployment creation date in Unix timestamp.
     *
     */
    @SerializedName("dateCreated")
    val dateCreated: Long,

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
     * The deployment status.
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
            resourceId = map["resourceId"] as String,
            resourceType = map["resourceType"] as String,
            dateCreated = (map["dateCreated"] as Number).toLong(),
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
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "dateCreated" to dateCreated as Any,
        "entrypoint" to entrypoint as Any,
        "size" to size as Any,
        "buildId" to buildId as Any,
        "activate" to activate as Any,
        "status" to status as Any,
        "buildStdout" to buildStdout as Any,
        "buildStderr" to buildStderr as Any
    )
}