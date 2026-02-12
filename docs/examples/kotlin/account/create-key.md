```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Account
import io.appwrite.enums.Scopes

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val account = Account(client)

val response = account.createKey(
    name = "<NAME>",
    scopes = listOf(Scopes.ACCOUNT),
    expire = "" // optional
)
```
