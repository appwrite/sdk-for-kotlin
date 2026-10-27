```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Migrations
import io.appwrite.enums.NHostMigrationResource

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val migrations = Migrations(client)

val response = migrations.createNHostMigration(
    resources = listOf(NHostMigrationResource.USER),
    subdomain = "<SUBDOMAIN>",
    region = "<REGION>",
    adminSecret = "<ADMIN_SECRET>",
    database = "<DATABASE>",
    username = "<USERNAME>",
    password = "password",
    port = 5432 // optional
)
```
