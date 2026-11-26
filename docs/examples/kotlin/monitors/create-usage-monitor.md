```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Monitors
import io.appwrite.enums.MonitorSeverity
import io.appwrite.Query

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val monitors = Monitors(client)

val response = monitors.createUsageMonitor(
    monitorId = "<MONITOR_ID>",
    name = "<NAME>",
    rules = listOf(
        Query.greaterThan("network.outbound", 5000000000)
    ),
    window = 3600, // optional
    cooldown = 1800, // optional
    enabled = true, // optional
    notify = listOf("owner"), // optional
    severity = MonitorSeverity.INFO, // optional
    escalationId = "<ESCALATION_ID>" // optional
)
```
