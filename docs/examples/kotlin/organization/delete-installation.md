```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organization

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val organization = Organization(client)

val response = organization.deleteInstallation(
    installationId = "<INSTALLATION_ID>"
)
```
