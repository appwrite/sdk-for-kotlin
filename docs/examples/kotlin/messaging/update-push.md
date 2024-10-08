import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Messaging

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val messaging = Messaging(client)

val response = messaging.updatePush(
    messageId = "{$example}",
    topics = listOf(), // optional
    users = listOf(), // optional
    targets = listOf(), // optional
    title = "{$example}", // optional
    body = "{$example}", // optional
    data = mapOf( "a" to "b" ), // optional
    action = "{$example}", // optional
    image = "{$example}", // optional
    icon = "{$example}", // optional
    sound = "{$example}", // optional
    color = "{$example}", // optional
    tag = "{$example}", // optional
    badge = 0, // optional
    draft = false, // optional
    scheduledAt = "" // optional
)
