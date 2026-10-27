```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Migrations
import io.appwrite.enums.AppwriteMigrationResource
import io.appwrite.enums.OnDuplicate

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val migrations = Migrations(client)

val response = migrations.createAppwriteMigration(
    resources = listOf(AppwriteMigrationResource.USER),
    endpoint = "https://example.com",
    projectId = "<PROJECT_ID>",
    apiKey = "<API_KEY>",
    onDuplicate = OnDuplicate.FAIL // optional
)
```
