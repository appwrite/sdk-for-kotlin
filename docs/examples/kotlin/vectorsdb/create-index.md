```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB
import io.appwrite.enums.VectorsDBIndexType
import io.appwrite.enums.OrderBy

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val vectorsDB = VectorsDB(client)

val response = vectorsDB.createIndex(
    databaseId = "<DATABASE_ID>",
    collectionId = "<COLLECTION_ID>",
    key = "",
    type = VectorsDBIndexType.HNSW_EUCLIDEAN,
    attributes = listOf(),
    orders = listOf(OrderBy.ASC), // optional
    lengths = listOf() // optional
)
```
