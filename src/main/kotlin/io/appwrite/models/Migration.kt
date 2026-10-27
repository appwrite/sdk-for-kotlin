package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Migration
 */
data class Migration(
    /**
     * Migration ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Migration creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * Migration status ( pending, processing, failed, completed )
     */
    @SerializedName("status")
    val status: String,

    /**
     * Migration stage ( init, processing, source-check, destination-check, migrating, finished )
     */
    @SerializedName("stage")
    val stage: String,

    /**
     * A string containing the type of source of the migration.
     */
    @SerializedName("source")
    val source: String,

    /**
     * A string containing the type of destination of the migration.
     */
    @SerializedName("destination")
    val destination: String,

    /**
     * Resources to migrate.
     */
    @SerializedName("resources")
    val resources: List<String>,

    /**
     * ID of the resource being migrated.
     */
    @SerializedName("resourceId")
    val resourceId: String,

    /**
     * Internal ID of the resource being migrated.
     */
    @SerializedName("resourceInternalId")
    val resourceInternalId: String,

    /**
     * Type of the resource being migrated.
     */
    @SerializedName("resourceType")
    val resourceType: String,

    /**
     * ID of the parent resource that contains the migrated resource.
     */
    @SerializedName("parentResourceId")
    val parentResourceId: String,

    /**
     * Internal ID of the parent resource that contains the migrated resource.
     */
    @SerializedName("parentResourceInternalId")
    val parentResourceInternalId: String,

    /**
     * Type of the parent resource that contains the migrated resource.
     */
    @SerializedName("parentResourceType")
    val parentResourceType: String,

    /**
     * ID of the destination resource created or overwritten by the migration.
     */
    @SerializedName("destinationResourceId")
    val destinationResourceId: String,

    /**
     * Internal ID of the destination resource created or overwritten by the migration.
     */
    @SerializedName("destinationResourceInternalId")
    val destinationResourceInternalId: String,

    /**
     * Type of the destination resource created or overwritten by the migration.
     */
    @SerializedName("destinationResourceType")
    val destinationResourceType: String,

    /**
     * A group of counters that represent the total progress of the migration.
     */
    @SerializedName("statusCounters")
    val statusCounters: Map<String, Any?>,

    /**
     * An array of objects containing the report data of the resources that were migrated.
     */
    @SerializedName("resourceData")
    val resourceData: List<Map<String, Any?>>,

    /**
     * All errors that occurred during the migration process.
     */
    @SerializedName("errors")
    val errors: List<String>,

    /**
     * Migration options used during the migration process.
     */
    @SerializedName("options")
    val options: Map<String, Any?>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "status" to status as Any,
        "stage" to stage as Any,
        "source" to source as Any,
        "destination" to destination as Any,
        "resources" to resources as Any,
        "resourceId" to resourceId as Any,
        "resourceInternalId" to resourceInternalId as Any,
        "resourceType" to resourceType as Any,
        "parentResourceId" to parentResourceId as Any,
        "parentResourceInternalId" to parentResourceInternalId as Any,
        "parentResourceType" to parentResourceType as Any,
        "destinationResourceId" to destinationResourceId as Any,
        "destinationResourceInternalId" to destinationResourceInternalId as Any,
        "destinationResourceType" to destinationResourceType as Any,
        "statusCounters" to statusCounters as Any,
        "resourceData" to resourceData as Any,
        "errors" to errors as Any,
        "options" to options as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Migration(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            status = (if (map.containsKey("status")) map["status"] else "") as String,
            stage = (if (map.containsKey("stage")) map["stage"] else "") as String,
            source = (if (map.containsKey("source")) map["source"] else "") as String,
            destination = (if (map.containsKey("destination")) map["destination"] else "Appwrite") as String,
            resources = (if (map.containsKey("resources")) map["resources"] else listOf<Any?>()) as List<String>,
            resourceId = (if (map.containsKey("resourceId")) map["resourceId"] else "") as String,
            resourceInternalId = (if (map.containsKey("resourceInternalId")) map["resourceInternalId"] else "") as String,
            resourceType = (if (map.containsKey("resourceType")) map["resourceType"] else "") as String,
            parentResourceId = (if (map.containsKey("parentResourceId")) map["parentResourceId"] else "") as String,
            parentResourceInternalId = (if (map.containsKey("parentResourceInternalId")) map["parentResourceInternalId"] else "") as String,
            parentResourceType = (if (map.containsKey("parentResourceType")) map["parentResourceType"] else "") as String,
            destinationResourceId = (if (map.containsKey("destinationResourceId")) map["destinationResourceId"] else "") as String,
            destinationResourceInternalId = (if (map.containsKey("destinationResourceInternalId")) map["destinationResourceInternalId"] else "") as String,
            destinationResourceType = (if (map.containsKey("destinationResourceType")) map["destinationResourceType"] else "") as String,
            statusCounters = (if (map.containsKey("statusCounters")) map["statusCounters"] else mapOf<String, Any?>()) as Map<String, Any?>,
            resourceData = (if (map.containsKey("resourceData")) map["resourceData"] else listOf<Any?>()) as List<Map<String, Any?>>,
            errors = (if (map.containsKey("errors")) map["errors"] else listOf<Any?>()) as List<String>,
            options = (if (map.containsKey("options")) map["options"] else mapOf<String, Any?>()) as Map<String, Any?>,
        )
    }
}
