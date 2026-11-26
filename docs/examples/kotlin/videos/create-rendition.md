```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos
import io.appwrite.enums.VideoOutput

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val videos = Videos(client)

val response = videos.createRendition(
    videoId = "<VIDEO_ID>",
    profileId = "<PROFILE_ID>",
    output = VideoOutput.HLS
)
```
