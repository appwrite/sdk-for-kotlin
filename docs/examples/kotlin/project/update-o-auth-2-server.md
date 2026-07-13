```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.updateOAuth2Server(
    enabled = false,
    authorizationUrl = "https://example.com",
    scopes = listOf(), // optional
    authorizationDetailsTypes = listOf(), // optional
    accessTokenDuration = 60, // optional
    refreshTokenDuration = 60, // optional
    publicAccessTokenDuration = 60, // optional
    publicRefreshTokenDuration = 60, // optional
    confidentialPkce = false, // optional
    verificationUrl = "https://example.com", // optional
    userCodeLength = 6, // optional
    userCodeFormat = "numeric", // optional
    deviceCodeDuration = 60, // optional
    defaultScopes = listOf() // optional
)
```
