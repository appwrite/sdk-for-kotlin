```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Webhooks

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val webhooks = Webhooks(client)

val response = webhooks.update(
    webhookId = "<WEBHOOK_ID>",
    name = "<NAME>",
    url = "",
    events = listOf(),
    enabled = false, // optional
    security = false, // optional
    httpUser = "<HTTP_USER>", // optional
    httpPass = "<HTTP_PASS>" // optional
)
```
