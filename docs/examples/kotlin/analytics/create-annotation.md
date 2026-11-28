```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Analytics

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val analytics = Analytics(client)

val response = analytics.createAnnotation(
    propertyId = "<PROPERTY_ID>",
    annotationId = "<ANNOTATION_ID>",
    date = "2020-10-15T06:38:00.000+00:00",
    content = "<CONTENT>"
)
```
