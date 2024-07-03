package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Build
 */
data class Build(
    /**
     * Build ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * The deployment that created this build.
     */
    @SerializedName("deploymentId")
    val deploymentId: String,

    /**
     * The build status. There are a few different types and each one means something different. \nFailed - The deployment build has failed. More details can usually be found in buildStderr\nReady - The deployment build was successful and the deployment is ready to be deployed\nProcessing - The deployment is currently waiting to have a build triggered\nBuilding - The deployment is currently being built
     */
    @SerializedName("status")
    val status: String,

    /**
     * The stdout of the build.
     */
    @SerializedName("stdout")
    val stdout: String,

    /**
     * The stderr of the build.
     */
    @SerializedName("stderr")
    val stderr: String,

    /**
     * The deployment creation date in ISO 8601 format.
     */
    @SerializedName("startTime")
    val startTime: String,

    /**
     * The time the build was finished in ISO 8601 format.
     */
    @SerializedName("endTime")
    val endTime: String,

    /**
     * The build duration in seconds.
     */
    @SerializedName("duration")
    val duration: Long,

    /**
     * The code size in bytes.
     */
    @SerializedName("size")
    val size: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "deploymentId" to deploymentId as Any,
        "status" to status as Any,
        "stdout" to stdout as Any,
        "stderr" to stderr as Any,
        "startTime" to startTime as Any,
        "endTime" to endTime as Any,
        "duration" to duration as Any,
        "size" to size as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Build(
            id = map["\$id"] as String,
            deploymentId = map["deploymentId"] as String,
            status = map["status"] as String,
            stdout = map["stdout"] as String,
            stderr = map["stderr"] as String,
            startTime = map["startTime"] as String,
            endTime = map["endTime"] as String,
            duration = (map["duration"] as Number).toLong(),
            size = (map["size"] as Number).toLong(),
        )
    }
}