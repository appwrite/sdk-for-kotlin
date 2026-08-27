```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB
import io.appwrite.Permission
import io.appwrite.Role

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val vectorsDB = VectorsDB(client)

val response = vectorsDB.updateCollection(
    databaseId = "<DATABASE_ID>",
    collectionId = "<COLLECTION_ID>",
    name = "<NAME>",
    dimension = 1, // optional
    permissions = listOf(Permission.read(Role.any())), // optional
    documentSecurity = false, // optional
    enabled = false // optional
)
```
