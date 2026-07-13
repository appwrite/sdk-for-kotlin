```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organization

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val organization = Organization(client)

val response = organization.createMembership(
    roles = listOf(),
    email = "email@example.com", // optional
    userId = "<USER_ID>", // optional
    phone = "+12065550100", // optional
    url = "https://example.com", // optional
    name = "<NAME>" // optional
)
```
