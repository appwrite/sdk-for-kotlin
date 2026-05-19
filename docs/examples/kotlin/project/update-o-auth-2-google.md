```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.ProjectOAuth2GooglePrompt

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateOAuth2Google(
    clientId = "<CLIENT_ID>", // optional
    clientSecret = "<CLIENT_SECRET>", // optional
    prompt = listOf(ProjectOAuth2GooglePrompt.NONE), // optional
    enabled = false // optional
)
```
