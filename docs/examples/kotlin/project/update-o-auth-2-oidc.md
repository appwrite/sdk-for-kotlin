```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.ProjectOAuth2OidcPrompt

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateOAuth2Oidc(
    clientId = "<CLIENT_ID>", // optional
    clientSecret = "<CLIENT_SECRET>", // optional
    wellKnownURL = "https://example.com", // optional
    authorizationURL = "https://example.com", // optional
    tokenURL = "https://example.com", // optional
    userInfoURL = "https://example.com", // optional
    prompt = listOf(ProjectOAuth2OidcPrompt.NONE), // optional
    maxAge = 0, // optional
    enabled = false // optional
)
```
