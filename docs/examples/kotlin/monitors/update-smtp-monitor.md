```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Monitors
import io.appwrite.enums.MonitorTlsMode
import io.appwrite.enums.MonitorSeverity
import io.appwrite.Query

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val monitors = Monitors(client)

val response = monitors.updateSmtpMonitor(
    monitorId = "<MONITOR_ID>",
    name = "<NAME>", // optional
    host = "smtp.example.com", // optional
    port = 587, // optional
    tlsMode = MonitorTlsMode.NONE, // optional
    rules = listOf(
        Query.or(listOf(
            Query.lessThan("certificateDays", 14),
            Query.greaterThan("latency", 2000)
        ))
    ), // optional
    interval = 60, // optional
    timeout = 10, // optional
    cooldown = 300, // optional
    enabled = true, // optional
    notify = listOf("owner"), // optional
    severity = MonitorSeverity.INFO, // optional
    escalationId = "<ESCALATION_ID>" // optional
)
```
