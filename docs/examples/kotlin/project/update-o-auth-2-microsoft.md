```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateOAuth2Microsoft(
    applicationId = "<APPLICATION_ID>", // optional
    applicationSecret = "<APPLICATION_SECRET>", // optional
    tenant = "<TENANT>", // optional
    enabled = false // optional
)
```
