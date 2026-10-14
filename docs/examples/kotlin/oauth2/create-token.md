```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val oauth2 = Oauth2(client)

val response = oauth2.createToken(
    grantType = "<GRANT_TYPE>",
    code = "<CODE>", // optional
    refreshToken = "<REFRESH_TOKEN>", // optional
    deviceCode = "<DEVICE_CODE>", // optional
    clientId = "<CLIENT_ID>", // optional
    clientSecret = "<CLIENT_SECRET>", // optional
    codeVerifier = "<CODE_VERIFIER>", // optional
    redirectUri = "https://example.com", // optional
    resource = listOf(), // optional
    audience = "<AUDIENCE>" // optional
)
```
