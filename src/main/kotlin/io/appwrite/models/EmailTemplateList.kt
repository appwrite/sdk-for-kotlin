package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Email Templates List
 */
data class EmailTemplateList(
    /**
     * Total number of templates that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of templates.
     */
    @SerializedName("templates")
    val templates: List<EmailTemplate>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "templates" to templates.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EmailTemplateList(
            total = (map["total"] as Number).toLong(),
            templates = (map["templates"] as List<Map<String, Any>>).map { EmailTemplate.from(map = it) },
        )
    }
}