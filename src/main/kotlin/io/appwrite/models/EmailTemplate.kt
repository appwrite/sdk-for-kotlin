package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * EmailTemplate
 */
data class EmailTemplate(
    /**
     * Template type
     */
    @SerializedName("templateId")
    val templateId: String,

    /**
     * Template locale
     */
    @SerializedName("locale")
    val locale: String,

    /**
     * Template message
     */
    @SerializedName("message")
    val message: String,

    /**
     * Name of the sender
     */
    @SerializedName("senderName")
    val senderName: String,

    /**
     * Email of the sender
     */
    @SerializedName("senderEmail")
    val senderEmail: String,

    /**
     * Reply to email address
     */
    @SerializedName("replyToEmail")
    val replyToEmail: String,

    /**
     * Reply to name
     */
    @SerializedName("replyToName")
    val replyToName: String,

    /**
     * Email subject
     */
    @SerializedName("subject")
    val subject: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "templateId" to templateId as Any,
        "locale" to locale as Any,
        "message" to message as Any,
        "senderName" to senderName as Any,
        "senderEmail" to senderEmail as Any,
        "replyToEmail" to replyToEmail as Any,
        "replyToName" to replyToName as Any,
        "subject" to subject as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = EmailTemplate(
            templateId = (if (map.containsKey("templateId")) map["templateId"] else "") as String,
            locale = (if (map.containsKey("locale")) map["locale"] else "") as String,
            message = (if (map.containsKey("message")) map["message"] else "") as String,
            senderName = (if (map.containsKey("senderName")) map["senderName"] else "") as String,
            senderEmail = (if (map.containsKey("senderEmail")) map["senderEmail"] else "") as String,
            replyToEmail = (if (map.containsKey("replyToEmail")) map["replyToEmail"] else "") as String,
            replyToName = (if (map.containsKey("replyToName")) map["replyToName"] else "") as String,
            subject = (if (map.containsKey("subject")) map["subject"] else "") as String,
        )
    }
}
