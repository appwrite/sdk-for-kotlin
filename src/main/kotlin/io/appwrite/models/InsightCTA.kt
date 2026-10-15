package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * InsightCTA
 */
data class InsightCTA(
    /**
     * Human-readable label for the CTA, used in UI.
     */
    @SerializedName("label")
    val label: String,

    /**
     * Public API service (SDK namespace) the client should invoke. Must match the engine that owns the resource — for index suggestions: databases (legacy), tablesDB, documentsDB, or vectorsDB.
     */
    @SerializedName("service")
    val service: String,

    /**
     * Public API method on the chosen service the client should invoke when this CTA is triggered.
     */
    @SerializedName("method")
    val method: String,

    /**
     * Parameter map the client should pass to the service method when this CTA is triggered. Keys match the target API's parameter names (e.g. databaseId/tableId/columns for tablesDB, databaseId/collectionId/attributes for the legacy Databases API).
     */
    @SerializedName("params")
    val params: Map<String, Any?>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "label" to label as Any,
        "service" to service as Any,
        "method" to method as Any,
        "params" to params as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = InsightCTA(
            label = (if (map.containsKey("label")) map["label"] else "") as String,
            service = (if (map.containsKey("service")) map["service"] else "") as String,
            method = (if (map.containsKey("method")) map["method"] else "") as String,
            params = (if (map.containsKey("params")) map["params"] else mapOf<String, Any?>()) as Map<String, Any?>,
        )
    }
}
