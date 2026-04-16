```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.Scopes

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.createKey(
    keyId = "<KEY_ID>",
    name = "<NAME>",
    scopes = listOf(Scopes.SESSIONS_WRITE),
    expire = "2020-10-15T06:38:00.000+00:00" // optional
)
```
