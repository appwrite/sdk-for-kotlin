```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Avatars

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val avatars = Avatars(client)

val result = avatars.getPhoto(
    width = 0, // optional
    height = 0, // optional
    quality = 0, // optional
    output = "png", // optional
    rating = "g", // optional
    userId = "current()", // optional
    emailHash = "<EMAIL_HASH>", // optional
    name = "<NAME>" // optional
)
```
