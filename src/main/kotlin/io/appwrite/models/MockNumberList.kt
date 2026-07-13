package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Mock Numbers List
 */
data class MockNumberList(
    /**
     * Total number of mockNumbers that matched your query.
     */
    @SerializedName("total")
    val total: Long,

    /**
     * List of mockNumbers.
     */
    @SerializedName("mockNumbers")
    val mockNumbers: List<MockNumber>,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "total" to total as Any,
        "mockNumbers" to mockNumbers.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MockNumberList(
            total = (map["total"] as Number).toLong(),
            mockNumbers = (map["mockNumbers"] as List<Map<String, Any>>).map { MockNumber.from(map = it) },
        )
    }
}
