```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Videos

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val videos = Videos(client)

val response = videos.createCaption(
    videoId = "<VIDEO_ID>",
    bucketId = "<BUCKET_ID>",
    fileId = "<FILE_ID>",
    name = "<NAME>",
    language = "aar",
    default = false // optional
)
```
