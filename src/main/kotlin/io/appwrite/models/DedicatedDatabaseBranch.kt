package io.appwrite.models

import com.google.gson.annotations.SerializedName
import io.appwrite.extensions.jsonCast

/**
 * Branch
 */
data class DedicatedDatabaseBranch(
    /**
     * Branch identifier.
     */
    @SerializedName("branchId")
    val branchId: String,

    /**
     * Branch name.
     */
    @SerializedName("branchName")
    val branchName: String,

    /**
     * Kubernetes namespace where the branch is deployed.
     */
    @SerializedName("namespace")
    val namespace: String,

    /**
     * Unix timestamp when the branch expires.
     */
    @SerializedName("expiresAt")
    val expiresAt: Long,

    /**
     * Branch hostname for direct connections.
     */
    @SerializedName("host")
    val host: String,

    /**
     * Branch port. Null until the backing reports one.
     */
    @SerializedName("port")
    val port: Long,

    /**
     * Advertised catalog the client connects to. MySQL/MariaDB use default; Postgres uses the routing label.
     */
    @SerializedName("database")
    val database: String,

    /**
     * Database username. Shared with the parent database.
     */
    @SerializedName("username")
    val username: String,

    /**
     * Database password. Shared with the parent database.
     */
    @SerializedName("password")
    val password: String,

    /**
     * Whether SSL is required.
     */
    @SerializedName("ssl")
    val ssl: Boolean,

    /**
     * Database engine. Possible values: postgresql, mysql, mongodb.
     */
    @SerializedName("engine")
    val engine: String,

    /**
     * Full connection string for the branch.
     */
    @SerializedName("connectionString")
    val connectionString: String,

) {
    fun toMap(): Map<String, Any?> = mapOf(
        "branchId" to branchId as Any,
        "branchName" to branchName as Any,
        "namespace" to namespace as Any,
        "expiresAt" to expiresAt as Any,
        "host" to host as Any,
        "port" to port as Any,
        "database" to database as Any,
        "username" to username as Any,
        "password" to password as Any,
        "ssl" to ssl as Any,
        "engine" to engine as Any,
        "connectionString" to connectionString as Any,
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = DedicatedDatabaseBranch(
            branchId = map["branchId"] as String,
            branchName = map["branchName"] as String,
            namespace = map["namespace"] as String,
            expiresAt = (map["expiresAt"] as Number).toLong(),
            host = map["host"] as String,
            port = (map["port"] as Number).toLong(),
            database = map["database"] as String,
            username = map["username"] as String,
            password = map["password"] as String,
            ssl = map["ssl"] as Boolean,
            engine = map["engine"] as String,
            connectionString = map["connectionString"] as String,
        )
    }
}
