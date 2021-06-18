import io.appwrite.Client
import io.appwrite.services.Storage

val client = Client(context)
  .setEndpoint("https://[HOSTNAME_OR_IP]/v1") // Your API Endpoint
  .setProject("5df5acd0d48c2") // Your project ID
  .setKey("919c2d18fb5d4...a2ae413da83346ad2") // Your secret API key

val storageService = Storage(client)
val response = storageService.getFilePreview("[FILE_ID]")
val json = response.body?.string()