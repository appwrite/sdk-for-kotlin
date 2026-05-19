```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.ProjectKeyScopes

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.createEphemeralKey(
    scopes = listOf(ProjectKeyScopes.PROJECT_READ),
    duration = 600
)
```
