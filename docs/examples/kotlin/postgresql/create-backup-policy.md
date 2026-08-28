```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Postgresql

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val postgresql = Postgresql(client)

val response = postgresql.createBackupPolicy(
    databaseId = "<DATABASE_ID>",
    policyId = "<POLICY_ID>",
    name = "<NAME>",
    schedule = "",
    retention = 1,
    type = "full", // optional
    enabled = false // optional
)
```
