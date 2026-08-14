package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Database Migrations List
 */
data class DatabaseMigrationList(
    /**
     * Total number of migrations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of migrations.
     */
    @SerializedName("migrations")
    val migrations: List<DatabaseMigration>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "migrations" to migrations.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseMigrationList(
            total = (map["total"] as Number).toLong(),
            migrations = (map["migrations"] as List<Map<String, Any>>).map { DatabaseMigration.from(map = it) },
        )
    }
}
