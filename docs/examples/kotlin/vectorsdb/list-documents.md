```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val vectorsDB = VectorsDB(client)

val response = vectorsDB.listDocuments(
    databaseId = "<DATABASE_ID>",
    collectionId = "<COLLECTION_ID>",
    queries = listOf(), // optional
    transactionId = "<TRANSACTION_ID>", // optional
    total = false, // optional
    ttl = 0 // optional
)
```
