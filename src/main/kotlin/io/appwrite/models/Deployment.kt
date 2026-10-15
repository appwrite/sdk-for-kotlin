package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.enums.DeploymentStatus
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
    @SerializedName("sourceSize")
    val sourceSize: Long,

    /**
     * The build output size in bytes.
     */
    @SerializedName("buildSize")
    val buildSize: Long,

    /**
     * The total size in bytes (source and build output).
     */
    @SerializedName("totalSize")
    val totalSize: Long,

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
     * Screenshot with light theme preference file ID.
     */
    @SerializedName("screenshotLight")
    val screenshotLight: String,

    /**
     * Screenshot with dark theme preference file ID.
     */
    @SerializedName("screenshotDark")
    val screenshotDark: String,

    /**
     * The deployment status. Possible values are "waiting", "processing", "building", "ready", "canceled" and "failed".
     */
    @SerializedName("status")
    val status: DeploymentStatus,

    /**
     * The build logs.
     */
    @SerializedName("buildLogs")
    val buildLogs: String,

    /**
     * The current build time in seconds.
     */
    @SerializedName("buildDuration")
    val buildDuration: Long,

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
    @SerializedName("providerBranch")
    val providerBranch: String,

    /**
     * The branch of the vcs repository
     */
    @SerializedName("providerBranchUrl")
    val providerBranchUrl: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "type" to type as Any,
        "resourceId" to resourceId as Any,
        "resourceType" to resourceType as Any,
        "entrypoint" to entrypoint as Any,
        "sourceSize" to sourceSize as Any,
        "buildSize" to buildSize as Any,
        "totalSize" to totalSize as Any,
        "buildId" to buildId as Any,
        "activate" to activate as Any,
        "screenshotLight" to screenshotLight as Any,
        "screenshotDark" to screenshotDark as Any,
        "status" to status.value as Any,
        "buildLogs" to buildLogs as Any,
        "buildDuration" to buildDuration as Any,
        "providerRepositoryName" to providerRepositoryName as Any,
        "providerRepositoryOwner" to providerRepositoryOwner as Any,
        "providerRepositoryUrl" to providerRepositoryUrl as Any,
        "providerCommitHash" to providerCommitHash as Any,
        "providerCommitAuthorUrl" to providerCommitAuthorUrl as Any,
        "providerCommitAuthor" to providerCommitAuthor as Any,
        "providerCommitMessage" to providerCommitMessage as Any,
        "providerCommitUrl" to providerCommitUrl as Any,
        "providerBranch" to providerBranch as Any,
        "providerBranchUrl" to providerBranchUrl as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Deployment(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            type = (if (map.containsKey("type")) map["type"] else "") as String,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            entrypoint = (if (map.containsKey("entrypoint")) map["entrypoint"] else "") as String,
            sourceSize = ((if (map.containsKey("sourceSize")) map["sourceSize"] else 0) as Number).toLong(),
            buildSize = ((if (map.containsKey("buildSize")) map["buildSize"] else 0) as Number).toLong(),
            totalSize = ((if (map.containsKey("totalSize")) map["totalSize"] else 0) as Number).toLong(),
            buildId = (if (map.containsKey("buildId")) map["buildId"] else "") as String,
            activate = (if (map.containsKey("activate")) map["activate"] else false) as Boolean,
            screenshotLight = (if (map.containsKey("screenshotLight")) map["screenshotLight"] else "") as String,
            screenshotDark = (if (map.containsKey("screenshotDark")) map["screenshotDark"] else "") as String,
            status = DeploymentStatus.values().find { it.value == map["status"] as String }!!,
            buildLogs = (if (map.containsKey("buildLogs")) map["buildLogs"] else "") as String,
            buildDuration = ((if (map.containsKey("buildDuration")) map["buildDuration"] else 0) as Number).toLong(),
            providerRepositoryName = (if (map.containsKey("providerRepositoryName")) map["providerRepositoryName"] else "") as String,
            providerRepositoryOwner = (if (map.containsKey("providerRepositoryOwner")) map["providerRepositoryOwner"] else "") as String,
            providerRepositoryUrl = (if (map.containsKey("providerRepositoryUrl")) map["providerRepositoryUrl"] else "") as String,
            providerCommitHash = (if (map.containsKey("providerCommitHash")) map["providerCommitHash"] else "") as String,
            providerCommitAuthorUrl = (if (map.containsKey("providerCommitAuthorUrl")) map["providerCommitAuthorUrl"] else "") as String,
            providerCommitAuthor = (if (map.containsKey("providerCommitAuthor")) map["providerCommitAuthor"] else "") as String,
            providerCommitMessage = (if (map.containsKey("providerCommitMessage")) map["providerCommitMessage"] else "") as String,
            providerCommitUrl = (if (map.containsKey("providerCommitUrl")) map["providerCommitUrl"] else "") as String,
            providerBranch = (if (map.containsKey("providerBranch")) map["providerBranch"] else "") as String,
            providerBranchUrl = (if (map.containsKey("providerBranchUrl")) map["providerBranchUrl"] else "") as String,
        )
    }
}
