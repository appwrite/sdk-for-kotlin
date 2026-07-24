```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val apps = Apps(client)

val response = apps.get(
    appId = "<APP_ID>"
)
```
