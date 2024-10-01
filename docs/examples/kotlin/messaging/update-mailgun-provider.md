import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Messaging

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val messaging = Messaging(client)

val response = messaging.updateMailgunProvider(
    providerId = "{$example}",
    name = "{$example}", // optional
    apiKey = "{$example}", // optional
    domain = "{$example}", // optional
    isEuRegion = false, // optional
    enabled = false, // optional
    fromName = "{$example}", // optional
    fromEmail = "{$example}", // optional
    replyToName = "{$example}", // optional
    replyToEmail = "{$example}" // optional
)
