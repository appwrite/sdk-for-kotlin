```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val apps = Apps(client)

val response = apps.listInstallations(
    appId = "<APP_ID>",
    queries = listOf(), // optional
    total = false // optional
)
```
