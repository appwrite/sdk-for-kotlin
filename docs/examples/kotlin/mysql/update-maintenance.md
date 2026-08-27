```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Mysql

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val mysql = Mysql(client)

val response = mysql.updateMaintenance(
    databaseId = "<DATABASE_ID>",
    day = "sun",
    hourUtc = 0
)
```
