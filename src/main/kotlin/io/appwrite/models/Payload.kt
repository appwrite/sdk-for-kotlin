package io.appwrite.models

import io.appwrite.extensions.gson
import java.io.File
import java.net.URLConnection
import java.nio.file.Files
import java.nio.file.Paths

class Payload private constructor() {

    lateinit var path: String
    lateinit var filename: String
    lateinit var sourceType: String
    lateinit var data: Any
    var mimeType: String? = null

    override fun toString(): String {
        if (sourceType != "bytes") {
            throw IllegalArgumentException("source type is not supported: $sourceType")
        }

        return String(data as ByteArray)
    }

    fun toBinary(): ByteArray {
        if (sourceType != "bytes") {
            throw IllegalArgumentException("source type is not supported: $sourceType")
        }

        return data as ByteArray
    }

    fun toJson(): MutableMap<String, Any> {
        if (sourceType != "bytes") {
            throw IllegalArgumentException("source type is not supported: $sourceType")
        }

        return gson.fromJson(toString(), MutableMap::class.java) as MutableMap<String, Any>
    }

    fun toFile(path: String): File {
        Files.createDirectories(Paths.get(path).parent);

        val file = File(path)
        file.appendBytes(toBinary())
        return file
    }

    companion object {
        fun fromFile(path: String, filename: String = ""): Payload = fromFileObject(File(path), filename).apply {
            sourceType = "path"
        }

        fun fromBinary(bytes: ByteArray, filename: String = "") = Payload().apply {
            this.filename = filename
            data = bytes
            sourceType = "bytes"
        }

        fun fromString(string: String) = fromBinary(string.toByteArray())

        fun fromJson(data: Any) = fromString(gson.toJson(data))

        fun fromFileObject(file: File, name: String = "") = Payload().apply {
            path = file.canonicalPath
            filename = if (name != "") name else file.name
            mimeType = Files.probeContentType(Paths.get(file.canonicalPath))
                ?: URLConnection.guessContentTypeFromName(filename)
                        ?: ""
            sourceType = "file"
        }
    }
}