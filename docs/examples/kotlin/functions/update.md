```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Functions
import io.appwrite.enums.Runtime
import io.appwrite.enums.ProjectKeyScopes

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val functions = Functions(client)

val response = functions.update(
    functionId = "<FUNCTION_ID>",
    name = "<NAME>",
    runtime = Runtime.NODE_14_5, // optional
    execute = listOf("any"), // optional
    events = listOf(), // optional
    schedule = "0 0 * * *", // optional
    timeout = 1, // optional
    enabled = false, // optional
    logging = false, // optional
    entrypoint = "<ENTRYPOINT>", // optional
    commands = "<COMMANDS>", // optional
    scopes = listOf(ProjectKeyScopes.PROJECT_READ), // optional
    installationId = "<INSTALLATION_ID>", // optional
    providerRepositoryId = "<PROVIDER_REPOSITORY_ID>", // optional
    providerBranch = "<PROVIDER_BRANCH>", // optional
    providerSilentMode = false, // optional
    providerRootDirectory = "<PROVIDER_ROOT_DIRECTORY>", // optional
    providerBranches = listOf(), // optional
    providerPaths = listOf(), // optional
    buildSpecification = "s-1vcpu-512mb", // optional
    runtimeSpecification = "s-1vcpu-512mb", // optional
    deploymentRetention = 0 // optional
)
```
