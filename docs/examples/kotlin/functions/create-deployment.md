import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.models.Payload
import io.appwrite.services.Functions

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val functions = Functions(client)

val response = functions.createDeployment(
    functionId = "{$example}",
    code = Payload.fromFile("/path/to/file.png"),
    activate = false,
    entrypoint = "{$example}", // optional
    commands = "{$example}" // optional
)
