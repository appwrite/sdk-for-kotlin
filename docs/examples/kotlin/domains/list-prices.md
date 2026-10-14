```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Domains
import io.appwrite.enums.DomainRegistrationType

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val domains = Domains(client)

val response = domains.listPrices(
    domains = listOf(),
    periodYears = 0, // optional
    registrationType = DomainRegistrationType.NEW // optional
)
```
