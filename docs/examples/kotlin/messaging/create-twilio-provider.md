import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Messaging

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val messaging = Messaging(client)

val response = messaging.createTwilioProvider(
    providerId = "{$example}",
    name = "{$example}",
    from = "{$example}", // optional
    accountSid = "{$example}", // optional
    authToken = "{$example}", // optional
    enabled = false // optional
)
