```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Presences
import io.appwrite.Permission
import io.appwrite.Role

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val presences = Presences(client)

val response = presences.upsert(
    presenceId = "<PRESENCE_ID>",
    userId = "<USER_ID>",
    status = "<STATUS>",
    permissions = listOf(Permission.read(Role.any())), // optional
    expiresAt = "2020-10-15T06:38:00.000+00:00", // optional
    metadata = mapOf( "a" to "b" ) // optional
)
```
