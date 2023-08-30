package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Deployment
 */
data class Deployment(
    /**
     * Deployment ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Deployment creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Deployment update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Type of deployment.
     */
    @SerializedName("type")
    val type: String,

    /**
     * Resource ID.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Resource type.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * The entrypoint file to use to execute the deployment code.
     */
    @SerializedName("entrypoint")
    val entrypoint: String,

    /**
     * The code size in bytes.
     */
    @SerializedName("size")
    val size: Long,

    /**
     * The current build ID.
     */
    @SerializedName("buildId")
    val buildId: String,

    /**
     * Whether the deployment should be automatically activated.
     */
    @SerializedName("activate")
    val activate: Boolean,

    /**
     * The deployment status. Possible values are &quot;processing&quot;, &quot;building&quot;, &quot;waiting&quot;, &quot;ready&quot;, and &quot;failed&quot;.
     */
    @SerializedName("status")
    val status: String,

    /**
     * The build logs.
     */
    @SerializedName("buildLogs")
    val buildLogs: String,

    /**
     * The current build time in seconds.
     */
    @SerializedName("buildTime")
    val buildTime: Long,

    /**
     * The name of the vcs provider repository
     */
    @SerializedName("providerRepositoryName")
    val providerRepositoryName: String,

    /**
     * The name of the vcs provider repository owner
     */
    @SerializedName("providerRepositoryOwner")
    val providerRepositoryOwner: String,

    /**
     * The url of the vcs provider repository
     */
    @SerializedName("providerRepositoryUrl")
    val providerRepositoryUrl: String,

    /**
     * The branch of the vcs repository
     */
    @SerializedName("providerBranch")
    val providerBranch: String,

    /**
     * The commit hash of the vcs commit
     */
    @SerializedName("providerCommitHash")
    val providerCommitHash: String,

    /**
     * The url of vcs commit author
     */
    @SerializedName("providerCommitAuthorUrl")
    val providerCommitAuthorUrl: String,

    /**
     * The name of vcs commit author
     */
    @SerializedName("providerCommitAuthor")
    val providerCommitAuthor: String,

    /**
     * The commit message
     */
    @SerializedName("providerCommitMessage")
    val providerCommitMessage: String,

    /**
     * The url of the vcs commit
     */
    @SerializedName("providerCommitUrl")
    val providerCommitUrl: String,

    /**
     * The branch of the vcs repository
     */
    @SerializedName("providerBranchUrl")
    val providerBranchUrl: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "type" to type as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "entrypoint" to entrypoint as Any,
        "size" to size as Any,
        "buildId" to buildId as Any,
        "activate" to activate as Any,
        "status" to status as Any,
        "buildLogs" to buildLogs as Any,
        "buildTime" to buildTime as Any,
        "providerRepositoryName" to providerRepositoryName as Any,
        "providerRepositoryOwner" to providerRepositoryOwner as Any,
        "providerRepositoryUrl" to providerRepositoryUrl as Any,
        "providerBranch" to providerBranch as Any,
        "providerCommitHash" to providerCommitHash as Any,
        "providerCommitAuthorUrl" to providerCommitAuthorUrl as Any,
        "providerCommitAuthor" to providerCommitAuthor as Any,
        "providerCommitMessage" to providerCommitMessage as Any,
        "providerCommitUrl" to providerCommitUrl as Any,
        "providerBranchUrl" to providerBranchUrl as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Deployment(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            type = map["type"] as String,
            resourceId = map["resourceId"] as String,
            resourceType = map["resourceType"] as String,
            entrypoint = map["entrypoint"] as String,
            size = (map["size"] as Number).toLong(),
            buildId = map["buildId"] as String,
            activate = map["activate"] as Boolean,
            status = map["status"] as String,
            buildLogs = map["buildLogs"] as String,
            buildTime = (map["buildTime"] as Number).toLong(),
            providerRepositoryName = map["providerRepositoryName"] as String,
            providerRepositoryOwner = map["providerRepositoryOwner"] as String,
            providerRepositoryUrl = map["providerRepositoryUrl"] as String,
            providerBranch = map["providerBranch"] as String,
            providerCommitHash = map["providerCommitHash"] as String,
            providerCommitAuthorUrl = map["providerCommitAuthorUrl"] as String,
            providerCommitAuthor = map["providerCommitAuthor"] as String,
            providerCommitMessage = map["providerCommitMessage"] as String,
            providerCommitUrl = map["providerCommitUrl"] as String,
            providerBranchUrl = map["providerBranchUrl"] as String,
        )
    }
}