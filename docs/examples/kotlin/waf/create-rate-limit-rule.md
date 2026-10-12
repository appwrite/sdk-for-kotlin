```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Waf

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val waf = Waf(client)

val response = waf.createRateLimitRule(
    ruleId = "<RULE_ID>",
    resourceType = "api",
    name = "<NAME>",
    limit = 1,
    interval = 1,
    resourceId = "<RESOURCE_ID>", // optional
    description = "<DESCRIPTION>", // optional
    key = "ip", // optional
    strategy = "fixedWindow", // optional
    maxBucketSize = 1, // optional
    priority = -100000, // optional
    enabled = false, // optional
    conditions = listOf() // optional
)
```
