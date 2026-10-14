```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.models.InputFile
import io.appwrite.services.Avatars

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val avatars = Avatars(client)

val response = avatars.updatePhoto(
    file = InputFile.fromPath("file.png")
)
```
