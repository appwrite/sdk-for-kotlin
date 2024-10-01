import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Databases

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val databases = Databases(client)

val response = databases.createEnumAttribute(
    databaseId = "{$example}",
    collectionId = "{$example}",
    key = "",
    elements = listOf(),
    required = false,
    default = "{$example}", // optional
    array = false // optional
)
