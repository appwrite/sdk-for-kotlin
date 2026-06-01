```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Proxy
import io.appwrite.enums.StatusCode
import io.appwrite.enums.ProxyResourceType

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val proxy = Proxy(client)

val response = proxy.createRedirectRule(
    domain = "",
    url = "https://example.com",
    statusCode = StatusCode.MOVEDPERMANENTLY,
    resourceId = "<RESOURCE_ID>",
    resourceType = ProxyResourceType.SITE
)
```
