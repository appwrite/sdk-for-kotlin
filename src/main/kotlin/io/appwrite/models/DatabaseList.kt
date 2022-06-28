package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * Databases List
 */
data class DatabaseList(
    /**
     * Total number of databases documents that matched your query.
     *
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of databases.
     *
     */
    @SerializedName("databases")
    val databases: List<Database>
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = DatabaseList(
            total = (map["total"] as Number).toLong(),
            databases = (map["databases"] as List<Map<String, Any>>).map { Database.from(map = it) }
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "databases" to databases.map { it.toMap() } as Any
    )
}