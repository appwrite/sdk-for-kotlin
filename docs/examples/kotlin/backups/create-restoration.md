import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Backups

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val backups = Backups(client)

val response = backups.createRestoration(
    archiveId = "<ARCHIVE_ID>",
    services = listOf(),
    newResourceId = "<NEW_RESOURCE_ID>", // optional
    newResourceName = "<NEW_RESOURCE_NAME>" // optional
)
