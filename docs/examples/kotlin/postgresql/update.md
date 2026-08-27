```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Postgresql

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val postgresql = Postgresql(client)

val response = postgresql.update(
    databaseId = "<DATABASE_ID>",
    name = "<NAME>", // optional
    status = "ready", // optional
    specification = "<SPECIFICATION>", // optional
    replicas = 0, // optional
    syncMode = "async", // optional
    networkIdleTimeoutSeconds = 60, // optional
    networkIPAllowlist = listOf(), // optional
    idleTimeoutMinutes = 5, // optional
    pitr = false, // optional
    pitrRetentionDays = 1, // optional
    storageAutoscaling = false, // optional
    storageAutoscalingThresholdPercent = 50, // optional
    storageAutoscalingMaxGb = 0, // optional
    metricsTraceSampleRate = 0, // optional
    metricsSlowQueryLogThresholdMs = 0, // optional
    sqlApiEnabled = false, // optional
    sqlApiAllowedStatements = listOf(), // optional
    sqlApiMaxRows = 1, // optional
    sqlApiMaxBytes = 1024, // optional
    sqlApiTimeoutSeconds = 1 // optional
)
```
