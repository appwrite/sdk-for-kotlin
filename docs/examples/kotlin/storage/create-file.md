import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.models.Payload
import io.appwrite.services.Storage

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val storage = Storage(client)

val response = storage.createFile(
    bucketId = "{$example}",
    fileId = "{$example}",
    file = Payload.fromFile("/path/to/file.png"),
    permissions = listOf("read("any")") // optional
)
