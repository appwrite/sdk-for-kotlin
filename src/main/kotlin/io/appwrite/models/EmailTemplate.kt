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
    fun toMap(): Map<String, Any> = mapOf(
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
            templateId = map["templateId"] as String,
            locale = map["locale"] as String,
            message = map["message"] as String,
            senderName = map["senderName"] as String,
            senderEmail = map["senderEmail"] as String,
            replyToEmail = map["replyToEmail"] as String,
            replyToName = map["replyToName"] as String,
            subject = map["subject"] as String,
        )
    }
}