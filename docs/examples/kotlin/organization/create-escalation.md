```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organization

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val organization = Organization(client)

val response = organization.createEscalation(
    escalationId = "<ESCALATION_ID>",
    name = "<NAME>",
    steps = listOf(mapOf(
        "delay" to 0,
        "roles" to listOf("owner")
    ), mapOf(
        "delay" to 900,
        "roles" to listOf("developer"),
        "userIds" to listOf("<USER_ID>")
    )),
    repeat = 1 // optional
)
```
