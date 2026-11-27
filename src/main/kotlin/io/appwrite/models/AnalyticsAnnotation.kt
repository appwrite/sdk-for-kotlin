package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * AnalyticsAnnotation
 */
data class AnalyticsAnnotation(
    /**
     * Annotation ID.
     */
    @SerializedName("\$id")
    val id: String,

    /**
     * Annotation creation date in ISO 8601 format.
     */
    @SerializedName("\$createdAt")
    val createdAt: String,

    /**
     * Annotation update date in ISO 8601 format.
     */
    @SerializedName("\$updatedAt")
    val updatedAt: String,

    /**
     * ID of the analytics property the annotation belongs to.
     */
    @SerializedName("propertyId")
    val propertyId: String,

    /**
     * Point in time the annotation marks, in ISO 8601 format.
     */
    @SerializedName("date")
    val date: String,

    /**
     * Annotation text.
     */
    @SerializedName("content")
    val content: String,

    /**
     * ID of the user who created the annotation. Empty when it was created with an API key.
     */
    @SerializedName("userId")
    val userId: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "propertyId" to propertyId as Any,
        "date" to date as Any,
        "content" to content as Any,
        "userId" to userId as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AnalyticsAnnotation(
            id = (if (map.containsKey("\$id")) map["\$id"] else "") as String,
            createdAt = (if (map.containsKey("\$createdAt")) map["\$createdAt"] else "") as String,
            updatedAt = (if (map.containsKey("\$updatedAt")) map["\$updatedAt"] else "") as String,
            propertyId = (if (map.containsKey("propertyId")) map["propertyId"] else "") as String,
            date = (if (map.containsKey("date")) map["date"] else "") as String,
            content = (if (map.containsKey("content")) map["content"] else "") as String,
            userId = (if (map.containsKey("userId")) map["userId"] else "") as String,
        )
    }
}
