package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Projects List
 */
data class ProjectList<T>(
    /**
     * Total number of projects that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of projects.
     */
    @SerializedName("projects")
    val projects: List<Project<T>>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "projects" to projects.map { it.toMap() } as Any,
    )

    companion object {
        operator fun invoke(
            total: Long,
            projects: List<Project<Map<String, Any>>>,
        ) = ProjectList<Map<String, Any>>(
            total,
            projects,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T> from(
            map: Map<String, Any>,
            nestedType: Class<T>
        ) = ProjectList<T>(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            projects = ((if (map.containsKey("projects")) map["projects"] else listOf<Any?>()) as List<Map<String, Any>>).map { Project.from(map = it, nestedType) },
        )
    }
}
