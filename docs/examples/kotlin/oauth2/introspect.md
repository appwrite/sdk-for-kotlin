```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val oauth2 = Oauth2(client)

val response = oauth2.introspect(
    token = "<TOKEN>",
    tokenTypeHint = "access_token", // optional
    clientId = "<CLIENT_ID>", // optional
    clientSecret = "<CLIENT_SECRET>" // optional
)
```
