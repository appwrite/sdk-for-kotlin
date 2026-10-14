```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Account
import io.appwrite.enums.IdTokenProvider

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val account = Account(client)

val response = account.createIdTokenSession(
    provider = IdTokenProvider.APPLE,
    idToken = "<ID_TOKEN>",
    nonce = "<NONCE>", // optional
    accessToken = "<ACCESS_TOKEN>", // optional
    accessTokenExpiry = 0, // optional
    name = "<NAME>" // optional
)
```
