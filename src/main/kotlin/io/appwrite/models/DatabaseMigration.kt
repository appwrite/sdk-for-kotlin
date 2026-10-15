package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Database Migration
 */
data class DatabaseMigration(
    /**
     * Database migration ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Migration creation time in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Migration update time in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Project ID that owns the migrating database.
     */
    @SerializedName("projectId")
    val projectId: String,

    /**
     * Logical database ID being migrated.
     */
    @SerializedName("databaseId")
    val databaseId: String,

    /**
     * Dedicated compute specification provisioned for the migration target.
     */
    @SerializedName("specification")
    val specification: String,

    /**
     * Migration phase. Possible values: pending, provisioned, capturing, backfilling, catching_up, verifying, ready_to_cutover, cutover, soaking, done, failed, rolled_back.
     */
    @SerializedName("phase")
    val phase: String,

    /**
     * Number of times a migration step has failed and been recorded.
     */
    @SerializedName("attempt")
    val attempt: Long,

    /**
     * Reason the most recent migration step failed, empty while none has.
     */
    @SerializedName("lastError")
    val lastError: String,

    /**
     * Number of documents still pending replication to the target.
     */
    @SerializedName("lagDocuments")
    val lagDocuments: Long,

    /**
     * Highest source changelog sequence applied to the target so far.
     */
    @SerializedName("changelogWatermark")
    val changelogWatermark: Long,

    /**
     * Time the migrated data was verified against the source in ISO 8601 format.
     */
    @SerializedName("verifiedAt")
    val verifiedAt: String,

    /**
     * Time routing was flipped to the target in ISO 8601 format.
     */
    @SerializedName("cutoverAt")
    val cutoverAt: String,

    /**
     * Time the post-cutover soak window ends in ISO 8601 format.
     */
    @SerializedName("soakUntil")
    val soakUntil: String,

    /**
     * Whether the migration cuts over automatically once ready. Set when the migration is created and never changed afterwards, so it always reports what was asked for.
     */
    @SerializedName("autoCutover")
    val autoCutover: Boolean,

    /**
     * Whether a cutover has been requested and not yet attempted. Set by the cutover endpoint and cleared when the attempt is made, so a cutover that fails a check parks the migration again rather than retrying on its own.
     */
    @SerializedName("cutoverRequested")
    val cutoverRequested: Boolean,

    /**
     * Whether the migration is paused.
     */
    @SerializedName("paused")
    val paused: Boolean,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "projectId" to projectId as Any,
        "databaseId" to databaseId as Any,
        "specification" to specification as Any,
        "phase" to phase as Any,
        "attempt" to attempt as Any,
        "lastError" to lastError as Any,
        "lagDocuments" to lagDocuments as Any,
        "changelogWatermark" to changelogWatermark as Any,
        "verifiedAt" to verifiedAt as Any,
        "cutoverAt" to cutoverAt as Any,
        "soakUntil" to soakUntil as Any,
        "autoCutover" to autoCutover as Any,
        "cutoverRequested" to cutoverRequested as Any,
        "paused" to paused as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DatabaseMigration(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            projectId = (if (map.containsKey("projectId")) map["projectId"] else "") as String,
            databaseId = (if (map.containsKey("databaseId")) map["databaseId"] else "") as String,
            specification = (if (map.containsKey("specification")) map["specification"] else "") as String,
            phase = (if (map.containsKey("phase")) map["phase"] else "pending") as String,
            attempt = ((if (map.containsKey("attempt")) map["attempt"] else 0) as Number).toLong(),
            lastError = (if (map.containsKey("lastError")) map["lastError"] else "") as String,
            lagDocuments = ((if (map.containsKey("lagDocuments")) map["lagDocuments"] else 0) as Number).toLong(),
            changelogWatermark = ((if (map.containsKey("changelogWatermark")) map["changelogWatermark"] else 0) as Number).toLong(),
            verifiedAt = (if (map.containsKey("verifiedAt")) map["verifiedAt"] else "") as String,
            cutoverAt = (if (map.containsKey("cutoverAt")) map["cutoverAt"] else "") as String,
            soakUntil = (if (map.containsKey("soakUntil")) map["soakUntil"] else "") as String,
            autoCutover = (if (map.containsKey("autoCutover")) map["autoCutover"] else true) as Boolean,
            cutoverRequested = (if (map.containsKey("cutoverRequested")) map["cutoverRequested"] else false) as Boolean,
            paused = (if (map.containsKey("paused")) map["paused"] else false) as Boolean,
        )
    }
}
