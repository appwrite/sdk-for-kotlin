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
    var port: Long?,

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
        "port" to port as Any?,
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
            branchId = (if (map.containsKey("branchId")) map["branchId"] else "") as String,
            branchName = (if (map.containsKey("branchName")) map["branchName"] else "") as String,
            namespace = (if (map.containsKey("namespace")) map["namespace"] else "") as String,
            expiresAt = ((if (map.containsKey("expiresAt")) map["expiresAt"] else 0) as Number).toLong(),
            host = (if (map.containsKey("host")) map["host"] else "") as String,
            port = (map["port"] as? Number)?.toLong(),
            database = (if (map.containsKey("database")) map["database"] else "") as String,
            username = (if (map.containsKey("username")) map["username"] else "") as String,
            password = (if (map.containsKey("password")) map["password"] else "") as String,
            ssl = (if (map.containsKey("ssl")) map["ssl"] else false) as Boolean,
            engine = (if (map.containsKey("engine")) map["engine"] else "") as String,
            connectionString = (if (map.containsKey("connectionString")) map["connectionString"] else "") as String,
        )
    }
}
