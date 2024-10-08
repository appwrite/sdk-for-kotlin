import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Databases

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession("") // The user session to authenticate with

val databases = Databases(client)

val response = databases.updateDocument(
    databaseId = "{$example}",
    collectionId = "{$example}",
    documentId = "{$example}",
    data = mapOf( "a" to "b" ), // optional
    permissions = listOf("read("any")") // optional
)
