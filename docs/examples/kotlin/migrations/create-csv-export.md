```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Migrations

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val migrations = Migrations(client)

val response = migrations.createCSVExport(
    databaseId = "<DATABASE_ID>",
    collectionId = "<COLLECTION_ID>",
    filename = "<FILENAME>",
    columns = listOf(), // optional
    queries = listOf(), // optional
    delimiter = "<DELIMITER>", // optional
    enclosure = "<ENCLOSURE>", // optional
    escape = "<ESCAPE>", // optional
    header = false, // optional
    notify = false // optional
)
```
