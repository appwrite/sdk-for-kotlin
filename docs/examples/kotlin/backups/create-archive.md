```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Backups
import io.appwrite.enums.BackupServices

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val backups = Backups(client)

val response = backups.createArchive(
    services = listOf(BackupServices.DATABASES),
    resourceId = "<RESOURCE_ID>" // optional
)
```
