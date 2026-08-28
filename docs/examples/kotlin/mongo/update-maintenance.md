```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Mongo

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val mongo = Mongo(client)

val response = mongo.updateMaintenance(
    databaseId = "<DATABASE_ID>",
    day = "sun",
    hourUtc = 0
)
```
