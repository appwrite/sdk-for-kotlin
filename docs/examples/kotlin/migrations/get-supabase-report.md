```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Migrations
import io.appwrite.enums.SupabaseMigrationResource

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val migrations = Migrations(client)

val response = migrations.getSupabaseReport(
    resources = listOf(SupabaseMigrationResource.USER),
    endpoint = "https://example.com",
    apiKey = "<API_KEY>",
    databaseHost = "<DATABASE_HOST>",
    username = "<USERNAME>",
    password = "password",
    port = 5432 // optional
)
```
