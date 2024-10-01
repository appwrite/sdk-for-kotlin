import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Functions
import io.appwrite.enums.Runtime

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val functions = Functions(client)

val response = functions.create(
    functionId = "{$example}",
    name = "{$example}",
    runtime =  .NODE_14_5,
    execute = listOf("any"), // optional
    events = listOf(), // optional
    schedule = "", // optional
    timeout = 1, // optional
    enabled = false, // optional
    logging = false, // optional
    entrypoint = "{$example}", // optional
    commands = "{$example}", // optional
    scopes = listOf(), // optional
    installationId = "{$example}", // optional
    providerRepositoryId = "{$example}", // optional
    providerBranch = "{$example}", // optional
    providerSilentMode = false, // optional
    providerRootDirectory = "{$example}", // optional
    templateRepository = "{$example}", // optional
    templateOwner = "{$example}", // optional
    templateRootDirectory = "{$example}", // optional
    templateVersion = "{$example}", // optional
    specification = "" // optional
)
