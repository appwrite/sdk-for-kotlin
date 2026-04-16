```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Webhooks

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val webhooks = Webhooks(client)

val response = webhooks.create(
    webhookId = "<WEBHOOK_ID>",
    url = "",
    name = "<NAME>",
    events = listOf(),
    enabled = false, // optional
    tls = false, // optional
    authUsername = "<AUTH_USERNAME>", // optional
    authPassword = "<AUTH_PASSWORD>", // optional
    secret = "<SECRET>" // optional
)
```
