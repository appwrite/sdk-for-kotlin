```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Mysql

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val mysql = Mysql(client)

val response = mysql.create(
    databaseId = "<DATABASE_ID>",
    name = "<NAME>",
    version = "17", // optional
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
    storageAutoscalingMaxGb = 0 // optional
)
```
