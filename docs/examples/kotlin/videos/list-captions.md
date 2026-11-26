```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val videos = Videos(client)

val response = videos.listCaptions(
    videoId = "<VIDEO_ID>",
    queries = listOf(), // optional
    total = false // optional
)
```
