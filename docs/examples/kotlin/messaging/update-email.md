```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Messaging

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val messaging = Messaging(client)

val response = messaging.updateEmail(
    messageId = "<MESSAGE_ID>",
    topics = listOf(), // optional
    users = listOf(), // optional
    targets = listOf(), // optional
    subject = "<SUBJECT>", // optional
    content = "<CONTENT>", // optional
    draft = false, // optional
    html = false, // optional
    cc = listOf(), // optional
    bcc = listOf(), // optional
    scheduledAt = "2020-10-15T06:38:00.000+00:00", // optional
    attachments = listOf() // optional
)
```
