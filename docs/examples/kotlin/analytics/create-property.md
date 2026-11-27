```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Analytics
import io.appwrite.enums.AnalyticsPropertyType

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val analytics = Analytics(client)

val response = analytics.createProperty(
    propertyId = "<PROPERTY_ID>",
    name = "<NAME>",
    domain = "<DOMAIN>", // optional
    enabled = false, // optional
    allowedOrigins = listOf(), // optional
    identifyUsers = false, // optional
    type = AnalyticsPropertyType.WEB // optional
)
```
