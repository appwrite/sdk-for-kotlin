```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Domains

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val domains = Domains(client)

val response = domains.updateRecordCNAME(
    domainId = "<DOMAIN_ID>",
    recordId = "<RECORD_ID>",
    name = "",
    value = "<VALUE>",
    ttl = 1,
    comment = "<COMMENT>" // optional
)
```
