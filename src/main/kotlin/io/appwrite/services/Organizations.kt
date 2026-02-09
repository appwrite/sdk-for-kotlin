package io.appwrite.services

import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Organizations(client: Client) : Service(client) {

    /**
     * Delete an organization.
     *
     * @param organizationId Team ID.
     * @return [Any]
     */
    @Throws(AppwriteException::class)
    suspend fun delete(
        organizationId: String,
    ): Any {
        val apiPath = "/organizations/{organizationId}"
            .replace("{organizationId}", organizationId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
        )
    }

    /**
     * Get estimation for deleting an organization.
     *
     * @param organizationId Team ID.
     * @return [io.appwrite.models.EstimationDeleteOrganization]
     */
    @Throws(AppwriteException::class)
    suspend fun estimationDeleteOrganization(
        organizationId: String,
    ): io.appwrite.models.EstimationDeleteOrganization {
        val apiPath = "/organizations/{organizationId}/estimations/delete-organization"
            .replace("{organizationId}", organizationId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf<String, String>(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.EstimationDeleteOrganization = {
            io.appwrite.models.EstimationDeleteOrganization.from(map = it as Map<String, Any>)
        }
        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.EstimationDeleteOrganization::class.java,
            converter,
        )
    }

}