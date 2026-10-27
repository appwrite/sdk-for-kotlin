package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Migrations List
 */
data class MigrationList(
    /**
     * Total number of migrations that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of migrations.
     */
    @SerializedName("migrations")
    val migrations: List<Migration>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "migrations" to migrations.map { it.toMap() } as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MigrationList(
            total = ((if (map.containsKey("total")) map["total"] else 0) as Number).toLong(),
            migrations = ((if (map.containsKey("migrations")) map["migrations"] else listOf<Any?>()) as List<Map<String, Any>>).map { Migration.from(map = it) },
        )
    }
}
