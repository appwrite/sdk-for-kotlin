import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Messaging

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val messaging = Messaging(client)

val response = messaging.updateTelesignProvider(
    providerId = "{$example}",
    name = "{$example}", // optional
    enabled = false, // optional
    customerId = "{$example}", // optional
    apiKey = "{$example}", // optional
    from = "{$example}" // optional
)
