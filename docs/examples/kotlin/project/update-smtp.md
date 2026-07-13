```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.ProjectSMTPSecure

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateSMTP(
    host = "", // optional
    port = 0, // optional
    username = "<USERNAME>", // optional
    password = "password", // optional
    senderEmail = "email@example.com", // optional
    senderName = "<SENDER_NAME>", // optional
    replyToEmail = "email@example.com", // optional
    replyToName = "<REPLY_TO_NAME>", // optional
    secure = ProjectSMTPSecure.TLS, // optional
    enabled = false // optional
)
```
