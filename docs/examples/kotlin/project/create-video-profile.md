```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.VideoCodecId

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.createVideoProfile(
    profileId = "<PROFILE_ID>",
    name = "<NAME>",
    videoBitRate = 32000,
    audioBitRate = 32000,
    width = 16,
    height = 16,
    codec = VideoCodecId.H264 // optional
)
```
