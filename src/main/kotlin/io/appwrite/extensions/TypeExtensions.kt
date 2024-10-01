package io.appwrite.extensions

import io.appwrite.models.Payload
import kotlin.reflect.KClass
import kotlin.reflect.typeOf

inline fun <reified T : Any> classOf(): Class<T> {
    return (typeOf<T>().classifier!! as KClass<T>).java
}

fun String.fromMultiPart(binaryBody: ByteArray): Map<String, Any> {
    val match = Regex("(-+\\w+)--").find(this) ?: return emptyMap()
    // For kotlin

    val boundary = match.groupValues[1]

    var map =
        mutableMapOf<String, Any>(
            "\$id" to "",
            "\$createdAt" to "",
            "\$updatedAt" to "",
            "\$permissions" to emptyList<String>(),
            "functionId" to "",
            "trigger" to "",
            "status" to "",
            "requestMethod" to "",
            "requestPath" to "",
            "requestHeaders" to emptyList<HashMap<String, Any>>(),
            "responseStatusCode" to 0,
            "responseBody" to Payload.fromBinary(ByteArray(0)),
            "responseHeaders" to emptyList<HashMap<String, Any>>(),
            "logs" to "",
            "errors" to "",
            "duration" to 0.0,
            "scheduledAt" to "",
        )

    val parts = this.split(boundary)
    for (part in parts) {
        var lines = part.split("\r\n")

        val name = Regex("name=\"?(\\w+)").find(part) ?: continue

        lines =
            lines
                .dropWhile { it.isEmpty() }
                .drop(1)
                .dropWhile { it.isEmpty() }
                .dropLastWhile { it.isEmpty() }
        val key = name.groupValues[1]

        if (lines.isEmpty()) {
            continue
        }

        if (key == "responseBody") {
            val needle = "name=\"responseBody\"\r\n\r\n"
            val indexOf = this.indexOf(needle) + needle.length
            val endBytes = "\r\n-------".toByteArray()

            val list = ByteArray(binaryBody.size - indexOf)
            val multipart = binaryBody.drop(indexOf)

            var weHitTheEnd = false
            var j = 0
            for (i in multipart) {
                if (multipart.size > j + endBytes.size) {
                    var jj = 0
                    for (byte in endBytes) {
                        if (byte != multipart[j + jj]) break
                        jj++
                        if (jj != endBytes.size - 1) continue
                        weHitTheEnd = true
                    }
                }
                if (weHitTheEnd) {
                    break
                }

                list[j] = multipart[j]
                j++
            }

            map["responseBody"] =
                Payload.fromBinary(list.dropLastWhile { it == 0.toByte() }.toByteArray())
            continue
        }

        if (lines[0] == "Content-Type: application/json") {
            lines = lines.drop(1).dropWhile { it.isEmpty() }
            val list = lines.joinToString("\r\n").fromJson<List<String>>()
            map[key] = list
            continue
        }

        val value = lines.joinToString("\r\n")

        map[key] =
            when (key) {
                "responseStatusCode" -> value.toInt()
                "duration" -> value.toFloat()
                else -> value
            }
    }

    return map
}
