```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB
import io.appwrite.Permission
import io.appwrite.Role

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val vectorsDB = VectorsDB(client)

val response = vectorsDB.updateDocument(
    databaseId = "<DATABASE_ID>",
    collectionId = "<COLLECTION_ID>",
    documentId = "<DOCUMENT_ID>",
    data = mapOf( "a" to "b" ), // optional
    permissions = listOf(Permission.read(Role.any())), // optional
    transactionId = "<TRANSACTION_ID>" // optional
)
```
