```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setSession("") // The user session to authenticate with
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val response = oauth2.listProjects(
    limit = 1, // optional
    offset = 0, // optional
    search = "<SEARCH>" // optional
)
```
