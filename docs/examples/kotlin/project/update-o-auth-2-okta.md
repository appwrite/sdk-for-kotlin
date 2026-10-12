```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.ProjectOAuth2OktaPrompt

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateOAuth2Okta(
    clientId = "<CLIENT_ID>", // optional
    clientSecret = "<CLIENT_SECRET>", // optional
    domain = "example.com", // optional
    authorizationServerId = "<AUTHORIZATION_SERVER_ID>", // optional
    prompt = listOf(ProjectOAuth2OktaPrompt.NONE), // optional
    enabled = false // optional
)
```
