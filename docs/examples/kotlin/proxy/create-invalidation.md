```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Proxy
import io.appwrite.enums.InvalidationType

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val proxy = Proxy(client)

val response = proxy.createInvalidation(
    domain = "",
    type = InvalidationType.TAG,
    reference = "<REFERENCE>" // optional
)
```
